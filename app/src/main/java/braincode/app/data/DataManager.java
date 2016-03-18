package braincode.app.data;

import javax.inject.Inject;

import braincode.app.App;
import braincode.app.data.model.Profile;
import braincode.app.network.ApiServcie;
import rx.Observable;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public class DataManager {

    private final ApiServcie apiServcie;

    @Inject
    public DataManager(ApiServcie apiServcie) {
        this.apiServcie = apiServcie;
    }

    public Observable<Profile> profile(long id, int realm, String name) {
        return apiServcie.profile(id, realm, name, "en_GB", App.BNET_API_KEY);
    }

}
