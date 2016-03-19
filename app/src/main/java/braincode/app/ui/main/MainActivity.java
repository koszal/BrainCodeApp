package braincode.app.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import braincode.app.R;
import braincode.app.data.model.Checklist;
import braincode.app.ui.BaseActivity;
import braincode.app.ui.checklist.ChecklistActivity;
import braincode.app.ui.search.SearchActivity;
import braincode.app.ui.views.LoadingView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView, CreateChecklistDialog.OnChecklistCreatedInterface {

    @Bind(R.id.addChecklistButton)
    Button addChecklistButton;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.loadingView)
    LoadingView loadingView;

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.loadChecklists();
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

    @Override
    public void showChecklists(List<Checklist> checklists) {
        checklistsAdapter.setChecklists(checklists);
        if (checklists == null || checklists.size() == 0) {
            loadingView.show().withMessage("No checklists yet!");
        } else {
            loadingView.hide();
        }
    }

    @Override
    public void openChecklist(Checklist checklist) {
        startActivity(ChecklistActivity.getStartIntent(this, checklist));
    }

    public static Intent getStartIntent(Context targetContext) {
        return new Intent(targetContext, MainActivity.class);
    }

    @Override
    public void onChecklistCreated(Checklist checklist) {
        mainPresenter.createChecklist(checklist);
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
            holder.completion.setText(checklist.getSize() + " ");
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    @OnClick(R.id.addChecklistButton)
    public void onAddChecklistClicked() {
        CreateChecklistDialog dialog = CreateChecklistDialog.newInstance();
        FragmentManager fm = getSupportFragmentManager();
        dialog.show(fm, "create");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_search) {
            startActivity(SearchActivity.getStartIntent(this));
        }

        return true;
    }
}
