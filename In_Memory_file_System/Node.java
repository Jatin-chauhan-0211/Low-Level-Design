import java.util.*;

public class Node {
    final String name;
    StringBuilder content;
    Map<String,Node> children;
    final boolean isFile;

    public Node(String name, boolean isFile) {
        this.name = name;
        this.isFile = isFile;

        if (isFile) {
            content = new StringBuilder();
        } else {
            children = new TreeMap<>();
        }
    }
}
