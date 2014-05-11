package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Allows the user to edit his or her profile information. This includes the name, age, 
 * weight, height,and other measurements of the body.   
 * 
 */
public class EditProfiles extends Activity {
	EditText nameEdit, ageEdit, weightEdit, heightEdit, bodyfatEdit;
	EditText heightInchesEdit, heightFeetEdit;
	ExerciseHelper helper;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editprofiles);
		nameEdit = (EditText) findViewById(R.id.profileNameEditText);
		ageEdit = (EditText) findViewById(R.id.ageEditText);
		helper = new ExerciseHelper(this);
		ArrayList<Measurable> ms = helper.getMeasurables();
		Measurable[] marray = (Measurable[]) ms.toArray(new Measurable[ms
				.size()]);
		MyArrayAdapter adapter = new MyArrayAdapter(this, marray);
		ListView listView = (ListView) findViewById(R.id.editProfileListView);
		listView.setAdapter(adapter);
	}
	/**
	 * saves the name and age using shared preferences
	 */
	public void onClickSubmit(View v) {

		SharedPreferences settings = getSharedPreferences("prefs", MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("name", nameEdit.getText().toString());
		Log.i("Put", "name:" + nameEdit.getText().toString());
		editor.putInt("age", parseInt(ageEdit.getText().toString()));
		// Commits the edits
		editor.commit();
		finish();
	}
	/**
	 * retrieves the name and age that are stored using shared preferences
	 */
	public void onStart() {
		super.onStart();
		SharedPreferences settings = getSharedPreferences("prefs", MODE_PRIVATE);
		String temp = settings.getString("name", "Name");
		nameEdit.setText(temp);
		ageEdit.setText(settings.getInt("age", 0) + "");
	}
	/**
	 * converts a string to and integer.  If the string cannot be converted, a zero is returned.
	 * 
	 * @param s string to be converted into an integer
	 * @return an integer based on the string's value
	 */
	private int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return 0;
		}
	}
	/**
	 * Used to display the editable measurements of each bodypart on a listView. 
	 * Includes a textView of the name of the bodypart, a seekbar to change the value, 
	 * and a textView with the value.
	 */
	private class MyArrayAdapter extends ArrayAdapter<Measurable> {
		private final Context context;
		private final Measurable[] values;
		private String[] svalues;

		public MyArrayAdapter(Context context, Measurable[] values) {
			super(context, R.layout.measurable_list_item, values);
			this.context = context;
			this.values = values;
		}
		/**
		 * Sets up the view containing all measurable body parts.
		 */
		public View getView(final int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView = inflater.inflate(R.layout.measurable_list_item,
					parent, false);
			TextView label1 = (TextView) rowView
					.findViewById(R.id.measurableLabel);
			SeekBar seekbar = (SeekBar) rowView
					.findViewById(R.id.measurableSeekbar);
			final TextView label2 = (TextView) rowView
					.findViewById(R.id.measurableInchesLabel);
			label1.setText(values[position].getName());
			final int id = values[position].getId();
			String temp = values[position].getName();
			final String type; //inches, pounds (lbs), or percent (%)
			//sets max values in the seekbar and the type label to be displayed:
			if (temp.equalsIgnoreCase("weight")) {
				seekbar.setMax(500);
				type = " lbs";
			} else if (temp.equalsIgnoreCase("bodyfat")) {
				seekbar.setMax(100);
				type = " %";
			} else if (temp.equalsIgnoreCase("height")){
				seekbar.setMax(80);
				type=" inches";
			}else
				type = " inches";
			//sets the seekbar to the correct position and the label with the correct value:	
			seekbar.setProgress(values[position].getMeasurement());
			label2.setText(values[position].getMeasurement() + type);
			seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					//updates the label when the seekbar is changed:		
					label2.setText(progress + type);
				}

				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
				}

				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					//saves changes to database automatically:
					SQLiteDatabase db = helper.getWritableDatabase();
					ContentValues initialValues = new ContentValues();
					initialValues.put("measurement",seekBar.getProgress());	
					db.update("measurables", initialValues, "id ="+id, null);
					db.close();
					//displays message to user:
					Toast.makeText(getBaseContext(), "changes saved", Toast.LENGTH_SHORT).show();

				}

			});

			return rowView;
		}
	}
}
