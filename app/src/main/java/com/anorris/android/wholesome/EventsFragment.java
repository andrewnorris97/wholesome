package com.anorris.android.wholesome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anorris on 2017-02-04.
 */
public class EventsFragment extends Fragment {

    private Event mEvent;
    private TextView mEventTitle;
    private RecyclerView mEventRecyclerViewer;
    private EventAdapter mAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEvent = new Event();
        mEvent.setEventLocation("Home");
        mEvent.setEventTitle("Sleep");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event_list, container, false);

        mEventRecyclerViewer = (RecyclerView) v.findViewById(R.id.event_recycler_view);
        mEventRecyclerViewer.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;

    }

    private void updateUI(){
        EventLab eventLab = EventLab.get(getActivity());
        List<Event> events = eventLab.getEvents();

        mAdapter = new EventAdapter(events);
        mEventRecyclerViewer.setAdapter(mAdapter);
    }


    public static EventsFragment newInstance(String text){

        EventsFragment f = new EventsFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    private class EventHolder extends RecyclerView.ViewHolder{

        private Event mEvent;

        private TextView mTitleTextView;
        private TextView mLocationTextView;

        public EventHolder(View itemView){
            super(itemView);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_event_title);
            mLocationTextView = (TextView) itemView.findViewById(R.id.list_item_event_location);
        }

        public void bindEvent(Event event){
            mEvent = event;
            mTitleTextView.setText(mEvent.getEventTitle());
            mLocationTextView.setText(mEvent.getEventLocation());
        }
    }

    private class EventAdapter extends RecyclerView.Adapter<EventHolder>{
        private List<Event> mEvents;

        public EventAdapter(List<Event> events){
            mEvents = events;
        }

        public EventHolder onCreateViewHolder(ViewGroup parent, int ViewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_event, parent, false);
            return new EventHolder(view);
        }

        @Override
        public void onBindViewHolder(EventHolder holder, int position){
            Event event = mEvents.get(position);
            holder.bindEvent(event);
        }

        @Override
        public int getItemCount(){
            return mEvents.size();
        }
    }
}
