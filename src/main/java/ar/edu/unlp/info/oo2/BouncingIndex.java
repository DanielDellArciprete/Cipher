package ar.edu.unlp.info.oo2;

//import roo2.Cipher;

public class BouncingIndex {
    int maxSize;
    int idx;

    public BouncingIndex(int size) {
        maxSize = size;
        idx = 0;
    };

    public int next() {
        int result;

        if (idx < maxSize) {
            result = idx++;
        } else {
            idx = 0; // aca errpr
            result = idx++;
        }

        return result;
    };

}