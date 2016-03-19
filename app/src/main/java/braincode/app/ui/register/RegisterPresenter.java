package braincode.app.ui.register;

import javax.inject.Inject;

import braincode.app.data.DataManager;
import braincode.app.network.request.RegisterRequest;
import braincode.app.network.response.RegisterResponse;
import braincode.app.ui.BasePresenter;
import retrofit2.Response;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
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
        Subscription s = dataManager.register(new RegisterRequest(username, password, email))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<RegisterResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().onError(e);
                    }

                    @Override
                    public void onNext(Response<RegisterResponse> registerResponse) {
                        getMvpView().onRegistered();
                    }
                });
        subscription.add(s);
    }

}
