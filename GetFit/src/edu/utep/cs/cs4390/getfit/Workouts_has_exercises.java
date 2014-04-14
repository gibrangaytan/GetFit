package edu.utep.cs.cs4390.getfit;

public class Workouts_has_exercises {
	int wha_id;
	int workouts_id;
	int exercieses_id;
	int reps, sets, ordinal;

	public Workouts_has_exercises(int wha_id, int workouts_id,
			int exercieses_id, int reps, int sets, int ordinal) {
		super();
		this.wha_id = wha_id;
		this.workouts_id = workouts_id;
		this.exercieses_id = exercieses_id;
		this.reps = reps;
		this.sets = sets;
		this.ordinal = ordinal;
	}
	public int getWha_id() {
		return wha_id;
	}
	public void setWha_id(int wha_id) {
		this.wha_id = wha_id;
	}
	public int getWorkouts_id() {
		return workouts_id;
	}
	public void setWorkouts_id(int workouts_id) {
		this.workouts_id = workouts_id;
	}
	public int getExercieses_id() {
		return exercieses_id;
	}
	public void setExercieses_id(int exercieses_id) {
		this.exercieses_id = exercieses_id;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets = sets;
	}
	public int getOrdinal() {
		return ordinal;
	}
	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}
	
}
