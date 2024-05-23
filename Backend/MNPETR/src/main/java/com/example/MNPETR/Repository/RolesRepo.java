package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.Enum.intituleRole;
import com.example.MNPETR.Model.Roles;
import com.example.MNPETR.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RolesRepo extends JpaRepository<Roles, Integer> {
    boolean existsByIntitule(intituleRole intitule);

    Set<Roles> findByUsers(User user);
}
