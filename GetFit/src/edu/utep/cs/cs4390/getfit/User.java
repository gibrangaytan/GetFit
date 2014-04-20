package edu.utep.cs.cs4390.getfit;

/*
CREATE  TABLE  IF NOT EXISTS "users" (
"id" int(3) NOT NULL, 
"name" VARCHAR(40), 
"age" int(2), 
"weight" int(2), 
"height" int(2), 
"bodyfat" int(2),
PRIMARY KEY ("id")
)
*/
public class User {
	int id;
	String name;
	int age, weight, height, bodyfat;
	//Exercise
	//Group
	//Media
	public User(){}
	public User(int id){
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
