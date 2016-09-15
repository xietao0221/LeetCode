public class ValidWordAbbr {
    private Map<String, String> map = new HashMap<>();
    
    public ValidWordAbbr(String[] dictionary) {
        for(String str: dictionary){
            String abbr = getAbbreviation(str);
            if(map.containsKey(abbr) && !map.get(abbr).equals(str)) {
                map.put(abbr, "");
            } else {
                map.put(abbr, str);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbreviation(word);
        if(!map.containsKey(abbr) || (map.containsKey(abbr) && map.get(abbr).equals(word))) {
            return true;
        } else {
            return false;
        }
    }

    private String getAbbreviation(String str){
        if(str.length() <= 2) return str;
        return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");