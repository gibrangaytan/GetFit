package edu.utep.cs.cs4390.getfit;

public class Routine {
	int id;
	String name;
	public Routine(){
		
	}
	public Routine(int id, String name){
		this.id = id;
		this.name = name;
	}
	public int getId(){
		return this.id;
	}
	public String name(){
		return this.name;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}	
	

}
