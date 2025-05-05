package solutions.obama.taskmanager;

import io.javalin.Javalin;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import solutions.obama.taskmanager.models.*;
import solutions.obama.taskmanager.repositories.TaskRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        // Hibernate Configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // Create hibernate.cfg.xml
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        TaskRepository taskRepository = new TaskRepository(sessionFactory);

        Javalin app = Javalin.create();

        // CRUD Endpoints

        // Create
        app.post("/tasks", ctx -> {
            String name = ctx.formParam("name");
            String desc = ctx.formParam("desc");
            Priority priority = Priority.valueOf(ctx.formParam("priority"));
            Timestamp dueDate = Timestamp.valueOf(Objects.requireNonNull(ctx.formParam("dueDate"))); // Ensure not null

            Task task = new Task(name, desc, priority, dueDate);
            Task createdTask = taskRepository.create(task);
            ctx.json(createdTask);
            ctx.status(201); // Created
        });

        // Read (Get All)
        app.get("/tasks", ctx -> {
            List<Task> tasks = taskRepository.getAll();
            ctx.json(tasks);
        });

        // Read (Get by ID)
        app.get("/tasks/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Task task = taskRepository.getById(id);
            if (task != null) {
                ctx.json(task);
            } else {
                ctx.status(404); // Not Found
            }
        });

        // Update
        app.put("/tasks/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Task existingTask = taskRepository.getById(id);

            if (existingTask != null) {
                String name = ctx.formParam("name");
                String desc = ctx.formParam("desc");
                Boolean isDone = Boolean.parseBoolean(ctx.formParam("isDone"));
                Priority priority = Priority.valueOf(ctx.formParam("priority"));
                Timestamp dueDate = Timestamp.valueOf(Objects.requireNonNull(ctx.formParam("dueDate")));

                existingTask.setName(name);
                existingTask.setDesc(desc);
                existingTask.setIsDone(isDone);
                existingTask.setPriority(priority);
                existingTask.setDueDate(dueDate);

                Task updatedTask = taskRepository.update(existingTask);
                ctx.json(updatedTask);
            } else {
                ctx.status(404); // Not Found
            }
        });

        // Delete (Delete by ID)
        app.delete("/tasks/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            taskRepository.deleteById(id);
            ctx.status(204); // No Content
        });

        // Delete (Delete all)
        app.delete("/tasks", ctx -> {
            taskRepository.deleteAll();
            ctx.status(204); // No Content
        });

        // simple HTML info
        app.get("/", ctx -> {
            ctx.html("<meta http-equiv='refresh' content='0; url=https://obama.solutions/'/>");
        });

        app.start(7000);
    }
}