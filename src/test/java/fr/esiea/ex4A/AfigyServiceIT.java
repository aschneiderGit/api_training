package fr.esiea.ex4A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AfigyServiceIT {

    final Launcher mock = new Launcher();

    AgifyService afigyService = new AgifyService(mock.agifyClient(), new UserRepository());

    @Test
    void add_user() throws IOException {
        User user = new User("test@test.com", "test", "test", "FR", "M", "M");
        afigyService.addUser(user);
        Assertions.assertEquals(user, afigyService.userRepository.users.get("testFR"));
        Assertions.assertEquals(1, afigyService.userRepository.userAs.size());
    }

    @Test
    void match_for() throws IOException {
        User user = new User("test@test.com", "test", "test", "FR", "M", "M");
        afigyService.addUser(user);
        ArrayList<User> users = afigyService.matchFor("test", "FR");
        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals(user, users.get(0));
        users = afigyService.matchFor("azerty", "RU");
        Assertions.assertEquals(new ArrayList<User>(), users);

    }
}
