package uk.co.grandparade.androidtesting;


import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import rx.Observable;
import uk.co.grandparade.androidtesting.data.model.Career;
import uk.co.grandparade.androidtesting.data.model.Profile;
import uk.co.grandparade.androidtesting.ui.main.MainActivity;
import uk.co.grandparade.androidtesting.test.common.rules.TestComponentRule;

@RunWith(AndroidJUnit4.class)
public class Main {

    public final TestComponentRule component = new TestComponentRule(InstrumentationRegistry.getTargetContext());

    public final ActivityTestRule<MainActivity> main = new ActivityTestRule<MainActivity>(MainActivity.class, false, false) {
        @Override
        protected Intent getActivityIntent() {
            return MainActivity.getStartIntent(InstrumentationRegistry.getTargetContext(), false);
        }
    };

    @Rule
    public final TestRule chain = RuleChain.outerRule(component).around(main);

    @Test
    public void something() throws InterruptedException {
        Profile profile = new Profile();
        profile.setDisplayName("Zbigniew");
        profile.setClanName("Delfiny");
        Career career = new Career(1000, "ZERG");
        profile.setCareer(career);

        when(component.getMockDataManager().profile(anyLong(), anyInt(), anyString()))
                .thenReturn(Observable.just(profile));

        main.launchActivity(null);

        onView(withId(R.id.displayName)).check(matches(withText("Zbigniew")));
        onView(withId(R.id.clanTag)).check(matches(withText("")));

        Thread.sleep(2000);

        main.getActivity().finish();
    }

    @Test
    public void testLoadError() throws InterruptedException {
        when(component.getMockDataManager().profile(anyLong(), anyInt(), anyString()))
                .thenReturn(Observable.<Profile>error(new RuntimeException("Some example exception.")));

        main.launchActivity(null);

        onView(withText("Some example exception.")).check(matches(isDisplayed()));

        Thread.sleep(2000);

        main.getActivity().finish();
    }

}
