package cz.uhk.pro2_c.service;

import cz.uhk.pro2_c.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public interface UserService {
    ArrayList<User> getUsers();
    void saveUser(User user);
}
