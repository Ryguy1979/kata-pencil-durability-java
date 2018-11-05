class Pencil {



    private int pencilLength;
    private int pencilDurability;

    Pencil() {
        pencilDurability = PencilConstants.DEFAULT_PENCIL_DURABILITY;
        pencilLength = PencilConstants.DEFAULT_PENCIL_LENGTH;
    }

    int getPencilLength() {
        return pencilLength;
    }

    void setPencilLength(int pencilLength) {
        this.pencilLength = pencilLength;
    }

    int getPencilDurability() {
        return pencilDurability;
    }

    void setPencilDurability(int pencilDurability) {
        this.pencilDurability = pencilDurability;
    }

    void write(Paper paper, String textToWrite) {
        for (Character writtenCharacter : textToWrite.toCharArray()) {
            if(pencilDurability >= calculateCharacterCost(writtenCharacter)) {
                writeToPaper(paper, writtenCharacter);
            } else {
                writeToPaper(paper, ' ');
            }
            pencilDurability -= calculateCharacterCost(writtenCharacter);
        }
    }

    private int calculateCharacterCost(Character writtenCharacter) {
        if (Character.isWhitespace(writtenCharacter)) {
            return PencilConstants.WHITESPACE_DURABILITY_VALUE;
        } else {
            return Character.isUpperCase(writtenCharacter) ? PencilConstants.UPPERCASE_DURABILITY_VALUE : PencilConstants.LOWERCASE_DURABILITY_VALUE;
        }
    }

    private void writeToPaper(Paper paper, Character writtenCharacter) {
        paper.writeText(writtenCharacter);
    }

    void sharpen() {
        if (getPencilLength() != 0) {
            setPencilDurability(40000);
            setPencilLength(getPencilLength() - 1);
        }
    }

    void edit(String originalWord, String replacementWord, Paper paper) throws Exception {
        String stringToModify = paper.getText();
        int startReplacement = stringToModify.lastIndexOf(originalWord);

        if (startReplacement == -1) {
            throw new Exception("Word to replace not found");
        }

        StringBuilder builder = new StringBuilder();

        builder.append(stringToModify, 0, startReplacement);

        if (replacementWord.length() <= originalWord.length()) {
            builder.append(replacementWord);
            paper.setText(String.valueOf(builder.append(stringToModify.substring(startReplacement + replacementWord.length()))));
        } else {
            builder.append(replaceWordWithCollision(originalWord, replacementWord,
                    stringToModify.substring(startReplacement, startReplacement + replacementWord.length())));
            paper.setText(String.valueOf(builder.append(stringToModify.substring(startReplacement + replacementWord.length()))));
        }
    }

    private char[] replaceWordWithCollision(String originalWord, String replacementWord, String originalStringToEdit) {
        char[] returnedChars = originalStringToEdit.toCharArray();

        for (int i = 0; i < originalWord.length(); i++) {
            if (pencilDurability >= calculateCharacterCost(replacementWord.toCharArray()[i])) {
                returnedChars[i] = replacementWord.toCharArray()[i];
            } else {
                returnedChars[i] = ' ';
            }

            pencilDurability -= calculateCharacterCost(replacementWord.toCharArray()[i]);
        }

        for (int i = originalWord.length(); i < originalStringToEdit.length(); i++) {
            if (Character.isWhitespace(originalStringToEdit.toCharArray()[i])
                    && pencilDurability >= calculateCharacterCost(replacementWord.toCharArray()[i])) {
                returnedChars[i] = replacementWord.toCharArray()[i];
            } else if (Character.isWhitespace(originalStringToEdit.toCharArray()[i])) {
                returnedChars[i] = ' ';
            } else {
                returnedChars[i] = PencilConstants.COLLISION_CHARACTER;
            }

            pencilDurability -= calculateCharacterCost(replacementWord.toCharArray()[i]);
        }

        return returnedChars;
    }
}
