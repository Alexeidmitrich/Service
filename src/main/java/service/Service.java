package service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idService", nullable = true)
    private int idService;
    private String title;

    @ManyToOne()
    @JoinColumn(name = "idCategory")
    private Category category;

    public Service(int idService, String title) {
        this.idService = idService;
        this.title = title;
    }
    public Service(String title){
        this.title = title;
    }
    public Service(){

    }
    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void printServiceInformation(){
        System.out.println(getIdService() + " " + getTitle());
    }
}
