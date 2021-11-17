package ua.lviv.iot.dao.impl;

import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.dao.AbstractDao;
import ua.lviv.iot.model.EventEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class EventDaoImpl implements AbstractDao<EventEntity> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<EventEntity> findAll() throws SQLException {
        List<EventEntity> eventEntities = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            eventEntities = session.createQuery("from EventEntity ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventEntities;
    }

    @Override
    public EventEntity findById(Integer id) throws SQLException {
        EventEntity eventEntity = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            eventEntity = session.get(EventEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventEntity;
    }

    @Override
    public void create(EventEntity eventEntity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(eventEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, EventEntity eventEntity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(eventEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            EventEntity eventEntity = session.get(EventEntity.class, id);
            if (eventEntity != null) {
                session.delete(eventEntity);
                session.getTransaction().commit();
                System.out.println("Event with ID = " + id + "was deleted\n");
            }
            else  {
                System.out.println("Nothing to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
