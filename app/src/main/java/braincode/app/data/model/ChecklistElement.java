package braincode.app.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by koszal on 18/03/16.
 */
public class ChecklistElement implements Parcelable {

    private String description;
    private String sort;

    public String getDescription() {
        return description;
    }

    public String getSort() {
        return sort;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.description);
        dest.writeString(this.sort);
    }

    public ChecklistElement() {
    }

    protected ChecklistElement(Parcel in) {
        this.description = in.readString();
        this.sort = in.readString();
    }

    public static final Parcelable.Creator<ChecklistElement> CREATOR = new Parcelable.Creator<ChecklistElement>() {
        public ChecklistElement createFromParcel(Parcel source) {
            return new ChecklistElement(source);
        }

        public ChecklistElement[] newArray(int size) {
            return new ChecklistElement[size];
        }
    };
}
