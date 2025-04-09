package cz.uhk.pro2_c.service;

import cz.uhk.pro2_c.model.User;
import cz.uhk.pro2_c.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
