package edu.utep.cs.cs4390.getfit;

public class Routines_has_exercises {
	int routine_id;
	int exercise_id;
	int sets;
	int reps;
	int weight;
	String name;
	public Routines_has_exercises(){
		
	}
    public Routines_has_exercises(int r, int e, int s, int re, int w, String n){
    	this.routine_id = r;
    	this.reps = re;
    	this.exercise_id = e;
    	this.sets = s;
    	this.weight = w;
    	this.name = n;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoutine_id() {
		return routine_id;
	}
	public void setRoutine_id(int routine_id) {
		this.routine_id = routine_id;
	}
	public int getExercise_id() {
		return exercise_id;
	}
	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets = sets;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	

}
