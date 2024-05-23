package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.Enum.intituleRole;
import com.example.MNPETR.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findUsersByRolesIntitule(intituleRole role);

    User findByUsername(String username);
}
