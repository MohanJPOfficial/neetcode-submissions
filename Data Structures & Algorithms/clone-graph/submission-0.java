/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> map;

    public Node cloneGraph(Node node) {

        map = new HashMap<>();

        return dfs(node);
    }

    private Node dfs(Node node) {
        
        if(node == null) {
            return node;
        }

        var newNode = new Node(node.val);
        map.put(node, newNode);

        for(Node neighbor : node.neighbors) {
            if(map.containsKey(neighbor)) {
                newNode.neighbors.add(map.get(neighbor));
            } else {
                newNode.neighbors.add(dfs(neighbor));
            }
        }

        return newNode;
    }
}