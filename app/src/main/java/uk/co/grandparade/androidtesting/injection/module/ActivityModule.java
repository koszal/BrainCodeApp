package uk.co.grandparade.androidtesting.injection.module;

import android.app.Activity;
import android.content.Context;

import uk.co.grandparade.androidtesting.injection.ActivityContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity proviceActivity() {
        return activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

}
