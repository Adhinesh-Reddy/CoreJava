package com.ims.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ims.dao.CategoryDAO;
import com.ims.model.Category;


public class CategoryDAOImpl implements CategoryDAO{
    private static List<Category> category = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

    @Override
    public void addCategory(){
        System.out.println("Enter Category Number");
		int cid = sc.nextInt();
        System.out.println("Enter Category Name");
        String cname = sc.next();
        Category c = new Category(cid, cname);
        category.add(c);
    }

    @Override
    public Category getCategory(int cid){
        if(category != null){
            for(Category c : category){
                if(c != null)
                    if(c.getCid() == cid)
                        return c;
            }
        }
        return null;
    }

    @Override
    public List<Category> getAllCategories(){
        return category;
    }

    @Override
    public void updateCategory(int cid){
        if(category !=null)
            for(Category c: category){
                if(c!=null)
                    if(c.getCid() == cid){
                        System.out.println("Enter Category Name");
                        String cname = sc.next();
                        c.setCname(cname);
                    }
            }
    }

    @Override
    public void deleteCategory(int cid){
        if (category != null)
		{
			for (Category c : category) {
				if (c != null)
					if (c.getCid() == cid) {
						category.remove(c);
						System.out.println("Record Deleted SussessFully");
						break;
                    }
			}
		}//end of if
		else
			System.out.println("Given Record Not found");
    }

}
