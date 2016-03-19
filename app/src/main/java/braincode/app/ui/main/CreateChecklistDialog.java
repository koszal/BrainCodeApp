package braincode.app.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import braincode.app.R;
import braincode.app.data.model.Checklist;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by koszal on 19/03/16.
 */
public class CreateChecklistDialog extends DialogFragment {

    @Bind(R.id.title)
    EditText title;
    @Bind(R.id.description)
    EditText description;
    @Bind(R.id.tags)
    EditText tags;

    OnChecklistCreatedInterface listener;

    public static CreateChecklistDialog newInstance() {
        return new CreateChecklistDialog();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (OnChecklistCreatedInterface) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_new_checklist, container);
        ButterKnife.bind(this, view);
        getDialog().setTitle("New Checklist");
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @OnClick(R.id.createButton)
    public void createButtonClicked() {
        Checklist checklist = new Checklist();
        checklist.setName(title.getText().toString());
        checklist.setDescription(description.getText().toString());
        String[] split = TextUtils.split(tags.getText().toString(), " ");
        checklist.setTags(split);
        if (listener != null) {
            listener.onChecklistCreated(checklist);
        }
        getDialog().dismiss();
    }

    public interface OnChecklistCreatedInterface {
        void onChecklistCreated(Checklist checklist);
    }

}
