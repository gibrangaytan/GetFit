package edu.utep.cs.cs4390.getfit;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
        /*ExerciseHelper db = new ExerciseHelper(this);
        Log.d("Reading: ", "Reading all the exercises..");
        List<Exercise> excercises = db.getAllExercises();
        for (Exercise cn : excercises){
        	String log = "Id: "+cn.getId()+" Name: "+cn.getName();
        	Log.d("Name: ",log);
        }*/
    }
    public void onClick(View v){
    	int sourceId = v.getId();
    	switch(sourceId){
    	case R.id.exercises:
    		startActivity(new Intent("edu.utep.cs.cs4390.getfit.BodyParts"));
    		break;
    	case R.id.meals:
    		break;
    	case R.id.profile:
    		startActivity(new Intent("edu.utep.cs.cs4390.getfit.Profiles"));
    		break;
    	};
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
