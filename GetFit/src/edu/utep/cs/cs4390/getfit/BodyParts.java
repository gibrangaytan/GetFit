package edu.utep.cs.cs4390.getfit;

import java.util.List;

import edu.utep.cs.cs4390.getfit.MainActivity.PlaceholderFragment;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class BodyParts extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodyparts);

        ExerciseHelper db = new ExerciseHelper(this);
    	List<Muscle> muscle = db.getAllMuscles();
    	for (Muscle m : muscle) {
            String log = " Name: " + m.name();
                // Writing Contacts to log
        Log.d("Name: ", log);
    }

    }
	
//	public void onClick(View v) {
//
//	     switch(v.getId()){
//	     case (R.id.plusbutton):
//	                 Button myButton = new Button(this);
//	                 myButton.setText("Add Me");
//
//	                 LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
//	                 LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//	                 ll.addView(myButton, lp);
//	                 break;.
//	     case (R.id.minusbutton):
//	                 Button myButton = new Button(this);
//	                 myButton.setText("Remove Me");
//
//	                 LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
//	                 LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//	                 ll.removeView(myButton, lp);
//	                 break;
//	           }
//	         }
    
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

}
