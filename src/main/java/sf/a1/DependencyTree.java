package sf.a1;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DependencyTree {

    public static void main(String[] args) {
        DependencyTree dependencyTree = new DependencyTree();
        String path = args[0];
        List<String> input = dependencyTree.parseCommand(path);
        
        dependencyTree.executeCommands(input);
        
    }

    private void executeCommands(List<String> input) {
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
