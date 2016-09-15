public class Vector2D implements Iterator<Integer> {
    private int row = 0, col = 0;
    private List<List<Integer>> list;
    
    public Vector2D(List<List<Integer>> vec2d) {
        list = vec2d;
    }

    @Override
    public Integer next() {
        // always check hasNext() is a good idea
        if(hasNext()) return list.get(row).get(col++);
        else return null;
    }

    @Override
    public boolean hasNext() {
        while(row < list.size()) {
            if(col < list.get(row).size()) {
                return true;
            } else {
                row++;
                col = 0;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */