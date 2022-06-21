package service;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 15)
    private int idCategory;
    @Column(nullable = false, length = 20)
    private String type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Service> services = new HashSet<>();


    public Category(int idCategory, String type) {
        this.idCategory = idCategory;
        this.type = type;
    }

    public Category(String type){
        this.type = type;
    }

    public Category(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void printInformation(){
        System.out.println(getIdCategory() + " " + getType());
    }

    public void addService(Service service){
        services.add(service);
    }
}
