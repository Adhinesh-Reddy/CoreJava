package com.pms.details;
import java.util.Scanner;
import java.util.List;

import com.pms.model.Product;
import com.pms.dao.impl.ProductDAOImpl;

public class UserDetails {
    private static Scanner sc = new Scanner(System.in);
    private static ProductDAOImpl productdaoImpl = new ProductDAOImpl();

    public static void adminMenu(){
        while(true){
            System.out.println("\nAdmin Menu:");
            System.out.println("1) Add Products");
            System.out.println("2) View All Products");
            System.out.println("3) View Product");
            System.out.println("4) Update Products");
            System.out.println("5) Delete Product");
            System.out.println("6) Back");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    productdaoImpl.addProduct();
                    break;
                case 2:
                    List<Product> viewAllProducts= productdaoImpl.viewAllProducts();
                    if (viewAllProducts != null) {
                        for (Product st : viewAllProducts) {
                            if (st != null)
                                System.out.println(st.getPid() + "\t" + st.getPname() + "\t" + st.getQty() + "\t" + st.getPrice());
                        }
                    } // end of if
                    else
                        System.out.println("Records not Found");
                    break;
                case 3:
                    System.out.println("Enter Product Number");
                    Product pd = productdaoImpl.viewProduct(sc.nextInt());
                    if (pd != null)
                        System.out.println(pd.getPid() + "\t" + pd.getPname() + "\t" + pd.getQty() + "\t" + pd.getPrice());
                    else
                        System.out.println("Given Record Not Found");
                    break;
                case 4:
                    System.out.println("Enter Product Number");
                    productdaoImpl.updateProduct(sc.nextInt());
                    break;
                case 5:
                    System.out.println("Enter Product Number");
                    productdaoImpl.deleteProduct(sc.nextInt());
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
    public static void userMenu() {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1) View All Products");
            System.out.println("2) View Product");
            System.out.println("3) Update Products");
            System.out.println("4) Back");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    List<Product> viewAllProducts= productdaoImpl.viewAllProducts();
                    if (viewAllProducts != null) {
                        for (Product st : viewAllProducts) {
                            if (st != null)
                                System.out.println(st.getPid() + "\t" + st.getPname() + "\t" + st.getQty() + "\t" + st.getPrice());
                        }
                    } // end of if
                    else
                        System.out.println("Records not Found");
                    break;
                case 2:
                    System.out.println("Enter Product Number");
                    Product pd = productdaoImpl.viewProduct(sc.nextInt());
                    if (pd != null)
                        System.out.println(pd.getPid() + "\t" + pd.getPname() + "\t" + pd.getQty() + "\t" + pd.getPrice());
                    else
                        System.out.println("Given Record Not Found");
                    break;
                case 3:
                    System.out.println("Enter Product Number");
                    productdaoImpl.updateProduct(sc.nextInt());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
