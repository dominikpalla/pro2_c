package cz.uhk.pro2_c.rest;

import cz.uhk.pro2_c.model.User;
import cz.uhk.pro2_c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public List<User> getAll() {
        return userService.getUsers();
    }

    @GetMapping("/get/{id}")
    public User getAll(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PostMapping("/new")
    public String newUser(@RequestBody User user) {
        userService.saveUser(user);
        return "ok";
    }

    @PutMapping("/update/{id}")
    public String newUser(@PathVariable long id, @RequestBody User user) {
        if(userService.getUser(id) == null) {
            return "user does not exist";
        }
        user.setId(id);
        userService.saveUser(user);
        return "ok";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        if(userService.getUser(id) == null) {
            return "user does not exist";
        }
        userService.deleteUser(id);
        return "ok";
    }

}
