package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ExerciseList extends Activity {

	ArrayList<Exercise> e;
	ArrayList<String> es;
	ArrayAdapter adapter;
	String id;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exerciselist);
        
        ListView listview = (ListView)findViewById(R.id.list);
        Bundle extras = getIntent().getExtras();
		if(extras != null){
			id = extras.getString("id");
		}
		//Toast.makeText(getApplicationContext(),"exe"+ id, Toast.LENGTH_SHORT).show();
		ExerciseHelper db = new ExerciseHelper(this);
        e = new ArrayList<Exercise>();
        es = new ArrayList<String>();
   	 e = db.getExerciseByMuscle(id);
   	for (Exercise m : e) {
           String log = " Name: " + m.getName();
           es.add(m.getName());		// puts the String name in the ArrayList<String>
               // Writing Muscles to log
       Log.d("Name: ", log);
   }
   	adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , es);
   	listview.setAdapter(adapter);

    	
    	
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
