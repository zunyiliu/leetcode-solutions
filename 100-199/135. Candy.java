// solution 1: a straightforward solution, start from the smallest rate and go higher, O(nlogn) time comlexity for sorting
// ratings, and O(n) for calculate --> overall O(nlogn) time complexity

// solution 2: brute force O(n^2), 1st iteration, give all children 1 candy, 2nd iteration, give those children with higher
// ratings than their number one more candy, so on and so force, maximum n traverse required

// solution 3: use two traverse, O(n) time complexity and O(n) sapce complexity
// first traverse left to right, to calculate all candies distributed for children only applies to left
// then traverse from right to left, update candies apply for both left and right

// solution 4: O(1) space complexity, using slope up and down to record the peak (like climbing mountain, only when you
// go down you can know how many extra steps you should extra increase). For example you go 3 steps to reach the peak, and 4 steps to
// the bot, the peak should be lifted by 1 to satisfy both left and right

class Solution {
    public int candy(int[] ratings) {
        // mapping for storing rate-index mapping
        // e.g [5,4,6] is stored as:
        // [0,5]                                                 [1,4]   
        // [1,4] --> after sort according to rate it becomes to  [0,5]   
        // [2,6]                                                 [2,6]
        int [][] mapping = new int[ratings.length][2]; 
        for(int i=0;i<ratings.length;i++) mapping[i][0] = i;
        for(int i=0;i<ratings.length;i++) mapping[i][1] = ratings[i];
        Arrays.sort(mapping,(t0,t1)->(t0[1]-t1[1]));    
        
        // candies for storing the min amount of candies an index should have
        int candies[] = new int[ratings.length];
        
        int sum = 0;
        for(int i=0;i<ratings.length;i++){
            int index = mapping[i][0];
            int min = minfromleft(index,ratings,candies);
            min = Math.max(min,minfromright(index,ratings,candies));
            candies[index] = min;
            sum+=min;
        }
        return sum;
    }
    public int minfromleft(int index,int[] ratings,int[] candies){
        if(index==0) return 1;
        // if current child's left has lower rating
        if(ratings[index-1]<ratings[index]) return candies[index-1]+1;
        else return 1;
    }
    public int minfromright(int index,int[] ratings,int[] candies){
        if(index==candies.length-1) return 1;
        // if current child's right has lower rating
        if(ratings[index+1]<ratings[index]) return candies[index+1]+1;
        else return 1;
    }
}

// solution 2
public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        boolean flag = true;
        int sum = 0;
        while (flag) {
            flag = false;
            for (int i = 0; i < ratings.length; i++) {
                if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    flag = true;
                }
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    flag = true;
                }
            }
        }
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }
}

// solution 3
public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        int sum = 0;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]) candies[i] = candies[i-1]+1;
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
            sum += candies[i];
        }
        return sum+candies[ratings.length-1];
    }
}

//solution 4
