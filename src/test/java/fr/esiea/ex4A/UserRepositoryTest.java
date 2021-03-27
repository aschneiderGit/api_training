package fr.esiea.ex4A;

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

    private UserRepository userRepository = new UserRepository();

    @Test
    void addUser_add_user_in_list() throws IOException {
        User user = new User("test@test.com", "test", "test", "FR", "M", "M");
        UserAgify userA = new UserAgify("test", 22,1, "FR");
        int size = userRepository.users.size();
        userRepository.addUser(user, userA);
        Assertions.assertEquals(userRepository.users.size(), size + 1);
        Assertions.assertEquals(userRepository.userAs.size(), size + 1);
        Assertions.assertEquals(userRepository.users.get(user.getId()), user);
        userRepository.addUser(user, userA); //Add same user shouldn't incremant repository
        Assertions.assertEquals(userRepository.users.size(), size + 1);
        Assertions.assertEquals(userRepository.userAs.size(), size + 1);
        Assertions.assertEquals(userRepository.users.get(user.getId()), user);
    }


    @Test
    void match_users() throws IOException {
        User user1 = new User("test@test.com", "test1", "test", "FR", "M", "F");
        UserAgify userA1 = new UserAgify("test1", 22, 10, "FR");
        userRepository.addUser(user1, userA1);
        User user2 = new User("test@test.com", "test2", "test", "FR", "F", "M");
        UserAgify userA2 = new UserAgify("test2", 22, 10, "FR");
        userRepository.addUser(user2, userA2);
        User user3 = new User("test@test.com", "test3", "test", "FR", "F", "M");
        UserAgify userA3 = new UserAgify("test3", 32, 10, "FR");
        userRepository.addUser(user3, userA3);


        ArrayList<User> usersList = userRepository.matchUsers(user1);
        Assertions.assertTrue(usersList.contains(user2));
        Assertions.assertFalse(usersList.contains(user3));
        usersList = userRepository.matchUsers(user2);
        Assertions.assertTrue(usersList.contains(user1));
        Assertions.assertFalse(usersList.contains(user3));
    }
}
