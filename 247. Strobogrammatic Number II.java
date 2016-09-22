// Solution 1
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        char[][] pairs = new char[][]{{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
        List<String> res = new ArrayList<>();
        findStrobogrammaticHelper(pairs, 0, n - 1, new char[n], res);
        return res;
    }

    private void findStrobogrammaticHelper(char[][] pairs, int left, int right, char[] tmpRes, List<String> res) {
        if(left > right) {
            res.add(new String(tmpRes));
            return;
        }

        for(char[] pair: pairs) {
            if(tmpRes.length > 1 && left == 0 && pair[0] == '0') continue;
            if(left == right && (pair[0] == '6' || pair[0] == '9')) continue;

            tmpRes[left] = pair[0];
            tmpRes[right] = pair[1];
            findStrobogrammaticHelper(pairs, left + 1, right - 1, tmpRes, res);
        }
    }
}

// Solution 2
/*
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammaticHelper(n, n);
    }
    
    public List<String> findStrobogrammaticHelper(int n, int remaining) {
        if(remaining == 0) return new ArrayList<>(Arrays.asList(""));
        if(remaining == 1) return new ArrayList<>(Arrays.asList("0","1","8"));
        
        List<String> subResult = findStrobogrammaticHelper(n, remaining - 2);
        List<String> result = new ArrayList<>();
        for(String s: subResult) {
            if(remaining != n) result.add("0" + s + "0");       // n == remaining means '0' is at the leading position
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }
        return result;
    }
}
*/