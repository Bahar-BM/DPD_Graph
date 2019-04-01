package detection;

import detection.graph.Graph;
import detection.graph.Matching;
import detection.graph.MethodChecking;
import detection.graph.Node;
import detection.load.GraphCreator;
import detection.result.resultMaker.ResultViewer;
import detection.result.resultStructureModel.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by hamed on 11/15/2017.
 */
public class Program {
    static String sourceJsonPath = "ClassDiagram300.json";
    static String dest = "result.out";
    static String jarPath = "materials/generatedCode300.jar";
    public static String sourceCodePath = "materials/targetCode300/";
    public static String packageName = "targetCode";

    public static void main(String[] args) {
//        if (args != null && args.length != 3) {
//            System.out.println("pass 3 path ");
//            System.out.println("first : source code path");
//            System.out.println("second : source jsonfile path");
//            System.out.println("third : dest detection.result path");
//            return;
//        }
//        sourceJsonPath = args[1];
//        dest = args[2];

//        Graph sampleSystem = getSampleSystem();
//        Graph samplePattern = getSmaplePattern();
//        samplePattern.calculatePatternValues();
//
//        sampleSystem.enrichedGraph();
//        sampleSystem.fillSimailarValues(samplePattern);
//        sampleSystem.getSubSystems(samplePattern);
//        List<Graph> graphList = sampleSystem.getSubGraphs();
//
//
//        for (int i = 0; i < graphList.size(); i++) {
//            Matching matching = new Matching(graphList.get(i), samplePattern);
//            matching.getMatching();
//        }

        GraphCreator[] patternGraphCreator = new GraphCreator[12];
        patternGraphCreator[0] = new GraphCreator("PatternsJsonRevised/revised_AbstractFactoryPattern.json", "AbstractFactory");
        patternGraphCreator[1] = new GraphCreator("PatternsJsonRevised/revised_AdapterPattern.json", "Adapter");
        patternGraphCreator[2] = new GraphCreator("PatternsJsonRevised/revised_CompositePattern.json", "Composite");
        patternGraphCreator[3] = new GraphCreator("PatternsJsonRevised/revised_DecoratorPattern.json", "Decorator");
        patternGraphCreator[4] = new GraphCreator("PatternsJsonRevised/revised_FactoryMethodPattern.json", "FactoryMethod");
        patternGraphCreator[5] = new GraphCreator("PatternsJsonRevised/revised_ObjectAdapterPattern.json", "ObjectAdapter");
        patternGraphCreator[6] = new GraphCreator("PatternsJsonRevised/revised_Observerpattern.json", "Observer");
        patternGraphCreator[7] = new GraphCreator("PatternsJsonRevised/revised_SingletonPattern.json", "Singleton");
        patternGraphCreator[8] = new GraphCreator("PatternsJsonRevised/revised_StatePattern.json", "State");
        patternGraphCreator[9] = new GraphCreator("PatternsJsonRevised/revised_StrategyPattern.json", "Strategy");
        patternGraphCreator[10] = new GraphCreator("PatternsJsonRevised/revised_TemplateMethodPattern.json", "TemplateMethod");
        patternGraphCreator[11] = new GraphCreator("PatternsJsonRevised/revised_VisitorPattern.json", "Visitor");


        PatternsGroupInfo patternsGroupInfo = new PatternsGroupInfo();
        for (int k = 0; k < patternGraphCreator.length; k++) {
            Graph pattern = patternGraphCreator[k].getGraph();
            pattern.calculatePatternValues();
            System.out.println("start : " + patternGraphCreator[k].getName());
            GraphCreator sysGraphCreator = new GraphCreator(sourceJsonPath, "system");
            Graph sys = sysGraphCreator.getGraph();
            sys.enrichedGraph();
            sys.fillSimailarValues(pattern);
            sys.getSubSystems(pattern);
            List<Graph> graphList = sys.getSubGraphs();
            GroupInfo groupInfo = new GroupInfo();
            groupInfo.setGroupName(patternGraphCreator[k].getName());

            for (int i = 0; i < graphList.size(); i++) {
                Matching matching = new Matching(graphList.get(i), pattern);

                List<List<List<Matching.NodeMap>>> nodeMaps = matching.getMatching();
//                System.out.println();
                for (int j = 0; j < nodeMaps.size(); j++) {
                    System.out.print(j + " ");
                    List<List<Matching.NodeMap>> maps = nodeMaps.get(j);
                    MethodChecking methodChecking = new MethodChecking(maps, patternGraphCreator[k].getName(),
                            jarPath, packageName);
                    maps = methodChecking.getOptimis();

//                    if (methodChecking.isMatch()) {
                    if (maps != null) {


                        InstanceInfo instanceInfo = new InstanceInfo();
                        for (int l = 0; l < maps.size(); l++) {
                            for (int f = 0; f < maps.get(l).size(); f++) {
                                Entry entry = new Entry(maps.get(l).get(f).v.className, maps.get(l).get(f).u.className);
                                instanceInfo.addEntry(entry);
                            }
                        }
                        groupInfo.addInstance(instanceInfo);
                    }
//                    }
                }
                System.out.println();

            }

            for (int i = 0; i < groupInfo.getInstances().size(); i++) {
                for (int j = i + 1; j < groupInfo.getInstances().size(); j++) {

                    if (groupInfo.getInstances().get(i).equals(groupInfo.getInstances().get(j))) {
                        groupInfo.getInstances().remove(j);
                        j--;
                    }
                }
            }

            patternsGroupInfo.addGroupInfo(groupInfo);
        }


        ResultViewer resultViewer = new ResultViewer(patternsGroupInfo, new JsonWriter());
        String results = resultViewer.getResults();
        try

        {
            PrintWriter writer = new PrintWriter(dest, "UTF-8");
            writer.println(results);
            writer.close();
        } catch (
                IOException e)

        {
            e.printStackTrace();
            // do something
        }

    }

