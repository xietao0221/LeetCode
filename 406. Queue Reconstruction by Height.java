public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new PQComparator());
        
        for(int[] person: people) queue.offer(person);
        while(!queue.isEmpty()) insert(queue.poll(), list);
        
        int[][] res = new int[people.length][2];
        for(int i = 0; i < res.length; i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
    
    private void insert(int[] person, List<int[]> list) {
        int count = 0;
        for(int i = 0; i < list.size(); i++) {
            if(count == person[1]) {
                list.add(i, person);
                return;
            } else if(list.get(i)[0] >= person[0]) {
                count++;
            }
        }
        list.add(person);
    }
    
    class PQComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        }
    }
}