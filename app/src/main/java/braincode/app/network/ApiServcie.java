package braincode.app.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import braincode.app.data.model.Checklist;
import braincode.app.network.request.LoginRequest;
import braincode.app.network.request.RegisterRequest;
import braincode.app.network.response.ChecklistListResponse;
import braincode.app.network.response.LoginResponse;
import braincode.app.network.response.RegisterResponse;
import braincode.app.network.response.UserResponse;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public interface ApiServcie {

    String ENDPOINT = "http://54.93.79.160/socheck/";

    @POST("api/auth/")
    Observable<LoginResponse> login(@Body LoginRequest body);

    @POST("api/user/")
    Observable<Response<RegisterResponse>> register(@Body RegisterRequest body);

    @GET("api/user/{name}")
    Observable<UserResponse> user(@Path("name") String username, @Header("AccessToken") String accessToken);

    @GET("search/")
    Observable<ChecklistListResponse> query(@Header("token") String token, @Query("query") String query);

    @POST("put/")
    Observable<Response<JSONObject>> put(@Header("token") String token, @Body Checklist checklist);

    class Creator {
        public static ApiServcie newApiService() {
            Gson gson = new GsonBuilder().create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(ApiServcie.class);
        }
    }

}
