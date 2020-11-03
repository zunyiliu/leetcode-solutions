class Solution {
    class Line {
        int x;
        int y;
        boolean isleft;
        
        public Line(int x, int y, boolean isleft) {
            this.x = x;
            this.y = y;
            this.isleft = isleft;
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList();
        List<Line> lines = new ArrayList();
        
        // treat buildings as vertical lines, a line has a start x, a height, and a isleft tag which shows
        // the line is the left side of a building or not
        for (int i = 0; i < buildings.length; i++) {
            lines.add(new Line(buildings[i][0],buildings[i][2],true) );
            lines.add(new Line(buildings[i][1],buildings[i][2],false) );
        }
        
        // sort all lines according to x-axis, two lines with same left x, the one that is a left line will
        // infront of the other line
        Collections.sort(lines, (line1,line2) -> {
            if (line1.x == line2.x) {
                if (line1.isleft && line2.isleft) return line2.y - line1.y; // these two lines are considering while two buildings start at same x
                if (!line1.isleft && !line2.isleft) return line1.y - line2.y; //
                return line1.isleft? -1 : 0;
            }
            return line1.x - line2.x;
        });

        // iterate the building, while meet a left line, add onto list, when meet a right line, remove the corresponding left line from the list
        // deal very carefully for when to add a new point
        List<Line> list = new ArrayList();
        list.add(new Line(0,0,true));
        for(int i = 0; i < lines.size(); i++) {
            Line t = lines.get(i);
            
            if (t.isleft) {
                list.add(t);
                
                int max = 0;
                for (int j = 0; j < list.size()-1; j++) {
                    max = Math.max(list.get(j).y,max);
                }
                
                if (max < t.y) {
                    List<Integer> tmp = new ArrayList();
                    tmp.add(t.x);
                    tmp.add(t.y);
                    res.add(tmp);
                }
                
            } else {
                int max = 0;
                int count = 0;
                for (int j = list.size()-1; j >= 0; j--) {
                    if (list.get(j).y == t.y && count == 0) { // only remove one pair
                        list.remove(j);
                        count++;
                    }
                    else max = Math.max(list.get(j).y,max);
                }
                
                if (max < t.y) {
                    List<Integer> tmp = new ArrayList();
                    tmp.add(t.x);
                    tmp.add(max);
                    res.add(tmp);
                }
            }
        }
        
        return res;
    }
}
