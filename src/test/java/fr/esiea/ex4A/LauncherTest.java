package fr.esiea.ex4A;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LauncherTest {

    @Test
    void agifyServiceBean_test(){
        Launcher mock = new Launcher();

        AgifyService agifyService = mock.agifyService();

        assertNotNull(agifyService);
    }

}
