package conversion;
import java.util.Scanner;
import validate.Validate;

public class TextConversionStrategy implements ConversionStrategy {
    @Override
    public String convert(String ascii) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("entrer la base d'encodage de votre chaine: ");
            String reverseBase = scanner.nextLine();

            // inst new Validate 
            Validate val = new Validate();


            // check if reverseBase is null 
            if( (reverseBase = val.validateBase(reverseBase)) == null ){
                System.out.println("ERROR: inserer une base valide");
                System.exit(1);
            }

            DecodeStrategy decodeStrategy;

            switch (reverseBase) {
                case "text":
                    decodeStrategy = new DecodeText();
                    break;
                // case for BINARY decoding
                case "binary":
                    decodeStrategy = new DecodeBinary();
                    break;
                // case for DECIMAL decoding
                case "decimal":
                    decodeStrategy = new DecodeDecimal();
                    break;
                // case for OCTAL decoding
                case "octal":
                    decodeStrategy = new DecodeOctal();
                    break;
                // case for HEX decoding
                case "hexadecimal":
                    decodeStrategy = new DecodeHexadecimal();
                    break;
                // if strategy doesn't exist throw an error, normally, it already exists at this point
                
                default:
                // feed a default value then exit to avoid exceptions
                decodeStrategy = null;
            }

            
        if(decodeStrategy == null){
            System.out.println("ERROR: base non trouvee");
            System.exit(1);
        }

        // Convert it
        String decodedString = decodeStrategy.convert(ascii);

        scanner.close();

        return decodedString;
    }
}