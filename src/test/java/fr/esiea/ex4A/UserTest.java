package fr.esiea.ex4A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class UserTest {

    @Test
    void to_String()
    {
        User user = new User("test@test.com", "test", "test", "FR", "M", "M");
        String toString = "User{" +
            "mail='" + "test@test.com" + '\'' +
            ", twitter='" + "test" + '\'' +
            ", username='" + "test" + '\'' +
            ", country='" + "FR" + '\'' +
            ", sex='" + "M" + '\'' +
            ", sexPref='" + "M" + '\'' +
            '}';
        Assertions.assertEquals(user.toString(), toString);
    }

    @Test
    void get_id()
    {
        User user = new User("test@test.com", "test", "test", "FR", "M", "M");
        Assertions.assertEquals("testFR", user.getId());
    }

    @Test
    void equal_user()
    {
        User user = new User("test@test.com", "test", "test", "FR", "M", "M");
        User user1 = new User("test@test.com", "test", "test", "FR", "M", "M");
        User user2 = new User("test2@test.com", "test2", "test2", "FR", "M", "M");
        Assertions.assertTrue(user.equals(user1));
        Assertions.assertFalse(user.equals(user2));
    }

    @Test
    void hash_code()
    {
        User user = new User("test@test.com", "test", "test", "FR", "M", "M");
        int hash = Objects.hash(user.mail, user.twitter, user.username, user.country, user.sex, user.sexPref);
        Assertions.assertEquals(hash, user.hashCode());
    }
}
