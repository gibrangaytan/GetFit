package edu.utep.cs.cs4390.getfit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profiles extends Activity {
	
	ImageView image;
	TextView nameView, ageView, weightView, heightView, bodyfatView;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profiles);   	
        nameView = (TextView)findViewById(R.id.profileNameTextView);
        ageView = (TextView)findViewById(R.id.ageTextView);
        weightView = (TextView)findViewById(R.id.weightTextView);
        heightView = (TextView)findViewById(R.id.heightTextView);
        bodyfatView = (TextView)findViewById(R.id.bodyfatTextView);
        
    }
	public void onClickRoutines(View v){
		startActivity(new Intent("edu.utep.cs.cs4390.getfit.RoutinesList"));
	}
	public void onClickEdit(View v){
		startActivity(new Intent("edu.utep.cs.cs4390.getfit.EditProfiles"));
	}
	public void onStart(){
		super.onStart();
		SharedPreferences settings = getSharedPreferences("prefs",MODE_PRIVATE);
        String temp = settings.getString("name", "Name");
        nameView.setText(temp);
        ageView.setText("Age: "+settings.getInt("age", 0)+"");
        weightView.setText("Weight: "+settings.getInt("weight", 0)+" lbs");
        temp = settings.getInt("heightFeet", 0)+"'"+settings.getInt("heightInches",0)+"\"";
        heightView.setText("Height: "+temp);
        bodyfatView.setText("Body Fat: "+settings.getInt("bodyfat", 0)+"%");
	}
}
