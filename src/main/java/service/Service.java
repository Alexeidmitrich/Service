package service;


import javax.persistence.*;

@Entity
public class Service{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idService;
    private String title;
    private String category;

    public Service(int idService, String title, String category) {
        this.idService = idService;
        this.title = title;
        this.category = category;
    }

    public Service(String title, String category){
        this.title = title;
        this.category = category;
    }
    public Service(){}

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public void printInformation(){
        System.out.println(getIdService() + " " + getTitle() + ";" + getCategory());
    }
}
