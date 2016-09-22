// Solution 1
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

// Solution 2
/*
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        if(n == 0) return new ArrayList<>();
        if(n == 1) return Arrays.asList("0", "1", "8");

        char[][] set = new char[][]{{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
        List<String> res = new ArrayList<>();
        StringBuilder tmpRes = new StringBuilder();
        findStrobogrammaticHelper(n, 0, n % 2 == 1, set, tmpRes, res);
        return res;
    }

    private void findStrobogrammaticHelper(int n, int count, boolean isOdd, char[][] set,
                                           StringBuilder tmpRes, List<String> res) {
        if(count == n / 2) {
            if(isOdd) {
                for(char[] c: set) {
                    if(c[0] == '6' || c[0] == '9') continue;
                    tmpRes.insert(count, c[0]);
                    res.add(tmpRes.toString());
                    tmpRes.delete(count, count + 1);
                }
            } else {
                res.add(tmpRes.toString());
            }
            return;
        }

        for(char[] c: set) {
            if(count == 0 && c[0] == '0') continue;
            tmpRes.insert(count, c[0] + "" + c[1]);
            findStrobogrammaticHelper(n, count + 1, isOdd, set, tmpRes, res);
            tmpRes.delete(count, count + 2);
        }
    }
}
*/