/*
      left_part          |        right_part
A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]

conditions:
    (1) i + j == (m - i) + (n - j) + 1 ==> (len(left) >= len(right))
        if n >= m, we just need to set: i = 0 ~ m, j = (m + n + 1)/2 - i
    (2) B[j-1] <= A[i] and A[i-1] <= B[j]

result:
    m + n is odd: max(A[i-1], B[j-1])
    m + n is even: (max(A[i-1], B[j-1]) + min(A[i], B[j])) / 2
    
Algorithm:
    <a> (j == 0 or i == m or B[j-1] <= A[i]) and
        (i == 0 or j = n or A[i-1] <= B[j])
        Means i is perfect, we can stop searching.

    <b> j > 0 and i < m and B[j - 1] > A[i]
        Means i is too small, we must increase it.

    <c> i > 0 and j < n and A[i - 1] > B[j]
        Means i is too big, we must decrease it.
*/
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // setup A, B where len(A) <= len(B), and m, n are their length respectively
        int[] A, B;
        int m, n;
        if(nums1.length <= nums2.length) {
            A = nums1; B = nums2; m = nums1.length; n = nums2.length;
        } else {
            B = nums1; A = nums2; n = nums1.length; m = nums2.length;
        }
        
        // binary search: 
        // if total number is odd: the length of left is one larger than the length of right
        // and we just compare the right-most of lefts
        int iMin = 0, iMax = m, maxLeft = 0, minRight = 0;
        while(iMin <= iMax) {
            int i = (iMin + iMax) / 2, j = (m + n + 1) / 2 - i;     // don't forget to plus one
            if(i < m && j > 0 && B[j-1] > A[i]) {                   
                // B[j-1] and A[i] are exist, and they don't meet requirement
                // i need to increase
                iMin = i + 1;
            } else if(i > 0 && j < n && A[i-1] > B[j]) {            
                // A[i-1] and B[j] are exist, and they don't meet requirement
                // i need to decrease
                iMax = i - 1;
            } else {
                // calculate maxLeft
                if(i == 0) maxLeft = B[j-1];
                else if(j == 0) maxLeft = A[i-1];
                else maxLeft = Math.max(A[i-1], B[j-1]);
                
                if((m + n) % 2 == 1) return maxLeft;
                
                // calculate minRight
                if(i == m) minRight = B[j];
                else if(j == n) minRight = A[i];
                else minRight = Math.min(A[i], B[j]);
                break;
            }
        }
        return (double)(maxLeft + minRight) / 2.0;
    }
}