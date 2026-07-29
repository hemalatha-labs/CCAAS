//package Repo;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

//import model.User;

//@Repository
//public interface UserRepo extends JpaRepository<User, Long>{

//}


package com.CCS.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CCS.Service.model.*;
@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}