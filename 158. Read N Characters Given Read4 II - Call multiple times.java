/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    private char[] tmpBuf = new char[4];
    private int indexBuf = 0, indexTmpBuf = 0, count = 0;
    private boolean eof = false;
    
    public int read(char[] buf, int n) {
        indexBuf = 0;
        eof = false;
        
        while(!eof && indexBuf < n) {
            if(indexTmpBuf == 0) count = read4(tmpBuf);
            eof = count < 4;
            while(indexBuf < n && indexTmpBuf < count) {
                buf[indexBuf++] = tmpBuf[indexTmpBuf++];
            }
            if(indexTmpBuf == count) indexTmpBuf = 0;
        }
        return indexBuf;
    }
}