package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Enum.intituleRole;
import com.example.MNPETR.Model.User;

import java.util.List;

public interface IUserService {
    List<User> getUsersByRole(intituleRole role);

    User findByUsername(String username);
}
