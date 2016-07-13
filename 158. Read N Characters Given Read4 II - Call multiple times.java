/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    char[] tmpBuf = new char[4];
    int indexTmpBuf = 0, count = 0;
    
    public int read(char[] buf, int n) {
        int indexBuf = 0;
        while(indexBuf < n) {
            if(indexTmpBuf == 0) count = read4(tmpBuf);
            if(count == 0) break;
            while(indexBuf < n && indexTmpBuf < count) {
                buf[indexBuf++] = tmpBuf[indexTmpBuf++];
            }
            if(indexTmpBuf >= count) indexTmpBuf = 0;
        }
        return indexBuf;
    }
}