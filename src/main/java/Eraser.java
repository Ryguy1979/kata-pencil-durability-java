class Eraser {

    private static final int ERASE_CHARACTER_VALUE = 1;
    private static final int WHITESPACE_ERASE_VALUE = 0;

    private static final int ERASER_DEFAULT_DURABILITY = 40000;

    Eraser() {
        this.eraserDurability = ERASER_DEFAULT_DURABILITY;
    }

    int getEraserDurability() {
        return eraserDurability;
    }

    void setEraserDurability(int eraserDurability) {
        this.eraserDurability = eraserDurability;
    }

    private int eraserDurability;

    void erase(String wordToErase, Paper paper) throws Exception {
        String stringToModify = paper.getText();
        int startReplacement = stringToModify.lastIndexOf(wordToErase);

        if (startReplacement == -1) {
            throw new Exception("Word to replace not found");
        }

        StringBuilder builder = new StringBuilder();

        builder.append(stringToModify, 0, startReplacement);
        builder.append(whiteSpaceReplacement(wordToErase));
        paper.setText(String.valueOf(builder.append(stringToModify.substring(startReplacement + wordToErase.length()))));
    }

    private char[] whiteSpaceReplacement(String wordToErase) {
        char[] returnedChars = wordToErase.toCharArray();

        for (int i = wordToErase.length() - 1; i > -1; i--) {
            if (eraserDurability >= calculateCharacterCost((char) wordToErase.indexOf(i))) {
                returnedChars[i] = ' ';
            }

            eraserDurability -= calculateCharacterCost((char) wordToErase.indexOf(i));
        }

        return returnedChars;
    }

    private int calculateCharacterCost(Character writtenCharacter) {
        return Character.isWhitespace(writtenCharacter) ? WHITESPACE_ERASE_VALUE : ERASE_CHARACTER_VALUE;
    }
}
