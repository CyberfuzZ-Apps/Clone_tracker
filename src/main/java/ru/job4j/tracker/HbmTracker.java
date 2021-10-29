package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

/**
 * Класс HbmTracker
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public void init() {
    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        item.setId(id);
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
        return item.equals(findById(id));
    }

    @Override
    public boolean delete(int id) {
        Item item = findById(id);
        if (item == null) {
            return false;
        }
        Session session = sf.openSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from ru.job4j.tracker.Item where name = :name");
        query.setParameter("name", key);
        List result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    public static void main(String[] args) throws Exception {
        /* At first - Truncate table and restart identity */
        Item item1 = new Item("Item 1");
        Item item2 = new Item("Item 2");
        Store tracker = new HbmTracker();
        tracker.add(item1);
        tracker.add(item2);
        System.out.println("FIND ALL = " + tracker.findAll());
        System.out.println("REPLACE = " + tracker.replace(1, new Item("Replaced")));
        System.out.println("FIND ALL = " + tracker.findAll());
        System.out.println("FIND BY ID 1 = " + tracker.findById(1));
        System.out.println("FIND BY NAME - Replaced = " + tracker.findByName("Replaced"));
        System.out.println("DELETE id 1 = " + tracker.delete(1));
        System.out.println("FIND ALL (without id 1) = " + tracker.findAll());
        tracker.close();
    }
}
