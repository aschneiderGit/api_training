package fr.esiea.ex4A;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UserRepositoryTest {

    private  UserRepository repository = new UserRepository();

    @Test
    void addUser_add_user_in_list() {
        User user = new User("test@test.com", "test", "test", "FR", "M", "M");
        int size = repository.users.size();
        repository.addUser(user);
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


    }
}
