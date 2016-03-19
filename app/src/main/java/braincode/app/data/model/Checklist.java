package braincode.app.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by koszal on 18/03/16.
 */
public class Checklist implements Parcelable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String title;
    private String description;
    private String author;
    private String[] tags;
    private String[] items;
    private ChecklistStats stats;

    public String getName() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String[] getTags() {
        return tags;
    }

    public String[] getItems() {
        return items;
    }

    public ChecklistStats getStats() {
        return stats;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.author);
        dest.writeStringArray(this.tags);
        dest.writeStringArray(this.items);
        dest.writeParcelable(this.stats, 0);
    }

    public Checklist() {
    }

    protected Checklist(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.author = in.readString();
        this.tags = in.createStringArray();
        this.items = in.createStringArray();
        this.stats = in.readParcelable(ChecklistStats.class.getClassLoader());
    }

    public static final Parcelable.Creator<Checklist> CREATOR = new Parcelable.Creator<Checklist>() {
        public Checklist createFromParcel(Parcel source) {
            return new Checklist(source);
        }

        public Checklist[] newArray(int size) {
            return new Checklist[size];
        }
    };

    public void setName(String name) {
        this.title = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public int getSize() {
        if (items == null) return 0;
        return items.length;
    }
}
