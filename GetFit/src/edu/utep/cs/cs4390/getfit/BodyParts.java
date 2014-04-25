package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;
import java.util.List;

import edu.utep.cs.cs4390.getfit.MainActivity.PlaceholderFragment;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class BodyParts extends Activity {
	
	ArrayList<Muscle> muscle;
	ArrayList<String> mu;
	ArrayAdapter adapter;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodyparts);
        
        ListView listview = (ListView)findViewById(R.id.list);

        ExerciseHelper db = new ExerciseHelper(this);
         muscle = new ArrayList<Muscle>();
         mu = new ArrayList<String>();
    	 muscle = db.getAllMuscles();
    	for (Muscle m : muscle) {
            mu.add(m.name()); 		// puts the String name in the ArrayList<String>
    }
    	adapter = new ArrayAdapter<String>(this, R.layout.list_item, mu);
    	listview.setAdapter(adapter);
    	listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				String item = (String) parent.getItemAtPosition(position);
				int idM	= muscle.get(position).getID();
				String idValue = Integer.toString(idM);
				
				//Toast.makeText(getApplicationContext(), idValue, Toast.LENGTH_SHORT).show();
				Intent i = new Intent("edu.utep.cs.cs4390.getfit.ExerciseList");
				i.putExtra("id", idValue);
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
