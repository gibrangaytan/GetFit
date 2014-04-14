package edu.utep.cs.cs4390.getfit;

public class Muscle {
	private int id;
	private String name;
	
	public Muscle(){
	}
	public Muscle(int id, String name){
		this.id = id;
		this.name = name;
	}
	public int getID(){
		return this.id;
	}
	public String name(){
		return this.name;
	}
	public void setID(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}	
}
