package braincode.app.ui.login;

import braincode.app.ui.BaseMvpView;

/**
 * Created by koszal on 18/03/16.
 */
public interface LoginMvpView extends BaseMvpView {

    void onLoggedIn();

    void onError(Throwable e);

}
