package service;

import javax.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="idCategory")
    private int idService;
    private String title;

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
