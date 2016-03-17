package uk.co.grandparade.androidtesting.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import uk.co.grandparade.androidtesting.App;
import uk.co.grandparade.androidtesting.injection.component.ActivityComponent;
import uk.co.grandparade.androidtesting.injection.component.DaggerActivityComponent;
import uk.co.grandparade.androidtesting.injection.module.ActivityModule;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(App.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

}
