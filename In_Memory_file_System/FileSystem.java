import java.util.*;

public class FileSystem {

    private final DirectoryNode root;

    public FileSystem() {
        root = new DirectoryNode("/");
    }

    public List<String> ls(String path) {

        Node node = getNode(path);

        if (node instanceof FileNode) {
            return List.of("");
        }

        DirectoryNode directory = (DirectoryNode) node;

        return directory.getChildren().stream().map(Node::getName).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public void mkdir(String path) {
        getOrCreateDirectory(path);
    }

    public void addContentToFile(String path, String content) {

        FileNode file = getOrCreateFile(path);

        file.appendContent(content);
    }

    public String readContentFromFile(String path) {

        Node node = getNode(path);

        if (!(node instanceof FileNode file)) {
            throw new IllegalArgumentException("Not a file");
        }

        return file.readContent();
    }

//check these functions

    private Node getNode(String path) {
        String[] parts = path.split("/");

        Node current = root;

        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }

            if (!(current instanceof DirectoryNode directory)) {
                throw new IllegalArgumentException("Invalid path");
            }

            current = directory.getChild(part);

            if (current == null) {
                throw new IllegalArgumentException("Path does not exist");
            }
        }

        return current;
    }  
    
    private DirectoryNode getOrCreateDirectory(String path) {
        String[] parts = path.split("/");

        DirectoryNode current = root;

        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }

            Node next = current.getChild(part);

            if (next == null) {
                DirectoryNode newDir = new DirectoryNode(part);
                current.addChild(newDir);
                current = newDir;
            } else if (next instanceof DirectoryNode directory) {
                current = directory;
            } else {
                throw new IllegalArgumentException("Path conflicts with a file");
            }
        }

        return current;
    }   

    public FileNode getOrCreateFile(String path) {
        String[] parts = path.split("/");

        DirectoryNode current = root;

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];

            if (part.isEmpty()) {
                continue;
            }

            Node next = current.getChild(part);

            if (i == parts.length - 1) { // Last part, should be a file
                if (next == null) {
                    FileNode newFile = new FileNode(part);
                    current.addChild(newFile);
                    return newFile;
                } else if (next instanceof FileNode file) {
                    return file;
                } else {
                    throw new IllegalArgumentException("Path conflicts with a directory");
                }
            } else { // Intermediate part, should be a directory
                if (next == null) {
                    DirectoryNode newDir = new DirectoryNode(part);
                    current.addChild(newDir);
                    current = newDir;
                } else if (next instanceof DirectoryNode directory) {
                    current = directory;
                } else {
                    throw new IllegalArgumentException("Path conflicts with a file");
                }
            }
        }

        throw new IllegalArgumentException("Invalid path");
    }
}