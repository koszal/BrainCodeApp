package braincode.app.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import braincode.app.injection.ApplicationContext;

/**
 * Created by koszal on 18/03/16.
 */
@Singleton
public class PreferenceHelper {

    private static final String PREF_NAMESPACE = "PREFS";

    private final SharedPreferences prefs;

    @Inject
    public PreferenceHelper(@ApplicationContext Context context) {
        prefs = context.getSharedPreferences(PREF_NAMESPACE, Context.MODE_PRIVATE);
    }
}
