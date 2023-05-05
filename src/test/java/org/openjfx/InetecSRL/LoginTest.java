package org.openjfx.InetecSRL;
/*
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openjfx.InetecSRL.controller.Login;
import org.openjfx.InetecSRL.domain.User;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

@RunWith(JfxTestRunner.class)
public class LoginTest {

    private static Login login;
    private static Stage stage;

    @BeforeClass
    public static void setUpClass() throws Exception {
        // Inizializza il toolkit JavaFX
        new JFXPanel();

        login = new Login("src/test/resources/org/openjfx/database/testRegistration.txt");
        stage = new Stage();
    }

    @Test
    public void testStart() {
        Platform.runLater(() -> login.start(stage));
        assertNotNull(stage.getScene());
        assertEquals("Login", stage.getTitle());
    }

    @Test
    public void testAuthenticate() {
        assertTrue(login.authenticate(new User("Mario", "Rossi", "mario.rossi@example.com", "password")));
        assertFalse(login.authenticate(new User("Mario", "Bianchi", "mario.bianchi@example.com", "password")));
    }
}
*/