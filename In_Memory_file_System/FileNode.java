
public class FileNode implements Node {
    private final String name;
    private StringBuilder content;

    public FileNode(String name) {
        this.name = name;
        this.content = new StringBuilder();
    }

    @Override
    public String getName() {
        return name;
    }
    public String readContent() {
        return content.toString();
    }
    public void appendContent(String newContent) {
        content.append(newContent);
    }
}