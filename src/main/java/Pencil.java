public class Pencil {

    private static final int DEFAULT_PENCIL_DURABILITY = 40000;
    private static final int UPPERCASE_DURABILITY_VALUE = 2;

    private int pencilDurability;

    Pencil() {
        this.pencilDurability = DEFAULT_PENCIL_DURABILITY;
    }

    long write(String charactersToWrite) {
        long upperCount = charactersToWrite.chars().filter(Character::isUpperCase).count();
        long lowerCount = charactersToWrite.chars().filter(Character::isLowerCase).count();

        return lowerCount + (upperCount * UPPERCASE_DURABILITY_VALUE);
    }

    int getPencilDurability() {
        return pencilDurability;
    }

    public void setPencilDurability(int pencilDurability) {
        this.pencilDurability = pencilDurability;
    }
}
