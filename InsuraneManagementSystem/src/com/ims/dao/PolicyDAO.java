package com.ims.dao;

import java.util.List;

import com.ims.model.Policy;

public interface PolicyDAO {
    void addPolicy();
    void updatePolicy(int pid);
    void deletePolicy(int pid);
    Policy getPolicy(int pid);
    List<Policy> getAllPolicy();
}
