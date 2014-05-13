package edu.utep.cs.cs4390.getfit;
/**
 * used to display data in the profileView. This includes 
 * measurements for weight, height, waist, chest, neck, arms, and others.
 */ 
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
	/**
	 * returns the id of the measurable
	 * @return the id
	 */ 
	public int getId() {
		return id;
	}
	/** sets the id of the object
	 * @param id the id to set
	 */ 
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * gets the name of the measurable
	 * @return the name of the object
	 */ 
	public String getName() {
		return name;
	}
	/**
	 * sets the name of the measurable object
	 * @param the name to set
	 */ 
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * gets the measurement of the object
	 * @return the measurement
	 */ 
	public int getMeasurement() {
		return measurement;
	}
	/**
	 * sets the measurement of the measurable object
	 * @param the measurement to set
	 */ 
	public void setMeasurement(int measurement) {
		this.measurement = measurement;
	}
	
}
