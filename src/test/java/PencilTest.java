import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PencilTest {

    @Test
    public void writeUpperCaseLetterForTwoDurabilityPoints() {
        Pencil pencil = new Pencil();
        assertEquals(2, pencil.write('U'));
    }
}
