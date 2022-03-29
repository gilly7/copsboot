package com.example.copsboot;

import com.example.copsboot.repository.UserRepository;
import com.example.copsboot.user.User;
import com.example.copsboot.user.UserRole;
import  org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;
    @Test
    public void testStoreUser() {
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);
        User user = repository.save(new User(UUID.randomUUID(),
                "alex.foley@beverly-hills.com",
                "my-secret-pwd",
                roles));
        assertThat(user).isNotNull(); //The object returned from the save method of the repository should return a non-null object.
        assertThat(repository.count()).isEqualTo(1L); //⑦If you count the number of User entities in the database, you should have one.
    }
}