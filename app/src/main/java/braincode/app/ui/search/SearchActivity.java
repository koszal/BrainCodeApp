package braincode.app.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import braincode.app.R;
import braincode.app.data.model.Checklist;
import braincode.app.ui.BaseActivity;
import braincode.app.ui.main.ChecklistViewHolder;
import braincode.app.ui.views.LoadingView;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by koszal on 19/03/16.
 */
public class SearchActivity extends BaseActivity implements SearchMvpView, TextWatcher {

    @Bind(R.id.searchEditText)
    EditText search;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.loadingView)
    LoadingView loadingView;

    @Inject
    SearchPresenter presenter;

    private SearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        presenter.attachView(this);

        adapter = new SearchAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        search.addTextChangedListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SearchActivity.class);
    }

    @Override
    public void showResults(List<Checklist> results) {
        adapter.setChecklists(results);
        loadingView.hide();
    }

    @Override
    public void showError(Throwable e) {
        loadingView.show().withMessage(e.getLocalizedMessage());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        presenter.query(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    class SearchAdapter extends RecyclerView.Adapter<ChecklistViewHolder> {

        List<Checklist> items = new ArrayList<>();

        public void setChecklists(List<Checklist> checklists) {
            items.clear();
            items.addAll(checklists);
            notifyDataSetChanged();
        }

        @Override
        public ChecklistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(SearchActivity.this, R.layout.view_checklist_list_item, parent);
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

}
