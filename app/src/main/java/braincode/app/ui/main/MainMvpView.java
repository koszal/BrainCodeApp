package braincode.app.ui.main;

import braincode.app.ui.BaseMvpView;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public interface MainMvpView extends BaseMvpView {

//    void showProfile(Profile profile);

    void showError(Throwable e);

    void showLoading();

}
