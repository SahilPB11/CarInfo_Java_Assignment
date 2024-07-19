package car.info;

import static org.junit.Assert.*;
import org.junit.Test;

public class CricketMatchesTest {

    @Test
    public void testParseScore() {
        assertEquals(250, CricketMatches.parseScore("250/7"));
        assertEquals(150, CricketMatches.parseScore("150"));
        assertEquals(0, CricketMatches.parseScore(""));
        assertEquals(0, CricketMatches.parseScore(null));
    }

}
