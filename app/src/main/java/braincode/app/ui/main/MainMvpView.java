package braincode.app.ui.main;

import java.util.List;

import braincode.app.data.model.Checklist;
import braincode.app.ui.BaseMvpView;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public interface MainMvpView extends BaseMvpView {

//    void showProfile(Profile profile);

    void showError(Throwable e);

    void showLoading();

    void showChecklists(List<Checklist> checklists);

    void openChecklist(Checklist checklist);
}
