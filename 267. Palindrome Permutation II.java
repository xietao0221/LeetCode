public class Solution {
    private List<String> res = new ArrayList<>();
    private List<Character> list = new ArrayList<>();
    private Character middle = null;
    
    public List<String> generatePalindromes(String s) {
        // get the character whose number of occurance is odd
        int[] letters = new int[256];
        int oddCount = 0;
        for(char c: s.toCharArray()) oddCount += ++letters[c] % 2 != 0 ? 1 : -1;
        if(oddCount > 1) return res;
        
        // put half of letters into arraylist
        for(int i=0; i<letters.length; i++) {
            Character curr = (char)i;
            if(letters[i] % 2 == 1) middle = curr;
            for(int j=0; j<letters[i]/2; j++) list.add(curr);
        }

        // get the permutation
        getPermutation(new boolean[list.size()], new StringBuilder());
        return res;
    }
    
    // the same as '46. Permutations II'
    public void getPermutation(boolean[] used, StringBuilder sb) {
        if(sb.length() == list.size()) {
            if(middle == null) res.add(sb.toString() + sb.reverse().toString());
            else res.add(sb.toString() + middle + sb.reverse().toString());
            sb.reverse();       // need to restore the original stringbuilder
        } else {
            for(int i=0; i<list.size(); i++) {
                // avoid duplicated !!! very important
                // when a number has the same value with its previous, we can use this number only if his previous is used
                // because if we choose the second one first, and then to the next recursion, the first one is added,
                // duplicate occurs
                if((i > 0 && list.get(i) == list.get(i-1) && !used[i-1]) || used[i]) continue;
                
                used[i] = true;
                sb.append(list.get(i));
                
                getPermutation(used, sb);
                
                // backtracking
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}