package com.ims.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ims.dao.SubCategoryDAO;
import com.ims.model.SubCategory;

public class SubCategoryDAOImpl implements SubCategoryDAO {

    private static List<SubCategory> subCategories = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

    @Override
    public void addSubCategory() {
        for (int i = 0; i < 3; ++i) {
            System.out.println("Enter Catrgory Number");
			int cid = sc.nextInt();
			System.out.println("Enter Sub Catrgory Number");
			int scid = sc.nextInt();
			System.out.println("Enter Sub Catrgory Name");
			String scname = sc.next();

			SubCategory pro = new SubCategory(cid, scid, scname);
			subCategories.add(pro);
            System.out.println("Sub Category added successfully");
        }
    }

    @Override
    public void updateSubCategory(int scid) {
        if(subCategories !=null)
            for(SubCategory c: subCategories){
                if(c!=null)
                    if(c.getScid() == scid){
                        System.out.println("Enter Sub Category Name");
                        String scname = sc.next();
                        System.out.println("Enter Category Number");
                        int cid = sc.nextInt();
                        c.setScname(scname);
                        c.setCid(cid);
                    }
            }
    }

    @Override
    public void deleteSubCategory(int scid) {
        if (subCategories != null)
		{
			for (SubCategory c : subCategories) {
				if (c != null)
					if (c.getScid() == scid) {
						subCategories.remove(c);
						System.out.println("Record Deleted SussessFully");
						break;
                    }
			}
		}//end of if
		else
			System.out.println("Given Record Not found");
    }

    @Override
    public SubCategory getSubCategory(int scid) {
        if(subCategories != null){
            for(SubCategory c : subCategories){
                if(c != null)
                    if(c.getScid() == scid)
                        return c;
            }
        }
        return null;
    }

    @Override
    public List<SubCategory> getAllSubCategory() {
        return subCategories;
    }
    
}
