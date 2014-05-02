package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AddRoutine extends Activity {
	
	ArrayList<Exercise> e;
	ArrayList<String> es;
	ArrayAdapter adapter;
	ArrayAdapter adapter2;
	AutoCompleteTextView myAutoComplete;

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addroutine);
		myAutoComplete = (AutoCompleteTextView) findViewById(R.id.myautocompleteR);

      final  ListView listview = (ListView) findViewById(R.id.listexeR);
		ExerciseHelper db = new ExerciseHelper(this);
		e = new ArrayList<Exercise>();
		es = new ArrayList<String>();
		e = db.getAllExercises();
		for (Exercise m : e) {
			es.add(m.getName()); // puts the String name in the
									// ArrayList<String>
		}
		Collections.sort(es);
		
		adapter = new ArrayAdapter<String>(this, R.layout.my_list_item_multiple_choice, es);
		listview.setChoiceMode(listview.CHOICE_MODE_MULTIPLE);
		listview.setAdapter(adapter);
		adapter2 = new ArrayAdapter<String>(this, R.layout.list_item, es);
		myAutoComplete.setAdapter(adapter2);
		

		
		myAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String str = myAutoComplete.getText().toString();
				 int po = es.indexOf(str);
				  listview.setSelection(po);
			}
			
		});
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			long[] l =	listview.getCheckItemIds();
			//if(listview.getCh)
			
			Toast.makeText(getApplicationContext(), "po: "+ l.length , Toast.LENGTH_SHORT).show();
			Toast.makeText(getApplicationContext(), "l:" + l[0], Toast.LENGTH_SHORT).show();

				


			}

		});
		
}
}