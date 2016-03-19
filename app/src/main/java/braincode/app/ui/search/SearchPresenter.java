package braincode.app.ui.search;

import javax.inject.Inject;

import braincode.app.data.DataManager;
import braincode.app.network.response.ChecklistListResponse;
import braincode.app.ui.BasePresenter;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by koszal on 19/03/16.
 */
public class SearchPresenter extends BasePresenter<SearchMvpView> {

    private DataManager dataManager;

    private CompositeSubscription subscription;

    @Inject
    public SearchPresenter(DataManager dataManager) {
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

    public void query(String query) {
        Subscription s = dataManager.query(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ChecklistListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(e);
                    }

                    @Override
                    public void onNext(ChecklistListResponse checklistListResponse) {
                        getMvpView().showResults(checklistListResponse.getItems());
                    }
                });
    }

}
