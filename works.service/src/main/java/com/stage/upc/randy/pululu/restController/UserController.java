package com.stage.upc.randy.pululu.restController;

import com.stage.upc.randy.pululu.models.User;
import com.stage.upc.randy.pululu.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    UserServices userServices;

    @RequestMapping(method =  RequestMethod.GET)
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    @RequestMapping(value="/{id}",method =  RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id){
        return userServices.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userServices.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        return userServices.updateUser(user);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) {
        userServices.deleteUserById(id);
    }
}
