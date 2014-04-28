package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class RoutinesList extends Activity {
	
    ArrayList<Routine> routine;
	ArrayList<String> ru;
	ArrayAdapter adapter;
	EditText myAutoComplete;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.routines);
        myAutoComplete = (EditText) findViewById(R.id.myautocompleteroutines);
           ListView listview = (ListView)findViewById(R.id.listroutines);

            ExerciseHelper db = new ExerciseHelper(this);
            routine = new ArrayList<Routine>();
             ru = new ArrayList<String>();
             routine = db.getRoutines();
        	for (Routine m : routine) {
                ru.add(m.name()); 		// puts the String name in the ArrayList<String>
        }
        	myAutoComplete.addTextChangedListener(new TextWatcher() {

    			public void onTextChanged(CharSequence cs, int arg1, int arg2,
    					int arg3) {
    				// When user changed the Text
    				RoutinesList.this.adapter.getFilter().filter(cs);
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
        	adapter = new ArrayAdapter<String>(this, R.layout.list_item, ru);
        	listview.setAdapter(adapter);
        	listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    			@Override
    			public void onItemClick(AdapterView<?> parent, View view, int position,
    					long id) {
    				String item = (String) parent.getItemAtPosition(position);
    				int idM	= routine.get(position).getId();
    				String idValue = Integer.toString(idM);
    				
    				//Toast.makeText(getApplicationContext(), idValue, Toast.LENGTH_SHORT).show();
    				Intent i = new Intent("edu.utep.cs.cs4390.getfit.RoutineView");
    				i.putExtra("id", idValue);
    				startActivity(i);
    				

    				}
    			
        		
    		});
        
	}
	
	public void onClick(View v){
		startActivity(new Intent("edu.utep.cs.cs4390.getfit.AddRoutine"));
		
	}

}
