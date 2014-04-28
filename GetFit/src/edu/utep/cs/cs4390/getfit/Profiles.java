package edu.utep.cs.cs4390.getfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Profiles extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profiles);
        
        
    	
    }
	public void onClickRoutines(View v){
		startActivity(new Intent("edu.utep.cs.cs4390.getfit.RoutinesList"));
	}
}
