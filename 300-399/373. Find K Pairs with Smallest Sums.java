class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        List<List<Integer>> list = new ArrayList();
        
        for (int i  = 0; i < nums1.length && i < k; i++) {
            for (int j = 0; j < nums2.length && j < k; j++) {
                pq.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int []cur = pq.poll();
            list.add(Arrays.asList(new Integer[]{cur[0], cur[1]}));
        }
        
        return list;
    }
}
