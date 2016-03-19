package braincode.app.ui.checklist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import braincode.app.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by koszal on 19/03/16.
 */
public class CheckboxViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.checkBox)
    CheckBox checkBox;

    public CheckboxViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
