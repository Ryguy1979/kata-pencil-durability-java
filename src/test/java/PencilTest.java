import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PencilTest {

    private Pencil pencil;
    private Paper paper;

    @BeforeEach
    void setUp() {
        pencil = new Pencil();
        paper = new Paper();
    }

    @Test
    void writeLowerCaseLetterForOneDurabilityPoints() {
        pencil.setPencilDurability(3);
        pencil.write(paper,"l");
        assertEquals(2, pencil.getPencilDurability());
    }

    @Test
    void writeUpperCaseLetterForTwoDurabilityPoints() {
        pencil.setPencilDurability(4);
        pencil.write(paper,"U");
        assertEquals(2, pencil.getPencilDurability());
    }

    @Test
    void writingTwoLowerCaseLettersForTwoDurabilityPoints() {
        pencil.setPencilDurability(5);
        pencil.write(paper,"ll");
        assertEquals(3, pencil.getPencilDurability());
    }

    @Test
    void writingTwoUpperCaseLettersForFourDurabilityPoints() {
        pencil.setPencilDurability(6);
        pencil.write(paper,"UU");
        assertEquals(2, pencil.getPencilDurability());
    }

    @Test
    void sharpenResetsPencilDurabilityToFortyThousand() {
        pencil.sharpen();
        assertEquals(40000, pencil.getPencilDurability());
    }

    @Test
    void writingWorDForSixDurabilityPoints() {
        pencil.setPencilDurability(1);
        pencil.write(paper,"WorD ");
        assertEquals("     ", paper.getText());
    }

    @Test
    void writingThisIsASentenceForNineteenDurabilityPoints() {
        pencil.setPencilDurability(18);
        pencil.write(paper,"This is A Sentence");
        assertEquals("This is A Sentence", paper.getText());
    }

    @Test
    void pencilStartsWithFortyThousandDurability() {
        assertEquals(40000, new Pencil().getPencilDurability());
    }

    @Test
    void pencilWithFourDurabilityCannotWriteTextToPaper() {
        pencil.setPencilDurability(2);
        pencil.write(paper, "Text");

        assertEquals("T   ", paper.getText());
    }

    @Test
    void pencilWithOneDurabilityCanOnlyWriteWhitespaceWithText() {
        pencil.setPencilDurability(1);
        pencil.write(paper, "Text");

        assertEquals("    ", paper.getText());
    }

    @Test
    void pencilWithFiveDurabilityCanWriteTextToPaper() {
        pencil.setPencilDurability(5);
        pencil.write(paper, "Text");

        assertEquals("Text", paper.getText());
    }
}
