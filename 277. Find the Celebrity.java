/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for(int i = 1; i < n; i++) {
            // for this candidate(k), we can ensure:
            // (1) people in (0, k - 1) cannot be celebrity, because each of them must know at least one person, 
            // to let him to be changed.
            // (2) people in (k + 1, n - 1) cannot be known by celebrity, because this candidate does not be changed.
            if(knows(celebrity, i)) celebrity = i;
        }
        
        // so we need to check:
        // (1) people in (0, k - 1) cannot be known by celebrity
        // (2) people in (k + 1, n - 1) must know celebrity
        for(int i = 0; i < celebrity; i++) {
            if(knows(celebrity, i)) return -1;
        }
        
        for(int i = celebrity + 1; i < n; i++) {
            if(!knows(i, celebrity)) return -1;
        }
        return celebrity;
    }
}