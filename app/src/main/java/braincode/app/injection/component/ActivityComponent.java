package braincode.app.injection.component;

import braincode.app.injection.PerActivity;
import braincode.app.injection.module.ActivityModule;
import braincode.app.ui.checklist.ChecklistActivity;
import braincode.app.ui.login.LoginActivity;
import braincode.app.ui.main.MainActivity;
import braincode.app.ui.register.RegisterActivity;
import dagger.Component;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

     void inject(MainActivity mainActivity);

     void inject(LoginActivity loginActivity);

     void inject(RegisterActivity registerActivity);

     void inject(ChecklistActivity checklistActivity);

}
