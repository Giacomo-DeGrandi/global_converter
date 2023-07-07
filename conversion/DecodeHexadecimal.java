package conversion;

import validate.Validate;

public class DecodeHexadecimal implements DecodeStrategy {
    
    @Override
    public String convert(String hex) {

            Validate validateHex = new Validate();

            if(validateHex.validateHex(hex) == null){
                System.out.println("La chaine hexadecimale inseree n'est pas valide");
                System.exit(1);
            }
            
            String [] parts = hex.split(" ");
            StringBuilder decodedString = new StringBuilder();

            String digits = "0123456789ABCDEF";
            hex = hex.toUpperCase();

            // iterate bin val
            for (String singleHex : parts) {

                int val = 0;

                for (int i = 0; i < singleHex.length(); i++) {
                    char c = singleHex.charAt(i);
                    int d = digits.indexOf(c);
                    val = 16*val + d;
                }
                
                // cast decimal to char
                char character = (char) val;

                // build result
                decodedString.append(character);
            }

            return decodedString.toString();
    }
}
