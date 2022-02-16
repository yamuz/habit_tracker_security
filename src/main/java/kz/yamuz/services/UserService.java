package kz.yamuz.services;

import kz.yamuz.domain.Status;
import kz.yamuz.domain.User;
import kz.yamuz.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void processOAuthPostLogin(String email) {
        Optional<User> existUser = userRepository.findByEmail(email);

        if (existUser.isEmpty()) {
            User newUser = new User();
            newUser.setEmail(email);
            //newUser.getPassword();
            //newUser.setProvider(Provider.GOOGLE);
            newUser.setStatus(Status.ACTIVE);
            userRepository.save(newUser);

            System.out.println("Created new user: " + email);
        }

    }

    public User getUserByEmail(String username){
        User user = userRepository.findByEmail(username).orElse(null);
        return user;
    }

    @Transactional
    public User saveUser(User user){
        try {
            userRepository.save(user);
        } catch (Exception exception){
            log.error("unable to save user with email : " + user.getEmail() + " : " + exception);
            throw new RuntimeException(exception);
        }
        return user;
    }

}
