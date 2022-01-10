package sf.a1;

import java.util.ArrayList;
import java.util.List;

/**
 * ServiceNode : ServiceNode
 *
 * @author: Mohit Aggarwal (mohitw@cisco.com)
 * @version: 0.1 11/23/21
 * @since: 0.1 11/23/21
 */
public class ServiceNode {
    String name;
    boolean isInstalled;
    boolean isEXplicit;
    List<ServiceNode> neighbors = new ArrayList<>();
    int referenceCounter;

    ServiceNode(String name) {
        this.name = name;
    }
}
