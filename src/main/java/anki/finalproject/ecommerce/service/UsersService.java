package anki.finalproject.ecommerce.service;

import anki.finalproject.ecommerce.model.Users;
import anki.finalproject.ecommerce.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepo userRepository;

    public Users registerUser(Users user) {
        return userRepository.save(user);
    }
    public Optional<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean validateUser(String username, String password) {
        Optional<Users> userOptional =userRepository.findByUsername(username);
        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }

}
