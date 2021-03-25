package fr.esiea.ex4A;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import retrofit2.Call;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ApiControllerIT {

     final Launcher mock = new Launcher();
     final MockMvc mockMvc;

    @MockBean
    AgifyService agifyService;

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
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?userName=Fabien&userCountry=FR"))
            .andExpect(status().isOk());
        verify(agifyService).matchFor(argumentCaptor.capture(), argumentCaptor.capture());
        Assertions.assertEquals("Fabien", argumentCaptor.getAllValues().get(0));
        Assertions.assertEquals("FR", argumentCaptor.getAllValues().get(1));
    }
}
