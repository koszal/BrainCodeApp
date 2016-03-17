package uk.co.grandparade.androidtesting;

import android.app.Application;
import android.content.Context;

import uk.co.grandparade.androidtesting.injection.component.ApplicationComponent;
import uk.co.grandparade.androidtesting.injection.component.DaggerApplicationComponent;
import uk.co.grandparade.androidtesting.injection.module.ApplicationModule;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public class App extends Application {

    ApplicationComponent applicationComponent;

    public static final String BNET_API_KEY = "586d7ac6m8992buzyyjxggk6b3fud33m";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return applicationComponent;
    }

    public void setComponent(ApplicationComponent component) {
        this.applicationComponent = component;
    }

}
