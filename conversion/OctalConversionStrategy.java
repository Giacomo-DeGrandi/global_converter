package conversion;

import java.util.Arrays;

public class OctalConversionStrategy implements ConversionStrategy {
    @Override
    public String convert(String ascii) {
        
        StringBuilder octal = new StringBuilder();

        // stream it to int []
        int [] intArr = Arrays.stream(ascii.split(" ")).mapToInt(Integer::parseInt).toArray();

        // System.out.println(Arrays.toString(intArr));

        // foreach int [] val 
        for(int value : intArr){
             
            StringBuilder reverseOctal = new StringBuilder();

            // while the actual value of the int [] is bigger than 0 (ea 72) 
            while(value > 0){
                // calculate the remainder of / 8 
                int remainder = value % 8;
                // append it to the value
                reverseOctal.append(remainder);
                // divide value by EIGHT to loop again
                value = value / 8;
            }

            // reverse the octal sequence
            reverseOctal.reverse();
            octal.append(reverseOctal);

            // format it to make it readable
            octal.append(" ");

        }

        // return the string representation of binary (ea Hello =  1001000 1100101 1101100 1101100 1101111 )
        return octal.toString();
    }
}