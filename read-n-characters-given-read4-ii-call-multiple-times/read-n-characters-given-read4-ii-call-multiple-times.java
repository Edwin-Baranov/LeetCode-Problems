/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    private int buffPointer = 0;
    private int readCount = 0;
    private char[] buff = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int writingPtr = 0;
        while (writingPtr < n) {
            if (buffPointer == 0) {
                readCount = read4(buff);
            }
            if (readCount == 0) break;
            while (writingPtr < n && buffPointer < readCount) {
                buf[writingPtr] = buff[buffPointer];
                ++writingPtr;
                ++buffPointer;
            }
            if (buffPointer >= readCount) buffPointer = 0;
        }
        return writingPtr;
    }
}