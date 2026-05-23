class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int reminder = target - nums[i];

            if(map.containsKey(reminder)) {
                return new int[] {map.get(reminder), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
