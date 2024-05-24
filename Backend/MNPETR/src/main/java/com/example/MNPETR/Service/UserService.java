    package com.example.MNPETR.Service;

    import com.example.MNPETR.Model.Enum.intituleRole;
    import com.example.MNPETR.Model.User;
    import com.example.MNPETR.Repository.UserRepo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import java.util.List;

    @Service
    public class UserService implements IUserService {


        @Autowired
        private UserRepo userRepo;

        @Autowired
        private PasswordEncoder passwordEncoder;


        @Override
        public List<User> getUsersByRole(intituleRole role) {
            return userRepo.findUsersByRolesIntitule(role);
        }

        @Override
        public User findByUsername(String username) {
            return userRepo.findByUsername(username);
        }

        public boolean checkCredentials(User user) {
            User existingUser = userRepo.findByUsername(user.getUsername());
            if (existingUser != null) {
                return passwordEncoder.matches(user.getPassword(), existingUser.getPassword());
            }
            return false;
        }
    }
