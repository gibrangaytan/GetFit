package edu.utep.cs.cs4390.getfit;

public class Measurable {
	private int id;
	private String name;
	private int measurement;
	public Measurable(){
		
	}
	public Measurable(int id, String name, int measurement){
		this.id = id;
		this.name = name;
		this.measurement = measurement;
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
	public int getMeasurement() {
		return measurement;
	}
	public void setMeasurement(int measurement) {
		this.measurement = measurement;
	}
	
}