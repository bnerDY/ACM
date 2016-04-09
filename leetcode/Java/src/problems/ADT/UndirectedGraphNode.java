package problems.ADT;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 09/04/2016.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
