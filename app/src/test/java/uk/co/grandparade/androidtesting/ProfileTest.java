package androidtesting.grandparade.co.uk.androidtesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import uk.co.grandparade.androidtesting.data.model.Profile;

@RunWith(MockitoJUnitRunner.class)
public class ProfileTest {

    Profile profile;

    @Before
    public void setUp() {
        profile = new Profile();
        profile.setClanTag("CLAN");
        profile.setDisplayName("Koszal");
        profile.setClanName("Clan Name");
        profile.setId(1000);
        profile.setRealm(1);
    }

    @Test
    public void getClanTag_test() {
        assertThat(profile.getClanTag(), equalTo("[CLAN]"));
    }

    @After
    public void tearDown() {

    }

}
