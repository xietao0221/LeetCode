/*
zero			only z
one				if o, ++, -= count[0] - count[2] - count[4]
two				only w
three			if r, ++, -= count[0] - count[4]
four			only u
five			if f, ++, -= count[4]
six				only x
seven			if s, ++; -= count[6]
eight			if t, ++; -= count[2] - count[3]
nine			if i, ++; -= count[5] - count[6] - count[8]
*/
public class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10];
        for(char c: s.toCharArray()) {
            if(c == 'z') count[0]++;
            else if(c == 'o') count[1]++;
            else if(c == 'w') count[2]++;
            else if(c == 'r') count[3]++;
            else if(c == 'u') count[4]++;
            else if(c == 'f') count[5]++;
            else if(c == 'x') count[6]++;
            else if(c == 's') count[7]++;
            else if(c == 't') count[8]++;
            else if(c == 'i') count[9]++;
        }

        count[5] = count[5] - count[4];
        count[7] = count[7] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        count[3] = count[3] - count[0] - count[4];
        count[8] = count[8] - count[2] - count[3];
        count[9] = count[9] - count[5] - count[6] - count[8];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            while(count[i]-- > 0) sb.append(i);
        }
        return sb.toString();
    }
}