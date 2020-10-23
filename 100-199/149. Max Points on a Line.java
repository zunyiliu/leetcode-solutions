// O(n^2) solution, thats represent a line start from point i to point j as line(i,j), use a map<key,value> where key is a unique line, and value is the number of points on that line.
// iterate i, i represents the start point of a line
// iterate j from i+1 to the end, j represents the end point of the line starting from i
// if line(i,j) does exist in the map, then j is the new point that on an existed line, so add the line's value by 1
// otherwise line(i,j) is a new line then map.put(newline,2) (here the value starts from 2 since a line consists of two points)
// the key concept is how we represents lines with a unique key so that we can know the lines with different keys are definitely not the same line?
// the answer is:
// if 3 points a(x0,y0), b(x1,y1), c(x2,y2) and (x1-x0)/(y1-y0) == (x2-x0)/(y2-y0), then a,b,c are in the same line
// we can track a line by (x1-x0)/(y1-y0)

class Solution {
    public int maxPoints(int[][] points) {
        int rt = 0;
        
        for(int i=0;i<points.length;i++){
            int x0 = points[i][0];
            int y0 = points[i][1];
            Map<String,Integer> map = new HashMap();
            int dup = 0;
            int max = 1;
            
            for(int j=i+1;j<points.length;j++){
                int x1 = points[j][0];
                int y1 = points[j][1];
                int gcdXY = gcd(x1-x0,y1-y0);
                
                // while j and i are same point, we can't use below as
                // the way to calculate if they are lie on the same line
                // instead we add result by 1 directly
                if(gcdXY==0){
                    dup++;
                    continue;
                }
                
                int deltaX = (x1-x0)/gcdXY;
                int deltaY = (y1-y0)/gcdXY;
                
                String key = deltaX+":"+deltaY;
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+1);
                }else{
                    map.put(key,2);
                }
                
                max = Math.max(max,map.get(key));
            }
            
            rt = Math.max(rt,max+dup);
        }
        
        return rt;
    }
    
    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
