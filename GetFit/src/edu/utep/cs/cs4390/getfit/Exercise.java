package edu.utep.cs.cs4390.getfit;

public class Exercise {
	int id;
	String name;
	String steps;
	int types_id;
	int difficulties_id;
	int mechanics_id; 
	/*
	 * or ?
	 * Type type;
	 * Difficulty difficulty;
	 * Mechanics mechanics;
	 */
	public Exercise(){}
	
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSteps() {
		return steps;
	}
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
