package fr.esiea.ex4A;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ApiControllerIT {

    private final Launcher mock = new Launcher();
    private final MockMvc mockMvc;

    @MockBean
    private  AgifyService agifyService = new AgifyService(mock.agifyClient(), new UserRepository());

    ApiControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void post_inscription_add_user_in_userslist() throws Exception {
        User user = new User("test@test.com", "test", "test", "FR", "M", "M");
        final String  requestJSON = "{\"userEmail\":\"test@test.com\",\"userName\":\"test\",\"userTweeter\":\"test\",\"userCountry\":\"FR\",\"userSex\":\"M\",\"userSexPref\":\"M\"}";
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        mockMvc
            .perform(MockMvcRequestBuilders.post("/api/inscription/").contentType(MediaType.APPLICATION_JSON).content(requestJSON));
        verify(agifyService).addUser(argumentCaptor.capture());
        Assertions.assertEquals(user, argumentCaptor.getValue());
    }

    @Test
    void get_match() throws Exception {
        User user1 = new User("test@test.com", "Fabien", "test", "FR", "M", "F");
        UserAgify userA1 = new UserAgify("Fabien", 22, 10, "FR");
        User user2 = new User("test@test.com", "Julie", "test", "FR", "F", "M");
        UserAgify userA2 = new UserAgify("Julie", 22, 10, "FR");
        User user3 = new User("test@test.com", "Marie", "test", "FR", "F", "M");
        UserAgify userA3 = new UserAgify("test3", 32, 10, "FR");
        agifyService.userRepository.addUser(user1, userA1);
        agifyService.userRepository.addUser(user2, userA2);
        agifyService.userRepository.addUser(user3, userA3);
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?userName=Fabien&userCountry=FR"))
            .andExpect(status().isOk());
            //.andExpect(content().json());

    }
}
