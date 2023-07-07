import java.util.Scanner;

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

        // check if key is null 
        if( key == 0 ){
        Scanner scanner = new Scanner(System.in);
                
                System.out.print("Continuer sans algo de chiffrement ni cle? ['y' ou 'n']: ");
                String response = scanner.nextLine();
                
                if (response.equalsIgnoreCase("y")) {
                    encodingAlgo = "defaultEncoding";
                } else if (response.equalsIgnoreCase("n")) {
                    System.out.println("ERROR - exemple d'utilisation: java Main.java <base> <text> [<encodingAlgo> <key>]");
                    System.exit(1);
                } else {
                    System.out.println("Reponse invalide.");
                }
                
                scanner.close();
        }



        // inst new Ascii
        Ascii ascii = new Ascii();

        // init testAlgo
        boolean textAlgo = false;

        // Declare asciiText 
        String asciiText;

            if( encodingAlgo == "defaultEncoding"){
                asciiText = ascii.textToASCII(validatedInput);

            } else {

                // inst new EncodingStrategyFactory
                EncodingStrategyFactory encodingFactory = new EncodingStrategyFactory();

                // get the right encoding strategy
                EncodingStrategy encodingStrategy = encodingFactory.getStrategy(encodingAlgo);

                // encode the validated input
                String encodedText = encodingStrategy.encode(validatedInput , key);
                // translate validated input to ascii
                asciiText = ascii.textToASCII(encodedText);

                // Set the bool for algo strategy in case the string is a text
                textAlgo = true;
            }



        // Choose conversion strategy based on base
        ConversionStrategy conversionStrategy;
        boolean textBool = false;

        switch (validatedBase) {
            case "text":
                if( textAlgo  != true){
                  conversionStrategy = new TextConversionStrategy();
                  break;
                }
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
        String convertedString = (textBool != true) ? conversionStrategy.convert(asciiText) : conversionStrategy.convert(validatedInput);

        // print the results
        System.out.println(convertedString);

    }
}



/*
                // if is a text base
        if(validatedBase.equals("text")){
            conversionStrategy = new TextConversionStrategy();

            System.out.print("entrer la base desideree: ");
            String reverseBase = scanner.nextLine();
        } 



 */