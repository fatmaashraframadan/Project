package com.example.onlinestore.UserManagment.Buyer;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller // This means that this class is a Controller
@RequestMapping(path="/buyer") // This means URL's start with /demo (after Application path)
public class BuyerResource {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private BuyerRepository BuyerRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (  @RequestParam String name
            ,
                                             @RequestParam String email,  @RequestParam String password
            ,  @RequestParam String username, @RequestParam String age
            ,  @RequestParam String adrress) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Buyer n = new Buyer();
        n.setUsername(username);
        n.setName(name);
        n.setEmail(email);
        n.setAge(age);
        n.setPassword(password);
        n.setAdrress(adrress);
        BuyerRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Buyer> getAllUsers() {
        // This returns a JSON or XML with the users
        return BuyerRepository.findAll();
    }
}
