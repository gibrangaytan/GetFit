package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author miguelpalacios
 *This class will display the name of the new routine the user is creating
 *with the selected exercise and will give let the user specified the sets,reps
 *and weights. After saving it the user will be directed to the routines list.
 */
public class AddRoutineSpec extends Activity {
	
	long [] l;
	ArrayList<Exercise> exercises;
	ArrayList<String> e;
	ArrayList<String> eSelected;
	String name;
	TextView nameText;
	LinearLayout layout;
	TextView textView;
	EditText editSets;
	ArrayList<EditText> allEditSets = new ArrayList<EditText>();
	EditText editReps;
	ArrayList<EditText> allEditReps = new ArrayList<EditText>();
	EditText editWeight;
	ArrayList<EditText> allEditWeight = new ArrayList<EditText>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addroutinespec);
		nameText = (TextView) findViewById(R.id.nameRoutine);
		layout = (LinearLayout) findViewById(R.id.editroutine);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			l = extras.getLongArray("l");
			name = extras.getString("name");
		}
		nameText.setText(name);
		ExerciseHelper db = new ExerciseHelper(this);
		exercises = new ArrayList<Exercise>();
		e = new ArrayList<String>();
		eSelected = new ArrayList<String>();
		exercises = db.getAllExercises();
		for (Exercise m : exercises) {
			e.add(m.getName()); // puts the String name in the
									// ArrayList<String>
		}
		Collections.sort(e);
		
		for(int i=0; i<l.length; i++){
			eSelected.add(e.get((int) l[i]));
		}
		setTextView();
		
	}
	
	/**
	 * Will set all the textView to have the exercise selected by the user.
	 * Will display the editText for each exercise with the reps,sets and weight.
	 */
	public void setTextView(){


		for(int i=0; i < eSelected.size(); i++){
		textView = new TextView(this);
		textView.setVisibility(View.VISIBLE);
		textView.setTextColor(Color.WHITE);
		textView.setTextSize(18);
		textView.setText(eSelected.get(i));
		layout.addView(textView);
		
	    editSets = new EditText(this);
	    allEditSets.add(editSets);
	    editSets.setId(i); 
	    editSets.setHint("Sets");
	    layout.addView(editSets);
	    
	    editReps = new EditText(this);
	    allEditReps.add(editReps);
	    editReps.setId(i); 
	    editReps.setHint("Reps");
	    layout.addView(editReps);
	    
	    editWeight = new EditText(this);
	    allEditWeight.add(editWeight);
	    editWeight.setId(i); 
	    editWeight.setHint("Weight");
	    layout.addView(editWeight);

		}		
		}
	/**
	 * Will get the text on the edit text from the sets, reps and weight.
	 * Will store that text into the database.
	 * Will start the activity of the routines list.
	 */
	public void onClick(View v){
		ExerciseHelper db = new ExerciseHelper(this);
		db.createRoutine(name);
		for(int i=0; i < eSelected.size(); i++){
		String getSets = allEditSets.get(i).getText().toString();
		//Toast.makeText(getApplicationContext(), "sets:" + getSets, Toast.LENGTH_SHORT).show();
		String getReps = allEditReps.get(i).getText().toString();
		String getWeight = allEditWeight.get(i).getText().toString();
		String nameExercise = eSelected.get(i);
		String idExercise = db.getIdFromExerciseName(nameExercise);
		db.insertRoutineSpec(idExercise,name,getReps,getSets,getWeight);
		}
		
		startActivity(new Intent("edu.utep.cs.cs4390.getfit.RoutinesList"));
		
	}
	}


