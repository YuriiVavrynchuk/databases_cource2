package ua.lviv.iot.dao.impl;

import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.dao.AbstractDao;
import ua.lviv.iot.model.AnimatorsAgencyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class AnimatorsAgencyDaoImpl implements AbstractDao<AnimatorsAgencyEntity> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<AnimatorsAgencyEntity> findAll() throws SQLException {
        List<AnimatorsAgencyEntity> animatorsAgencyEntities = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            animatorsAgencyEntities = session.createQuery("from AnimatorsAgencyEntity ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return animatorsAgencyEntities;
    }

    @Override
    public AnimatorsAgencyEntity findById(Integer id) throws SQLException {
        AnimatorsAgencyEntity animatorsAgencyEntity = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            animatorsAgencyEntity = session.get(AnimatorsAgencyEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animatorsAgencyEntity;
    }

    @Override
    public void create(AnimatorsAgencyEntity animatorsAgencyEntity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(animatorsAgencyEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, AnimatorsAgencyEntity animatorsAgencyEntity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(animatorsAgencyEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            AnimatorsAgencyEntity animatorsAgencyEntity = session.get(AnimatorsAgencyEntity.class, id);
            if (animatorsAgencyEntity != null) {
                session.delete(animatorsAgencyEntity);
                session.getTransaction().commit();
                System.out.println("Animators agency with ID = " + id + "was deleted\n");
            }
            else  {
                System.out.println("Nothing to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
