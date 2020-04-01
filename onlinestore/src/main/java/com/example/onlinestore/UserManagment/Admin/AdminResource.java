package com.example.onlinestore.UserManagment.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/admin") // This means URL's start with /demo (after Application path)
public class AdminResource {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private AdminRepository AdminRepository;


    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Admin> getAllUsers() {
        // This returns a JSON or XML with the users
        return AdminRepository.findAll();
    }
}
