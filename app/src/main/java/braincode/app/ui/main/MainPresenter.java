package braincode.app.ui.main;

import javax.inject.Inject;

import braincode.app.data.DataManager;
import braincode.app.ui.BasePresenter;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public class MainPresenter extends BasePresenter<MainMvpView> {

    private final DataManager dataManager;

    CompositeSubscription compositeSubscription;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
        this.compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
        }
    }

    public void loadProfile() {
//        getMvpView().showLoading();
//        Subscription s = dataManager.profile(1934500, 1, "Koszal")
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Profile>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        getMvpView().showError(e);
//                    }
//
//                    @Override
//                    public void onNext(Profile profile) {
//                        getMvpView().showProfile(profile);
//                    }
//                });
//        compositeSubscription.add(s);
    }


}
