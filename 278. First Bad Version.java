/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n, middle = 0, res = 0;
        while(left <= right) {
            middle = left + (right - left) / 2;
            if(isBadVersion(middle)) {
                res = middle;
                right = middle - 1;    
            } else {
                left = middle + 1;
            }
        }
        return res;
    }
}

// similar to '34. Search for a Range'
/*
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n, middle = 0;
        while(left < right) {
            middle = left + (right - left) / 2;
            if(isBadVersion(middle)) right = middle;
            else left = middle + 1;
        }
        return left;
    }
}
*/