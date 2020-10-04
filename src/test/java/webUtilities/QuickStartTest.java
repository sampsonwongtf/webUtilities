package webUtilities;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickStartTest {
    @Test public void testAppHasAGreeting() {
        QuickStart classUnderTest = new QuickStart();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
