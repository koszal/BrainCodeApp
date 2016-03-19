package braincode.app.ui.login;

import javax.inject.Inject;

import braincode.app.data.DataManager;
import braincode.app.network.request.LoginRequest;
import braincode.app.network.response.LoginResponse;
import braincode.app.ui.BasePresenter;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
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
        if (username == null || username.length() == 0) {
            getMvpView().onError(new RuntimeException("Too shord username!"));
        } else {
            Subscription s = dataManager.login(new LoginRequest(username, password))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<LoginResponse>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            getMvpView().onError(e);
                        }

                        @Override
                        public void onNext(LoginResponse loginResponse) {
                            dataManager.saveToken(loginResponse.getToken());
                            getMvpView().onLoggedIn();
                        }
                    });
            subscription.add(s);
        }
    }

}
