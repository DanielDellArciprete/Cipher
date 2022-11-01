package ar.edu.unlp.info.oo2;

public abstract class SubstitutionCipher implements CipherInterface{
    char[] alphabet;
    char[] result;


    public String cipher(String inputText) {
        result = new char[inputText.length()];
        for (int idx = 0; idx < inputText.length(); idx++)
            result[idx] = cipherChar(inputText.charAt(idx));
        return new String(result);
    }


    public String decipher(String inputText) {
        result = new char[inputText.length()];
        for (int idx = 0; idx < inputText.length(); idx++)
        //Cadena.chars().forEach(c -> ) Conviene?
            result[idx] = decipherChar(inputText.charAt(idx));
        return new String(result);
    }



    public char cipherChar(char inputChar) {
        int offset;
        char result;
        int idx = java.util.Arrays.binarySearch(alphabet, inputChar);

        if (idx < 0) {
            result = inputChar;
        } else {
            offset = calculateIdxCipher(idx);
            if (offset < alphabet.length) {
                result = alphabet[offset];
                // refactoring para numeros negativos, usar excepciones para puntualizar el caso
                // extremo
            } else {
                result = alphabet[offset - alphabet.length];
            }
        }
        return result;

    };

    public char decipherChar(char inputChar) {
        int offset;
        char result;
        int idx = java.util.Arrays.binarySearch(alphabet, inputChar);

        if (idx < 0) {
            result = inputChar;
        } else {
            offset = calculateIdxDecipher(idx);

            if (offset >= 0) {
                result = alphabet[offset];
            } else {
                result = alphabet[alphabet.length + offset];
            }
        }
        return result;
    };

    public abstract int calculateIdxCipher(int index);

    public abstract int calculateIdxDecipher(int index);
}
