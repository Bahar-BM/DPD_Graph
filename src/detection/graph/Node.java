package detection.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hamed on 11/15/2017.
 */
public class Node {
    public String className;
    //    public int value;
    private List<Pair<Node, NodeType>> outRelations = new ArrayList<>();
    private List<Pair<Node, NodeType>> inRelations = new ArrayList<>();
    private List<Integer> values = new ArrayList<>();
    boolean isValid = true;

    public Node(String className) {
        this.className = className;
    }

    public Node() {
    }

    public Node addOutRelation(Node node, NodeType nodeType) {

        for(int i=0;i<outRelations.size();i++){
            if(outRelations.get(i).getKey().equals(node) ){
                node = outRelations.get(i).getKey();
                if(outRelations.get(i).getValue() == nodeType){
                    return outRelations.get(i).getKey();
                }
            }
        }
        outRelations.add(new Pair<>(node, nodeType));
        node.inRelations.add(new Pair<>(this, nodeType));
        return node;
    }

    public Node addInRelation(Node node, NodeType nodeType) {
        for(int i=0;i<inRelations.size();i++){
            if(inRelations.get(i).getKey().equals(node) ){
                node = inRelations.get(i).getKey();
                if(inRelations.get(i).getValue() == nodeType) {
                    return inRelations.get(i).getKey();
                }
            }
        }
        inRelations.add(new Pair<>(node, nodeType));
        node.outRelations.add(new Pair<>(this, nodeType));
        return node;
    }

