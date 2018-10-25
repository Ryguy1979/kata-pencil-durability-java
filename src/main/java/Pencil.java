public class Pencil {

    private static final int UPPERCASE_DURABILITY_VALUE = 2;

    public long write(String charactersToWrite) {
        long upperCount = charactersToWrite.chars().filter(Character::isUpperCase).count();
        long lowerCount = charactersToWrite.chars().filter(Character::isLowerCase).count();

        return lowerCount + (upperCount * UPPERCASE_DURABILITY_VALUE);
    }
}
