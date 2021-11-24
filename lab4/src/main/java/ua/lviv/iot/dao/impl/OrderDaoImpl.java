package ua.lviv.iot.dao.impl;

import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.dao.AbstractDao;
import ua.lviv.iot.model.OrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class OrderDaoImpl implements AbstractDao<OrderEntity> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<OrderEntity> findAll() throws SQLException {
        List<OrderEntity> orderEntities = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            orderEntities = session.createQuery("from OrderEntity ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderEntities;
    }

    @Override
    public OrderEntity findById(Integer id) throws SQLException {
        OrderEntity orderEntity = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            orderEntity = session.get(OrderEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderEntity;
    }

    @Override
    public void create(OrderEntity orderEntity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(orderEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, OrderEntity orderEntity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(orderEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            OrderEntity orderEntity = session.get(OrderEntity.class, id);
            if (orderEntity != null) {
                session.delete(orderEntity);
                session.getTransaction().commit();
                System.out.println("Order with ID = " + id + "was deleted\n");
            }
            else  {
                System.out.println("Nothing to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
