package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ExerciseList extends Activity {

	ArrayList<Exercise> e;
	ArrayList<String> es;
	ArrayAdapter adapter;
	String id;
	EditText myAutoComplete;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exerciselist);
		myAutoComplete = (EditText) findViewById(R.id.myautocomplete);

		ListView listview = (ListView) findViewById(R.id.list);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getString("id");
		}
		// Toast.makeText(getApplicationContext(),"exe"+ id,
		// Toast.LENGTH_SHORT).show();
		ExerciseHelper db = new ExerciseHelper(this);
		e = new ArrayList<Exercise>();
		es = new ArrayList<String>();
		e = db.getExerciseByMuscle(id);
		for (Exercise m : e) {
			es.add(m.getName()); // puts the String name in the
									// ArrayList<String>
		}
		adapter = new ArrayAdapter<String>(this, R.layout.list_item, es);
		listview.setAdapter(adapter);

		myAutoComplete.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence cs, int arg1, int arg2,
					int arg3) {
				// When user changed the Text
				ExerciseList.this.adapter.getFilter().filter(cs);
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}

		});

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String item = (String) parent.getItemAtPosition(position);
				int idM = e.get(position).getId();
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
