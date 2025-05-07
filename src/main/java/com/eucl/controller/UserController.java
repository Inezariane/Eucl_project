package com.eucl.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.eucl.service.UserService;
import com.eucl.user.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @GetMapping("/name/{name}")
    public User getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
    @GetMapping("/phone/{phone}")
    public User getUserByPhone(@PathVariable String phone){
        return userService.getUserByPhone(phone);
    }
    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable Role role){
        return userService.getUsersByRole(role);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails){
        return userService.updateUser(id, userDetails);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
    
}
