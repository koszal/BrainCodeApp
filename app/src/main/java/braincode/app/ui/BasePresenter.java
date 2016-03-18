package braincode.app.ui;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public class BasePresenter<T extends BaseMvpView> {

    private T mvpView;

    public void attachView(T mvpView) {
        this.mvpView = mvpView;
    }

    public void detachView() {
        this.mvpView = null;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }

    public T getMvpView() {
        return mvpView;
    }

}
