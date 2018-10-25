public class Pencil {
    public int write(char characterToWrite) {
        if (Character.isUpperCase(characterToWrite)) {
            return 2;
        } else {
            return 1;
        }
    }
}
