package ua.com.gosmartservice.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.gosmartservice.model.User;
import ua.com.gosmartservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/users")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepo.findAll().forEach(user -> users.add(user));
        return users;
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
    public User addUser(@RequestBody UserReq c) {
        User user = new User(c.getLogin(), c.getPassword(), c.getRole());
        return userRepo.save(user);
    }

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return userRepo.findOne(id);
    }

    @RequestMapping(value = "/users/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userRepo.delete(id);
    }

}

@Data
class UserReq {
    private String login;
    private String password;
    private String role;
}
