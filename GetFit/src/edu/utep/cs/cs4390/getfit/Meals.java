package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Meals extends Activity {
	
	ArrayList<String> meals;
	ArrayAdapter adapter;
	
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.meals);
	        
	        ListView listview = (ListView)findViewById(R.id.listMeals);
	        meals = new ArrayList<String>();
	        meals.add("Chicken Marsala");
	        meals.add("Baked Garlic Parmesan Chicken");
	        meals.add("Angel Chicken Pasta");
	        adapter = new ArrayAdapter<String>(this, R.layout.list_item , meals);
	        listview.setAdapter(adapter);
	        
	        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	    		@Override
	    		public void onItemClick(AdapterView<?> parent, View view, int position,
	    				long id) {
	    			
	    			startActivity(new Intent("edu.utep.cs.cs4390.getfit.MealView"));

	    			

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
