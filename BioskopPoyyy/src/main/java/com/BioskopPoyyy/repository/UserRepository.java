package com.BioskopPoyyy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BioskopPoyyy.model.User;
import com.BioskopPoyyy.model.UserRoles;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    List<User> findByAddress(String address);
    User findByEmail(String email);
    User findById(long id);
    User findByEmailAndPassword(String email, String password);
    
    List<User> findByName(String name);
    List<User> findByPassword(String password);
    List<User> findByRole(UserRoles role);
    List<User> findBySurname(String surname);

}
