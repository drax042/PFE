package com.example.MNPETR.Service;

import com.example.MNPETR.Repository.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

    @Autowired
    public RolesRepo rolesRepo;
}
