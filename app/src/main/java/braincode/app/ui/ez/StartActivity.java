package braincode.app.ui.ez;

import android.os.Bundle;

import javax.inject.Inject;

import braincode.app.data.DataManager;
import braincode.app.ui.BaseActivity;
import braincode.app.ui.login.LoginActivity;
import braincode.app.ui.main.MainActivity;

/**
 * Created by koszal on 18/03/16.
 */
public class StartActivity extends BaseActivity {

    @Inject
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);

        if (dataManager.hasToken()) {
            startActivity(MainActivity.getStartIntent(this));
        } else {
            startActivity(LoginActivity.getStartIntent(this));
        }

        finish();
    }

}
