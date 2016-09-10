// BFS Solution
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        // build course prerequisites matrix
        for(int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1], post = prerequisites[i][0];
            if(matrix[pre][post] == 0) {
                indegree[post]++;
                matrix[pre][post] = 1;
            }
        }

        // input no-incoming courses
        for(int i = 0; i < indegree.length; i++) if(indegree[i] == 0) queue.offer(i);

        while(!queue.isEmpty()) {
            int tmpCourse = queue.poll();
            count++;
            for(int i = 0; i < numCourses; i++) {
                if(matrix[tmpCourse][i] != 0 && --indegree[i] == 0) queue.offer(i);
            }
        }
        return count == numCourses;
    }
}

// DFS Solution
/*
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1], post = prerequisites[i][0];
            graph[pre].add(post);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(!canFinishHelper(graph, visited, i)) return false;
        }
        return true;
    }
    
    public boolean canFinishHelper(List<Integer>[] graph, boolean[] visited, int course) {
        if(visited[course]) return false;       // cycle detected

        visited[course] = true;
        for(int i = 0; i < graph[course].size(); i++) {
            if(!canFinishHelper(graph, visited, graph[course].get(i))) return false;
        }
        visited[course] = false;                // backtracking
        return true;
    }
}
*/