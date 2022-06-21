package service;

import service.database.CategoryDAO;
import service.database.CategoryDAOImpl;
import service.database.ServiceDAO;
import service.database.ServiceDAOImpl;

public class ServiceSystem {

    private CategoryDAO categoryDAO = new CategoryDAOImpl();
    private ServiceDAO serviceDAO = new ServiceDAOImpl();


    public void addCategory(String type){
        Category category = new Category(type);
        categoryDAO.save(category);
    }
    public void addService(String title, String categoryType){
        Category category = categoryDAO.getCategoryByType(categoryType);
        Service service = new Service(title, category);
        serviceDAO.save(service);
    }
    public void printServiceId(int id){
        CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
        Category s = categoryDAOImpl.getCategoryById(id);
        s.printInformation();
    }
    public void deleteServiceById(int id){
        CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
        Category ser = categoryDAOImpl.deleteCategoryById(id);
    }
}
