package ua.lviv.iot.dao.impl;

import ua.lviv.iot.HibernateUtil;
import ua.lviv.iot.dao.AbstractDao;
import ua.lviv.iot.model.ClientAccountEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class ClientAccountDaoImpl implements AbstractDao<ClientAccountEntity> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<ClientAccountEntity> findAll() throws SQLException {
        List<ClientAccountEntity> clientAccountEntities = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            clientAccountEntities = session.createQuery("from ClientAccountEntity ").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientAccountEntities;
    }

    @Override
    public ClientAccountEntity findById(Integer id) throws SQLException {
        ClientAccountEntity clientAccountEntity = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            clientAccountEntity = session.get(ClientAccountEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientAccountEntity;
    }

    @Override
    public void create(ClientAccountEntity billEntity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(billEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, ClientAccountEntity clientAccountEntity) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(clientAccountEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            ClientAccountEntity clientAccountEntity = session.get(ClientAccountEntity.class, id);
            if (clientAccountEntity != null) {
                session.delete(clientAccountEntity);
                session.getTransaction().commit();
                System.out.println("Client account with ID = " + id + "was deleted\n");
            }
            else  {
                System.out.println("Nothing to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}