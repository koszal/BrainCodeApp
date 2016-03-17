package uk.co.grandparade.androidtesting.data.model;

import android.net.Uri;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public class Profile {

    private long id;
    private int realm;
    private String displayName;
    private String clanName;
    private String clanTag;
    private String profilePath;
    private Portrait portrait;
    private Career career;
    private SwarmLevels swarmLevels;

    public long getId() {
        return id;
    }

    public int getRealm() {
        return realm;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getClanName() {
        return clanName;
    }

    public String getClanTag() {
        if (clanTag == null || clanTag.length() == 0) {
            return null;
        } else {
            return String.format("[%s]", clanTag);
        }
    }

    public String getProfilePath() {
        return profilePath;
    }

    public Portrait getPortrait() {
        return portrait;
    }

    public Career getCareer() {
        return career;
    }

    public SwarmLevels getSwarmLevels() {
        return swarmLevels;
    }

    public Uri getProfileUrl(String locale) {
        return Uri.parse(String.format("http://eu.battle.net/sc2/%s%s", locale, getProfilePath()));
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRealm(int realm) {
        this.realm = realm;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    public void setClanTag(String clanTag) {
        this.clanTag = clanTag;
    }

    public void setCareer(Career career) {
        this.career = career;
    }
}
