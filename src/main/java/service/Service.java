package service;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 15)
    private int idService;
    @Column(nullable = false, length = 25)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCategory", nullable = false)
    private Category category;

    public Service(int idService, String title) {
        this.idService = idService;
        this.title = title;
    }
    public Service(String title){
        this.title = title;
    }

    public Service(String title, Category category){
        this.title = title;
        this.category = category;
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

    public void setCategory(Category category) {
        this.category = category;
    }
}
