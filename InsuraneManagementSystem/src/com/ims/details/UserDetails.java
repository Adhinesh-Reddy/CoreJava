package com.ims.details;

import java.util.List;
import java.util.Scanner;
import com.ims.dao.impl.CategoryDAOImpl;
import com.ims.model.Category;

public class UserDetails {
    private static Scanner sc = new Scanner(System.in);
    private static CategoryDAOImpl categorydaoImpl = new CategoryDAOImpl();

    public static void adminMenu(){
        while(true){
            System.out.println("\nAdmin Menu:");
            System.out.println("1) Add Category");
            System.out.println("2) View All Categories");
            System.out.println("3) View Category");
            System.out.println("4) Update Category");
            System.out.println("5) Delete Category");
            System.out.println("6) Back");
            System.out.print("Enter choice: ");

            int choiceCategory = sc.nextInt();
            sc.nextLine();

            switch (choiceCategory) {
                case 1:
                    categorydaoImpl.addCategory();
                    break;
                case 2:
                    List<Category> getAllCategories= categorydaoImpl.getAllCategories();
                    if (getAllCategories != null) {
                        for (Category st : getAllCategories) {
                            if (st != null)
                                System.out.println(st.getCid() + "\t" + st.getCname());
                        }
                    } // end of if
                    else
                        System.out.println("Records not Found");
                    break;
                case 3:
                    System.out.println("Enter Category Number");
                    Category pd = categorydaoImpl.getCategory(sc.nextInt());
                    if (pd != null)
                        System.out.println(pd.getCid() + "\t" + pd.getCname());
                    else
                        System.out.println("Given Record Not Found");
                    break;
                case 4:
                    System.out.println("Enter Category Number");
                    categorydaoImpl.updateCategory(sc.nextInt());
                    break;
                case 5:
                    System.out.println("Enter Category Number");
                    categorydaoImpl.deleteCategory(sc.nextInt());
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
