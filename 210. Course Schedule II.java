// BFS Approach
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

// DFS Approach
/*
public class Solution {
    private boolean[] visited, marked;
    private List<Integer> res;
    private boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        marked = new boolean[numCourses];
        res = new ArrayList<>();

        // build prerequisites graph
        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for(int[] prerequisite: prerequisites) graph[prerequisite[1]].add(prerequisite[0]);

        // search
        for(int i = 0; i < numCourses && !hasCycle; i++) {
            if(!marked[i]) findOrderHelper(graph, i);
        }
        if(hasCycle) return new int[0];
        
        // output result
        int[] resArray = new int[numCourses];
        for(int i = res.size() - 1; i >= 0; i--) {
            resArray[numCourses - i - 1] = res.get(i);
        }
        return resArray;
    }

    private void findOrderHelper(List<Integer>[] graph, int pre) {
        if(hasCycle) return;
        
        marked[pre] = true;
        visited[pre] = true;

        for(int i = 0; i < graph[pre].size(); i++) {
            int post = graph[pre].get(i);
            if(visited[post]) {
                hasCycle = true;
                return;
            }
            if(!marked[post]) findOrderHelper(graph, post);
        }
        res.add(pre);
        visited[pre] = false;
    }
}
*/