    public boolean removeOutRelation(Node node, NodeType nodeType) {
        for (int i = 0; i < outRelations.size(); i++) {
            if (outRelations.get(i).getKey().equals(node) && outRelations.get(i).getValue() == nodeType) {
                outRelations.remove(i);
                for (int j = 0; j < node.inRelations.size(); j++) {
                    if (node.inRelations.get(j).getKey().equals(this) && node.inRelations.get(j).getValue() == nodeType) {
                        node.inRelations.remove(j);
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public List<Pair<Node, NodeType>> getOutRelations() {
        return outRelations;
    }

    public void setOutRelations(List<Pair<Node, NodeType>> outRelations) {
        this.outRelations = outRelations;
    }

    public List<Pair<Node, NodeType>> getInRelations() {
        return inRelations;
    }

    public void setInRelations(List<Pair<Node, NodeType>> inRelations) {
        this.inRelations = inRelations;
    }

    public int calculateValue() {
        int value = 1;
        for (int i = 0; i < outRelations.size(); i++) {
            NodeType type = outRelations.get(i).getValue();
            if (type == NodeType.inhert) {
                value *= 3;
            } else if (type == NodeType.aggregation) {
                value *= 7;
            } else if (type == NodeType.association) {
                value *= 13;
            }
        }
        for (int i = 0; i < inRelations.size(); i++) {
            NodeType type = inRelations.get(i).getValue();
            if (type == NodeType.inhert) {
                value *= 2;
            } else if (type == NodeType.aggregation) {
                value *= 5;
            } else if (type == NodeType.association) {
                value *= 11;
            }
        }
        return value;
    }

    public boolean containOutRelation(Node node, NodeType nodeType) {
        for (int i = 0; i < outRelations.size(); i++) {
            if (outRelations.get(i).getKey().className == node.className && outRelations.get(i).getValue() == nodeType) {
                return true;
            }
        }
        return false;
    }

    public boolean containInRelation(Node node, NodeType nodeType) {
        for (int i = 0; i < inRelations.size(); i++) {
            if (inRelations.get(i).getKey().className == node.className && inRelations.get(i).getValue() == nodeType) {
                return true;
            }
        }
        return false;
    }

    public List<Node> getDistinctRelNode() {
        List<Node> nodes = new ArrayList<>();
        HashMap<String, Node> hashMap = new HashMap<>();
        for (int i = 0; i < outRelations.size(); i++) {
            if (!hashMap.containsKey(outRelations.get(i).getKey().className)) {
                nodes.add(outRelations.get(i).getKey());
                hashMap.put(outRelations.get(i).getKey().className, outRelations.get(i).getKey());
            }
        }
        for (int i = 0; i < inRelations.size(); i++) {
            if (!hashMap.containsKey(inRelations.get(i).getKey().className)) {
                nodes.add(inRelations.get(i).getKey());
                hashMap.put(inRelations.get(i).getKey().className, inRelations.get(i).getKey());
            }
        }
        return nodes;
    }

    public boolean isSimilarTo(Node node) {
        List<Node> distinct = getDistinctRelNode();

        List<Node> distintNode = node.getDistinctRelNode();
        if (distintNode.size() > distinct.size()) {
            return false;
        }
        boolean[] checks = new boolean[distintNode.size()];
        for (int j = 0; j < distintNode.size(); j++) {
            Node distinctNodeItem = distintNode.get(j);
            List<NodeType> distinctNodeInType = node.getInRelations(distinctNodeItem);
            List<NodeType> distinctNodeOutType = node.getOutRelations(distinctNodeItem);
            boolean result = false;
            for (int i = 0; i < distinct.size(); i++) {
                Node distinctItem = distinct.get(i);
                List<NodeType> distinctInType = getInRelations(distinctItem);
                List<NodeType> distinctOutType = getOutRelations(distinctItem);
                boolean b = true;
                for (int k = 0; k < distinctNodeInType.size(); k++) {
                    if (!distinctInType.contains(distinctNodeInType.get(k))) {
                        b = false;
                        break;
                    }
                }
                for (int k = 0; k < distinctNodeOutType.size(); k++) {
                    if (!distinctOutType.contains(distinctNodeOutType.get(k))) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    checks[j] = true;
                    break;
                }
            }
        }
        for (int i = 0; i < checks.length; i++) {
            if (!checks[i])
                return false;
        }
        return true;
    }

    public List<NodeType> getInRelations(Node node) {
        List<NodeType> nodeTypes = new ArrayList<>();
        for (int i = 0; i < inRelations.size(); i++) {
            if (inRelations.get(i).getKey().className.equals(node.className)) {
                nodeTypes.add(inRelations.get(i).getValue());
            }
        }
        return nodeTypes;
    }

    public List<NodeType> getOutRelations(Node node) {
        List<NodeType> nodeTypes = new ArrayList<>();
        for (int i = 0; i < outRelations.size(); i++) {
            if (outRelations.get(i).getKey().className.equals(node.className)) {
                nodeTypes.add(outRelations.get(i).getValue());
            }
        }
        return nodeTypes;
    }

    public void destroy() {
        for (int i = 0; i < outRelations.size(); i++) {
            Node node = outRelations.get(i).getKey();
            for (int j = 0; j < node.inRelations.size(); j++) {
                if (node.inRelations.get(j).getKey().className.equals(className)) {
                    node.inRelations.remove(j);
                    j--;
                }
            }
        }
        for (int i = 0; i < inRelations.size(); i++) {
            Node node = inRelations.get(i).getKey();
            for (int j = 0; j < node.outRelations.size(); j++) {
                if (node.outRelations.get(j).getKey().className.equals(className)) {
                    node.outRelations.remove(j);
                    j--;
                }
            }
        }
        outRelations = null;
        inRelations = null;
        values = null;
    }

    public void addValue(int value) {
        values.add(value);
    }


    public void setValues(List<Integer> values) {
        this.values = values;
    }

    public List<Integer> getValues() {
        return values;
    }

    public enum NodeType {
        association,
        inhert,
        aggregation,
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        return className.equals(((Node)obj).className);
    }

    public Node getSimpleCopy(){
        Node node = new Node(className);
        node.values = new ArrayList<>(values);
        return node;
    }
}
