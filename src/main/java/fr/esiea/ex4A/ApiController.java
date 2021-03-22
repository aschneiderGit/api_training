package fr.esiea.ex4A;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ApiController {

    private final UserRepository userRepository;
    ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "api/inscription")
    void inscription(@RequestBody User user) {
        userRepository.addUser(user);
        System.out.println(user);
        System.out.println(userRepository.users.size());
        System.out.println(userRepository.users.get(userRepository.users.size()-1));
    }

    @GetMapping("api/matches")
    void match(@RequestParam(name="userName") String username, @RequestParam(name="userCountry") String country) {
        System.out.println(country);
        System.out.println(username);
        userRepository.addUser( new User("test@test.com", "test2", "test", "FR", "M", "M"));
        userRepository.addUser(new User("test@test.com", "test2", "test", "FR", "M", "M"));
        userRepository.addUser(new User("test@test.com", "test3", "test", "RU", "M", "M"));
        userRepository.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        userRepository.addUser(new User("test@test.com", "test3", "test", "FR", "M", "M"));
        userRepository.addUser(new User("test@test.com", "test", "test", "FR", "M", "M"));
        userRepository.addUser(new User("test@test.com", "test", "test", "FR", "M", "M"));
        userRepository.addUser(new User("test@test.com", "test", "test", "FR", "M", "M"));
        System.out.println(userRepository.users);
        ArrayList<User> userMatch = userRepository.getByCountry(country, userRepository.getByUsername(username, userRepository.users));
        System.out.println(userMatch);

    }
}
