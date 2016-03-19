package braincode.app.data;

import java.util.List;

import javax.inject.Inject;

import braincode.app.data.local.PreferenceHelper;
import braincode.app.data.model.Checklist;
import braincode.app.network.ApiServcie;
import braincode.app.network.request.LoginRequest;
import braincode.app.network.request.RegisterRequest;
import braincode.app.network.response.ChecklistListResponse;
import braincode.app.network.response.LoginResponse;
import braincode.app.network.response.RegisterResponse;
import braincode.app.network.response.UserResponse;
import retrofit2.Response;
import rx.Observable;

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

    public void saveToken(String token) {
        prefsHelper.saveToken(token);
    }


    public boolean hasToken() {
        return prefsHelper.hasToken();
    }

    public Observable<LoginResponse> login(LoginRequest loginRequest) {
        return apiServcie.login(loginRequest);
    }

    public Observable<Response<RegisterResponse>> register(RegisterRequest registerRequest) {
        return apiServcie.register(registerRequest);
    }

    public Observable<UserResponse> user(String username) {
        return apiServcie.user(username, prefsHelper.getToken());
    }


    public List<Checklist> getChecklists() {
        return prefsHelper.getAllChecklists();
    }

    public void addChecklist(Checklist checklist) {
        prefsHelper.addChecklist(checklist);
    }

    public Observable<ChecklistListResponse> query(String query) {
        return apiServcie.query(prefsHelper.getToken(), query);
    }
}
