/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmpBuf = new char[4];
        int indexBuf = 0, indexTmpBuf = 0, count = 0;
        boolean eof = false;
        
        while(!eof && indexBuf < n) {
            count = read4(tmpBuf);       // return the actual count, could smaller than 4
            eof = count < 4;
            while(indexBuf < n && indexTmpBuf < count) {
                buf[indexBuf++] = tmpBuf[indexTmpBuf++];
            }
            if(indexTmpBuf == count) indexTmpBuf = 0;
        }
        return indexBuf;
    }
}