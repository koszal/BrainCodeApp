package uk.co.grandparade.androidtesting.injection.module;

import android.content.Context;

import javax.inject.Singleton;

import uk.co.grandparade.androidtesting.App;
import uk.co.grandparade.androidtesting.injection.ApplicationContext;
import uk.co.grandparade.androidtesting.network.ApiServcie;
import dagger.Module;
import dagger.Provides;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
@Module
public class ApplicationModule {

    protected final App app;

    public ApplicationModule(App app) {
        this.app = app;
    }

    @Provides
    App provideApp() {
        return app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return app;
    }

    @Provides
    @Singleton
    ApiServcie provideApiService() {
        return ApiServcie.Creator.newApiService();
    }

}
