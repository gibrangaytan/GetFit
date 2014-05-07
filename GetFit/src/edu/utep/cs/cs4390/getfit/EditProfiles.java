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

public class EditProfiles extends Activity {
	EditText nameEdit, ageEdit, weightEdit, heightEdit, bodyfatEdit;
	EditText heightInchesEdit, heightFeetEdit;
	ExerciseHelper helper;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editprofiles);
		nameEdit = (EditText) findViewById(R.id.profileNameEditText);
		ageEdit = (EditText) findViewById(R.id.ageEditText);
		//weightEdit = (EditText) findViewById(R.id.weightEditText);
		//heightFeetEdit = (EditText) findViewById(R.id.heightFeetEditText);
		//heightInchesEdit = (EditText) findViewById(R.id.heightInchesEditText);
		//bodyfatEdit = (EditText) findViewById(R.id.bodyfatEditText);
		helper = new ExerciseHelper(this);
		ArrayList<Measurable> ms = helper.getMeasurables();
		Measurable[] marray = (Measurable[]) ms.toArray(new Measurable[ms
				.size()]);
		MyArrayAdapter adapter = new MyArrayAdapter(this, marray);
		ListView listView = (ListView) findViewById(R.id.editProfileListView);
		listView.setAdapter(adapter);
	}

	public void onClickSubmit(View v) {

		SharedPreferences settings = getSharedPreferences("prefs", MODE_PRIVATE);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("name", nameEdit.getText().toString());
		Log.i("Put", "name:" + nameEdit.getText().toString());
		editor.putInt("age", parseInt(ageEdit.getText().toString()));
		//editor.putInt("weight", parseInt(weightEdit.getText().toString()));
		//editor.putInt("heightInches", parseInt(heightInchesEdit.getText().toString()));
		//editor.putInt("heightFeet", parseInt(heightFeetEdit.getText().toString()));
		//editor.putInt("bodyfat", parseInt(bodyfatEdit.getText().toString()));
		// Commit the edits!
		editor.commit();
		finish();
		// Toast.makeText(getApplicationContext(), "changes submitted",
		// Toast.LENGTH_SHORT).show();
	}

	public void onStart() {
		super.onStart();
		SharedPreferences settings = getSharedPreferences("prefs", MODE_PRIVATE);
		String temp = settings.getString("name", "Name");
		nameEdit.setText(temp);
		ageEdit.setText(settings.getInt("age", 0) + "");
		//weightEdit.setText(settings.getInt("weight", 0) + "");
		//heightInchesEdit.setText(settings.getInt("heightInches", 0) + "");
		//heightFeetEdit.setText(settings.getInt("heightFeet", 0) + "");
		//bodyfatEdit.setText(settings.getInt("bodyfat", 0) + "");
	}

	private int parseInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			// Log exception.
			return 0;
		}
	}

	private class MyArrayAdapter extends ArrayAdapter<Measurable> {
		private final Context context;
		private final Measurable[] values;
		private String[] svalues;

		public MyArrayAdapter(Context context, Measurable[] values) {
			super(context, R.layout.measurable_list_item, values);
			this.context = context;
			this.values = values;
		}

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
			final String type;
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
			seekbar.setProgress(values[position].getMeasurement());
			label2.setText(values[position].getMeasurement() + type);
			seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					label2.setText(progress + type);
				}

				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					SQLiteDatabase db = helper.getWritableDatabase();//.update("measurable", values,
					ContentValues initialValues = new ContentValues();
					//initialValues.put("id",values[position].getId());	
					initialValues.put("measurement",seekBar.getProgress());	
					// "id = "+name, whereArgs);
					db.update("measurables", initialValues, "id ="+id, null);
					db.close();
					Toast.makeText(getBaseContext(), "changes saved", Toast.LENGTH_SHORT).show();

				}

			});

			return rowView;
		}
	}
}