package uk.co.grandparade.androidtesting.test.common.injection.component;

import javax.inject.Singleton;

import uk.co.grandparade.androidtesting.injection.component.ApplicationComponent;
import dagger.Component;
import uk.co.grandparade.androidtesting.test.common.injection.module.ApplicationTestModule;

/**
 * Created by pawel.ogorzalek on 17/03/16.
 */
@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {
}
