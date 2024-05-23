package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Roles;
import com.example.MNPETR.Model.User;
import com.example.MNPETR.Repository.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RolesService {

    @Autowired
    public RolesRepo rolesRepo;

    public Set<Roles> getRolesByUser(User user) {
        return rolesRepo.findByUsers(user);
    }
}
