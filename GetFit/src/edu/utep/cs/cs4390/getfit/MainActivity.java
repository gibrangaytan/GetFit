package edu.utep.cs.cs4390.getfit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private static final String DB_FULL_PATH = "data/data/edu.utep.cs.cs4390.getfit/databases/getfit.db";
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if(!checkDataBase()){
        	Log.i("Database",
                    "New database is being copied to device!");
            byte[] buffer = new byte[1234945];
            OutputStream myOutput = null;
            int length;
            // Open your local db as the input stream
            InputStream myInput = null;
            try
            {
                myInput = getApplicationContext().getAssets().open("getfit.jpg");
                // transfer bytes from the inputfile to the
                // outputfile
                myOutput =new FileOutputStream(DB_FULL_PATH);
                while((length = myInput.read(buffer)) > 0)
                {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.close();
                myOutput.flush();
                myInput.close();
                Log.i("Database",
                        "New database has been copied to device!");


            }
            
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }
	private boolean checkDataBase() {
		File dbFile = new File(DB_FULL_PATH);
	    return dbFile.exists();
	}
    public void onClick(View v){

    		startActivity(new Intent("edu.utep.cs.cs4390.getfit.BodyParts"));
    }
    public void onClickMeals(View v){
    		startActivity(new Intent("edu.utep.cs.cs4390.getfit.Meals"));
    }
    public void onClickProfile(View v){
    		startActivity(new Intent("edu.utep.cs.cs4390.getfit.Profiles"));
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
