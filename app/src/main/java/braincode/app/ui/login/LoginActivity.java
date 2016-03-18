package braincode.app.ui.login;

import android.os.Bundle;
import android.widget.EditText;

import javax.inject.Inject;

import braincode.app.R;
import braincode.app.ui.BaseActivity;
import braincode.app.ui.register.RegisterActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by koszal on 18/03/16.
 */
public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Bind(R.id.username)
    EditText username;
    @Bind(R.id.password)
    EditText password;

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @OnClick(R.id.loginButton)
    public void onLoginClicked() {
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();
        presenter.login(usernameText, passwordText);
    }

    @OnClick(R.id.registerButton)
    public void onRegisterClicked() {
        startActivity(RegisterActivity.getStartIntent(this));
    }

}
