package org.example.petblog.data;


import org.example.petblog.data.entity.Role;
import org.example.petblog.data.entity.User;
import org.example.petblog.data.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;


import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenCreateUser_thenUserIsSaved() {
        User user = new User();
        user.setUserName("user1");
        user.setEmail("mylo@gmail.com");
        user.setRole(Role.USER);
        user.setPasswordHash("hashedPassword");
        userRepository.save(user);

        Optional<User> foundUser = userRepository.findByEmail(user.getEmail());
        assert (foundUser.isPresent());
        assert (Objects.equals(foundUser.get().getId(), user.getId()));




    }

}
