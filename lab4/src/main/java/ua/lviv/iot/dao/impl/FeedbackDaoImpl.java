package ua.lviv.iot.dao.impl;

import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.dao.AbstractDao;
import ua.lviv.iot.model.FeedbackEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class FeedbackDaoImpl implements AbstractDao<FeedbackEntity> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<FeedbackEntity> findAll() throws SQLException {
        List<FeedbackEntity> feedbackEntities = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            feedbackEntities = session.createQuery("from FeedbackEntity ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return feedbackEntities;
    }

    @Override
    public FeedbackEntity findById(Integer id) throws SQLException {
        FeedbackEntity feedbackEntity = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            feedbackEntity = session.get(FeedbackEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return feedbackEntity;
    }

    @Override
    public void create(FeedbackEntity feedbackEntity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(feedbackEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, FeedbackEntity feedbackEntity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(feedbackEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            FeedbackEntity feedbackEntity = session.get(FeedbackEntity.class, id);
            if (feedbackEntity != null) {
                session.delete(feedbackEntity);
                session.getTransaction().commit();
                System.out.println("Feedback with ID = " + id + "was deleted\n");
            }
            else  {
                System.out.println("Nothing to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
