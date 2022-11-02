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

    //la idea fue reconstruir los railes desde el texto cifrado
    public String decipher(String inputText) {
    	String result = "";
    	boolean check = false;
    	int j = 0;
    	int row = rails.length;
    	int col = inputText.length();
    	char[][] aux = new char[row][col];
    	
    	//se arma un arreglo con la railes "sombreados" con "/" donde irian caracteres
    	for (int i = 0; i < col; i++) {
    		if(j == 0 || j == row - 1)
    			check = !check;
            aux[j][i] = '/';
            if (check) {
            	j++;
            }else {
            	j--;
            }
    	}
          
    	//se reemplaza "/" con los caracteres a descifrar
        int index = 0;
        for (int i = 0; i < row; i++) {
        	for (int k = 0; k < col; k++) {
        		if (aux[i][k] == '/' && index < col) 
        			aux[i][k] = inputText.charAt(index++); 
        	}
        }
        //imprime en pantalla como queda el railfence armado
//        for (int i = 0; i < row; i++) {
//        	for (int k = 0; k < col; k++) {
//        		System.out.print(aux[i][k] + " ");
//        		
//        	}
//        	System.out.println();
//        }
        
        //recorre los railes armando el texto plano
        j = 0;
        check = false;
        for (int i = 0; i < col; i++) {
    		if(j == 0 || j == row - 1) 
    			check = !check;
    		
    		result += aux[j][i];
    	
            if (check) {
            	j++;
            }else {
            	j--;
            }
    	}
    	
        return result;
    };


}