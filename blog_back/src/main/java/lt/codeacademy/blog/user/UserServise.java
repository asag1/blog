package lt.codeacademy.blog.user;

import lt.codeacademy.blog.config.NotFoundException;
import org.springframework.stereotype.Service;

import static lt.codeacademy.blog.user.Role.ROLE_ADMIN;

@Service
public class UserServise {

    private User user = new User ("Name", "email@gmail.com", "pasword", ROLE_ADMIN);

    public User getUser() {
        if (user == null) {
            throw new NotFoundException("Person info not found");
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void updatePerson(User updateUser) {
        if (updateUser.getUsername() != null) {
            user.setUsername(updateUser.getUsername());
        }
        if (updateUser.getEmail() != null) {
            user.setEmail(updateUser.getEmail());
        }
        if (updateUser.getPassword() != null) {
            user.setPassword(updateUser.getPassword());
        }
        if (updateUser.getRole() != null) {
            user.setRole(updateUser.getRole());
        }
    }
}
