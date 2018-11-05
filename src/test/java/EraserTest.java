import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EraserTest {

    private Eraser eraser;
    private Paper paper;

    @BeforeEach
    void setUp() {
        eraser = new Eraser();
        paper = new Paper();
    }

    @Test
    void eraserErasesGivenTextFromPaper() throws Exception {
        paper.setText("How much wood would a woodchuck chuck if a woodchuck could chuck wood?");

        eraser.erase("chuck", paper);

        assertEquals("How much wood would a woodchuck chuck if a woodchuck could       wood?", paper.getText());
    }

    @Test
    void eraserErasesGivenTextFromPaperTwice() throws Exception {
        paper.setText("How much wood would a woodchuck chuck if a woodchuck could chuck wood?");

        eraser.erase("chuck", paper);
        eraser.erase("chuck", paper);

        assertEquals("How much wood would a woodchuck chuck if a wood      could       wood?", paper.getText());
    }

    @Test
    void eraserStartsWithDefaultDurability() {
        assertEquals(40000, eraser.getEraserDurability());
    }

    @Test
    void eraserThrowsExceptionWhenWordToEraseNotFound() {
        paper.setText("Buffalo Bil");

        assertThrows(Exception.class, () -> eraser.erase("Bill", paper));
    }

    @Test
    void eraserErasesBillWithEnoughDurability() throws Exception {
        eraser.setEraserDurability(10);
        paper.setText("Buffalo Bill");
        eraser.erase("Bill", paper);

        assertEquals("Buffalo     ", paper.getText());
    }

    @Test
    void eraserWithThreeDurabilityLeavesB() throws Exception {
        eraser.setEraserDurability(3);
        paper.setText("Buffalo Bill");
        eraser.erase("Bill", paper);

        assertEquals("Buffalo B   ", paper.getText());
    }

    @Test
    void eraserWithTwoDurabilityLeavesBi() throws Exception {
        eraser.setEraserDurability(2);
        paper.setText("Buffalo Bill");
        eraser.erase("Bill", paper);

        assertEquals("Buffalo Bi  ", paper.getText());
    }
}
