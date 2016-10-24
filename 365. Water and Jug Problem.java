// https://leetcode.com/discuss/110478/math-solution-java-solution
// BFS Solution, result in TLE
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if(x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        Queue<State> states = new ArrayDeque<>();
        Set<State> visited = new HashSet<>();

        // initial state
        State init = new State(0, 0);
        states.offer(init);
        visited.add(init);

        while(!states.isEmpty()) {
            State curr = states.poll();
            if(curr.a + curr.b == z) return true;

            // fill jug1
            Queue<State> queue = new ArrayDeque<>();
            queue.offer(new State(x, curr.b));      									// fill jug 1
            queue.offer(new State(0, curr.b));      									// empty jug1
            queue.offer(new State(curr.a, y));      									// fill jug 2
            queue.offer(new State(curr.a, 0));      									// empty jug2
            queue.offer(new State(Math.min(curr.a + curr.b, x),
                    curr.a + curr.b < x ? 0 : curr.b - (x - curr.a)));      			// pour all water from jug2 to jug1
            queue.offer(new State(curr.a + curr.b < y ? 0 : curr.a - (y - curr.b),		
                    Math.min(curr.a + curr.b, y)));										// pour all water from jug1 to jug2

            for(State tmp: queue) {
                if(visited.contains(tmp)) continue;
                states.offer(tmp);
                visited.add(tmp);
            }
        }
        return false;
    }


    class State {
        public int a, b;

        public State(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int hashCode() {
            return 31 * a + b;
        }

        public boolean equals(Object o) {
            State other = (State)o;
            return this.a == other.a && this.b == other.b;
        }
    }
}

// Math Solution
/*
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if(z == x || z == y || z == x + y) return true;
        
        return z % GCD(x, y) == 0;
    }
    
    private int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}
*/