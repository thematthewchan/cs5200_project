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

    @GetMapping("/orm/users/find")
    public List<User> findAllUser() {
        return userRepository.findAllUsers();
    }

    @GetMapping("/orm/users/find/id/{userId}")
    public User findUserById(@PathVariable("userId") Integer id) {
        return userRepository.findUserById(id);
    }

    @GetMapping("/orm/users/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Integer id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/orm/users/update/{userId}/{password}")
    public User updateUser(@PathVariable("userId") Integer id,
        @PathVariable("password") String password) {
        User user = userRepository.findUserById(id);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
