package service.database;

import service.Service;

import java.util.List;

public interface ServiceDAO {

    List<Service> getAllService();

    Service getServiceById(int id);
    Service deleteServiceById(int id);
    void save(Service service);

}
