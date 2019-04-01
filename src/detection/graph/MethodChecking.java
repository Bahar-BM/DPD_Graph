package detection.graph;

import detection.Program;
import org.xeustechnologies.jcl.JarClassLoader;
import detection.util.UsedMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MethodChecking {
    //    PatternsGroupInfo patternsGroupInfo;
    public String packageName;
    JarClassLoader jcl;
    public List<List<Matching.NodeMap>> mapList;
    String patternName;
    Graph graph;
    String fileAddress;
    String sourceCode = Program.sourceCodePath;

    public MethodChecking(List<List<Matching.NodeMap>> mapList, String patternName, String fileAddress, String packageName) {
        this.mapList = mapList;
        this.patternName = patternName;
        packageName += ".";
        this.packageName = packageName;
        this.fileAddress = fileAddress;
        jcl = new JarClassLoader();
        jcl.add(fileAddress);

    }

    public List<List<Matching.NodeMap>> getOptimis() {
        if (patternName.equals("AbstractFactory")) {
            List<Matching.NodeMap> abstractFactory = null, concreteFactory = null, product = null;
            for (int i = 0; i < mapList.size(); i++) {
                if (mapList.get(i).get(0).u.className.equals("AbstractFactory")) {
                    abstractFactory = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("ConcreteFactory")) {
                    concreteFactory = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("Product")) {
                    product = mapList.get(i);
                }
            }
            return doAbstractFactory(abstractFactory, concreteFactory, product);
        } else if (patternName.equals("Decorator")) {
            List<Matching.NodeMap> component = null, concreteComponent = null, decorator = null;
            for (int i = 0; i < mapList.size(); i++) {
                if (mapList.get(i).get(0).u.className.equals("Decorator")) {
                    decorator = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("ConcreteComponent")) {
                    concreteComponent = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("Component")) {
                    component = mapList.get(i);
                }
            }

            return doDecorator(component, concreteComponent, decorator);
        } else if (patternName.equals("Composite")) {
            List<Matching.NodeMap> component = null, composite = null;
            for (int i = 0; i < mapList.size(); i++) {
                if (mapList.get(i).get(0).u.className.equals("Composite")) {
                    composite = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("Component")) {
                    component = mapList.get(i);
                }
            }
            try {
                return doComposite(component, composite);
            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
            }

        } else if (patternName.equals("FactoryMethod")) {
            List<Matching.NodeMap> creator = null, concreteProduct = null, concreteCreator = null;
            for (int i = 0; i < mapList.size(); i++) {
                if (mapList.get(i).get(0).u.className.equals("Creator")) {
                    creator = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("ConcreteProduct")) {
                    concreteProduct = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("ConcreteCreator")) {
                    concreteCreator = mapList.get(i);
                }
            }
//            return mapList;
            try {
                return doFactoryMethod(creator, concreteProduct, concreteCreator);
            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
            } catch (FileNotFoundException e) {
                // e.printStackTrace();
            } catch (NoSuchMethodException e) {
                //e.printStackTrace();
            }
            return null;
        } else if (patternName.equals("Strategy")) {
            List<Matching.NodeMap> context = null, strategy = null, concreteStratagy = null;
            for (int i = 0; i < mapList.size(); i++) {
                if (mapList.get(i).get(0).u.className.equals("Context")) {
                    context = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("Strategy")) {
                    strategy = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("ConcreteStratagy")) {
                    concreteStratagy = mapList.get(i);
                }
            }
//            return mapList;
            try {
                return doStratagy(context, strategy, concreteStratagy);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        } else if (patternName.equals("State")) {
            List<Matching.NodeMap> context = null, state = null, concreteState = null;
            for (int i = 0; i < mapList.size(); i++) {
                if (mapList.get(i).get(0).u.className.equals("Context")) {
                    context = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("State")) {
                    state = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("ConcreteState")) {
                    concreteState = mapList.get(i);
                }
            }
//            return mapList;
            try {
                return doState(context, state, concreteState);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } else if (patternName.equals("TemplateMethod")) {
            List<Matching.NodeMap> abstractClass = null, concreteClass = null;
            for (int i = 0; i < mapList.size(); i++) {
                if (mapList.get(i).get(0).u.className.equals("AbstractClass")) {
                    abstractClass = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("ConcreteClass")) {
                    concreteClass = mapList.get(i);
                }
            }
//            return mapList;
            try {
                return doTemplateMethod(abstractClass, concreteClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        } else if (patternName.equals("Visitor")) {
            List<Matching.NodeMap> element = null, visitor = null, objectStructure = null, concreteElement = null, concreteVisitor = null;
            for (int i = 0; i < mapList.size(); i++) {
                if (mapList.get(i).get(0).u.className.equals("Element")) {
                    element = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("Visitor")) {
                    visitor = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("ObjectStructure")) {
                    objectStructure = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("ConcreteElement")) {
                    concreteElement = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("ConcreteVisitor")) {
                    concreteVisitor = mapList.get(i);
                }
            }
//            return mapList;
            try {
                return doVisitor(element, visitor, objectStructure, concreteElement, concreteVisitor);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
//                e.printStackTrace();
            }
            return null;

        } else if (patternName.equals("Singleton")) {
            try {
                List<Matching.NodeMap> singleton = mapList.get(0);
                return mapList = doSingleton(singleton);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        } else if (patternName.equals("Observer")) {
            List<Matching.NodeMap> subject = null, observer = null;
            for (int i = 0; i < mapList.size(); i++) {
                if (mapList.get(i).get(0).u.className.equals("Subject")) {
                    subject = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("Observer")) {
                    observer = mapList.get(i);
                }
            }
//            return mapList;
            try {
                return doObserver(subject, observer);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
//                e.printStackTrace();
            }
            return null;

        } else if (patternName.equals("ObjectAdapter")) {
            List<Matching.NodeMap> target = null, adapter = null, adaptee = null;
            for (int i = 0; i < mapList.size(); i++) {
                if (mapList.get(i).get(0).u.className.equals("Adapter")) {
                    adapter = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("Adaptee")) {
                    adaptee = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("Target")) {
                    target = mapList.get(i);
                }
            }
//            return mapList;
            try {
                return doObjectAdapter(target, adapter, adaptee);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
//                e.printStackTrace();
            }
        } else if (patternName.equals("Adapter")) {
            List<Matching.NodeMap> target = null, adapter = null, adaptee = null;
            for (int i = 0; i < mapList.size(); i++) {
                if (mapList.get(i).get(0).u.className.equals("Adapter")) {
                    adapter = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("Adaptee")) {
                    adaptee = mapList.get(i);
                } else if (mapList.get(i).get(0).u.className.equals("Target")) {
                    target = mapList.get(i);
                }
            }
//            return mapList;
            try {
                return doClassAdapter(target, adapter, adaptee);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
        return mapList;
    }

    public List<List<Matching.NodeMap>> doTemplateMethod(List<Matching.NodeMap> abstractClass, List<Matching.NodeMap> concreteClass) throws ClassNotFoundException, FileNotFoundException {
        List<Matching.NodeMap> abstractResult = new ArrayList<>();
        List<Matching.NodeMap> concreteResult = new ArrayList<>();
        for (int i = 0; i < abstractClass.size(); i++) {
            Class abst = jcl.loadClass(packageName + abstractClass.get(i).v.className);
            for (int g = 0; g < concreteClass.size(); g++) {
                boolean b = false;
                for (int j = 0; j < abst.getMethods().length && !b; j++) {
                    String m = abst.getMethods()[j].getName();
                    String textFile = getfileText(abstractClass.get(i).v.className + ".java");
                    int index = textFile.indexOf(m);
                    if (index == -1) {
                        continue;
                    }
                    index = textFile.indexOf(m, index + 1);
                    if (index == -1) {
                        continue;
                    }

                    String concreteTextfile = getfileText(concreteClass.get(g).v.className + ".java");
                    if (concreteTextfile.indexOf(m) != -1) {
                        if (!abstractResult.contains(abstractClass.get(i))) {
                            abstractResult.add(abstractClass.get(i));
                        }
                        if (!concreteResult.contains(concreteClass.get(g))) {
                            concreteResult.add(concreteClass.get(g));
                        }
                        b = true;
                        break;
                    }
                }

            }

        }

        if (concreteResult.size() == 0 || abstractResult.size() == 0) {
            return null;
        }
        List<List<Matching.NodeMap>> mapList = new ArrayList<>();
        mapList.add(concreteResult);
        mapList.add(abstractResult);
        return mapList;

    }

    public List<List<Matching.NodeMap>> doStratagy(List<Matching.NodeMap> context, List<Matching.NodeMap> strategy, List<Matching.NodeMap> concreteStratagy) throws Exception {
        List<Matching.NodeMap> contextResult = new ArrayList<>(), strategyResult = new ArrayList<>(), concreteResult = new ArrayList<>();

        for (int i = 0; i < context.size(); i++) {
            Class contextClass = jcl.loadClass(packageName + context.get(i).v.className);
            if (contextClass.isInterface()) {
                continue;
            }
            for (int k = 0; k < strategy.size(); k++) {
                Class strategyClass = jcl.loadClass(packageName + strategy.get(k).v.className);
                if (!strategyClass.isInterface())
                    continue;

                boolean b = false;
                for (int j = 0; j < contextClass.getDeclaredFields().length && !b; j++) {

                    if (contextClass.getDeclaredFields()[j].getType().getSimpleName().equals(strategy.get(k).v.className)) {

                        for (int g = 0; g < strategyClass.getMethods().length && !b; g++) {
                            String m = strategyClass.getMethods()[g].getName();
                            String textFile = getfileText(context.get(i).v.className + ".java");

                            String s = contextClass.getDeclaredFields()[j].getName() + "." + m + "(";

                            int index = textFile.indexOf(s);
                            if (index == -1)
                                continue;
                            index = textFile.lastIndexOf("{", index);
                            index = textFile.lastIndexOf("(", index);
                            String methodName = textFile.substring(textFile.lastIndexOf(" ", index), index).trim();
                            for (int d = 0; d < contextClass.getMethods().length && !b; d++) {
                                if (contextClass.getMethods()[d].getName().equals(methodName)) {
                                    if (!contextResult.contains(context.get(i))) {
                                        contextResult.add(context.get(i));
                                    }
                                    if (!strategyResult.contains(strategy.get(k))) {
                                        strategyResult.add(strategy.get(k));
                                    }
                                    b = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (strategyResult.size() == 0 || contextResult.size() == 0) {
            return null;
        }

        List<List<Matching.NodeMap>> mapList = new ArrayList<>();
        mapList.add(strategyResult);
        mapList.add(contextResult);

        return mapList;
    }

    public List<List<Matching.NodeMap>> doState(List<Matching.NodeMap> context, List<Matching.NodeMap> state, List<Matching.NodeMap> concreteState) throws ClassNotFoundException, FileNotFoundException {
        List<Matching.NodeMap> contextResult = new ArrayList<>(), strategyResult = new ArrayList<>(), concreteResult = new ArrayList<>();

        for (int i = 0; i < context.size(); i++) {
            Class contextClass = jcl.loadClass(packageName + context.get(i).v.className);
            if (contextClass.isInterface()) {
                continue;
            }
            for (int k = 0; k < state.size(); k++) {
                for (int h = 0; h < concreteState.size(); h++) {
                    Class concreteClass = jcl.loadClass(packageName + concreteState.get(h).v.className);
                    if (concreteClass.isInterface()) {
                        continue;
                    }
                    boolean b = false;
                    for (int sh = 0; sh < contextClass.getMethods().length && !b; sh++) {
                        if (contextClass.getMethods()[sh].getParameterCount() >= 1 && contextClass.getMethods()[sh].getParameters()[0].getType().getSimpleName().equals(state.get(k).v.className)) {
                            for (int j = 0; j < contextClass.getDeclaredFields().length && !b; j++) {

                                if (contextClass.getDeclaredFields()[j].getType().getSimpleName().equals(state.get(k).v.className)) {
                                    Class strategyClass = jcl.loadClass(packageName + state.get(k).v.className);
                                    if (!strategyClass.isInterface())
                                        break;
                                    for (int g = 0; g < strategyClass.getMethods().length && !b; g++) {
                                        String m = strategyClass.getMethods()[g].getName();
                                        String textFile = getfileText(context.get(i).v.className + ".java");

                                        String s = contextClass.getDeclaredFields()[j].getName() + "." + m + "(";

                                        int index = textFile.indexOf(s);
                                        if (index == -1)
                                            continue;
                                        index = textFile.lastIndexOf("{", index);
                                        index = textFile.lastIndexOf("(", index);
                                        String methodName = textFile.substring(textFile.lastIndexOf(" ", index), index).trim();
                                        for (int d = 0; d < contextClass.getDeclaredMethods().length && !b; d++) {
                                            if (contextClass.getDeclaredMethods()[d].getName().equals(methodName)) {

                                                for (int n = 0; n < concreteClass.getMethods().length && !b; n++) {
                                                    if (concreteClass.getMethods()[n].getName().equals(m)) {

                                                        if (!contextResult.contains(context.get(i))) {
                                                            contextResult.add(context.get(i));
                                                        }
                                                        if (!strategyResult.contains(state.get(k))) {
                                                            strategyResult.add(state.get(k));
                                                        }
                                                        if (!concreteResult.contains(concreteState.get(h))) {
                                                            concreteResult.add(concreteState.get(h));
                                                        }
                                                        b = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        }

                                    }

                                }
                            }
                        }
                    }
                }
            }
        }

        if (strategyResult.size() == 0 || contextResult.size() == 0 || concreteResult.size() == 0) {
            return null;
        }

        List<List<Matching.NodeMap>> mapList = new ArrayList<>();
        mapList.add(strategyResult);
        mapList.add(contextResult);
        mapList.add(concreteResult);

        return mapList;
    }

    public List<List<Matching.NodeMap>> doObserver(List<Matching.NodeMap> subject, List<Matching.NodeMap> observer) throws ClassNotFoundException, FileNotFoundException {
        List<Matching.NodeMap> observerRsult = new ArrayList<>(), subjectResult = new ArrayList<>();
        for (int i = 0; i < observer.size(); i++) {
            Class observerClass = jcl.loadClass(packageName + observer.get(i).v.className);
            for (int j = 0; j < subject.size(); j++) {
                if (observer.get(i).v.className.equals(subject.get(j).v.className)) {
                    continue;
                }
                Class subjClass = jcl.loadClass(packageName + subject.get(j).v.className);
                boolean b = false;
                for (int d = 0; d < subjClass.getDeclaredFields().length && !b; d++) {
                    String output = subjClass.getDeclaredFields()[d].getType().getSimpleName();
                    if (output.toLowerCase().indexOf("list") != -1) {

                        for (int k = 0; k < observerClass.getMethods().length && !b; k++) {
                            if (observerClass.getMethods()[k].getParameterCount() == 1 && observerClass.getMethods()[k].getParameterTypes()[0].getSimpleName().equals(subject.get(j).v.className)) {
                                File f = new File(sourceCode + subject.get(j).v.className + ".java");
                                Scanner scanner = new Scanner(f);
                                while (scanner.hasNext() && !b) {
                                    String str = scanner.nextLine();
                                    String sx = observerClass.getMethods()[k].getName();
                                    if (str.indexOf(sx) != -1) {
                                        if (!observerRsult.contains(observer.get(i))) {
                                            observerRsult.add(observer.get(i));
                                        }
                                        if (!subjectResult.contains(subject.get(j))) {
                                            subjectResult.add(subject.get(j));
                                        }
                                        b = true;
                                        break;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        if (subjectResult.size() == 0 || observerRsult.size() == 0) {
            return null;
        }

        List<List<Matching.NodeMap>> mapList = new ArrayList<>();
        mapList.add(observerRsult);
        mapList.add(subjectResult);
        return mapList;
    }

    public List<List<Matching.NodeMap>> doVisitor(List<Matching.NodeMap> element, List<Matching.NodeMap> visitor, List<Matching.NodeMap> objectStructure, List<Matching.NodeMap> concreteElement, List<Matching.NodeMap> concreteVisitor) throws ClassNotFoundException, FileNotFoundException {
        List<Matching.NodeMap> elementResult = new ArrayList<>(),objectStructureResult = new ArrayList<>(), visitorResult = new ArrayList<>(), concreteResult = new ArrayList<>();
        for (int i = 0; i < element.size(); i++) {
            Class elementClass = jcl.loadClass(packageName + element.get(i).v.className);
            for (int j = 0; j < visitor.size(); j++) {
                Class visitorClass = jcl.loadClass(packageName + visitor.get(j).v.className);
                for (int h = 0; h < concreteElement.size(); h++) {
                    Class conElClass = jcl.loadClass(packageName + concreteElement.get(h).v.className);
                    for (int u = 0; u < objectStructure.size(); u++) {
                        Class objectStructureClass = jcl.loadClass(packageName + objectStructure.get(u).v.className);
                        boolean b = false;
                        for (int u2 = 0; u2 < objectStructureClass.getDeclaredFields().length; u2++) {
                            if (objectStructureClass.getDeclaredFields()[u2].getType().getSimpleName().toLowerCase().indexOf("list") != -1) {
                                String textFile = getfileText(objectStructure.get(u).v.className + ".java");
                                if (textFile.indexOf("<" + element.get(i).v.className + ">") == -1) {
                                    continue;
                                }
                                for (int g = 0; g < elementClass.getMethods().length && !b; g++) {
                                    if (elementClass.getMethods()[g].getParameterCount() == 1 && elementClass.getMethods()[g].getParameterTypes()[0].getSimpleName().equals(visitor.get(j).v.className)) {
                                        for (int d = 0; d < conElClass.getMethods().length && !b; d++) {
                                            if (conElClass.getMethods()[d].getName().equals(elementClass.getMethods()[g].getName())) {
                                                for (int s = 0; s < visitorClass.getMethods().length && !b; s++) {
                                                    String textFile2 = getfileText(concreteElement.get(h).v.className + ".java");
                                                    String sx = visitorClass.getMethods()[s].getName();
                                                    if (textFile2.indexOf(sx) != -1) {
                                                        if (!elementResult.contains(element.get(i))) {
                                                            elementResult.add(element.get(i));
                                                        }
                                                        if (!visitorResult.contains(visitor.get(j))) {
                                                            visitorResult.add(visitor.get(j));
                                                        }
                                                        if (!concreteResult.contains(concreteElement.get(h))) {
                                                            concreteResult.add(concreteElement.get(h));
                                                        }
                                                        if(!objectStructureResult.contains(objectStructure.get(u))){
                                                            objectStructureResult.add(objectStructure.get(u));
                                                        }
                                                        b = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (visitorResult.size() == 0 || concreteResult.size() == 0 || elementResult.size() == 0) {
            return null;
        }

//        for (int i = 0; i < objectStructure.size(); i++) {
//            boolean b = false;
//            for (int k = 0; k < objectStructure.get(i).v.getOutRelations().size() && !b; k++) {
//                for (int j = 0; j < elementResult.size(); j++) {
//                    if (objectStructure.get(i).v.getOutRelations().get(k).getKey().className.equals(elementResult.get(j).v.className)) {
//                        b = true;
//                        break;
//                    }
//                }
//            }
//            if (!b) {
//                objectStructure.remove(i);
//                i--;
//            }
//        }

        for (int i = 0; i < concreteVisitor.size(); i++) {
            boolean b = false;
            for (int k = 0; k < concreteVisitor.get(i).v.getOutRelations().size() && !b; k++) {
                for (int j = 0; j < visitorResult.size(); j++) {
                    if (concreteVisitor.get(i).v.getOutRelations().get(k).getKey().className.equals(visitorResult.get(j).v.className)) {
                        b = true;
                        break;
                    }
                }
            }
            if (!b) {
                concreteVisitor.remove(i);
                i--;
            }
        }

        List<List<Matching.NodeMap>> mapList = new ArrayList<>();
        mapList.add(visitorResult);
        mapList.add(elementResult);
        mapList.add(concreteResult);
        mapList.add(concreteVisitor);
        mapList.add(objectStructureResult);


        return mapList;
    }

    public List<List<Matching.NodeMap>> doObjectAdapter(List<Matching.NodeMap> target, List<Matching.NodeMap> adapter, List<Matching.NodeMap> adaptee) throws Exception {
        List<Matching.NodeMap> targetResult = new ArrayList<>(), adapterResult = new ArrayList<>(), adapteeResult = new ArrayList<>();
        for (int i = 0; i < target.size(); i++) {
            Class targetClass = jcl.loadClass(packageName + target.get(i).v.className);
            if (!targetClass.isInterface())
                continue;
            for (int j = 0; j < adapter.size(); j++) {
                Class adapterClass = jcl.loadClass(packageName + adapter.get(j).v.className);
                if (adapterClass.isInterface()) {
                    continue;
                }
                for (int k = 0; k < adaptee.size(); k++) {
                    Class adapteeClass = jcl.loadClass(packageName + adaptee.get(k).v.className);
                    if (adapteeClass.isInterface())
                        continue;
                    boolean b = false;
                    if (target.get(i).v.className.equals(adapter.get(j).v.className) || target.get(i).v.className.equals(adaptee.get(k).v.className) || adapter.get(j).v.className.equals(adaptee.get(k).v.className)) {
                        continue;
                    }
                    boolean temp1 = false, temp2 = false;
                    for (int f = 0; f < adapter.get(j).v.getOutRelations().size(); f++) {
                        if (adapter.get(j).v.getOutRelations().get(f).getKey().className.equals(target.get(i).v.className) && adapter.get(j).v.getOutRelations().get(f).getValue() == Node.NodeType.inhert) {
                            temp1 = true;
                        }
                        if (adapter.get(j).v.getOutRelations().get(f).getKey().className.equals(adaptee.get(k).v.className) && (adapter.get(j).v.getOutRelations().get(f).getValue() == Node.NodeType.association)) {
                            temp2 = true;
                        }
                    }
                    if (!temp1 || !temp2) {
                        continue;
                    }
                    for (int l = 0; l < targetClass.getMethods().length && !b; l++) {
                        for (int h = 0; h < adapterClass.getMethods().length && !b; h++) {
                            if (targetClass.getMethods()[l].getName().equals(adapterClass.getMethods()[h].getName())) {
                                for (int d = 0; d < adapteeClass.getMethods().length && !b; d++) {
                                    for (int f = 0; f < adapterClass.getDeclaredFields().length; f++) {
                                        if (adapterClass.getDeclaredFields()[f].getType().getSimpleName().equals(adaptee.get(k).v.className)) {

                                            String fileText = getfileText(adapter.get(j).v.className + ".java");
                                            int index = 0;
                                            String sx = adapterClass.getDeclaredFields()[f].getName() + "." + adapteeClass.getMethods()[d].getName();
                                            while ((index = fileText.indexOf(sx, index + 1)) != -1) {
                                                int i1 = fileText.lastIndexOf("{", index);
                                                int i2 = fileText.lastIndexOf("\n", i1);
                                                int i3 = fileText.lastIndexOf("\n", i2 - 1);
                                                String me = fileText.substring(i3, i2);
                                                if (me.indexOf(targetClass.getMethods()[l].getName()) != -1) {
                                                    if (!targetResult.contains(target.get(i))) {
                                                        targetResult.add(target.get(i));
                                                    }
                                                    if (!adapteeResult.contains(adaptee.get(k))) {
                                                        adapteeResult.add(adaptee.get(k));
                                                    }
                                                    if (!adapterResult.contains(adapter.get(j))) {
                                                        adapterResult.add(adapter.get(j));
                                                    }
                                                    b = true;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (targetResult.size() == 0 || adapteeResult.size() == 0 || adapterResult.size() == 0) {
            return null;
        }

        List<List<Matching.NodeMap>> mapList = new ArrayList<>();
        mapList.add(adapterResult);
        mapList.add(adapteeResult);
        mapList.add(targetResult);

        return mapList;
    }

    public List<List<Matching.NodeMap>> doClassAdapter(List<Matching.NodeMap> target, List<Matching.NodeMap> adapter, List<Matching.NodeMap> adaptee) throws Exception {
        List<Matching.NodeMap> targetResult = new ArrayList<>(), adapterResult = new ArrayList<>(), adapteeResult = new ArrayList<>();
        for (int i = 0; i < target.size(); i++) {
            Class targetClass = jcl.loadClass(packageName + target.get(i).v.className);
            if (!targetClass.isInterface())
                continue;
            for (int j = 0; j < adapter.size(); j++) {
                Class adapterClass = jcl.loadClass(packageName + adapter.get(j).v.className);
                if (adapterClass.isInterface()) {
                    continue;
                }
                for (int k = 0; k < adaptee.size(); k++) {
                    Class adapteeClass = jcl.loadClass(packageName + adaptee.get(k).v.className);
                    if (adapteeClass.isInterface())
                        continue;
                    boolean b = false;
                    if (target.get(i).v.className.equals(adapter.get(j).v.className) || target.get(i).v.className.equals(adaptee.get(k).v.className) || adapter.get(j).v.className.equals(adaptee.get(k).v.className)) {
                        continue;
                    }
                    boolean temp1 = false, temp2 = false;
                    for (int f = 0; f < adapter.get(j).v.getOutRelations().size(); f++) {
                        if (adapter.get(j).v.getOutRelations().get(f).getKey().className.equals(target.get(i).v.className) && adapter.get(j).v.getOutRelations().get(f).getValue() == Node.NodeType.inhert) {
                            temp1 = true;
                        }
                        if (adapter.get(j).v.getOutRelations().get(f).getKey().className.equals(adaptee.get(k).v.className) && adapter.get(j).v.getOutRelations().get(f).getValue() == Node.NodeType.inhert) {
                            temp2 = true;
                        }
                    }
                    if (!temp1 || !temp2) {
                        continue;
                    }
                    for (int l = 0; l < targetClass.getMethods().length && !b; l++) {
                        for (int h = 0; h < adapterClass.getMethods().length && !b; h++) {
                            if (targetClass.getMethods()[l].getName().equals(adapterClass.getMethods()[h].getName())) {
                                for (int d = 0; d < adapteeClass.getMethods().length && !b; d++) {
                                    String fileText = getfileText(adapter.get(j).v.className + ".java");
                                    int index = 0;
                                    String sx = "this." + adapteeClass.getMethods()[d].getName();
                                    while ((index = fileText.indexOf(sx, index + 1)) != -1) {
                                        int i1 = fileText.lastIndexOf("{", index);
                                        int i2 = fileText.lastIndexOf("\n", i1);
                                        int i3 = fileText.lastIndexOf("\n", i2 - 1);
                                        String me = fileText.substring(i3, i2);
                                        if (me.indexOf(targetClass.getMethods()[l].getName()) != -1) {
                                            if (!targetResult.contains(target.get(i))) {
                                                targetResult.add(target.get(i));
                                            }
                                            if (!adapteeResult.contains(adaptee.get(k))) {
                                                adapteeResult.add(adaptee.get(k));
                                            }
                                            if (!adapterResult.contains(adapter.get(j))) {
                                                adapterResult.add(adapter.get(j));
                                            }
                                            b = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (targetResult.size() == 0 || adapteeResult.size() == 0 || adapterResult.size() == 0) {
            return null;
        }

        List<List<Matching.NodeMap>> mapList = new ArrayList<>();
        mapList.add(adapterResult);
        mapList.add(adapteeResult);
        mapList.add(targetResult);

        return mapList;
    }

    public List<List<Matching.NodeMap>> doSingleton(List<Matching.NodeMap> singleton) throws
            ClassNotFoundException {
        for (int i = 0; i < singleton.size(); i++) {
            Class single = jcl.loadClass(packageName + singleton.get(i).v.className);
            boolean b1 = true;
            for (int j = 0; j < single.getConstructors().length; j++) {
                if (!Modifier.isPrivate(single.getConstructors()[j].getModifiers())) {
                    b1 = false;
                    break;
                }
            }
            if (!b1) {
                singleton.remove(i);
                i--;
                continue;
            }
            boolean b2 = false;
            for (int j = 0; j < single.getMethods().length; j++) {
                if (Modifier.isStatic(single.getMethods()[j].getModifiers()) && Modifier.isPublic(single.getMethods()[j].getModifiers()) && single.getMethods()[j].getReturnType().equals(single.getClass())) {
                    b2 = true;
                }
            }
            if (!b2) {
                singleton.remove(i);
                i--;
                continue;
            }
        }

        if (singleton.size() == 0) {
            return null;
        }

        List<List<Matching.NodeMap>> mapList = new ArrayList<>();
        mapList.add(singleton);

        return mapList;
    }

    public List<List<Matching.NodeMap>> doFactoryMethod
            (List<Matching.NodeMap> creator, List<Matching.NodeMap> concreteProduct, List<Matching.NodeMap> concreteCreator) throws
            ClassNotFoundException, FileNotFoundException, NoSuchMethodException {
        List<Matching.NodeMap> creatorResult = new ArrayList<>();
        List<Matching.NodeMap> productResult = new ArrayList<>();
        List<Matching.NodeMap> concreteResult = new ArrayList<>();
        for (int i = 0; i < concreteCreator.size(); i++) {
            Class conC = jcl.loadClass(packageName + concreteCreator.get(i).v.className);
            for (int f = 0; f < concreteProduct.size(); f++) {
                for (int k = 0; k < creator.size(); k++) {

                    for (int j = 0; j < conC.getMethods().length; j++) {
                        String name = conC.getMethods()[j].getName();
                        String output = conC.getMethods()[j].getReturnType().getSimpleName();
                        Class crea = jcl.loadClass(packageName + creator.get(k).v.className);
                        try {
                            if (crea.getMethod(name) != null) {
                                if (concreteProduct.get(f).v.className.equals(output)) {
                                    if (!productResult.contains(concreteProduct.get(f)))
                                        productResult.add(concreteProduct.get(f));
                                    if (!creatorResult.contains(creator.get(k)))
                                        creatorResult.add(creator.get(k));
                                    if (!concreteResult.contains(concreteCreator.get(i)))
                                        concreteResult.add(concreteCreator.get(i));
                                    break;
                                }
                            }
                        } catch (Exception e) {

                        }
                    }
                }
            }
        }
        if (concreteResult.size() == 0 || creatorResult.size() == 0 || productResult.size() == 0) {
            return null;
        }

        List<List<Matching.NodeMap>> mapList = new ArrayList<>();
        mapList.add(creatorResult);
        mapList.add(concreteResult);
        mapList.add(productResult);


        return mapList;

    }


    public List<List<Matching.NodeMap>> doComposite
            (List<Matching.NodeMap> component, List<Matching.NodeMap> composite) throws ClassNotFoundException {
        List<Matching.NodeMap> resultComposite = new ArrayList<>();
        List<Matching.NodeMap> resultComponent = new ArrayList<>();
        for (int i = 0; i < composite.size(); i++) {
            Class comp = jcl.loadClass(packageName + composite.get(i).v.className);
            boolean b = false;
            for (int k = 0; k < comp.getDeclaredFields().length; k++) {
                if (comp.getDeclaredFields()[k].getType() == List.class || comp.getDeclaredFields()[k].getType() == ArrayList.class || comp.getDeclaredFields()[k].getType().isArray()) {
                    b = true;
                    break;
                }
            }
            boolean b2 = false;
            for (int j = 0; j < component.size(); j++) {
                Class compon = jcl.loadClass(packageName + component.get(j).v.className);
                for (int k = 0; k < compon.getMethods().length; k++) {
                    try {
                        if (comp.getMethod(compon.getMethods()[k].getName()) != null) {
                            b2 = true;
                            if (!resultComponent.contains(component.get(j))) {
                                resultComponent.add(component.get(j));
                            }
                            break;
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (b && b2) {
                resultComposite.add(composite.get(i));
            }
        }
        if (resultComposite.size() == 0 || resultComponent.size() == 0) {
            return null;
        }

        List<List<Matching.NodeMap>> mapList = new ArrayList<>();
        mapList.add(resultComposite);
        mapList.add(resultComponent);

        return mapList;
    }


    public List<List<Matching.NodeMap>> doDecorator
            (List<Matching.NodeMap> component, List<Matching.NodeMap> concreteComponent, List<Matching.NodeMap> decorator) {
        List<Matching.NodeMap> resultComponent = new ArrayList<>();

        for (int i = 0; i < decorator.size(); i++) {
            Class dec = null;
            try {
                dec = jcl.loadClass(packageName + decorator.get(i).v.className);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean b = false;
            for (int j = 0; j < dec.getDeclaredFields().length; j++) {
                for (int h = 0; h < component.size(); h++) {
                    if (dec.getDeclaredFields()[j].getType().getSimpleName().equals(component.get(h).v.className)) {
                        resultComponent.add(component.get(h));
                        b = true;
                    }
                }
                if (b)
                    break;
            }
            if (!b) {
                decorator.remove(i);
                i--;
            }
        }
        for (int i = 0; i < concreteComponent.size(); i++) {
            Class con = null;
            try {
                con = jcl.loadClass(packageName + concreteComponent.get(i).v.className);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean b2 = false;
            for (int k = 0; k < resultComponent.size(); k++) {
                Class comp = null;
                try {
                    comp = jcl.loadClass(packageName + resultComponent.get(k).v.className);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                boolean b = false;
                for (int j = 0; j < con.getMethods().length; j++) {
                    try {
                        if (comp.getMethod(con.getMethods()[j].getName()) != null) {
                            b = true;
                            b2 = true;
                            break;
                        }
                    } catch (NoSuchMethodException e) {
//                        e.printStackTrace();
                    }
                }
                if (!b) {
                    resultComponent.remove(k);
                    k--;
                }
                if (b2)
                    break;
            }
            if (!b2) {
                concreteComponent.remove(i);
                i--;
            }
        }
        if (decorator.size() == 0 || resultComponent.size() == 0) {
            return null;
        }
        List<List<Matching.NodeMap>> mapList = new ArrayList<>();
        mapList.add(decorator);
        mapList.add(resultComponent);
        mapList.add(concreteComponent);

        return mapList;
    }

    private List<List<Matching.NodeMap>> doAbstractFactory
            (List<Matching.NodeMap> abstractFactory, List<Matching.NodeMap> concreteFactory, List<Matching.NodeMap> product) {
        List<Matching.NodeMap> resultProduct = new ArrayList<>();
        for (int i = 0; i < abstractFactory.size(); i++) {
            Class abstr = null;
            try {
                abstr = jcl.loadClass(packageName + abstractFactory.get(i).v.className);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean b = false;
            for (int j = 0; j < abstr.getMethods().length; j++) {
                for (int h = 0; h < product.size(); h++) {
                    if (abstr.getMethods()[j].getReturnType().getSimpleName().equals(product.get(h).v.className)) {
                        resultProduct.add(product.get(h));
                        b = true;
                        break;
                    }
                }
                if (b) {
                    break;
                }
            }
            if (!b) {
                Matching.NodeMap n = abstractFactory.remove(i);
                i--;
            }
        }
        for (int i = 0; i < concreteFactory.size(); i++) {
            Class abstr = null;
            try {
                abstr = jcl.loadClass(packageName + concreteFactory.get(i).v.className);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (abstr == null) {
                continue;
            }
            boolean b = false;
            for (int j = 0; j < abstr.getMethods().length; j++) {
                for (int h = 0; h < product.size(); h++) {
                    if (abstr.getMethods()[j].getReturnType().getSimpleName().equals(product.get(h).v.className)) {
                        if (!resultProduct.contains(product.get(h)))
                            resultProduct.add(product.get(h));
                        b = true;
                        break;
                    }
                }
                if (b) {
                    break;
                }
            }
            if (!b) {
                Matching.NodeMap n = concreteFactory.remove(i);
                i--;
            }
        }

        if (abstractFactory.size() == 0 || concreteFactory.size() == 0 || resultProduct.size() == 0) {
            return null;
        }
        List<List<Matching.NodeMap>> mapList = new ArrayList<>();
        mapList.add(abstractFactory);
        mapList.add(concreteFactory);
        mapList.add(resultProduct);


        return mapList;
    }


    public Method findMethod(Class c, String name, Class... parameter) {
        try {
            return c.getMethod(name, parameter);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean isMatch() {


        return true;
    }


//    private boolean methodsIsSimilar(CdOperation opPattern, CdOperation opSys) {
//        if (!opPattern.returnType.typeName.equals(opSys.returnType.typeName)) {
//            CdClass out1 = findClass(patternDiagram, opPattern.returnType.getTypeName());
//            CdClass out2 = findClass(sysDiagram, opSys.returnType.getTypeName());
//            if (out1 == null) {
//                return true;
//            }
//            if (out2 != null) {
//                for (int i = 0; i < matching.gSystem.nodes.size(); i++) {
//                    if (matching.gSystem.nodes.get(i).className.equals(out2.name)) {
//                        return true;
//                    }
//                }
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private CdClass findClass(ClassDiagram diagram, String clsName) {
//        for (int i = 0; i < diagram.classes.size(); i++) {
//            if (diagram.classes.get(i).name.equals(clsName)) {
//                return diagram.classes.get(i);
//            }
//        }
//        return null;
//    }


    private static HashMap<String, String> filesText = new HashMap<>();

    public static String getfileText(String fileName) throws FileNotFoundException {
        String temp = "";
        if (filesText.containsKey(fileName)) {
            temp = filesText.get(fileName);
        } else {
            File f = new File(Program.sourceCodePath + fileName);
            Scanner scanner = new Scanner(f);
            String ss = "";
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                ss += str + "\n";
            }
            filesText.put(fileName, ss);
            temp = ss;
        }
        return temp;
    }
}
