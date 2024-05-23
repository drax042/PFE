package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Enum.intituleRole;
import com.example.MNPETR.Model.User;
import com.example.MNPETR.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {


    @Autowired
    private UserRepo userRepo;


    @Override
    public List<User> getUsersByRole(intituleRole role) {
        return userRepo.findUsersByRolesIntitule(role);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }


}
