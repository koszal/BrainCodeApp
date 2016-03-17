package uk.co.grandparade.androidtesting.ui.main;

import uk.co.grandparade.androidtesting.data.model.Profile;
import uk.co.grandparade.androidtesting.ui.BaseMvpView;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public interface MainMvpView extends BaseMvpView {

    void showProfile(Profile profile);

    void showError(Throwable e);

    void showLoading();

}
