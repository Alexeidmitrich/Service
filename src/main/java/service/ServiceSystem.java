package service;

import service.database.ServiceDAO;
import service.database.ServiceDAOImpl;

public class ServiceSystem {

    private ServiceDAO serviceDAO = new ServiceDAOImpl();
    private ServiceDAOImpl serviceDAOImpl;

    public void addService(String title, String category){
        Service service = new Service(title,category);
        serviceDAO.save(service);
    }
    public void printServiceId(int id){
        ServiceDAOImpl  serviceDAOImpl = new ServiceDAOImpl();
        Service ser = serviceDAOImpl.getServiceById(id);
        ser.printInformation();
    }
    public void deleteServiceById(int id){
        ServiceDAOImpl serviceDAOImpl = new ServiceDAOImpl();
        Service ser = serviceDAOImpl.deleteServiceById(id);
    }
}
