import java.util.*;

public class DirectoryNode implements Node {

    private final String name;
    private final Map<String, Node> children;

    public DirectoryNode(String name) {
        this.name = name;
        this.children = new TreeMap<>();
    }

    @Override
    public String getName() {
        return name;
    }
//implement
    public List<Node> getChildren() {
        return new ArrayList<>(this.children.values());
    }
    public Node getChild(String name) {
        return children.get(name);
    }
    public void addChild(Node child) {
        children.put(child.getName(), child);
    }




    
}

