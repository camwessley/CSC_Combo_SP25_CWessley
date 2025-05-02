package solutions.obama.taskmanager;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import solutions.obama.taskmanager.models.*;
import solutions.obama.taskmanager.repositories.TaskRepository;

import java.sql.Timestamp;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Hibernate Configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // Create hibernate.cfg.xml (see below)
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        TaskRepository taskRepository = new TaskRepository(sessionFactory);

        Javalin app = Javalin.create();

        // CRUD Endpoints

        // Create
        app.post("/tasks", ctx -> {
            String name = ctx.formParam("name");
            String desc = ctx.formParam("desc");
            Priority priority = Priority.valueOf(ctx.formParam("priority"));
            Timestamp dueDate = Timestamp.valueOf(ctx.formParam("dueDate"));

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
                Timestamp dueDate = Timestamp.valueOf(ctx.formParam("dueDate"));

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

        // Delete
        app.delete("/tasks/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            taskRepository.delete(id);
            ctx.status(204); // No Content
        });

        app.start(7000);
    }
}