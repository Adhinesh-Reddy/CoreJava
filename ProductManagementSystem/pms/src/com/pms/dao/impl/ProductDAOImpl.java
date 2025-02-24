package com.pms.dao.impl;

import com.pms.dao.ProductDAO;
import com.pms.model.Product;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductDAOImpl implements ProductDAO{

    private static List<Product> products = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
    
    @Override
    public void addProduct(){
		for (int i = 0; i < 3; ++i) {
			System.out.println("Enter Product Number");
			int pid = sc.nextInt();
			System.out.println("Enter Product Name");
			String pname = sc.next();
			System.out.println("Enter Product Quantity");
			String qty = sc.next();
			System.out.println("Enter product Price");
			String price = sc.next();

			Product pro = new Product(pid, pname, qty, price);
			products.add(pro);
        System.out.println("Product added successfully");
        }
    }

    @Override
    public List<Product> viewAllProducts(){
        return products;
    }

    @Override
    public Product viewProduct(int pid){
        if (products != null)
			for (Product pd : products) {
				if (pd != null)
					if (pd.getPid() == pid)
						return pd;
			}
		return null;
    }

    @Override
    public void updateProduct(int pid){
        if (products != null)
			for (Product pd : products) {
				if (pd != null)
					if (pd.getPid() == pid) {
						System.out.println("Do you want modify 1)Product Name 2)Quantity 3)Price");

						int choice = sc.nextInt();
						switch (choice) {
						case 1:
							System.out.println("Enter Product Name");
							pd.setPname(sc.next());
							System.out.println("Product Name updated");
							break;

						case 2:
							System.out.println("Enter Product Quantity");
							pd.setQty(sc.next());
							System.out.println(" Product Quantity updated");
							break;
						case 3:
							System.out.println("Enter Product Price");
							pd.setPrice(sc.next());
							System.out.println("Product Price updated");
							break;
						default:
							System.out.println("Choose 1 to 3 Between");

						}// end of switch

					} // end of for
					
			} // end of if
        else
        System.out.println("Given Record Not found");
    }

    @Override
    public void deleteProduct(int pid){
		if (products != null)
		{
			for (Product pd : products) {
				if (pd != null)
					if (pd.getPid() == pid) {
						products.remove(pd);
						System.out.println("Record Deleted SussessFully");
						break;
                    }
			}
		}//end of if
		else
			System.out.println("Given Record Not found");
    }
}
