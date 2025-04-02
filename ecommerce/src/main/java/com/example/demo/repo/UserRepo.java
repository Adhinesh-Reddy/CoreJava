package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
    Optional<User> findByUserIdAndIsDeletedFalse(Long userId);

    @Query("select u from User u where u.isDeleted=false")
    List<User> findAllActiveUsers();
    // List<User> findByIsDeletedFalse();
}
