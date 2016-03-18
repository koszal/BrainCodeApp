package braincode.app.ui.login;

import javax.inject.Inject;

import braincode.app.data.DataManager;
import braincode.app.ui.BasePresenter;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by koszal on 18/03/16.
 */
public class LoginPresenter extends BasePresenter<LoginMvpView> {

    private DataManager dataManager;

    private CompositeSubscription subscription;

    @Inject
    public LoginPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void attachView(LoginMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void login(String username, String password) {

    }

}
