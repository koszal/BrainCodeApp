package braincode.app.injection.component;

import android.content.Context;

import javax.inject.Singleton;

import braincode.app.App;
import braincode.app.data.DataManager;
import braincode.app.injection.ApplicationContext;
import braincode.app.injection.module.ApplicationModule;
import braincode.app.network.ApiServcie;
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
