package edu.utep.cs.cs4390.getfit;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
	
    Muscle getMuscle(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query("muscles",
        		new String[] {"name"},
        		"id = ?",
        		new String[]{String.valueOf(id)},
        		null,
        		null,
        		null,
        		null);
        		
        		
        if (cursor != null)
            cursor.moveToFirst();
        	
        	Muscle muscle = new Muscle();
        	muscle.setName(cursor.getString(0));

        	Log.d("getMuscle("+id+")", muscle.name());
        	
        return muscle;
    } 
    
    // Getting All Contacts
    public ArrayList<Muscle> getAllMuscles() {
        ArrayList<Muscle> muscleList = new ArrayList<Muscle>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + "muscles";
 
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Muscle muscle = new Muscle();
                muscle.setID(cursor.getInt(0));
                muscle.setName(cursor.getString(1));
                // Adding contact to list
                muscleList.add(muscle);
            } while (cursor.moveToNext());
        }
        db.close();
 
        // return contact list
        return muscleList;
    }
    
  //getting all exercises for a muscle
        public ArrayList<Exercise> getExerciseByMuscle(String muscleID){
        	ArrayList<Exercise> exerciseByMuscle = new ArrayList<Exercise>();
       	//Select query
    	String selectQuery = "SELECT e.*,em.muscles_id FROM exercises as e LEFT JOIN exercises_has_muscles as em ON e.id = em.exercises_id where em.muscles_id = "+muscleID+" ORDER BY e.name;";
        	
        	SQLiteDatabase db = this.getReadableDatabase();
           Cursor cursor = db.rawQuery(selectQuery, null);
     
            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Exercise exercise = new Exercise();
                    exercise.setId(cursor.getInt(0));
                    exercise.setName(cursor.getString(1));
                    // Adding contact to list
                    exerciseByMuscle.add(exercise);
                } while (cursor.moveToNext());
            }
            db.close();
            return exerciseByMuscle;
        }
        
        Exercise getExercise(int id) {
            SQLiteDatabase db = this.getReadableDatabase();
     
            Cursor cursor = db.query(TABLE_EXERCISES, new String[] {KEY_ID, 
            		KEY_NAME, KEY_STEPS, KEY_TYPES_ID, KEY_DIFFICULTIES_ID, KEY_MECHANICS_ID}, KEY_ID + "=?",
            		new String[]{String.valueOf(id)}, null, null, null, null);
                        		
            if (cursor != null)
                cursor.moveToFirst();
            	
            	Exercise exercise = new Exercise(Integer.parseInt(cursor.getString(0)),cursor.getString(1),
            			cursor.getString(2),Integer.parseInt(cursor.getString(3)),Integer.parseInt(cursor.getString(4)),
            			Integer.parseInt(cursor.getString(5)));
            	            	           	
            return exercise;
        } 
        
        public ArrayList<Media> getMedia(String exerciseID){
        	ArrayList<Media> mediaList = new ArrayList<Media>();
       	//Select query
    	String selectQuery = "SELECT * FROM media AS m LEFT JOIN exercises_has_media AS em ON em.media_id = m.id WHERE em.id="+exerciseID+";";
        	
        	SQLiteDatabase db = this.getReadableDatabase();
           Cursor cursor = db.rawQuery(selectQuery, null);
     
            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Media media = new Media();
                    media.setId(cursor.getInt(0));
                    media.setUrl(cursor.getString(1));
                    // Adding contact to list
                    mediaList.add(media);
                } while (cursor.moveToNext());
            }
            db.close();
            return mediaList;
        }


}
