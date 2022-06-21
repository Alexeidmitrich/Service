package service.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.Category;
import service.database.hibernate.HiberUtil;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public List<Category> getAllCategory() {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Category> category = session
                .createQuery("FROM Category")
                .getResultList();
        session.getTransaction().commit();
        factory.close();
        return  category;
    }

    public Category getCategoryById(int id) {
        Category category = null;
        SessionFactory factory = HiberUtil.getSessionFactory();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            category = session.get(Category.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            factory.close();
        }
        return category;
    }

    @Override
    public Category deleteCategoryById(int id) {
        Category category = null;
        SessionFactory factory = HiberUtil.getSessionFactory();
        try(Session session = HiberUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            category = session.get(Category.class, id);
            if (category != null) {
                session.delete(category);
                System.out.println("category is deleted");
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            factory.close();
        }
        return category;
    }

    @Override
    public void save(Category category) {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
        factory.close();
    }

    @Override
    public Category getCategoryByType(String type) {
        Category category = null;
        SessionFactory factory = HiberUtil.getSessionFactory();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            category = (Category) session.createQuery("from Category WHERE type =:type")
                    .setParameter("type", type)
                            .getResultList()
                    .get(0);
            session.getTransaction().commit();
        } catch (Exception e) {
            factory.close();
        }
        return category;
    }
}
