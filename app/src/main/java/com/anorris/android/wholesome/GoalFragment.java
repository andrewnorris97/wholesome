package com.anorris.android.wholesome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by anorris on 2017-02-04.
 */
public class GoalFragment extends Fragment {

    private Goal mGoalOne;
    private Goal mGoalTwo;
    private Goal mGoalThree;
    private Button mGoalTitleOne;
    private Button mGoalTitleTwo;
    private Button mGoalTitleThree;
    private CheckBox mGoalAccompOne;
    private CheckBox mGoalAccompTwo;
    private CheckBox mGoalAccompThree;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mGoalOne = new Goal();
        mGoalOne.setTitle("Goal 1");
        mGoalTwo = new Goal();
        mGoalTwo.setTitle("Goal 2");
        mGoalThree = new Goal();
        mGoalThree.setTitle("Goal 3");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_goal, container, false);

        mGoalTitleOne = (Button) v.findViewById(R.id.goal_one_title);
        mGoalTitleOne.setText(mGoalOne.getTitle());

        mGoalAccompOne = (CheckBox) v.findViewById(R.id.goal_one_accomplished);
        mGoalAccompOne.setChecked(mGoalOne.getProgress());
        mGoalAccompOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean accomp) {
                mGoalOne.setProgress(accomp);
            }
        });

        mGoalTitleTwo = (Button) v.findViewById(R.id.goal_two_title);
        mGoalTitleTwo.setText(mGoalTwo.getTitle());

        mGoalAccompTwo = (CheckBox) v.findViewById(R.id.goal_two_accomplished);
        mGoalAccompTwo.setChecked(mGoalTwo.getProgress());
        mGoalAccompTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean accomp) {
                mGoalTwo.setProgress(accomp);
            }
        });

        mGoalTitleThree = (Button) v.findViewById(R.id.goal_three_title);
        mGoalTitleThree.setText(mGoalThree.getTitle());

        mGoalAccompThree = (CheckBox) v.findViewById(R.id.goal_three_accomplished);
        mGoalAccompThree.setChecked(mGoalThree.getProgress());
        mGoalAccompThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean accomp) {
                mGoalThree.setProgress(accomp);
            }
        });

        return v;
    }

    public static GoalFragment newInstance(String text){

        GoalFragment f = new GoalFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
