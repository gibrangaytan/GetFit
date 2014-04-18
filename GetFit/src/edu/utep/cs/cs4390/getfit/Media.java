package edu.utep.cs.cs4390.getfit;

public class Media {
	int id;
	String url;
	//Item
	public Media(){}
	public Media(int id, String url) {
		super();
		this.id = id;
		this.url = url;
	}
	public int getId(){
		return this.id;
	}
	public String getUrl(){
		return this.url;
	}
	public void setId(int id){
		this.id=id;
	}
	public void setUrl(String url){
		this.url=url;
	}
}