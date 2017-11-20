package com.anorris.android.wholesome;

import java.util.UUID;

/**
 * Created by anorris on 2017-02-04.
 */
public class Goal {

    private UUID mID;
    private String mGoalTitle;
    private Boolean mGoalAccomp;

    public Goal (){
        mID = UUID.randomUUID();
        mGoalAccomp = false;
    }

    public UUID getID(){
        return mID;
    }

    public void setTitle(String title){
        mGoalTitle = title;
    }

    public String getTitle(){
        return mGoalTitle;
    }

    public Boolean getProgress(){
        return mGoalAccomp;
    }

    public void setProgress(Boolean accomp){
        mGoalAccomp = accomp;
    }
}
