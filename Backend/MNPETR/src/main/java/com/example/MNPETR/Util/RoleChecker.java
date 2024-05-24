package com.example.MNPETR.Util;

import com.example.MNPETR.Model.User;
import com.example.MNPETR.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RoleChecker {

    @Autowired
    private UserService userService;

    public boolean hasRole(String roleName) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.findByUsername(userDetails.getUsername());
        Set<String> roles = currentUser.getRoles().stream()
                .map(role -> role.getIntitule().name())
                .collect(Collectors.toSet());
        return roles.contains(roleName);
    }
}