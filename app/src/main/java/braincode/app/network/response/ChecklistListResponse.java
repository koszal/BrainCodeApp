package braincode.app.network.response;

import java.util.List;

import braincode.app.data.model.Checklist;

/**
 * Created by koszal on 18/03/16.
 */
public class ChecklistListResponse {

    List<Checklist> results;

    public List<Checklist> getItems() {
        return results;
    }
}
