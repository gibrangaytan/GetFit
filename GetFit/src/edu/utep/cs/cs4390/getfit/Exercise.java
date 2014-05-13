package edu.utep.cs.cs4390.getfit;
/**
 * Used to save exercise data from the database into objects.
 */ 
public class Exercise {
	int id;
	String name;
	String steps;
	int types_id;
	int difficulties_id;
	int mechanics_id; 
	/**
	 * empty contructor
	 */ 
	public Exercise(){}
	/**
	 * constructor with all fields specified
	 */ 
	public Exercise(int id, String name, String steps, int types_id,
			int difficulties_id, int mechanics_id) {
		super();
		this.id = id;
		this.name = name;
		this.steps = steps;
		this.types_id = types_id;
		this.difficulties_id = difficulties_id;
		this.mechanics_id = mechanics_id;
	}
	/**
	 * returns the exercise's id
	 */ 
	public int getId() {
		return id;
	}
	/**
	 * sets the exercies's id
	 */ 
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * returns the exercise's name
	 */ 
	public String getName() {
		return name;
	}
	/**
	 * sets the exercise's name
	 */ 
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * returns the exercise's steps
	 */ 
	public String getSteps() {
		return steps;
	}
	/**
	 * sets the exercise's steps
	 */ 
	public void setSteps(String steps) {
		this.steps = steps;
	}
	public int getTypes_id() {
		return types_id;
	}
	public void setTypes_id(int types_id) {
		this.types_id = types_id;
	}
	public int getDifficulties_id() {
		return difficulties_id;
	}
	public void setDifficulties_id(int difficulties_id) {
		this.difficulties_id = difficulties_id;
	}
	public int getMechanics_id() {
		return mechanics_id;
	}
	public void setMechanics_id(int mechanics_id) {
		this.mechanics_id = mechanics_id;
	}
	
}
