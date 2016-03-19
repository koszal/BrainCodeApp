package braincode.app.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import braincode.app.R;
import braincode.app.data.model.Checklist;
import braincode.app.ui.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Bind(R.id.addChecklistButton)
    Button addChecklistButton;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private ChecklistsAdapter checklistsAdapter;

    @Inject MainPresenter mainPresenter;

    private View.OnClickListener retryListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mainPresenter.loadProfile();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        checklistsAdapter = new ChecklistsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(checklistsAdapter);

        mainPresenter.attachView(this);
        mainPresenter.loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showError(Throwable e) {
    }

    @Override
    public void showLoading() {
    }

    public static Intent getStartIntent(Context targetContext) {
        return new Intent(targetContext, MainActivity.class);
    }

    class ChecklistsAdapter extends RecyclerView.Adapter<ChecklistViewHolder> {

        private List<Checklist> items = new ArrayList<>();

        public void setChecklists(List<Checklist> checklists) {
            items.clear();
            items.addAll(checklists);
            notifyDataSetChanged();
        }

        @Override
        public ChecklistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.view_checklist_list_item, parent, false);
            return new ChecklistViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ChecklistViewHolder holder, int position) {
            Checklist checklist = items.get(position);
            holder.title.setText(checklist.getName());
            holder.description.setText(checklist.getDescription());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

}
