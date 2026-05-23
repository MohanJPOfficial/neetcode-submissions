class ListNode {
    ListNode prev;
    ListNode next;
    int key;
    int val;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    private int size;
    private Map<Integer, ListNode> map;
    private ListNode head, tail;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        removeNode(node);
        addNode(node);

        return node.val;
    }
    
    public void put(int key, int value) {   

        ListNode node = new ListNode(key, value);

        if(map.containsKey(key)) {
            removeNode(map.get(key));
        
        } else if(map.size() == size) {
            removeNode(tail.prev);
        }

        addNode(node);
    }

    private void addNode(ListNode node) {

        ListNode next = head.next;
        node.next = next;
        next.prev = node;

        node.prev = head;
        head.next = node;

        map.put(node.key, node);

        // ListNode temp = head;

        // while(temp != null) {
        //     System.out.println("addNode : " + " prev " + temp.prev + ", cur : " + temp.val + ", next : " + temp.next);
        //     temp = temp.next;
        // }
        // System.out.println();
    }

    private void removeNode(ListNode node) {
        ListNode next = node.next;
        ListNode prev = node.prev;

        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;

        map.remove(node.key);

        // ListNode temp = head;

        // while(temp != null) {
        //     System.out.println("removeNode : " + " prev " + temp.prev + ", cur : " + temp.val + ", next : " + temp.next);
        //     temp = temp.next;
        // }

        // System.out.println();
    }
}
