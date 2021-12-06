package com.example.springtemplate.daos;

import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.UserRestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOrmDao {
    @Autowired
    UserRestRepository userRepository;

    @GetMapping("/orm/users/create/{fn}/{ln}/{un}/{pw}/{em}/{dob}")
    public User createUser(
        @PathVariable("fn") String firstName,
        @PathVariable("ln") String lastName,
        @PathVariable("un") String username,
        @PathVariable("pw") String password,
        @PathVariable("em") String email,
        @PathVariable("dob") String dob) {
        User user = new User(firstName, lastName, username, password, email, dob);
        return userRepository.save(user);
    }
    public List<User> findAllUser() { return null; }
    public User findUserById(Integer id) { return null; }
    public Integer deleteUser(Integer id) { return null; }
    public Integer updateUser() { return null; }
}
