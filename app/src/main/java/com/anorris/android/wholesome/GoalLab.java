package com.anorris.android.wholesome;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by anorris on 2017-02-04.
 */
public class GoalLab {

    private static GoalLab sGoalLab;
    private List<Goal> mGoals;

    public static GoalLab get(Context context){
        if (sGoalLab == null){
            sGoalLab = new GoalLab(context);
        }
        return sGoalLab;
    }

    private GoalLab(Context context){
        mGoals = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            Goal goal = new Goal();
            goal.setTitle("Goal #" + i);
            goal.setProgress(false);
            mGoals.add(goal);
        }
    }

    public List<Goal> getGoals(){
        return mGoals;
    }

    public Goal getGoal(UUID id){
        for (Goal goal : mGoals){
            if (goal.getID().equals(id)){
                return goal;
            }
        }
        return null;
    }
}
