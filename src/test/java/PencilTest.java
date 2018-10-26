import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PencilTest {

    private Pencil pencil;

    @BeforeEach
    void setUp() {
        pencil = new Pencil();
    }

    @Test
    void writeLowerCaseLetterForOneDurabilityPoints() {
        assertEquals(1, pencil.write("l"));
    }

    @Test
    void writeUpperCaseLetterForTwoDurabilityPoints() {
        assertEquals(2, pencil.write("U"));
    }

    @Test
    void writingTwoLowerCaseLettersForTwoDurabilityPoints() {
        assertEquals(2, pencil.write("ll"));
    }

    @Test
    void writingTwoUpperCaseLettersForFourDurabilityPoints() {
        assertEquals(4, pencil.write("UU"));
    }

    @Test
    void writingWorDForSixDurabilityPoints() {
        assertEquals(6, pencil.write("WorD"));
    }

    @Test
    void writingThisIsASentenceForNineteenDurabilityPoints() {
        assertEquals(19, pencil.write("This Is A Sentence"));
    }

    @Test
    void pencilStartsWithFortyThousandDurability() {
        assertEquals(40000, new Pencil().getPencilDurability());
    }
}
