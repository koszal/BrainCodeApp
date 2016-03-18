package braincode.app.ui.checklist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import braincode.app.R;
import braincode.app.data.model.Checklist;
import braincode.app.ui.BaseActivity;

/**
 * Created by koszal on 18/03/16.
 */
public class ChecklistActivity extends BaseActivity implements ChecklistMvpView {

    @Inject
    ChecklistPresenter presenter;

    private Checklist checklist;

    private static final String EXTRA_CHECKLIST = "CHECKLIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_checklist);
        presenter.attachView(this);

        if (getIntent().hasExtra(EXTRA_CHECKLIST)) {
            this.checklist = getIntent().getParcelableExtra(EXTRA_CHECKLIST);
        } else {
            finish();
            return;
        }

        showChecklist();

    }

    private void showChecklist() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    public static Intent getStartIntent(Context context, Checklist checklist) {
        Intent intent = new Intent(context, ChecklistActivity.class);
        intent.putExtra(EXTRA_CHECKLIST, checklist);
        return intent;
    }

}
