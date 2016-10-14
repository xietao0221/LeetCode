class Solution {
    public int findMinRectangle(List<int[]> points) {
        int res = Integer.MAX_VALUE;

        // build map
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int[] point: points) {
            if(!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<>());
                list.add(point[0]);
            }
            map.get(point[0]).add(point[1]);
        }

        for(int i = 0; i < list.size() - 1; i++) {
            int x1 = list.get(i);
            Set<Integer> y1Set = map.get(x1);
            if(y1Set.size() < 2) continue;


            for(int j = i + 1; j < list.size(); j++) {
                int x2 = list.get(j);
                Set<Integer> y2Set = map.get(x2);
                if(y2Set.size() < 2) continue;

                y2Set.retainAll(y1Set);
                if(y2Set.size() < 2) continue;

                List<Integer> y2List = new ArrayList<>(y2Set);
                Collections.sort(y2List);
                for(int k = 0; k < y2List.size() - 1; k++) {
                    res = Math.min(res, Math.abs(x1 - x2) * Math.abs(y2List.get(k) - y2List.get(k + 1)));
                }
            }
        }
        return res;
    }
}