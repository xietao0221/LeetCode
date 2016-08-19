public class Logger {
    Map<String, Integer> logMap;
    
    /** Initialize your data structure here. */
    public Logger() {
        logMap = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!logMap.containsKey(message)) {
            logMap.put(message, timestamp);
            return true;
        } else {
            if(timestamp - logMap.get(message) < 10) return false;
            logMap.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */