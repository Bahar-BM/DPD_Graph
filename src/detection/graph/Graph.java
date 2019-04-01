package detection.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamed on 11/15/2017.
 */
public class Graph {
    public List<Node> nodes = new ArrayList<>();

    public void enrichedGraph() {
        System.out.print("enriched : " + getCountOfٍEdges());
        for (int i = 0; i < nodes.size(); i++) {
            doEnrich(nodes.get(i), nodes.get(i), 0);
        }
        System.out.println("  " + getCountOfٍEdges());
    }

    public boolean addNodes(Node node) {
        if (nodes.contains(node)) {
            nodes.set(nodes.indexOf(node), node);
            return false;
        } else {
            nodes.add(node);
            return true;
        }
    }

    private void doEnrich(Node parent, Node current, int level) {
        if (level >= 2) {
            for (int i = 0; i < parent.getOutRelations().size(); i++) {
                if (!current.containOutRelation(parent.getOutRelations().get(i).getKey(), parent.getOutRelations().get(i).getValue())) {
                    current.addOutRelation(parent.getOutRelations().get(i).getKey(), parent.getOutRelations().get(i).getValue());
                }
            }
        }
        for (int j = 0; j < current.getInRelations().size(); j++) {
            if (current.getInRelations().get(j).getValue() == Node.NodeType.inhert) {
                doEnrich(current, current.getInRelations().get(j).getKey(), level + 1);
            }
        }
    }

    public int getCountOfٍEdges() {
        int x = 0;
        for (int i = 0; i < nodes.size(); i++) {
            x += nodes.get(i).getOutRelations().size();
        }
        return x;
    }

    public void fillSimailarValues(Graph pattern) {
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < pattern.nodes.size(); j++) {
                if (!nodes.get(i).getValues().contains(pattern.nodes.get(j).getValues().get(0)) && nodes.get(i).isSimilarTo(pattern.nodes.get(j))) {
                    nodes.get(i).addValue(pattern.nodes.get(j).getValues().get(0));
                }
            }
        }
    }

    public Node getNodeByName(String name) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).className.equals(name)) {
                return nodes.get(i);
            }
        }
        return null;
    }

    public void calculatePatternValues() {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).addValue(nodes.get(i).calculateValue());
        }
    }

    public void getSubSystems(Graph pattern) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getValues().size() == 0) {
                nodes.get(i).destroy();
                nodes.remove(i);
                i--;
            }
        }
        List<Edge> patternEdges = Edge.getDistinctEdges(pattern);
//        for (int i = 0; i < patternEdges.size(); i++) {
//            System.out.println(patternEdges.get(i).toString());
//        }
//        System.out.println("--------------------");
        List<Edge> systemEdges = Edge.getAllEdges(this);
        for (int i = 0; i < systemEdges.size(); i++) {
//            System.out.println(systemEdges.get(i).toString());
            for (int j = 0; j < patternEdges.size(); j++) {
                if (systemEdges.get(i).equals(patternEdges.get(j))) {
                    systemEdges.get(i).isValid = true;
                    break;
                }
            }
        }

        Graph graph = new Graph();

        for (int i = 0; i < systemEdges.size(); i++) {
            if (systemEdges.get(i).isValid) {
                graph.addNodes(systemEdges.get(i).start.getSimpleCopy());
                graph.addNodes(systemEdges.get(i).end.getSimpleCopy());
            } else {
                systemEdges.remove(i);
                i--;
            }
        }

//        detection.graph = Matching.fillRelations(this, detection.graph);


        for (int j = 0; j < graph.nodes.size(); j++) {
            for (int i = 0; i < systemEdges.size(); i++) {
                if (graph.nodes.get(j).className.equals(systemEdges.get(i).start.className)) {
                    for (int h = 0; h < graph.nodes.size(); h++) {
                        if(graph.nodes.get(h).className.equals(systemEdges.get(i).end.className)){
                            graph.nodes.get(j).addOutRelation(graph.nodes.get(h),systemEdges.get(i).nodeType);
                        }
                    }
                }
            }
        }
        nodes = graph.nodes;

//        System.out.println("############################");
//        for (int i = 0; i < systemEdges.size(); i++) {
////            System.out.println(systemEdges.get(i).toString());
//            if (!systemEdges.get(i).isValid) {
//                Edge e = systemEdges.get(i);
//                boolean done = false;
//                if (e.start.getValues().size() > 1) {
//                    if (e.start.getValues().remove((Object) e.startValue)) {
//                        done = true;
//                    }
//                }
//                if (!done && e.end.getValues().size() > 1) {
//                    if (e.end.getValues().remove((Object) e.endValue)) {
//                        done = true;
//                    }
//                }
//                if (!done) {
//                    boolean b = false;
//                    for (int j = i + 1; j < systemEdges.size(); j++) {
//                        Edge e2 = systemEdges.get(j);
//                        if (e2.start.equals(e.start) && e2.end.equals(e.end) && e2.nodeType == e.nodeType) {
//                            b = true;
//                            break;
//                        }
//                    }
//                    if (!b)
//                        e.start.removeOutRelation(e.end, e.nodeType);
//                }
//            }
//        }
//        System.out.println("--------------------");
//        List<Edge> systemEdges2 = Edge.getAllEdges(this);
//        for (int i = 0; i < systemEdges2.size(); i++) {
//            System.out.println(systemEdges2.get(i).toString());
//        }
//        for (int i = 0; i < nodes.size(); i++) {
//            if (nodes.get(i).getOutRelations().size() == 0 && nodes.get(i).getInRelations().size() == 0) {
//                nodes.remove(i);
//                i--;
//            }
//        }
    }


    public List<Graph> getSubGraphs() {
        List<Node> list = new ArrayList<>();
        list.addAll(nodes);
        List<Graph> graphList = new ArrayList<>();
        while (list.size() > 0) {
            List<Node> nodes = getSubGraph(new ArrayList<>(), list.get(0));
            for (int i = 0; i < nodes.size(); i++) {
                list.remove(nodes.get(i));
            }
            Graph g = new Graph();
            g.nodes = nodes;
            graphList.add(g);
        }
        return graphList;
    }


    private List<Node> getSubGraph(List<Node> nodes, Node node) {
        if (nodes.contains(node)) {
            return nodes;
        }
        nodes.add(node);
        for (int i = 0; i < node.getOutRelations().size(); i++) {
            Node out = node.getOutRelations().get(i).getKey();
            nodes = getSubGraph(nodes, out);
        }

        for (int i = 0; i < node.getInRelations().size(); i++) {
            Node in = node.getInRelations().get(i).getKey();
            nodes = getSubGraph(nodes, in);
        }
        return nodes;
    }

    @Override
    public boolean equals(Object obj) {
        Graph g = (Graph) obj;
        for (int i = 0; i < nodes.size(); i++) {
            boolean b = false;
            for (int j = 0; j < g.nodes.size(); j++) {
                if (nodes.get(i).equals(g.nodes.get(j))) {
                    b = true;
                    break;
                }
            }
            if (!b)
                return false;
        }
        return true;
    }
}
