package uk.co.grandparade.androidtesting.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import uk.co.grandparade.androidtesting.R;
import uk.co.grandparade.androidtesting.data.model.Profile;
import uk.co.grandparade.androidtesting.ui.BaseActivity;
import uk.co.grandparade.androidtesting.ui.views.LoadingView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject MainPresenter mainPresenter;

    @Bind(R.id.displayName)
    TextView displayName;
    @Bind(R.id.clanTag)
    TextView clanTag;
    @Bind(R.id.clanName)
    TextView clanName;
    @Bind(R.id.goToBnetButton)
    Button goToBnetButton;
    @Bind(R.id.primaryRace)
    TextView primaryRace;
    @Bind(R.id.careerTotalGames)
    TextView careerTotalGames;
    @Bind(R.id.loadingView)
    LoadingView loadingView;

    private View.OnClickListener retryListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mainPresenter.loadProfile();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter.attachView(this);
        mainPresenter.loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showProfile(final Profile profile) {
        displayName.setText(profile.getDisplayName());
        String clanTagText = profile.getClanTag();
        if (clanTagText != null) {
            clanTag.setText(profile.getClanTag());
            clanTag.setVisibility(View.VISIBLE);
        } else {
            clanTag.setVisibility(View.INVISIBLE);
        }
        clanName.setText(profile.getClanName());
        goToBnetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, profile.getProfileUrl("en"));
                startActivity(intent);
            }
        });
        primaryRace.setText(profile.getCareer().getPrimaryRace());
        careerTotalGames.setText(Integer.toString(profile.getCareer().getCareerTotalGames()));
        loadingView.hide();
    }

    @Override
    public void showError(Throwable e) {
        loadingView.show().withButton(e.getLocalizedMessage(), getString(R.string.view_loading_retry_label), retryListener);
    }

    @Override
    public void showLoading() {
        loadingView.show().withProgressBar();
    }

    public static Intent getStartIntent(Context targetContext, boolean b) {
        return new Intent(targetContext, MainActivity.class);
    }
}
