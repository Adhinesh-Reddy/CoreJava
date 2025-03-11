package com.ims.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ims.dao.PolicyDAO;
import com.ims.model.Policy;
import com.ims.model.SubCategory;

public class PolicyDAOImpl implements PolicyDAO {

    private static List<Policy> policies = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

    @Override
    public void addPolicy() {
         for (int i = 0; i < 3; ++i) {
             System.out.println("Enter Sub Catrgory Number");
             int scid = sc.nextInt();
            System.out.println("Enter Policy Number");
			int pid = sc.nextInt();
			System.out.println("Enter Policy Name");
			String pname = sc.next();

			Policy pro = new Policy(scid, pid, pname);
			policies.add(pro);
            System.out.println("Sub Category added successfully");
        }
    }

    @Override
    public void updatePolicy(int pid) {
        if(policies !=null)
            for(Policy p: policies){
                if(p!=null)
                    if(p.getPid() == pid){
                        System.out.println("Enter Policy Name");
                        String pname = sc.next();
                        System.out.println("Enter Sub Category Number");
                        int scid = sc.nextInt();
                        p.setPname(pname);
                        p.setScid(scid);
                    }
            }
    }

    @Override
    public void deletePolicy(int pid) {
        if (policies != null)
		{
			for (Policy c : policies) {
				if (c != null)
					if (c.getPid() == pid) {
						policies.remove(c);
						System.out.println("Record Deleted SussessFully");
						break;
                    }
			}
		}//end of if
		else
			System.out.println("Given Record Not found");
    }

    @Override
    public Policy getPolicy(int pid) {
        if(policies != null){
            for(Policy c : policies){
                if(c != null)
                    if(c.getPid() == pid)
                        return c;
            }
        }
        return null;
    }

    @Override
    public List<Policy> getAllPolicy() {
        return policies;
    }
    
}
