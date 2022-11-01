package ar.edu.unlp.info.oo2;

//import roo2.BouncingIndex;
//jugar con la cantidad de rieles

public class RailFenceCipher extends TranspositionCipher {
    String[] rails;
    BouncingIndex bIndex;

    public RailFenceCipher(int railCount) {
        rails = new String[railCount];
        for (int idx = 0; idx < rails.length; idx++)
            rails[idx] = "";
        bIndex = new BouncingIndex(railCount);

    };

    public String cipher(String inputText) {
        String result = "";
        
        inputText.chars().forEach(c ->  rails[bIndex.next()] += (char) c);


        // char inputChar[] = new char[inputText.length()];
        // inputText.getChars(0, inputText.length(), inputChar, 0);
        // for (int idx = 0; idx < inputText.length(); idx++) {
        //     int rIndex = bIndex.next();
        //     rails[rIndex] += inputChar[idx];
        // }
        // inputText.chars().forEach(c -> result.((char) c));
        for (int idx = 0; idx < rails.length; idx++) {
            result += rails[idx];
        }

        return result;
    };

    public String decipher(String inputText) {
    	
        return inputText;
    };


}