package graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Matching {
    Graph gSystem;
    Graph qPattern;
    int dq;

    public Matching(Graph subSystem, Graph pattern) {
        gSystem = subSystem;
        qPattern = pattern;
        dq = calculateDiameter();

    }

    private int calculateDiameter() {
        Node node = null;
        int max = 0;
        for (int i = 0; i < qPattern.nodes.size(); i++) {
            int d = qPattern.nodes.get(i).getOutRelations().size() + qPattern.nodes.get(i).getInRelations().size();
            if (d > max) {
                max = d;
                node = qPattern.nodes.get(i);
            }
        }

        return getDepthOfNode(null, node);

    }

    private int getDepthOfNode(Node last, Node node) {

        int max = 0;
        for (int i = 0; i < node.getOutRelations().size(); i++) {
            if (node.getOutRelations().get(i).getKey().equals(last))
                continue;
            int d = getDepthOfNode(node, node.getOutRelations().get(i).getKey()) + 1;
            if (d > max) {
                max = d;
            }
        }

        for (int i = 0; i < node.getInRelations().size(); i++) {
            if (node.getInRelations().get(i).getKey().equals(last))
                continue;
            int d = getDepthOfNode(node, node.getInRelations().get(i).getKey()) + 1;
            if (d > max) {
                max = d;
            }
        }

        return max;
    }

    //    private List<List<NodeMap>> nodeMaps = new ArrayList<>();
//
//    public List<List<NodeMap>> getNodeMaps() {
//        return nodeMaps;
//    }
    ArrayList<List<List<NodeMap>>> outPuts = new ArrayList<>();

    List<Graph> balls = new ArrayList<>();

    public ArrayList<List<List<NodeMap>>> getMatching() {
        for (int i = 0; i < gSystem.nodes.size(); i++) {
            Graph graph = new Graph();
            graph.nodes.add(gSystem.nodes.get(i).getSimpleCopy());
            Graph ball = getBall(graph, graph.nodes.get(0), gSystem.nodes.get(i), dq);
            ball = fillRelations(gSystem, ball);
            if (balls.contains(ball)) {
                continue;
            }
            balls.add(ball);
            List<List<NodeMap>> mapList = dualsim(ball);
            mapList = extractMatchedSubGraph(mapList);
            boolean b = true;
            for (int j = 0; j < mapList.size(); j++) {
                if (mapList.get(j).size() == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                if(!isOutPutContain(mapList)) {
                    outPuts.add(mapList);
                }
            }
            //doEjtema(mapList);
        }
        return outPuts;
//        nodeMaps = extractMatchedSubGraph(nodeMaps);
//        if (nodeMaps.size() != qPattern.nodes.size()) {
//            return false;
//        }
//        for (int i = 0; i < nodeMaps.size(); i++) {
//            if (nodeMaps.get(i).size() == 0)
//                return false;
//        }
//
//        return true;
    }

    private boolean isOutPutContain(List<List<NodeMap>> mapList) {
        for (int i = 0; i < outPuts.size(); i++) {
            if (outPuts.contains(mapList))
                return true;
        }
        return false;
    }

//    private void doEjtema(List<List<NodeMap>> mapList) {
//        for (int h = 0; h < mapList.size(); h++) {
//            if (mapList.get(h).size() == 0)
//                continue;
//            NodeMap node = mapList.get(h).get(0);
//            int index = -1;
//            for (int j = 0; j < nodeMaps.size(); j++) {
//                if (nodeMaps.get(j).size() > 0 && nodeMaps.get(j).get(0).u.equals(node.u)) {
//                    index = j;
//                    break;
//                }
//            }
//            if (index == -1) {
//                nodeMaps.add(mapList.get(h));
//            } else {
//                for (int j = 0; j < mapList.get(h).size(); j++) {
//                    if (!nodeMaps.get(index).contains(mapList.get(h).get(j))) {
//                        nodeMaps.get(index).add(mapList.get(h).get(j));
//                    }
//                }
//            }
//        }
//    }


    private Graph getBall(Graph graph, Node selectedNode, Node node, int dq) {
        if (dq == 0)
            return graph;
        for (int i = 0; i < node.getOutRelations().size(); i++) {
            Node n = graph.getNodeByName(node.getOutRelations().get(i).getKey().className);
            if (n == null) {
                n = node.getOutRelations().get(i).getKey().getSimpleCopy();
                graph.addNodes(n);
            }

            //n = selectedNode.addOutRelation(n, node.getOutRelations().get(i).getValue());
            graph = getBall(graph, n, node.getOutRelations().get(i).getKey(), dq - 1);
        }
        for (int i = 0; i < node.getInRelations().size(); i++) {
            Node n = graph.getNodeByName(node.getInRelations().get(i).getKey().className);
            if (n == null) {
                n = node.getInRelations().get(i).getKey().getSimpleCopy();
                graph.addNodes(n);
            }

//            n = selectedNode.addInRelation(n, node.getInRelations().get(i).getValue());

            graph = getBall(graph, n, node.getInRelations().get(i).getKey(), dq - 1);
        }
        return graph;
    }

    public static Graph fillRelations(Graph system, Graph ball) {
        for (int i = 0; i < system.nodes.size(); i++) {
            for (int k = 0; k < ball.nodes.size(); k++) {
                if (ball.nodes.get(k).equals(system.nodes.get(i))) {
                    List<Pair<Node, Node.NodeType>> ot1 = system.nodes.get(i).getOutRelations();
                    for (int j = 0; j < ot1.size(); j++) {
                        for (int h = 0; h < ball.nodes.size(); h++) {
                            if (ot1.get(j).getKey().equals(ball.nodes.get(h))) {
                                ball.nodes.get(k).addOutRelation(ball.nodes.get(h), ot1.get(j).getValue());
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return ball;
    }

//    private Graph getBall(Graph graph,Node node)


    private List<List<NodeMap>> dualsim(Graph sys) {

        List<List<NodeMap>> nodMapList = new ArrayList<>();
        for (int i = 0; i < qPattern.nodes.size(); i++) {
            Node u = qPattern.nodes.get(i);
            List<Node> simU = calculateSim(u, sys);
            int simUsize;
            do {
                simUsize = simU.size();
                for (int j = 0; j < simU.size(); j++) {
                    boolean b = false;

                    for (int k = 0; k < u.getOutRelations().size(); k++) {
                        int value = u.getOutRelations().get(k).getKey().getValues().get(0);
                        for (int h = 0; h < simU.get(j).getOutRelations().size(); h++) {
                            if (simU.get(j).getOutRelations().get(h).getKey().getValues().contains(value) && simU.get(j).getOutRelations().get(h).getValue() == u.getOutRelations().get(k).getValue()) {
                                b = true;
                                break;
                            }
                        }
                        if (b) {
                            break;
                        }
                    }
                    if (!b && u.getOutRelations().size() > 0) {
                        simU.remove(j);
                        j--;
                    }
                }

                for (int j = 0; j < simU.size(); j++) {
                    boolean b = false;

                    for (int k = 0; k < u.getInRelations().size(); k++) {
                        int value = u.getInRelations().get(k).getKey().getValues().get(0);
                        for (int h = 0; h < simU.get(j).getInRelations().size(); h++) {
                            if (simU.get(j).getInRelations().get(h).getKey().getValues().contains(value) && simU.get(j).getInRelations().get(h).getValue() == u.getInRelations().get(k).getValue()) {
                                b = true;
                                break;
                            }
                        }
                        if (b) {
                            break;
                        }
                    }
                    if (!b && u.getInRelations().size() > 0) {
                        simU.remove(j);
                        j--;
                    }
                }

            } while (simUsize != simU.size());

            nodMapList.add(NodeMap.createMap(u, simU));

        }
        return nodMapList;
    }

    private List<List<NodeMap>> extractMatchedSubGraph(List<List<NodeMap>> nodeMaps) {
        boolean done = true;
        while (done) {
            done = false;
            for (int i = 0; i < nodeMaps.size(); i++) {
                if (nodeMaps.get(i).size() == 0) {
                    return nodeMaps;
                } else if (nodeMaps.get(i).size() == 1) {
                    NodeMap nodeMap = nodeMaps.get(i).get(0);
                    for (int j = 0; j < nodeMaps.size(); j++) {
                        for (int k = 0; k < nodeMaps.get(j).size(); k++) {
                            if (i != j && nodeMaps.get(j).get(k).v.equals(nodeMap.v)) {
                                nodeMaps.get(j).remove(k);
                                done = true;
                                k--;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < nodeMaps.size(); i++) {
            for (int j = 0; j < nodeMaps.get(i).size(); j++) {
                NodeMap nodeMap = nodeMaps.get(i).get(j);
                boolean find = false;
                for (int k = 0; k < nodeMaps.size(); k++) {
                    for (int h = 0; h < nodeMaps.get(k).size(); h++) {
                        if (i == k && j == h) {
                            continue;
                        }
                        NodeMap node2 = nodeMaps.get(k).get(h);
                        if (nodeMap.v.equals(node2.v)) {
                            find = true;
                            break;
                        }
                    }
                    if (find)
                        break;
                }
//                if (!find) {
//                    for (int g = 0; g < nodeMaps.get(i).size(); g++) {
//                        if (nodeMaps.get(i).get(g) == nodeMap) {
//                            continue;
//                        }
//                        nodeMaps.get(i).remove(g);
//                        g--;
//                    }
//                }
            }
        }
        return nodeMaps;
    }

    private List<Node> calculateSim(Node u, Graph sys) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < sys.nodes.size(); i++) {
            if (sys.nodes.get(i).getValues().contains(u.getValues().get(0))) {
                nodeList.add(sys.nodes.get(i));
            }
        }
        return nodeList;
    }


    public static class NodeMap {
        public Node u;
        public Node v;

        public NodeMap(Node u, Node v) {
            this.u = u;
            this.v = v;
        }

        public static List<NodeMap> createMap(Node u, List<Node> list) {
            List<NodeMap> maps = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                maps.add(new NodeMap(u, list.get(i)));
            }
            return maps;
        }

        @Override
        public boolean equals(Object obj) {
            NodeMap nodeMap = (NodeMap) obj;
            if (nodeMap.u.equals(u) && nodeMap.v.equals(v))
                return true;
            return false;
        }
    }


}
