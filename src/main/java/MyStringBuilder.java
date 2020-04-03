public class MyStringBuilder {
    private char[] characters;
    private int size;
    private int length;

    public MyStringBuilder() {
        length = 16;
        characters = new char[length];
        size = 0;
    }

    public MyStringBuilder(String string) {
        length = string.length();
        characters = new char[length * 2];
        this.append(string);
    }

    public void append(String string) {
        int lengthOfString = string.length();
        int requiredCapacity = size + lengthOfString;
        if (requiredCapacity > length) {
            ensureCapacity(requiredCapacity);
        }
        System.arraycopy(string.toCharArray(), 0, characters, size, lengthOfString);
        size = requiredCapacity;
    }

    public String toString() {
        return String.valueOf(this.characters);
    }

    private void ensureCapacity (int requiredCapacity) {
        char[] newCharacters = new char[requiredCapacity * 2];
        System.arraycopy(characters, 0, newCharacters, 0, size);
        characters = newCharacters;
    }
}
