package CloneGraph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}

class Solution {

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> hash) {
        if (node == null)
            return null;
        UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
        hash.put(node.label, clonedNode);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (hash.containsKey(neighbor.label)) {
                clonedNode.neighbors.add(hash.get(neighbor.label));
            } else {
                clonedNode.neighbors.add(cloneGraph(neighbor, hash));
            }
        }
        return clonedNode;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneGraph(node, new HashMap<>());
    }
}