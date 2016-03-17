package uk.co.grandparade.androidtesting.test.common.rules;

import android.content.Context;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import uk.co.grandparade.androidtesting.App;
import uk.co.grandparade.androidtesting.data.DataManager;
import uk.co.grandparade.androidtesting.test.common.injection.component.TestComponent;
import uk.co.grandparade.androidtesting.test.common.injection.component.DaggerTestComponent;
import uk.co.grandparade.androidtesting.test.common.injection.module.ApplicationTestModule;


/**
 * Created by pawel.ogorzalek on 17/03/16.
 */
public class TestComponentRule implements TestRule {

    private final TestComponent mTestComponent;
    private final Context mContext;

    public TestComponentRule(Context context) {
        mContext = context;
        App application = App.get(context);
        mTestComponent = DaggerTestComponent.builder()
                .applicationTestModule(new ApplicationTestModule(application))
                .build();
    }

    public Context getContext() {
        return mContext;
    }

    public DataManager getMockDataManager() {
        return mTestComponent.dataManager();
    }

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                App application = App.get(mContext);
                application.setComponent(mTestComponent);
                base.evaluate();
                application.setComponent(null);
            }
        };
    }

}
