package uk.co.grandparade.androidtesting.injection.component;

import android.content.Context;

import javax.inject.Singleton;

import uk.co.grandparade.androidtesting.App;
import uk.co.grandparade.androidtesting.data.DataManager;
import uk.co.grandparade.androidtesting.injection.ApplicationContext;
import uk.co.grandparade.androidtesting.injection.module.ApplicationModule;
import uk.co.grandparade.androidtesting.network.ApiServcie;
import dagger.Component;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    App app();

    ApiServcie apiService();

    DataManager dataManager();

}
