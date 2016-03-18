package braincode.app.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by koszal on 18/03/16.
 */
public class Checklist implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.author);
        dest.writeString(this.tags);
        dest.writeTypedList(elements);
        dest.writeParcelable(this.stats, 0);
    }

    public Checklist() {
    }

    protected Checklist(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.author = in.readString();
        this.tags = in.readString();
        this.elements = in.createTypedArrayList(ChecklistElement.CREATOR);
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
}
