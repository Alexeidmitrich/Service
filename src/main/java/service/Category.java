package service;


import org.hibernate.mapping.List;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;
    private String type;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategory")
    private Set<Service> service = new HashSet<>();


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
}
