package braincode.app.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by koszal on 18/03/16.
 */
public class LoginResponse {

    @SerializedName("access_token")
    private String token;

    public String getToken() {
        return token;
    }
}
