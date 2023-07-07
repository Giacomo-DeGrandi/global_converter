package ascii;

public class Ascii {
        
    public String textToASCII(String validInput){

        StringBuilder ascii = new StringBuilder();


        for( int i = 0 ; i < validInput.length(); i++){
            ascii.append((int) validInput.charAt(i)).append(" ");
        }

        return ascii.toString().trim();
    }

}
