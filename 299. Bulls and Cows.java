// one pass
public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] charSet = new int[10];
        char[] sArray = secret.toCharArray(), gArray = guess.toCharArray();
        
        for(int i = 0; i < sArray.length; i++) {
            int tempS = sArray[i] - '0', tempG = gArray[i] - '0';
            if(tempS == tempG) {
                bull++;
            } else {
                // increase the count when meeting the character in secret
                // and decrease the count when meeting the character in guess
                
                // if the count before is less than 0, there must be a same character in guess to decrease the count
                if(charSet[tempS]++ < 0) cow++;
                // if the count before is greater than 0, there must be a same character in secret to increase the count
                if(charSet[tempG]-- > 0) cow++;
            }
        }
        return bull + "A" + cow + "B";
    }
}

// two pass
/*
public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] charSet = new int[10];
        char[] sArray = secret.toCharArray(), gArray = guess.toCharArray();
        
        // record the count of characters in secret, and check the bull
        for(int i = 0; i < sArray.length; i++) {
            if(sArray[i] == gArray[i]) bull++;
            else charSet[sArray[i] - '0']++;
        }
        
        // iterate the guess and calculate the cow
        for(int i = 0; i < gArray.length; i++) {
            if(sArray[i] != gArray[i] && charSet[gArray[i] - '0']-- > 0) cow++;
        }
        return bull + "A" + cow + "B";
    }
}
*/