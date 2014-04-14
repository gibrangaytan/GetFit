package edu.utep.cs.cs4390.getfit;

public class Mechanic {
	int id;
	String name;
	public Mechanic(){}
	
	public Mechanic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
