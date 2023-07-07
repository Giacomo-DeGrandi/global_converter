package conversion;

import java.util.Arrays;

public class HexadecimalConversionStrategy implements ConversionStrategy {
    @Override
    public String convert(String ascii) {

        StringBuilder hexadecimal = new StringBuilder();

        char[] hexDigits = "0123456789ABCDEF".toCharArray();

        // stream it to int []
        int[] intArr = Arrays.stream(ascii.split(" ")).mapToInt(Integer::parseInt).toArray();

        // foreach int [] val 
        for (int value : intArr) {

            StringBuilder hexChar = new StringBuilder();

            while (value != 0) {
                // divide the number by 16 and store the remainder
                int remainder = value % 16;
                // divide the value each iteration
                value /= 16;

                //  We append the reminder if less than 10 otherwise we subtract 10 from it and 
                //  convert the remainder to a character ('A' to 'F') for 10 to 15.
                hexChar.append( hexDigits[remainder] );
            }

            // Reverse the hexadecimal string as the conversion gives us the digits in reverse order
            hexChar.reverse();

            // format it to make it readable
            hexadecimal.append(hexChar.toString()).append(" ");
        }

        // The string should be in the correct order now, and no reversal is necessary.
        return hexadecimal.toString().trim();
    }

}