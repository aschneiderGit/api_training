package fr.esiea.ex4A;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.ArrayList;

import java.util.ArrayList;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UserRepositoryTest {

<<<<<<< HEAD
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
        User user4 = new User("test@test.com", "test3", "test", "FR", "F", "F");
        UserAgify userA4 = new UserAgify("test3", 32, 10, "FR");
        userRepository.addUser(user4, userA4);
        ArrayList<User> usersList = userRepository.matchUsers(user1);
        Assertions.assertTrue(usersList.contains(user2));
        Assertions.assertFalse(usersList.contains(user3));
        Assertions.assertFalse(usersList.contains(user4));
        usersList = userRepository.matchUsers(user2);
        Assertions.assertTrue(usersList.contains(user1));
        Assertions.assertFalse(usersList.contains(user3));
<<<<<<< HEAD


=======
    private  UserRepository repository = new UserRepository();

    @Test
    void addUser_add_user_in_list() {
        User user = new User("test@test.com", "test", "test", "FR", "M", "M");
        int size = repository.users.size();
        repository.addUser(user);
<<<<<<< HEAD
        Assertions.assertEquals(repository.users.size(), 1);
        Assertions.assertEquals(repository.users.get(0), user);
>>>>>>> e78aff8... on passe au get, tanpis pour les tests on verra plus tard :/
=======
        Assertions.assertEquals(repository.users.size(), size + 1);
        Assertions.assertEquals(repository.users.get(size), user);
        System.out.println(size);
    }


    @Test
    void filter_by_name() {
        repository.addUser( new User("test@test.com", "test2", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test2", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test", "test", "RU", "M", "M"));
        ArrayList<User> userMatch = repository.getByUsername("test2", repository.users);
        Assertions.assertEquals(userMatch.size(), 2);
        for (int i = 0;i<userMatch.size(); i++ )
        {
            Assertions.assertEquals(userMatch.get(i), repository.users.get(i));
        }

    }

    @Test
    void filter_by_country(){
        repository.addUser( new User("test@test.com", "test2", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test2", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test", "test", "FR", "M", "M"));
        repository.addUser(new User("test@test.com", "test", "test", "RU", "M", "M"));
        ArrayList<User> userMatch = repository.getByCountry("FR", repository.users);
        Assertions.assertEquals(userMatch.size(), 7);
        for (int i = 0;i<userMatch.size(); i++ )
        {
            Assertions.assertEquals(userMatch.get(i), repository.users.get(i));
        }


>>>>>>> 12164be... test for get
=======
        Assertions.assertFalse(usersList.contains(user4));
>>>>>>> 1e11f29... rise pourcent codecov
    }
}
