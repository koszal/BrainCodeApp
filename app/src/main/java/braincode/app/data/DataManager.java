package braincode.app.data;

import javax.inject.Inject;

import braincode.app.data.local.PreferenceHelper;
import braincode.app.network.ApiServcie;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public class DataManager {

    private final ApiServcie apiServcie;
    private final PreferenceHelper prefsHelper;

    @Inject
    public DataManager(ApiServcie apiServcie, PreferenceHelper prefsHelper) {
        this.apiServcie = apiServcie;
        this.prefsHelper = prefsHelper;
    }


}
