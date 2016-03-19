package braincode.app.ui.search;

import java.util.List;

import braincode.app.data.model.Checklist;
import braincode.app.ui.BaseMvpView;

/**
 * Created by koszal on 19/03/16.
 */
public interface SearchMvpView extends BaseMvpView {

    void showResults(List<Checklist> results);

    void showError(Throwable e);
}
