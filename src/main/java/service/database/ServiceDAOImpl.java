package service.database;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.Service;
import service.database.hibernate.HiberUtil;


import java.util.List;

public class ServiceDAOImpl implements ServiceDAO{
    @Override
    public List<Service> getAllService() {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Service> service = session
                .createQuery("FROM Service")
                .getResultList();
        session.getTransaction().commit();
        factory.close();
        return  service;
    }

    public Service getServiceById(int id) {
        Service service = null;
        SessionFactory factory = HiberUtil.getSessionFactory();
        try(Session session = factory.openSession();) {
            session.beginTransaction();
            service = session.get(Service.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            factory.close();
        }
        return service;
    }

    @Override
    public Service deleteServiceById(int id) {
        Service service = null;
        SessionFactory factory = HiberUtil.getSessionFactory();
        try(Session session = HiberUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            service = session.get(Service.class, id);
            if (service != null) {
                session.delete(service);
                System.out.println("service is deleted");
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            factory.close();
        }
        return service;
    }

    @Override
    public void save(Service service) {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(service);
        session.getTransaction().commit();
        factory.close();
    }
}
