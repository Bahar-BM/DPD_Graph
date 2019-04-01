package detection.load;

import cdg.model.ClassDiagram;
import cdg.util.CdCategory;
import diagramParser.Json2Object;
import detection.graph.Graph;
import detection.graph.Node;

/**
 * Created by hamed on 11/15/2017.
 */
public class GraphCreator {
    private String filePath;
    private ClassDiagram classDiagram;
    private Graph graph;
    private String name;

    public GraphCreator(String filePath, String name) {
        this.filePath = filePath;
        this.name = name;
    }

    public Graph getGraph() {
        if (graph != null)
            return graph;
        classDiagram = new Json2Object().convert2Object(filePath);
        graph = new Graph();
        for (int i = 0; i < classDiagram.classes.size(); i++) {
            Node node = new Node(classDiagram.classes.get(i).name);
            graph.addNodes(node);
        }
        for (int i = 0; i < classDiagram.associationRelations.size(); i++) {
            String left = classDiagram.associationRelations.get(i).leftClass;
            String right = classDiagram.associationRelations.get(i).rightClass;
            CdCategory.AssociationKind assoc = classDiagram.associationRelations.get(i).associationKind;
            Node nodeL = graph.getNodeByName(left);
            Node nodeR = graph.getNodeByName(right);
            if (assoc == CdCategory.AssociationKind.DIRECT) {
                nodeL.addOutRelation(nodeR, Node.NodeType.association);
            } else if (assoc == CdCategory.AssociationKind.TWOWAY) {
                nodeL.addOutRelation(nodeR, Node.NodeType.association);
                nodeR.addOutRelation(nodeL, Node.NodeType.association);
            }
        }
        for (int i = 0; i < classDiagram.generalizationRelations.size(); i++) {
            String superClass = classDiagram.generalizationRelations.get(i).superClass;
            String subClass = classDiagram.generalizationRelations.get(i).subClass;
//            classDiagram.generalizationRelations.get(i).generalizationKing
            Node sup = graph.getNodeByName(superClass);
            Node sub = graph.getNodeByName(subClass);
            sub.addOutRelation(sup, Node.NodeType.inhert);
        }

        for (int i = 0; i < classDiagram.dependencyRelations.size(); i++) {
            String client = classDiagram.dependencyRelations.get(i).clientClass;
            String sup = classDiagram.dependencyRelations.get(i).supplierClass;
//            classDiagram.generalizationRelations.get(i).generalizationKing
            Node supNode = graph.getNodeByName(sup);
            Node clientNode = graph.getNodeByName(client);
            supNode.addOutRelation(clientNode, Node.NodeType.aggregation);
        }

        return graph;
    }

    public ClassDiagram getClassDiagram() {
        return classDiagram;
    }

    public String getName() {
        return name;
    }
}

