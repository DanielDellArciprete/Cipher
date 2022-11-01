package ar.edu.unlp.info.oo2;

// interface
interface CipherInterface {
    public String cipher(String inputText); 
    public String decipher(String inputText); 

    // extract method de: ?
    //  char inputChar[] = new char[inputText.length()];
    //    inputText.getChars(0, inputText.length(), inputChar, 0); 
  }