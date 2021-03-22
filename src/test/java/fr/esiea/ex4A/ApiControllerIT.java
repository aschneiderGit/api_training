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

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ApiControllerIT {

    private final MockMvc mockMvc;

    @MockBean
    private  UserRepository repository;

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
        verify(repository).addUser(argumentCaptor.capture());
        Assertions.assertEquals(user, argumentCaptor.getValue());
    }
}
