package edu.bjtu.reative.controller;

import edu.bjtu.reative.entity.User;
import edu.bjtu.reative.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
public class TestController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return this.userService.saveUser(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Integer id){
        this.userService.deleteUser(id);
        return "success";
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public Iterable<User> listUser(){
        return this.userService.getAllUsers();
    }
}
