package encoding;

public class CaesarCipher implements EncodingStrategy {

    @Override
    public String encode(String text, int key) {

        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int offset = (character - base + key) % 26;
                if (offset < 0) {
                    offset += 26;
                }
                // Map the offset back to the correct ASCII values for characters
                result.append((char) (offset + (Character.isLowerCase(character) ? 'a' : 'A')));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
