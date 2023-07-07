import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import ascii.Ascii;
import conversion.*;
import validate.Validate;
import encoding.*; // import encoding package

public class Main {
    public static void main(String[] args) throws Exception {

        // Check if the input has at least two arguments (base and text)
        if (args.length < 2) {
            System.out.println("ERROR - exemple d'utilisation: java Main.java <base> <text> [<encodingAlgo> <key>]");
            System.exit(1);
        }

        // Initialize input, base, encodingAlgo, and key vars
        String input = args[1];
        String base = args[0];
        String encodingAlgo = args.length >= 3 ? args[2] : "defaultEncoding"; // Use "defaultEncoding" if encodingAlgo is not provided
        int key = args.length >= 4 ? Integer.parseInt(args[3]) : 0; // Use 0 as default key if not provided

        // inst new Validate 
        Validate val = new Validate();

        // init input and base for validation
        String validatedInput;
        String validatedBase;

        // check if input is null 
        if( (validatedInput = val.validateInput(input)) == null ){
            System.out.println("ERROR: inserer une chaine valide");
            System.exit(1);
        }

        // check if base is null 
        if( (validatedBase = val.validateBase(base)) == null ){
            System.out.println("ERROR: inserer une base valide");
            System.exit(1);
        }

        // inst new Ascii
        Ascii ascii = new Ascii();

        // if encodingAlgo is not default, encode the input
        if (!encodingAlgo.equals("defaultEncoding")) {

            System.out.println("Chiffrement: " + encodingAlgo);
            // inst new EncodingStrategyFactory
            EncodingStrategyFactory encodingFactory = new EncodingStrategyFactory();

            // get the right encoding strategy
            EncodingStrategy encodingStrategy = encodingFactory.getStrategy(encodingAlgo);

            System.out.println(validatedInput);
            // encode the validated input

            validatedInput = encodingStrategy.encode(validatedInput , key);


        } else {
            System.out.println("Encodage de default, aucun chiffrement selectionne");
        }

        // translate validated input to ascii
        String asciiText = ascii.textToASCII(validatedInput);

        // Choose conversion strategy based on base
        ConversionStrategy conversionStrategy;
        boolean textBool = false;

        switch (validatedBase) {
            case "text":
                conversionStrategy = new TextConversionStrategy();
                textBool = true;
                break;
            // case for BINARY
            case "binary":
                conversionStrategy = new BinaryConversionStrategy();
                break;
            // case for DECIMAL
            case "decimal":
                conversionStrategy = new DecimalConversionStrategy();
                break;
            // case for OCTAL
            case "octal":
                conversionStrategy = new OctalConversionStrategy();
                break;
            // case for HEXADECIMAL
            case "hexadecimal":
                conversionStrategy = new HexadecimalConversionStrategy();
                break;
            // if strategy doesn't exist throw an error, normally, it already exists at this point
            default:
                // feed a default value then exit to avoid exceptions
                conversionStrategy = null;
        }

        if(conversionStrategy == null){
            System.out.println("ERROR: base non trouvee");
            System.exit(1);
        }

        // Convert it
        String convertedString;
        if (textBool != true) {
            convertedString = conversionStrategy.convert(asciiText);
        } else {
            if(key >= 0){
                CypherToTextConversionStrategy decyphIt = new CypherToTextConversionStrategy();
                convertedString = decyphIt.convertToText(validatedInput, key);

                // oneline cause i m lazy
                convertedString = Arrays.stream(asciiText.split(" "))
                .mapToInt(Integer::parseInt)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());

            } else {
                convertedString = conversionStrategy.convert(validatedInput);
            }
        }

        // print the results
        System.out.println(convertedString);
    }
}
