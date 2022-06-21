package service;

import service.database.ServiceDAO;
import service.database.ServiceDAOImpl;

public class Demo {

    public static void main(String[] args) {
        Category category = new Category("test category 17");
        Service service = new Service("test service");
        ServiceDAO serviceDAO = new ServiceDAOImpl();
        service.setCategory(category);
        serviceDAO.save(service);
    }
}
