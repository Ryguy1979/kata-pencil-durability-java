public class Pencil {



    private int pencilLength;
    private int pencilDurability;

    Pencil() {
        pencilDurability = PencilConstants.DEFAULT_PENCIL_DURABILITY;
        pencilLength = PencilConstants.DEFAULT_PENCIL_LENGTH;
    }

//    long write(String charactersToWrite) {
//        long upperCount = charactersToWrite.chars().filter(Character::isUpperCase).count();
//        long lowerCount = charactersToWrite.chars().filter(Character::isLowerCase).count();
//
//        return (lowerCount * LOWERCASE_DURABILITY_VALUE) + (upperCount * UPPERCASE_DURABILITY_VALUE);
//    }

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

    private StringBuilder replaceTextWithWhitespace(String text, long durabilityToWrite) {
        int startWhitespaceReplacement = text.length() - ((int)durabilityToWrite - pencilDurability);
        int endWhitespaceReplacement = text.length();

        return new StringBuilder(text).replace(startWhitespaceReplacement, endWhitespaceReplacement, " ");
    }

    public int write(char characterToWrite) {
        return 0;

    }

    void sharpen() {
        if (getPencilLength() != 0) {
            setPencilDurability(40000);
            setPencilLength(getPencilLength() - 1);
        }
    }
}
