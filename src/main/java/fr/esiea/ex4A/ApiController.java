package fr.esiea.ex4A;

import org.springframework.web.bind.annotation.*;

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
}
