package braincode.app.ui.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import braincode.app.R;
import braincode.app.ui.BaseActivity;
import butterknife.ButterKnife;

/**
 * Created by koszal on 18/03/16.
 */
public class RegisterActivity extends BaseActivity implements RegisterMvpView {

    @Inject
    RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        presenter.attachView(this);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

}
