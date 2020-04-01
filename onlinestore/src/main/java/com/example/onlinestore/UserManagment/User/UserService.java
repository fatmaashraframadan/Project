package com.example.onlinestore.UserManagment.User;

import com.example.onlinestore.UserManagment.Admin.Admin;
import com.example.onlinestore.UserManagment.Admin.AdminRepository;
import com.example.onlinestore.UserManagment.Buyer.Buyer;
import com.example.onlinestore.UserManagment.Buyer.BuyerRepository;
import com.example.onlinestore.UserManagment.Buyer.BuyerService;
import com.example.onlinestore.UserManagment.StoreOwner.StoreOwner;
import com.example.onlinestore.UserManagment.StoreOwner.StoreOwnerRepository;
import com.example.onlinestore.UserManagment.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private StoreOwnerRepository storeownerRepository;


    public String addUser(String username, String password , String email, String name,
                          String age, int type, String address){

        Validation validate = new Validation();

        if(!validate.validUsername(username)) return "This username is invalid or already taken";

        if(!validate.validEmail(email)) return "This email is invalid or already registered";

        if(!validate.validPassword(password)) return "Invalid password";

        switch (type) {
            case 1:
                Buyer buyer = new Buyer();

                buyer.setName(name);
                buyer.setEmail(email);
                buyer.setPassword(password);
                buyer.setUsername(username);
                buyer.setAge(age);
                buyer.setAdrress(address);
                BuyerService buyerservice = new BuyerService();
                if(!buyerservice.checkValidation(address))
                    return "Invalid address";
                else
                    buyerRepository.save(buyer);
                break;
            case 2:
                Admin admin = new Admin();
                admin.setName(name);
                admin.setEmail(email);
                admin.setPassword(password);
                admin.setUsername(username);
                admin.setAge(age);
                adminRepository.save(admin);
                break;
            case 3:
                StoreOwner storeowner = new StoreOwner();
                storeowner.setName(name);
                storeowner.setEmail(email);
                storeowner.setPassword(password);
                storeowner.setUsername(username);
                storeowner.setAge(age);
                storeownerRepository.save(storeowner);
                break;
        }

        return "Saved";
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
