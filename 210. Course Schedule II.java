public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; i++) res[i] = i;
            return res;
        }
        
        List<Integer>[] edges = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int count = 0;
        
        for(int[] prerequisite: prerequisites) {
            int pre = prerequisite[1], post = prerequisite[0];
            if(edges[pre] == null) edges[pre] = new ArrayList<>();
            edges[pre].add(post);
            indegree[post]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int pre = queue.poll();
            res[count++] = pre;
            if(edges[pre] == null) continue;
            for(int post: edges[pre]) {
                if(--indegree[post] == 0) queue.offer(post);
            }
        }
        
        if(count == numCourses) return res;
        else return new int[0];
    }
}