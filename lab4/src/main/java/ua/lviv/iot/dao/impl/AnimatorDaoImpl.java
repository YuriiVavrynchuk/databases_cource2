package ua.lviv.iot.dao.impl;

import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.dao.AbstractDao;
import ua.lviv.iot.model.AnimatorEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class AnimatorDaoImpl implements AbstractDao<AnimatorEntity> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<AnimatorEntity> findAll() throws SQLException {
        List<AnimatorEntity> animatorEntities = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            animatorEntities = session.createQuery("from AnimatorEntity ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return animatorEntities;
    }

    @Override
    public AnimatorEntity findById(Integer id) throws SQLException {
        AnimatorEntity animatorEntity = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            animatorEntity = session.get(AnimatorEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animatorEntity;
    }

    @Override
    public void create(AnimatorEntity animatorEntity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(animatorEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, AnimatorEntity animatorEntity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(animatorEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            AnimatorEntity animatorEntity = session.get(AnimatorEntity.class, id);
            if (animatorEntity != null) {
                session.delete(animatorEntity);
                session.getTransaction().commit();
                System.out.println("Animator with ID = " + id + "was deleted\n");
            }
            else  {
                System.out.println("Nothing to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
