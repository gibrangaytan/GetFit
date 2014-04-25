package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.ImageReader;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ExerciseView extends Activity{
	
	int id;
	String id_;
	String name;
	LinearLayout gallery;
	ArrayList<Media> e;
	ArrayList<String> es;

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exerciseview);
        
        Bundle extras = getIntent().getExtras();
		if(extras != null){
			id = extras.getInt("id");
			name = extras.getString("name");
		} 
        
        gallery = (LinearLayout)findViewById(R.id.gallery);
        //ImageView image = new ImageView(ExerciseView.this);
//        ImageView image2 = new ImageView(ExerciseView.this);
//        image.setBackgroundResource(R.drawable.benchpresssmall1);
//        image2.setBackgroundResource(R.drawable.benchpresssmall2);
//        gallery.addView(image);
//        gallery.addView(image2);
        
        
        ExerciseHelper db = new ExerciseHelper(this);
        e = new ArrayList<Media>();
        es = new ArrayList<String>();
        id_ = Integer.toString(id);
        e = db.getMedia(id_);
        for (Media m : e) {
           es.add(m.getUrl());		
        }
        for( int x=0; x < es.size(); x++){
        	String s =es.get(x);
        	Resources r = getResources();
        	int picId = r.getIdentifier(s, "drawable", "edu.utep.cs.cs4390.getfit");
        	
        	ImageView image = new ImageView(ExerciseView.this);
        	image.setBackgroundResource(picId);

        	
        	gallery.addView(image);
        	
        	
        }
        
        
         
       // ListView listview = (ListView)findViewById(R.id.list);
        TextView textview = (TextView)findViewById(R.id.steps);
		//Toast.makeText(getApplicationContext(),"exe"+ id, Toast.LENGTH_SHORT).show();
		String text = db.getExercise(id).getSteps() + "\n \n Copyright: Jefit.com";
		text = text.replaceAll("\\r", "");
		textview.setText(text);
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
