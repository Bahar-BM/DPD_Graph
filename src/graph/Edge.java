package graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Edge {
    public int startValue;
    public int endValue;
    public Node.NodeType nodeType;
    public Node start;
    public Node end;
    public boolean isValid = false;


    public Edge(int startValue, int endValue, Node.NodeType nodeType) {
        this.startValue = startValue;
        this.endValue = endValue;
        this.nodeType = nodeType;
    }

    @Override
    public boolean equals(Object obj) {
        Edge edge = (Edge) obj;
        if (startValue == edge.startValue && endValue == edge.endValue && nodeType == edge.nodeType) {
            return true;
        }
        return false;
    }

    public static List<Edge> getDistinctEdges(Graph graph) {
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < graph.nodes.size(); i++) {
            Node node = graph.nodes.get(i);
            for (int j = 0; j < node.getOutRelations().size(); j++) {
                Pair<Node, Node.NodeType> out = graph.nodes.get(i).getOutRelations().get(j);
                for (int k = 0; k < node.getValues().size(); k++) {
                    for (int h = 0; h < out.getKey().getValues().size(); h++) {
                        Edge edge = new Edge(node.getValues().get(k), out.getKey().getValues().get(h), out.getValue());
                        edge.start = node;
                        edge.end = out.getKey();
                        if (!edgeList.contains(edge)) {
                            edgeList.add(edge);
                        }
                    }
                }
            }
        }
        return edgeList;
    }

    public static List<Edge> getAllEdges(Graph graph) {
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < graph.nodes.size(); i++) {
            Node node = graph.nodes.get(i);
            for (int j = 0; j < node.getOutRelations().size(); j++) {
                Pair<Node, Node.NodeType> out = graph.nodes.get(i).getOutRelations().get(j);
                for (int k = 0; k < node.getValues().size(); k++) {
                    for (int h = 0; h < out.getKey().getValues().size(); h++) {
                        Edge edge = new Edge(node.getValues().get(k), out.getKey().getValues().get(h), out.getValue());
                        edge.start = node;
                        edge.end = out.getKey();
                        edgeList.add(edge);
                    }
                }
            }
        }
        return edgeList;
    }

    @Override
    public String toString() {
        return startValue + " " + endValue + " " +nodeType + " " +start.className + " " + end.className + " valid = " + isValid;
    }
}
