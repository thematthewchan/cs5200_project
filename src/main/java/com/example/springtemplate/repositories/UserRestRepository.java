package com.example.springtemplate.repositories;

import com.example.springtemplate.models.User;
import com.example.springtemplate.models.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRestRepository
        extends CrudRepository<User, Integer> {
    @Query(value = "SELECT * FROM users",
            nativeQuery = true)
    public List<User> findAllUsers();
    @Query(value = "SELECT * FROM users WHERE id=:userId",
            nativeQuery = true)
    public User findUserById(@Param("userId") Integer id);
    @Query(value = "SELECT * FROM vehicles WHERE user_id=:userId",
        nativeQuery = true)
    public List<Vehicle> getVehicles(@Param("userId") Integer id);
}
