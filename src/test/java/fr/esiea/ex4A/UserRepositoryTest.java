package fr.esiea.ex4A;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UserRepositoryTest {

    private final MockMvc mockMvc;

    @MockBean
    private  AgifyService agifyService;

    UserRepositoryTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void addUser_add_user_in_list() throws IOException {
        User user = new User("test@test.com", "test", "test", "FR", "M", "M");
        int size = agifyService.userRepository.users.size();
        agifyService.addUser(user);
        Assertions.assertEquals(agifyService.userRepository.users.size(), size + 1);
        Assertions.assertEquals(agifyService.userRepository.userAs.size(), size + 1);
        Assertions.assertEquals(agifyService.userRepository.users.get(user.mail), user);
    }


    @Test
    void filter_by_name() throws IOException {
        agifyService.addUser( new User("test@test.com", "test2", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test2", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test", "test", "RU", "M", "M"));
    }

    @Test
    void filter_by_country() throws IOException {
        agifyService.addUser( new User("test@test.com", "test2", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test2", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test", "test", "FR", "M", "M"));
        agifyService.addUser(new User("test@test.com", "test", "test", "RU", "M", "M"));
    }
}
