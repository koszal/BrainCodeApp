package uk.co.grandparade.androidtesting.data.model;

/**
 * Created by pawel.ogorzalek on 08/03/16.
 */
public class SwarmLevels {

    private int level;
    private SwarmLevel terran;
    private SwarmLevel zerg;
    private SwarmLevel protoss;

    public int getLevel() {
        return level;
    }

    public SwarmLevel getTerran() {
        return terran;
    }

    public SwarmLevel getZerg() {
        return zerg;
    }

    public SwarmLevel getProtoss() {
        return protoss;
    }

}
