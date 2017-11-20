package com.anorris.android.wholesome;

import java.util.UUID;

/**
 * Created by anorris on 2017-02-04.
 */
public class Event {

    private UUID mID;
    private String mEventTitle;
    private String mEventLocation;

    public Event (){
        mID = UUID.randomUUID();
    }

    public UUID getID() {
        return mID;
    }

    public String getEventTitle() {
        return mEventTitle;
    }

    public void setEventTitle(String eventTitle) {
        mEventTitle = eventTitle;
    }

    public String getEventLocation() {
        return mEventLocation;
    }

    public void setEventLocation(String eventLocation) {
        mEventLocation = eventLocation;
    }
}
