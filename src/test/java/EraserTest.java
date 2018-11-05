import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EraserTest {

    private Eraser eraser;
    private Paper paper;

    @BeforeEach
    void setUp() {
        eraser = new Eraser();
        paper = new Paper();
    }

    @Test
    void eraserErasesGivenTextFromPaper() {
        paper.setText("How much wood would a woodchuck chuck if a woodchuck could chuck wood?");

        eraser.erase("chuck", paper);

        assertEquals("How much wood would a woodchuck chuck if a woodchuck could       wood?", paper.getText());
    }

    @Test
    void eraserErasesGivenTextFromPaperTwice() {
        paper.setText("How much wood would a woodchuck chuck if a woodchuck could chuck wood?");

        eraser.erase("chuck", paper);
        eraser.erase("chuck", paper);

        assertEquals("How much wood would a woodchuck chuck if a wood      could       wood?", paper.getText());
    }
}
