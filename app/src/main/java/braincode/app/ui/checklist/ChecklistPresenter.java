package braincode.app.ui.checklist;

import javax.inject.Inject;

import braincode.app.data.DataManager;
import braincode.app.ui.BasePresenter;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by koszal on 18/03/16.
 */
public class ChecklistPresenter extends BasePresenter<ChecklistMvpView> {

    private DataManager dataManager;

    private CompositeSubscription subscription;

    @Inject
    public ChecklistPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }


}
