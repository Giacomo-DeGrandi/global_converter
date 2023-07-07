package encoding;

public class EncodingStrategyFactory{

    EncodingStrategy encodingStrategy;

    public EncodingStrategy getStrategy(String algo) {

        switch (algo) {

            case "caesar":
                return new CaesarCipher();

            default:

                System.out.println("ERROR: inserer une algo de chiffrement valid");
                System.out.println("OPTIONS: caesar, ROT13 ");
                System.out.println("ERROR - exemple d'utilisation: java Main.java <base> <text> [<encodingAlgo> <key>]");
                System.exit(1);
                return null;
        }

    }
}