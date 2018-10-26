import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaperTest {


    @Test
    void writeWordToPaper() {
        Paper paper = new Paper();
        paper.writeText("Word");
        assertEquals("Word", paper.getText());
    }

    @Test
    void writeAppendsToPreexistingText() {
        Paper paper = new Paper();
        paper.setText("She sells sea shells");
        paper.writeText("down by the sea shore");

        assertEquals("She sells sea shells down by the sea shore", paper.getText());
    }
}