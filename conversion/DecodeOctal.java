package conversion;

import validate.Validate;

public class DecodeOctal implements DecodeStrategy {
    
    @Override
    public String convert(String octal) {

            Validate validateOct = new Validate();

            if(validateOct.validateOctal(octal) == null){
                System.out.println("La chaine octale inseree n'est pas valide");
                System.exit(1);
            }
            
            String [] parts = octal.split(" ");
            StringBuilder decodedString = new StringBuilder();


            // iterate bin val
            for (String singleOct : parts) {

                int total = 0;
                int power = 0;

                // iterate over each digit, starting from the right (least significant)
                for (int i = singleOct.length() - 1; i >= 0; i--) {
                    // get digit at current position
                    int digit = Character.getNumericValue(singleOct.charAt(i));
                    // add the total to the rightdigit then elevate to ^8
                    total += digit * Math.pow(8, power);
                    // add 1 to pow
                    power++;
                }
                
                // cast decimal to char
                char character = (char) total;

                // build result
                decodedString.append(character);
            }

            return decodedString.toString();
    }
}
