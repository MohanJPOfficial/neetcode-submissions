class Triple {
    int x;
    int y;
    int distance;

    public Triple(int x, int y) {
        this.x = x;
        this.y = y;
        distance = (x * x) + (y * y);
    }
}

class Solution {

    public int[][] kClosest(int[][] points, int k) {
        
        Comparator<Triple> comparator = (a, b) -> Integer.compare(b.distance, a.distance); // take the max

        Queue<Triple> pq = new PriorityQueue<>(comparator);

        for(int[] p : points) {
            Triple triple = new Triple(p[0], p[1]);
            pq.offer(triple);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];

        for(int i = 0; i < k; i++) {
            Triple top = pq.poll();
            res[i] = new int[] { top.x, top.y };
        }

        return res;
    }
}