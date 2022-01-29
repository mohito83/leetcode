package sf.a1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
    boolean isExplicit;
    Set<ServiceNode> dependentServices;
    int referenceCounter;

    ServiceNode(String name) {
        this.name = name;
        this.dependentServices = new HashSet<>();
    }


    boolean addDependentService(ServiceNode serviceNode) {
        boolean result = dependentServices.add(serviceNode);
        if (result) {
            serviceNode.incrementReferenceCount();
        }
        return result;
    }

    private void incrementReferenceCount() {
        this.referenceCounter++;
    }

    void removeDependentService(ServiceNode serviceNode) {
        serviceNode.decrementReferenceCount();
        dependentServices.remove(serviceNode);
    }

    void uninstallService(Map<String, ServiceNode> map, Set<ServiceNode> installedServiceList) {
        if (this.getReferenceCounter() == 0) {
            System.out.println("Removing " + this.name);
            map.remove(this.name);
            installedServiceList.remove(this);
            Iterator<ServiceNode> iterator = this.getDependentServices().iterator();
            while (iterator.hasNext()) {
                ServiceNode child = iterator.next();
                child.decrementReferenceCount();
                child.uninstallService(map, installedServiceList);
            }
        } else {
            System.out.println("Cannot remove " + this.name + " because other services are dependent on it.");
        }
    }

    private void decrementReferenceCount() {
        if(this.referenceCounter>0) {
            this.referenceCounter--;
        } else {
            throw new IllegalStateException("Cannot decrement reference counter as it was already at zero!!");
        }
    }

    int getReferenceCounter(){
        return referenceCounter;
    }

    Set<ServiceNode> getDependentServices() {
        return dependentServices;
    }

    public boolean equals(ServiceNode o) {
        return this.name.equals(o.name);
    }

    void setInstalled(boolean installed) {
        this.isInstalled = installed;
    }

    boolean isInstalled() {
         return this.isInstalled;
    }

    boolean isExplicit() {
        return  this.isExplicit;
    }

    void setExplicit(boolean explicit) {
        this.isExplicit = explicit;
    }
}
