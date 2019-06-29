package lt.codeacademy.blog.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
@CrossOrigin("*")
public class UserController {

    private final UserServise userServise;

    @Autowired
    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping(path = "/info")
    public User GetUserInfo() {
        return userServise.getUser();
    }
    @PostMapping(path = "/create-info")
    public void createUserInfo(@RequestBody User user) {
        this.userServise.setUser(user);
    }

    @PutMapping(path = "/update-info")
    public void updateUserInfo(@RequestBody User user) {
        this.userServise.updatePerson(user);
    }
}
