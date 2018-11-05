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
        paper.writeText('W');
        assertEquals("W", paper.getText());
    }

    @Test
    void writeAppendsToPreexistingText() {
        paper.setText("She sells sea shells");
        paper.writeText(' ');

        assertEquals("She sells sea shells ", paper.getText());
    }
}