package sf.a1;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

public class DependencyTree {

    private List<String> installedServiceList = new ArrayList<>();
    private Map<String, ServiceNode> map = new HashMap<>();
    private Map<ServiceNode, LinkedList<ServiceNode>> installedServicesMap = new HashMap<>();

    public static void main(String[] args) {
        DependencyTree dependencyTree = new DependencyTree();
        String path = args[0];
        List<String> input = dependencyTree.parseCommand(path);
        
        dependencyTree.executeCommands(input);
        
    }

    private void executeCommands(List<String> input) {
        for (String str : input) {
            System.out.println(str);

            String[] tokens = str.split("\\s+");
            switch (tokens[0]) {
            case "DEPEND" : buildDependencyGraph(tokens);
            break;
            case "INSTALL" : installService(tokens[1]);
            break;
            case "LIST" : printInstalledServices();
            break;
            case "REMOVE" : removeService(tokens[1]);
            break;
            }
        }
    }

    void buildDependencyGraph(String[] services) {
        LinkedList<ServiceNode> list = new LinkedList<>();
        for (int i = 1; i < services.length; i++) {
            list.offer(new ServiceNode(services[i]));
        }
        ServiceNode key = new ServiceNode(services[0]);
        installedServicesMap.put(key, list);
        List<ServiceNode> cyclicDependency = cycleFound();
        if(!cyclicDependency.isEmpty()) {
            installedServicesMap.remove(key);
            System.out.println("Cannot add to dependency tree" + cyclicDependency.get(0) + " is already dependent on " + cyclicDependency.get(1));
        }
    }

    /**
     * If cycle detected in the grpah then delete the cyclic link and print error message.
     * @return
     */
    private List<ServiceNode> cycleFound() {
        Set<ServiceNode> dependencySet = new HashSet<>();
        for (Map.Entry<ServiceNode, LinkedList<ServiceNode>> entry: installedServicesMap.entrySet()) {
            //if (!dependencySet.add())
        }
        return new ArrayList<>(dependencySet);
    }

    void installService(String serviceName) {
        LinkedList<ServiceNode> stack = installedServicesMap.get(serviceName);
        boolean isExplicit = stack.size() == 1;
        while (!stack.isEmpty()) {
            ServiceNode service = stack.pop();
            if (!service.isEXplicit) {
                service.isEXplicit = isExplicit;
            }

            if (!service.isInstalled) {
                service.isInstalled = true;
                installedServiceList.add(service.name);
                System.out.println("Installing "+service.name);
            }

            service.referenceCounter++;
        }
    }

    void printInstalledServices() {
        for (String str : installedServiceList) {
            System.out.println(str);
        }
    }

    void removeService(String service) {

    }

    List<String> parseCommand(String path) {
        List<String> inputCommandList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(getClass().getClassLoader().getResource(path).toURI())))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inputCommandList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return inputCommandList;
    }
}
