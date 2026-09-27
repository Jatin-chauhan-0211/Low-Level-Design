import java.util.*;

public class FileSystem {

    private enum NodeType {
        FILE,
        DIRECTORY
    }

    private final Node root;

    public FileSystem() {
        root = new Node("/", false);
    }

    public List<String> ls(String path) { 
        Node node=getNode(path);
        if (node.isFile) 
            return List.of(node.name);
    
        return new ArrayList<>(node.children.keySet());
    }
    public void mkdir(String path) { 
        getOrCreateNode(path,NodeType.DIRECTORY);
        
     }

    public void addContentToFile(String path, String content) { 
        Node node=getOrCreateNode(path,NodeType.FILE);
        node.content.append(content);

     }

    public String readContentFromFile(String path) {
        Node node=getNode(path);
        return node.content.toString();
      }

    private Node getNode(String path){
        Node curr=root;
        String allNodeName[]=path.split("/");
        int n=allNodeName.length;

        for(int i=1; i<n; ++i){
            String name=allNodeName[i];
            curr=curr.children.get(name);
        }
        return curr;

    }
    private Node getOrCreateNode(String path, NodeType type){
        Node curr=root;
        String allNodeName[]=path.split("/");
        int n=allNodeName.length;
        for(int i=1; i<n; ++i){
            String name=allNodeName[i];
            boolean filetype=(i==n-1 && type==NodeType.FILE);
            curr=curr.children.computeIfAbsent(name, k -> new Node(name, filetype));
            
        }
        return curr;
    }

}
 
