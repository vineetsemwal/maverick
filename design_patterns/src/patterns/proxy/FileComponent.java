package patterns.proxy;

public class FileComponent implements IComponent {
    private String fileName;

    public FileComponent(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String load() {
        System.out.println("reading content from file="+fileName);
        return "content read from file="+fileName;
    }

    @Override
    public void display() {
        String content = load();
        System.out.println("dispalying laoded content" + content);
    }
}
