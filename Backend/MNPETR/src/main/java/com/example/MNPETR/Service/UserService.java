package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Enum.intituleRole;
import com.example.MNPETR.Model.User;
import com.example.MNPETR.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    public UserRepo userRepo;

    @Override
    public User getUsersByRole(intituleRole roles) {
        return userRepo.finduserByIntituleRole(roles);
    }
}
