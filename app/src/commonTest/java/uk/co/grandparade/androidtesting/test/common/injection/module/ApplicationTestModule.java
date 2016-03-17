package uk.co.grandparade.androidtesting.test.common.injection.module;

/**
 * Created by pawel.ogorzalek on 17/03/16.
 */

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import uk.co.grandparade.androidtesting.App;
import uk.co.grandparade.androidtesting.data.DataManager;
import uk.co.grandparade.androidtesting.injection.ApplicationContext;
import uk.co.grandparade.androidtesting.network.ApiServcie;
import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

@Module
public class ApplicationTestModule {

    private final App mApplication;

    public ApplicationTestModule(App application) {
        mApplication = application;
    }

    @Provides
    App provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    /************* MOCKS *************/

    @Provides
    @Singleton
    DataManager provideDataManager() {
        return mock(DataManager.class);
    }

    @Provides
    @Singleton
    ApiServcie provideApiService() {
        return mock(ApiServcie.class);
    }

}