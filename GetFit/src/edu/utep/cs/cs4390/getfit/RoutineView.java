package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class RoutineView extends Activity {
	
	ArrayList<Routines_has_exercises> e;
	ArrayList<String> es;
	ArrayAdapter adapter;
	String id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.routineview);

		ListView listview = (ListView) findViewById(R.id.listroutinesview);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
		}
		// Toast.makeText(getApplicationContext(),"exe"+ id,
		// Toast.LENGTH_SHORT).show();
		ExerciseHelper db = new ExerciseHelper(this);
		e = new ArrayList<Routines_has_exercises>();
		es = new ArrayList<String>();
		e = db.getRoutineExercises(id);
		for (Routines_has_exercises m : e) {
			es.add(m.getName() +" " + m.getSets() +"x"+ m.getReps() +" reps "+ m.getWeight()+"lbs"); // puts the String name in the
									// ArrayList<String>
		}
		adapter = new ArrayAdapter<String>(this, R.layout.list_item, es);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String item = (String) parent.getItemAtPosition(position);
				int idM = e.get(position).getExercise_id();
				String name = e.get(position).getName();

				// Toast.makeText(getApplicationContext(), idValue,
				// Toast.LENGTH_SHORT).show();
				Intent i = new Intent("edu.utep.cs.cs4390.getfit.ExerciseView");
				i.putExtra("id", idM);
				i.putExtra("name", name);
				startActivity(i);

			}

		});

}
}
