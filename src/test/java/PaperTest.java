import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaperTest {

    private Paper paper;

    @BeforeEach
    void setUp() {
        paper = new Paper();
    }


    @Test
    void writeWordToPaper() {
        paper.writeText("Word");
        assertEquals("Word", paper.getText());
    }

    @Test
    void writeAppendsToPreexistingText() {
        paper.setText("She sells sea shells");
        paper.writeText("down by the sea shore");

        assertEquals("She sells sea shells down by the sea shore", paper.getText());
    }
}