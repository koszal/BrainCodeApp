package braincode.app.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by koszal on 18/03/16.
 */
public class ChecklistStats implements Parcelable {

    private int likes;
    private int views;

    public int getLikes() {
        return likes;
    }

    public int getViews() {
        return views;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.likes);
        dest.writeInt(this.views);
    }

    public ChecklistStats() {
    }

    protected ChecklistStats(Parcel in) {
        this.likes = in.readInt();
        this.views = in.readInt();
    }

    public static final Parcelable.Creator<ChecklistStats> CREATOR = new Parcelable.Creator<ChecklistStats>() {
        public ChecklistStats createFromParcel(Parcel source) {
            return new ChecklistStats(source);
        }

        public ChecklistStats[] newArray(int size) {
            return new ChecklistStats[size];
        }
    };
}
