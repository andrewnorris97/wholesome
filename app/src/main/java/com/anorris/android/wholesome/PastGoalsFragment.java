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
public class PastGoalsFragment extends Fragment {

    private Goal mGoal;
    private TextView mPastGoalTitle;
    private RecyclerView mPastGoalsRecyclerViewer;
    private GoalAdapter mAdapter;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mGoal = new Goal();
        mGoal.setTitle("accomplished goal");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_past_goal, container, false);

        mPastGoalsRecyclerViewer = (RecyclerView) v.findViewById(R.id.past_goal_recycler_view);
        mPastGoalsRecyclerViewer.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        //mPastGoalTitle = (TextView)v.findViewById(R.id.past_goal);
        //mPastGoalTitle.setText(mGoal.getTitle());

        return v;
    }

    private void updateUI(){
        GoalLab goalLab = GoalLab.get(getActivity());
        List<Goal> goals = goalLab.getGoals();

        mAdapter = new GoalAdapter(goals);
        mPastGoalsRecyclerViewer.setAdapter(mAdapter);
    }

    public static PastGoalsFragment newInstance(String text){

        PastGoalsFragment f = new PastGoalsFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    private class GoalHolder extends RecyclerView.ViewHolder{

        public TextView mTitleTextView;

        public GoalHolder (View itemView){
            super(itemView);

            mTitleTextView = (TextView) itemView;
        }
    }

    private class GoalAdapter extends RecyclerView.Adapter<GoalHolder>{

        private List<Goal> mGoals;

        public GoalAdapter(List<Goal> goals){
            mGoals = goals;
        }

        @Override
        public GoalHolder onCreateViewHolder(ViewGroup parent, int ViewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new GoalHolder(view);
        }

        @Override
        public void onBindViewHolder(GoalHolder holder, int postion){
            Goal goal = mGoals.get(postion);
            holder.mTitleTextView.setText(goal.getTitle());
        }

        @Override
        public int getItemCount(){
            return mGoals.size();
        }
    }
}
