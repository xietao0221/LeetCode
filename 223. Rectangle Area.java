// https://discuss.leetcode.com/topic/21132/an-explanation-in-plain-language
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rec1 = (C - A) * (D - B);
        int rec2 = (G - E) * (H - F);
        
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        
        int overlap = 0;
        if(right > left && top > bottom) {
            overlap = (right - left) * (top - bottom);
        }
        return rec1 + rec2 - overlap;
    }
}