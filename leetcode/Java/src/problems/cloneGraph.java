package problems;

import problems.ADT.UndirectedGraphNode;

import java.util.HashMap;

/**
 * Created by Martin on 09/04/2016.
 */
public class cloneGraph {

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);

        DFS(hm, node);//DFS
        return head;

    }


    public static void DFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> hm, UndirectedGraphNode node) {
        if (node == null)
            return;

        for (UndirectedGraphNode aneighbor : node.neighbors) {
            if (!hm.containsKey(aneighbor)) {
                UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
                hm.put(aneighbor, newneighbor);
                DFS(hm, aneighbor);//DFS
            }
            hm.get(node).neighbors.add(hm.get(aneighbor));
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);

        node0.neighbors.add(node1);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);

        UndirectedGraphNode nodeClone = cloneGraph(node0);
        System.out.println("node2: " + nodeClone.toString());
    }

}
