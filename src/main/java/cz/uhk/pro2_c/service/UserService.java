package cz.uhk.pro2_c.service;

import cz.uhk.pro2_c.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {
    List<User> getUsers();
    void saveUser(User user);
    User getUser(long id);
    void deleteUser(long id);
}
