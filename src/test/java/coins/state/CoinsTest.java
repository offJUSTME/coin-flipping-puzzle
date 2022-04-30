package coins.state;

import org.junit.jupiter.api.Test;

import java.nio.LongBuffer;
import java.util.BitSet;

import static coins.state.Coins.generateFlips;
import static java.util.BitSet.valueOf;
import static org.apache.commons.math3.util.CombinatoricsUtils.binomialCoefficient;
import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

    private Coins state1 = new Coins(7, 3); // the original initial state

    private Coins state2; // the goal state
    {
        BitSet bs = new BitSet(7);
        bs.set(0, 7);
        state2 = new Coins(7, 3, bs);
    }

    @Test
    void testGetCoins() {
        assertEquals(state1.isGoal(), state2.isGoal());
        assertNotEquals(state1.isGoal(), false);
        assertNotEquals(state2.isGoal(), false);
    }

    @Test
    void testIsGoal() {
        assertEquals(state1.isGoal(), state2.isGoal());
        assertNotEquals(state1.isGoal(), false);
        assertNotEquals(state2.isGoal(), false);
    }

    @Test
    void testCanFlip() {
        assertEquals(state1.canFlip(valueOf(LongBuffer.allocate(2))), state2.canFlip(valueOf(LongBuffer.allocate(2))));
        assertNotEquals(state1.canFlip(valueOf(LongBuffer.allocate(2))), state2.canFlip(valueOf(LongBuffer.allocate(4))));
        assertNotEquals(state1.canFlip(valueOf(LongBuffer.allocate(4))), state2.canFlip(valueOf(LongBuffer.allocate(2))));
    }

    @Test
    void testFlip() {
        assertEquals(state1.canFlip(valueOf(LongBuffer.allocate(7))), state2.canFlip(valueOf(LongBuffer.allocate(7))));
        assertNotEquals(state1.canFlip(valueOf(LongBuffer.allocate(7))), state2.canFlip(valueOf(LongBuffer.allocate(0))));
    }

    @Test
    void testGenerateFlips() {
        assertEquals(generateFlips(7, 3),  binomialCoefficient( 7, 3));
        assertEquals(generateFlips(0, 7),  binomialCoefficient( 0, 7));
    }

    @Test
    void testGetFlips() {
        assertEquals(state1.getFlips(), state2.getFlips());
    }
}