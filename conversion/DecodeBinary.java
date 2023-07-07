package conversion;
import validate.Validate;

public class DecodeBinary implements DecodeStrategy {

    @Override
    public String convert(String binary) {

            Validate validateBin = new Validate();

            if(validateBin.validateBinary(binary) == null){
                System.out.println("La chaine binaire inseree n'est pas valide");
                System.exit(1);
            }
            
            String [] parts = binary.split(" ");
            StringBuilder decodedString = new StringBuilder();


            // iterate bin val
            for (String singleBin : parts) {

                int binaryNum = Integer.parseInt(singleBin);
                int n = 0;
                int decimal = 0;

                /*

                 For example, converting "1101" (a binary number) to decimal:
                (1 * (2^3)) + (1 * (2^2)) + (0 * (2^1)) + (1 * (2^0)) = 8 + 4 + 0 + 1 = 13

                 */

                while (binaryNum != 0) {

                    int remainder = binaryNum % 10; // GET rightmost (least significant), get remainder
                    binaryNum /= 10;    // POP rightmost 
                    decimal += remainder * Math.pow(2, n);  // remainder expo ^2
                    ++n;    // add 1 to n (indicate our current position)

                }
                
                // cast decimal to char
                char character = (char) decimal;

                // build result
                decodedString.append(character);
            }

            return decodedString.toString();
    }
    
}
