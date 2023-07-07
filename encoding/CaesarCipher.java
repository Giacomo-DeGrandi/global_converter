package encoding;

public class CaesarCipher implements EncodingStrategy {

    @Override
    public String encode(String text, int key) {
        
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) ((character + key - base) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();

    }

}
