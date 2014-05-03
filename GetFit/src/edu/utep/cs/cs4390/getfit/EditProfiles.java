package edu.utep.cs.cs4390.getfit;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfiles extends Activity {
	EditText nameEdit, ageEdit, weightEdit, heightEdit, bodyfatEdit;
	EditText heightInchesEdit, heightFeetEdit;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editprofiles);
		nameEdit = (EditText) findViewById(R.id.profileNameEditText);
		ageEdit = (EditText) findViewById(R.id.ageEditText);
		weightEdit = (EditText) findViewById(R.id.weightEditText);
		heightFeetEdit = (EditText) findViewById(R.id.heightFeetEditText);
		heightInchesEdit = (EditText) findViewById(R.id.heightInchesEditText);
		bodyfatEdit = (EditText) findViewById(R.id.bodyfatEditText);
		
	}

	public void onClickSubmit(View v) {

		SharedPreferences settings = getSharedPreferences("prefs", MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("name", nameEdit.getText().toString());
		Log.i("Put", "name:" + nameEdit.getText().toString());
		editor.putInt("age", parseInt(ageEdit.getText().toString()));
		editor.putInt("weight", parseInt(weightEdit.getText().toString()));
		editor.putInt("heightInches", parseInt(heightInchesEdit.getText()
				.toString()));
		editor.putInt("heightFeet", parseInt(heightFeetEdit.getText()
				.toString()));
		editor.putInt("bodyfat", parseInt(bodyfatEdit.getText().toString()));
		// Commit the edits!
		editor.commit();
		finish();
		//Toast.makeText(getApplicationContext(), "changes submitted",
			//	Toast.LENGTH_SHORT).show();
	}

	public void onStart() {
		super.onStart();
		SharedPreferences settings = getSharedPreferences("prefs", MODE_PRIVATE);
		String temp = settings.getString("name", "Name");
		nameEdit.setText(temp);
		ageEdit.setText(settings.getInt("age", 0)+"");
		weightEdit.setText(settings.getInt("weight", 0)+"");
		heightInchesEdit.setText(settings.getInt("heightInches",0)+"");
		heightFeetEdit.setText(settings.getInt("heightFeet",0)+"");
		bodyfatEdit.setText(settings.getInt("bodyfat", 0) + "");
	}

	private int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			// Log exception.
			return 0;
		}
	}
}
