public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int left = 0, right = 0, len = 0;
        while(right < s.length()) {
            // find the length of substring
            while(right < s.length() && s.charAt(right) != '/') right++;
            len = Integer.parseInt(s.substring(left, right));
            
            // move indexes to the boarder of substring
            left = right + 1;
            right += len + 1;
            res.add(s.substring(left, right));
            
            // setup the index of next round
            left = right;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));