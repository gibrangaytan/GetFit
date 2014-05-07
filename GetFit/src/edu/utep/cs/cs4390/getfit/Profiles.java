package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profiles extends Activity {

	ImageView image;
	TextView nameView, ageView, weightView, heightView, bodyfatView, waistView,
			chestView, armsView, forearmsView, shouldersView, hipsView,
			thighsView, calvesView, neckView;
	ExerciseHelper helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profiles);
		nameView = (TextView) findViewById(R.id.profileNameTextView);
		ageView = (TextView) findViewById(R.id.ageTextView);
		weightView = (TextView) findViewById(R.id.weightTextView);
		heightView = (TextView) findViewById(R.id.heightTextView);
		waistView = (TextView) findViewById(R.id.waistTextView);
		chestView = (TextView) findViewById(R.id.chestTextView);
		armsView = (TextView) findViewById(R.id.armsTextView);
		forearmsView = (TextView) findViewById(R.id.forearmsTextView);
		shouldersView = (TextView) findViewById(R.id.shouldersTextView);
		hipsView = (TextView) findViewById(R.id.hipsTextView);
		thighsView = (TextView) findViewById(R.id.thighsTextView);
		calvesView = (TextView) findViewById(R.id.calvesTextView);
		neckView = (TextView) findViewById(R.id.neckTextView);
		bodyfatView = (TextView) findViewById(R.id.bodyfatTextView);

	}

	public void onClickRoutines(View v) {
		startActivity(new Intent("edu.utep.cs.cs4390.getfit.RoutinesList"));
	}

	public void onClickEdit(View v) {
		startActivity(new Intent("edu.utep.cs.cs4390.getfit.EditProfiles"));
	}

	public void onStart() {
		super.onStart();
		SharedPreferences settings = getSharedPreferences("prefs", MODE_PRIVATE);
		String temp = settings.getString("name", "Name");
		nameView.setText(temp);
		ageView.setText("Age: " + settings.getInt("age", 0) + "");
		// weightView.setText("Weight: "+settings.getInt("weight", 0)+" lbs");
		// temp = settings.getInt("heightFeet",
		// 0)+"'"+settings.getInt("heightInches",0)+"\"";
		// heightView.setText("Height: "+temp);
		// bodyfatView.setText("Body Fat: "+settings.getInt("bodyfat", 0)+"%");
		helper = new ExerciseHelper(this);
		ArrayList<Measurable> ms = helper.getMeasurables();
		weightView.setText("Weight: " + ms.get(0).getMeasurement() + " lbs");
		heightView.setText("Height: " + ms.get(1).getMeasurement() + " \"");
		waistView.setText("Waist: " + ms.get(2).getMeasurement() + " \"");
		chestView.setText("Chest: " + ms.get(3).getMeasurement() + " \"");
		armsView.setText("Arms: " + ms.get(4).getMeasurement() + " \"");
		forearmsView.setText("Forearms: " + ms.get(5).getMeasurement() + " \"");
		shouldersView.setText("Shoulders: " + ms.get(6).getMeasurement()
				+ " \"");
		hipsView.setText("Hips: " + ms.get(7).getMeasurement() + " \"");
		thighsView.setText("Thighs: " + ms.get(8).getMeasurement() + " \"");
		calvesView.setText("Calves: " + ms.get(9).getMeasurement() + " \"");
		neckView.setText("Neck: " + ms.get(10).getMeasurement() + " \"");
		bodyfatView.setText("BodyFat: " + ms.get(11).getMeasurement() + " %");

	}
}