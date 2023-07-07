package conversion;

import java.util.Arrays;

import validate.Validate;

public class DecodeDecimal implements DecodeStrategy {

    @Override
    public String convert(String decimal) {

        String[] asciiValues = decimal.split(" ");

        Validate validateDec = new Validate();

        if(validateDec.validateBinary(decimal) == null){
            System.out.println("La chaine decimale inseree n'est pas valide");
            System.exit(1);
        }
            

        StringBuilder sb = new StringBuilder();

        for (String value : asciiValues) {
            int asciiValue = Integer.parseInt(value);
            sb.append(Character.toChars(asciiValue));
        }

        return sb.toString();
    }
    
}
