package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.Enum.intituleRole;
import com.example.MNPETR.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User finduserByIntituleRole(Enum intituleRole);
}
