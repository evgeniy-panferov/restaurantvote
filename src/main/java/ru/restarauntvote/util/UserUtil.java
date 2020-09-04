package ru.restarauntvote.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import ru.restarauntvote.model.Role;
import ru.restarauntvote.model.User;

import java.time.LocalDateTime;
import java.time.Month;

public class UserUtil {

    public static User createUserWithRoleNotAdmin(User user) {
        return new User(null, user.getPassword(), user.getEmail().toLowerCase(), user.getName(), LocalDateTime.of(1900, Month.JANUARY, 1, 6, 30), Role.USER);
    }

    public static User prepareToSave(User user, PasswordEncoder passwordEncoder) {
        String password = user.getPassword();
        user.setPassword(StringUtils.hasText(password) ? passwordEncoder.encode(password) : password);
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}
