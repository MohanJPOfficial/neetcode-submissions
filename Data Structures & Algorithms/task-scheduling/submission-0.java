class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for(char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for(int count : freq) {
            if(count > 0) {
                maxHeap.offer(count);
            }
        }

        Queue<int[]> cooldown = new ArrayDeque<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !cooldown.isEmpty()) {

            // move available tasks back into heap
            while(!cooldown.isEmpty() &&
                  cooldown.peek()[1] <= time) {

                maxHeap.offer(cooldown.poll()[0]);
            }

            // execute one task
            if(!maxHeap.isEmpty()) {

                int remaining = maxHeap.poll();

                remaining--;

                if(remaining > 0) {
                    cooldown.offer(
                        new int[] { remaining, time + n + 1 }
                    );
                }
            }

            time++;
        }

        return time;
    }
}