package sf.a1;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

public class DependencyTree {

    private Set<ServiceNode> installedServiceList = new HashSet<>();
    private Map<String, ServiceNode> map = new HashMap<>();
    private List<ServiceNode> dependencyGraph = new ArrayList<>();

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
        ServiceNode parent = null;
        if (map.containsKey(services[1])) {
            parent = map.get(services[1]);
        } else {
            parent = new ServiceNode(services[1]);
            map.put(services[1], parent);
        }

        dependencyGraph.add(parent);

        for (int i = 2; i < services.length; i++) {
            ServiceNode neighbor = null;
            if (map.containsKey(services[i])) {
                neighbor = map.get(services[i]);
            } else {
                neighbor = new ServiceNode(services[i]);
            }
            map.put(services[i], neighbor);
            parent.addDependentService(neighbor);
        }

        List<ServiceNode> cyclicDependency = cycleFound(parent);
        if(!cyclicDependency.isEmpty()) {
            //revertToPrevState
            System.out.println("Cannot add to dependency tree " + cyclicDependency.get(0).name + " is already dependent on " + cyclicDependency.get(1).name);
            Iterator<ServiceNode> iter = parent.getDependentServices().iterator();
            while (iter.hasNext()) {
                ServiceNode serviceNode = iter.next();
                parent.removeDependentService(serviceNode);
            }
            dependencyGraph.remove(parent);
        }
    }


    /**
     * If cycle detected in the graph then delete the cyclic link and print error message.
     * @return
     */
    private List<ServiceNode> cycleFound(ServiceNode root) {
        Set<ServiceNode> visited = new HashSet<>();
        LinkedList<ServiceNode> queue = new LinkedList<>();
        List<ServiceNode> result = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            ServiceNode current = queue.poll();
            if (visited.add(current)) {
                for (ServiceNode child : current.getDependentServices()) {
                    queue.offer(child);
                }
            } else {
                // populate result
                for (ServiceNode neighbor : current.getDependentServices()) {
                    if(visited.contains(neighbor)) {
                        result.add(neighbor);
                        result.add(current);
                        return result;
                    }
                }
            }
        }

        return result;
    }

    void installService(String serviceName) {
        ServiceNode root = null;
        if (!map.containsKey(serviceName)) {
            root = new ServiceNode(serviceName);
            root.setExplicit(true);
            root.setInstalled(true);
            System.out.println("Installing " + root.name);
            installedServiceList.add(root);
        } else {
            root = map.get(serviceName);
            Stack<ServiceNode> stack = new Stack<>();
            stack.push(root);
            for(ServiceNode child : root.getDependentServices()) {
                stack.push(child);
            }

            while (!stack.isEmpty()) {
                ServiceNode serviceNode = stack.pop();
                if (!serviceNode.isInstalled()){
                    serviceNode.setInstalled(true);
                    System.out.println("Installing " + serviceNode.name);
                    installedServiceList.add(serviceNode);
                }
            }
        }

    }

    void printInstalledServices() {
        for (ServiceNode serviceNode : installedServiceList) {
            System.out.println(serviceNode.name);
        }
    }


    void removeService(String service) {
        ServiceNode serviceNode = map.get(service);
        serviceNode.uninstallService(map,installedServiceList);
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
