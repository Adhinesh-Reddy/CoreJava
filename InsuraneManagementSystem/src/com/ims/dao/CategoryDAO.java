package com.ims.dao;
import java.util.List;
import com.ims.model.Category;

public interface CategoryDAO{
    void addCategory();
    void updateCategory(int cid);
    void deleteCategory(int cid);
    Category getCategory(int cid);
    List<Category> getAllCategories();
}