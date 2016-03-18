package braincode.app.ui.register;

import javax.inject.Inject;

import braincode.app.data.DataManager;
import braincode.app.ui.BasePresenter;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by koszal on 18/03/16.
 */
public class RegisterPresenter extends BasePresenter<RegisterMvpView> {

    private DataManager dataManager;

    private CompositeSubscription subscription;

    @Inject
    public RegisterPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void attachView(RegisterMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void register(String email, String username, String password) {

    }

}
