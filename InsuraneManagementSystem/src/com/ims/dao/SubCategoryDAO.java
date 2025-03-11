package com.ims.dao;

import com.ims.model.SubCategory;
import java.util.List;

public interface SubCategoryDAO {
    void addSubCategory();
    void updateSubCategory(int scid);
    void deleteSubCategory(int scid);
    SubCategory getSubCategory(int scid);
    List<SubCategory> getAllSubCategory();
}
