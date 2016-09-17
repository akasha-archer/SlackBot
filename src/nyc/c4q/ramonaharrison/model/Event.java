
package nyc.c4q.ramonaharrison.model;

import nyc.c4q.ramonaharrison.network.HTTP;
import org.json.simple.JSONObject;

/**
 * Created by Rafael on 9/14/16.
 */

public class Event {

    private String year;
    private String text;


    public Event(JSONObject json) {

        if (json.containsKey("year")) {
            this.year = (String) json.get("year");
        }
        if (json.containsKey("text")) {
            this.text = (String) json.get("text");
        }
    }

    public String getYear() {
        return year;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {

        AttachmentEdit attach = new AttachmentEdit();
        String year = getYear();
        String text = getText();
        String border1 = "  *   *   *   *   *   *   *   *   *   *   *   *   *  *   *   *   *   *  *   *   *   *   *  *   *   *   *   *  *   *   *   *   *";
        String complete = border1 + "\n" +"On this day in " + year + ": \n" + text + "\n" + HTTP.stringToURL(attach.getAttachment() + "\n"+ border1);

        return complete;
    }

}