    private static Graph getSmaplePattern() {
        Node component = new Node("Component");
        Node concreteComponent = new Node("ConcreteComponent");
        Node element = new Node("Element");
        Node concreteElementA = new Node("ConcreteElementA");
        Node concreteElementB = new Node("ConcreteElementB");

        concreteComponent.addOutRelation(component, Node.NodeType.inhert);
        element.addOutRelation(component, Node.NodeType.inhert);
        element.addOutRelation(component, Node.NodeType.aggregation);
        concreteElementA.addOutRelation(element, Node.NodeType.inhert);
        concreteElementB.addOutRelation(element, Node.NodeType.inhert);
        Graph graph = new Graph();
        graph.nodes.add(component);
        graph.nodes.add(concreteComponent);
        graph.nodes.add(element);
        graph.nodes.add(concreteElementA);
        graph.nodes.add(concreteElementB);
        return graph;
    }


    public static Graph getSampleSystem() {
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");
        Node s4 = new Node("s4");
        Node s5 = new Node("s5");
        Node s6 = new Node("s6");
        Node s7 = new Node("s7");
        Node s8 = new Node("s8");
//        Node s9 = new Node("s9");

        s2.addOutRelation(s1, Node.NodeType.inhert);
        s2.addOutRelation(s4, Node.NodeType.aggregation);
        s3.addOutRelation(s2, Node.NodeType.association);
        s5.addOutRelation(s4, Node.NodeType.inhert);
        s6.addOutRelation(s4, Node.NodeType.inhert);
        s6.addOutRelation(s4, Node.NodeType.aggregation);
        s7.addOutRelation(s6, Node.NodeType.inhert);
        s8.addOutRelation(s6, Node.NodeType.inhert);
//        s9.addOutRelation(s7, Node.NodeType.inhert);
        Graph graph = new Graph();
        graph.nodes.add(s1);
        graph.nodes.add(s2);
        graph.nodes.add(s3);
        graph.nodes.add(s4);
        graph.nodes.add(s5);
        graph.nodes.add(s6);
        graph.nodes.add(s7);
        graph.nodes.add(s8);
//        detection.graph.nodes.add(s9);
        return graph;
    }
}
