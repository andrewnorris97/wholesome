package com.anorris.android.wholesome;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by anorris on 2017-02-04.
 */
public class EventLab {

    private static EventLab sEventLab;
    private List<Event> mEvents;

    public static EventLab get(Context context){
        if (sEventLab == null){
            sEventLab = new EventLab(context);
        }
        return sEventLab;
    }

    private EventLab (Context context){
        mEvents = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            Event event = new Event();
            event.setEventTitle("Event #" + i);
            event.setEventLocation("Place #" + i);
            mEvents.add(event);
        }
    }

    public List<Event> getEvents(){
        return mEvents;
    }

    public Event getEvent(UUID id){
        for (Event event: mEvents){
            if (event.getID().equals(id)){
                return event;
            }
        }
        return null;
    }
}
