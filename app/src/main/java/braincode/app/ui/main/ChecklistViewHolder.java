package braincode.app.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import braincode.app.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by koszal on 19/03/16.
 */
public class ChecklistViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.title)
    public TextView title;
    @Bind(R.id.description)
    public TextView description;
    @Bind(R.id.completion)
    public TextView completion;

    public ChecklistViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
