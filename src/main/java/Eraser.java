class Eraser {
    void erase(String wordToErase, Paper paper) {
        String stringToModify = paper.getText();
        int startReplacement = stringToModify.lastIndexOf(wordToErase);

        StringBuilder builder = new StringBuilder();

        builder.append(stringToModify, 0, startReplacement);
        builder.append(whiteSpaceReplacement(wordToErase));
        paper.setText(String.valueOf(builder.append(stringToModify.substring(startReplacement + wordToErase.length()))));
    }

    private char[] whiteSpaceReplacement(String wordToErase) {
        char[] returnedChars = wordToErase.toCharArray();

        for (int i = wordToErase.length() - 1; i > -1; i--) {
            returnedChars[i] = ' ';
        }

        return returnedChars;
    }
}
