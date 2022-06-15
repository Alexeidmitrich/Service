package service.database;

import service.Category;

import java.util.List;

public interface CategoryDAO {

    List<Category> getAllCategory();

    Category getCategoryById(int id);
    Category deleteCategoryById(int id);
    void save(Category category);

}
