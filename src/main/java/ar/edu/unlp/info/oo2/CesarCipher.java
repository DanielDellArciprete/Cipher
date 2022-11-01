package ar.edu.unlp.info.oo2;

//import roo2.Cipher;
//saltos limites (max del alfabeto)
//salto negativo
//letras no incluidas en el alfabeto
//alfabeto vacio similar al caso salto 0 o salto maximo
public class CesarCipher extends SubstitutionCipher {
    int jump = 0;

    public CesarCipher(int number, String inputAlphabet) {
        alphabet = new char[inputAlphabet.length()];
        inputAlphabet.getChars(0, inputAlphabet.length(), alphabet, 0);
        jump = number;
    };

    public CesarCipher(int number) {

        String inputAlphabet = "abcdefghijklmnopqrstuvwxyz";
        alphabet = new char[inputAlphabet.length()];
        inputAlphabet.getChars(0, inputAlphabet.length(), alphabet, 0);
        jump = number;
    };

    // Código duplicado en ambas clases (Vigenere y Cesar); Lo llevo a una superclase (SubstitutionCipher);
    // cada subclase deberá redefinir los métodos (calculateIdxCipher y calculateIdxDecipher) ya que varían minimamente.

    // public String cipher(String inputText) {
    // char[] result = new char[inputText.length()];
    // inputText.getChars(0, inputText.length(), result, 0);

    // for (int idx = 0; idx < result.length; idx++)
    // result[idx] = cipherChar(result[idx]);
    // return new String(result); // alphabet[inputText.length()];
    // };

    // public String decipher(String inputText) {
    // char[] result = new char[inputText.length()];
    // inputText.getChars(0, inputText.length(), result, 0);

    // for (int idx = 0; idx < result.length; idx++)
    // result[idx] = decipherChar(result[idx]);
    // return new String(result);
    // };

    // private char cipherChar(char inputChar) {
    // int offset;
    // char result;
    // int idx = java.util.Arrays.binarySearch(alphabet, inputChar);

    // if (idx < 0) {
    // result = inputChar;
    // } else {
    // offset = idx + jump;
    // if (offset < alphabet.length) {
    // result = alphabet[offset];
    // // refactoring para numeros negativos, usar excepciones para puntualizar el
    // caso
    // // extremo
    // } else {
    // result = alphabet[offset - alphabet.length];
    // }
    // }
    // return result;

    // };

    // private char decipherChar(char inputChar) {
    // int offset;
    // char result;
    // int idx = java.util.Arrays.binarySearch(alphabet, inputChar);

    // if (idx < 0) {
    // result = inputChar;
    // } else {
    // offset = idx - jump;

    // if (offset >= 0) {
    // result = alphabet[offset];
    // } else {
    // result = alphabet[alphabet.length + offset];
    // }
    // }
    // return result;
    // };

    public int calculateIdxCipher(int index) {
        return index + jump;
    }

    public int calculateIdxDecipher(int index) {
        return index - jump;
    }
}