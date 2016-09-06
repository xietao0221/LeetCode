// If car starts at A and can not reach B. Any station between A and B can not reach B.
// If the total number of gas is bigger than the total number of cost. There must be a solution.
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int count = 0, tank = 0, res = 0;
        for(int i = 0; i < gas.length; i++) {
            int tmp = gas[i] - cost[i];
            tank += tmp;
            count += tmp;
            
            if(tank < 0) {
                tank = 0;
                res = i + 1;
            }
        }
        return count >= 0 ? res : -1;
    }
}