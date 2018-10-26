import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaperTest {


    @Test
    void writeWordToPaper() {
        Paper paper = new Paper();
        paper.setText("Word");
        assertEquals("Word", paper.getText());
    }
}