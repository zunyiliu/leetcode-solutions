// solution: 1st sort people with height from high to low, if two people have same height sort them with people[i][1] (the more people infront of him the higher his people[i][1]
// would be). This can be solved by Arrays.sort() with overriding Comparator(), 2nd we go through the sorted array, insert each element with index = people[i][1] (apply greedy) 

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]) return a[1]-b[1];
                return b[0]-a[0];
            }
        });
        
        List<int[]> tmp = new ArrayList();
        for(int i=0;i<people.length;i++){
            tmp.add(people[i][1],people[i]);
        }
        
        return tmp.toArray(new int[people.length][2]);
    }
}
