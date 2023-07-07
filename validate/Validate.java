package validate;

public class Validate {

    public  String validateInput(String args){
        
        if (!args.matches("^[a-zA-Z0-9 ]*$")) {

            return null;
        }

        return args;
    }


    public String validateBase(String args) {
        if (args == null || args.length() == 0) {
            return null;
        }

        switch (args) {
            case "text":
            case "-t":
                return "text";
            case "binary":
            case "-b":
                return "binary";
            case "decimal":
            case "-d":
                return "decimal";
            case "octal":
            case "-o":
                return "octal";
            case "hexadecimal":
            case "-h":
                return "hexadecimal";
            default:
                return null;
        }
    }


    public String validateBinary(String binary){

        // split by space
        String[] parts = binary.split(" ");
        // iterate bin val
        for (String singleBin : parts) {
            if (!singleBin.matches("^[01]+$")) {

                // if invalid
                return null;
            }
        }
        // return if correct
        return binary;
    }

    public String validateDecimal(String decimal){

        // split by space
        String[] parts = decimal.split(" ");
        // iterate decimal val
        for (String singleDec : parts) {
            if (!singleDec.matches("^-?\\\\d+$")) {

                // if invalid
                return null;
            }
        }
        // return if correct
        return decimal;
    }

    public String validateOctal(String octal){

        // split by space
        String[] parts = octal.split(" ");
        // iterate decimal val
        for (String singleOct : parts) {
            if (!singleOct.matches("^[0-7]+$")) {

                // if invalid
                return null;
            }
        }
        // return if correct
        return octal;
    }

        public String validateHex(String hex){

        // split by space
        String[] parts = hex.split(" ");

        // iterate decimal val
        for (String singleHex : parts) {
            if (!singleHex.matches("^([0-9A-Fa-f]{2} )*[0-9A-Fa-f]{2}$")) {

                // if invalid
                return null;
            }
        }
        // return if correct
        return hex;
    }
    
}


//  String message = decimalNumber.matches("^-?\\d+$") ? "Valid decimal number" : "Not a valid decimal number";

