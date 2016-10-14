// Better Solution
class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;

        for(String s : input.split("\n")){
            int level = s.lastIndexOf("\t") + 1;
            while(level + 1 < stack.size()) stack.pop();            // find parent
            int len = stack.peek() + (s.length() - level) + 1;      // remove "/t", add"/"
            stack.push(len);
            
            // check if it is file
            if(s.contains(".")) res = Math.max(res, len - 1);
        }
        return res;
    }
}

// My Solution
/*
public class Solution {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        int[] res = new int[]{0};
        FileNode root = parseString(input);
        outputLongestPath(root, res);
        return res[0] == 0 ? 0 : res[0] - 1;
    }

    private FileNode parseString(String input) {
        FileNode root = new FileNode(null, null, 0, -1, true), curr = root;
        String[] files = input.split("\n");
        for(String file: files) {
            int index = 0, level = 0;
            FileNode newFile;

            // calculate the level
            while(index < file.length() && file.substring(index, index + 1).equals("\t")) {
                level++;
                index++;
            }

            // decide if it is a file
            boolean isFile = file.contains(".");

            // decide it is the children or brother
            if(level == curr.level) {       // brother
                newFile = new FileNode(file.substring(index, file.length()),
                        curr.parent, file.length() - index + 1, level, isFile);
                curr.parent.children.add(newFile);
            } else {                        // children
                while(level != curr.level + 1) curr = curr.parent;
                newFile = new FileNode(file.substring(index, file.length()),
                        curr, file.length() - index + 1, level, isFile);
                curr.children.add(newFile);
            }
            curr = newFile;
        }
        return root;
    }

    private void outputLongestPath(FileNode root, int[] res) {
        if(!root.children.isEmpty()) {
            for(FileNode child: root.children) {
                outputLongestPath(child, res);
            }
        } else {
            if(!root.isFile) return;
            int count = root.count;
            while(root.parent != null) {
                count += root.parent.count;
                root = root.parent;
            }
            res[0] = Math.max(res[0], count);
        }
    }

    class FileNode {
        String fileName;
        FileNode parent;
        List<FileNode> children;
        int count, level;
        boolean isFile;

        public FileNode(String fileName, FileNode parent, int count, int level, boolean isFile) {
            this.fileName = fileName;
            this.parent = parent;
            this.children = new ArrayList<>();
            this.count = count;
            this.level = level;
            this.isFile = isFile;
        }
    }
}
*/