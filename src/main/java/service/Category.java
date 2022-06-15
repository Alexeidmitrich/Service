package service;


import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="idCategory")
    private int idCategory;
    private String type;

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
