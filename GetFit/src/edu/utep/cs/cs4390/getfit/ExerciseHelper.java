package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ExerciseHelper extends SQLiteOpenHelper{
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "getfit.db";
	private static final String TABLE_EXERCISES = "exercises";
	
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_STEPS = "steps";
	private static final String KEY_TYPES_ID = "types_id";
	private static final String KEY_DIFFICULTIES_ID = "difficulties_id";
	private static final String KEY_MECHANICS_ID = "mechanics_id";
	
	
	public ExerciseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Exercise> getAllExercises(){
		List<Exercise> exercisesList = new ArrayList<Exercise>();
		String selectQuery = "SELECT  * FROM " + TABLE_EXERCISES;
		
		SQLiteDatabase db = this.getReadableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	    
	    if (cursor.moveToFirst()) {
	        do {
	            Exercise exercise = new Exercise();
	            exercise.setId(Integer.parseInt(cursor.getString(0)));
	            exercise.setName(cursor.getString(1));
	            exercise.setSteps(cursor.getString(2));
	            exercise.setTypes_id(Integer.parseInt(cursor.getString(3)));
	            exercise.setDifficulties_id(Integer.parseInt(cursor.getString(4)));
	            exercise.setMechanics_id(Integer.parseInt(cursor.getString(5)));
	            // Adding exercise to list
	            exercisesList.add(exercise);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return exercisesList;
	}
	

}