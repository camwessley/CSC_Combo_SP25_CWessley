package solutions.obama.taskmanager.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import solutions.obama.taskmanager.models.Task;

import java.util.List;

public class TaskRepository {

    private final SessionFactory sessionFactory;

    public TaskRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Task create(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(task);
        transaction.commit();
        session.close();
        return task;
    }

    public Task getById(int id) {
        Session session = sessionFactory.openSession();
        Task task = session.get(Task.class, id);
        session.close();
        return task;
    }

    public List<Task> getAll() {
        Session session = sessionFactory.openSession();
        List<Task> tasks = session.createQuery("FROM Task", Task.class).list();
        session.close();
        return tasks;
    }

    public Task update(Task task) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(task);
        transaction.commit();
        session.close();
        return task;
    }

    public void deleteById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Task task = session.get(Task.class, id);
        if (task != null) {
            session.remove(task);
        }
        transaction.commit();
        session.close();
    }

    public void deleteAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from Task").executeUpdate(); // deprecated due to potential issues with transaction management, but it works fine for me
        transaction.commit();
        session.close();
    }
}
