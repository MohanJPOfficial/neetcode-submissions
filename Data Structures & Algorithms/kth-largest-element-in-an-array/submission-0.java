class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int index = 0;
        for(int i : nums) {
            pq.offer(i);
            index++;

            if(index > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }
}
