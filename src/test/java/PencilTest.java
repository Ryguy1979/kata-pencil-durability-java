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
    void pencilStartsWithADefaultLengthOfTen() {
        assertEquals(10, pencil.getPencilLength());
    }

    @Test
    void sharpenRemovesOneLengthValueFromPencil() {
        pencil.sharpen();
        assertEquals(9, pencil.getPencilLength());
    }

    @Test
    void sharpeningTwiceRemovesTwoLengthFromPencil() {
        pencil.sharpen();
        pencil.sharpen();
        assertEquals(8, pencil.getPencilLength());
    }

    @Test
    void sharpenPencilWithZeroLengthDoesNotAffectDurability() {
        pencil.setPencilLength(0);
        pencil.setPencilDurability(15000);
        pencil.sharpen();

        assertEquals(15000, pencil.getPencilDurability());
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

    @Test
    void pencilEditsAppleWithOnion() throws Exception {
        paper.setText("An apple a day keeps the doctor away");
        pencil.edit("apple", "onion", paper);

        assertEquals("An onion a day keeps the doctor away", paper.getText());
    }

    @Test
    void pencilEditsAppleWithArtichoke() throws Exception {
        paper.setText("An apple a day keeps the doctor away");
        pencil.edit("apple", "artichoke", paper);

        assertEquals("An artich@k@ay keeps the doctor away", paper.getText());
    }

    @Test
    void pencilEditsAppleWithArtichokeAndFiveDurability() throws Exception {
        pencil.setPencilDurability(5);
        paper.setText("An apple a day keeps the doctor away");
        pencil.edit("apple", "artichoke", paper);

        assertEquals("An artic @ @ay keeps the doctor away", paper.getText());
    }

    @Test
    void pencilEditsAppleWithArtichokeAndFiveDurabilityAndCapitals() throws Exception {
        pencil.setPencilDurability(5);
        paper.setText("An apple a day keeps the doctor away");
        pencil.edit("apple", "ARtichoke", paper);

        assertEquals("An ARt   @ @ay keeps the doctor away", paper.getText());
    }
}
