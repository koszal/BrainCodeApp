package braincode.app.data.model;

import java.util.List;

/**
 * Created by koszal on 18/03/16.
 */
public class Checklist {

    private String name;
    private String description;
    private String author;
    private String tags;
    private List<ChecklistElement> elements;
    private ChecklistStats stats;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getTags() {
        return tags;
    }

    public List<ChecklistElement> getElements() {
        return elements;
    }

    public ChecklistStats getStats() {
        return stats;
    }

}
