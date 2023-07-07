package conversion;

import java.util.Arrays;


public class BinaryConversionStrategy implements ConversionStrategy {
    @Override
    public String convert(String ascii) {

        StringBuilder binary = new StringBuilder();

        int [] intArr = Arrays.stream(ascii.split(" ")).mapToInt(Integer::parseInt).toArray();

        // System.out.println(Arrays.toString(intArr));

        for(int value : intArr){
             
            StringBuilder reverseBinary = new StringBuilder();

            // while the actual value of the int [] is bigger than 0 (ea 72) 
            while(value > 0){
                // calculate the remainder
                int remainder = value % 2;
                // append it to the value
                reverseBinary.append(remainder);
                // divide value by two to loop again
                value = value / 2;
            }

            // reverse the binary sequence
            reverseBinary.reverse();
            binary.append(reverseBinary);

            // format it to make it readable
            binary.append(" ");

        }

        // return the string representation of binary (ea Hello =  1001000 1100101 1101100 1101100 1101111 )
        return binary.toString();
    }
}