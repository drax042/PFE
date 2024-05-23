package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Enum.intituleRole;
import com.example.MNPETR.Model.User;

public interface IUserService {
    User getUsersByRole(intituleRole roles);
}
