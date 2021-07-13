public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int st = 1;
        int end = n;
        
        while (st < end) {
            int mid = st + (end-st)/2;
            if (!isBadVersion(mid)) {
                st = mid+1;
            } else end = mid;
        }
        return st;
    }
}
