package uk.co.grandparade.androidtesting.injection.component;

import uk.co.grandparade.androidtesting.ui.main.MainActivity;
import uk.co.grandparade.androidtesting.injection.PerActivity;
import uk.co.grandparade.androidtesting.injection.module.ActivityModule;
import dagger.Component;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

     void inject(MainActivity mainActivity);

}
