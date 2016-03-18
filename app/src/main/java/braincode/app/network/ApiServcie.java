package braincode.app.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public interface ApiServcie {

    String ENDPOINT = "https://eu.api.battle.net/sc2/";

//    @GET("profile/{id}/{realm}/{name}/")
//    Observable<Profile> profile(
//            @Path("id") long id,
//            @Path("realm") int realm,
//            @Path("name") String name,
//            @Query("locale") String locale,
//            @Query("apikey") String apiKey
//    );

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
