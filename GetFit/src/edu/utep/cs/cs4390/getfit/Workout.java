package edu.utep.cs.cs4390.getfit;

public class Workout {
	int workouts_id;
	int users_id; //or User user;
	String name;
	//workout_has_exercises wha_id Exercise reps,sets,ordinal
	public Workout(){}
	
	public Workout(int workouts_id, int users_id, String name) {
		super();
		this.workouts_id = workouts_id;
		this.users_id = users_id;
		this.name = name;
	}

	public int getWorkouts_id() {
		return workouts_id;
	}
	public void setWorkouts_id(int workouts_id) {
		this.workouts_id = workouts_id;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
