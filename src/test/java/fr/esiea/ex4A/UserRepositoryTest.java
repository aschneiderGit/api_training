package fr.esiea.ex4A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UserRepositoryTest {

    private  UserRepository repository = new UserRepository();

    @Test
    void addUser_add_user_in_list() throws Exception {
        User user = new User("test@test.com", "test", "test", "FR", "M", "M");
        repository.addUser(user);
        Assertions.assertEquals(repository.users.size(), 1);
        Assertions.assertEquals(repository.users.get(0), user);
    }
}
