package ar.edu.unlp.info.oo2;

//import roo2.Cipher;

public class BouncingIndex {
    int maxSize;
    int idx;
    boolean aux;

    public BouncingIndex(int size) {
        maxSize = size;
        idx = 0;
        aux = false;
    };

    public int next() {
        int result = 0;
       
        
        if(idx == 0 || idx == maxSize - 1) aux = !aux;
        
        if (aux) {
        	result = idx++;
        }else {
        	result = idx--;
        }

        return result;
    };

}