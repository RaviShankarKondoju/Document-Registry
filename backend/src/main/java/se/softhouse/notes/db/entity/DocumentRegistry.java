package se.softhouse.notes.db.entity;

public class DocumentRegistry {
    private int id;

    private String title;

    private String text;

    public DocumentRegistry(){}

    public DocumentRegistry(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
