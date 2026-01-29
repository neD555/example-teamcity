package plaindoll;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WelcomerTest {

    private final Welcomer welcomer = new Welcomer();

    @Test
    public void sayWelcomeContainsHello() {
        assertTrue(welcomer.sayWelcome().toLowerCase().contains("hello"));
    }

    @Test
    public void replyContainsHunter() {
        assertTrue(welcomer.reply().contains("hunter"));
    }
}
