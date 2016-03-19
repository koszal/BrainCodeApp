package braincode.app.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import braincode.app.data.model.Checklist;
import braincode.app.injection.ApplicationContext;

/**
 * Created by koszal on 18/03/16.
 */
@Singleton
public class PreferenceHelper {

    private static final String PREF_NAMESPACE = "PREFS";
    private static final String PREF_CHECKLIST_STORE = "CHECKLISTS";

    private static final String PREF_TOKEN = "TOKEN";

    private final SharedPreferences prefs;
    private final SharedPreferences store;

    private Gson gson = new Gson();

    @Inject
    public PreferenceHelper(@ApplicationContext Context context) {
        prefs = context.getSharedPreferences(PREF_NAMESPACE, Context.MODE_PRIVATE);
        store = context.getSharedPreferences(PREF_CHECKLIST_STORE, Context.MODE_PRIVATE);
    }

    public void saveToken(String token) {
        prefs.edit().putString(PREF_TOKEN, token).apply();
    }

    public void removeToken() {
        prefs.edit().remove(PREF_TOKEN).apply();
    }

    public boolean hasToken() {
        return prefs.contains(PREF_TOKEN);
    }

    public String getToken() {
        return prefs.getString(PREF_TOKEN, null);
    }

    public List<Checklist> getAllChecklists() {
        List<Checklist> list = new ArrayList<>();
        for (String s : store.getAll().keySet()) {
            list.add(gson.fromJson(store.getString(s, null), Checklist.class));
        }
        return list;
    }

    public void addChecklist(Checklist checklist) {
        String id = UUID.randomUUID().toString();
        checklist.setId(id);
        String s = gson.toJson(checklist);
        store.edit().putString(id, s).apply();
    }

}
