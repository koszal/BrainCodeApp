package braincode.app.ui.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import braincode.app.R;
import braincode.app.ui.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by koszal on 18/03/16.
 */
public class RegisterActivity extends BaseActivity implements RegisterMvpView {

    @Bind(R.id.login)
    EditText username;
    @Bind(R.id.email)
    EditText email;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.retype)
    EditText retype;

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

    @OnClick(R.id.registerButton)
    public void onRegisterClicked() {
        String usernameText = username.getText().toString();
        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();
        String retypeText = retype.getText().toString();

        if (usernameText.length() == 0) {
            Toast.makeText(RegisterActivity.this, "Username must not be empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (emailText.length() == 0) {
            Toast.makeText(RegisterActivity.this, "Email must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (passwordText.length() == 0 || !passwordText.equals(retypeText)) {
            Toast.makeText(RegisterActivity.this, "Passwords must match and not be empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        presenter.register(emailText, usernameText, passwordText);
    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

    @Override
    public void onRegistered() {
        finish();
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(RegisterActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}
