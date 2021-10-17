package com.todo.dao;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TodoItem {
    private String title;
    private String desc;
    private String current_date;
    private String category;
    private int is_completed;
	private int importance;
    private String duration;
	private String due_date;
    private transient int Id;
    private String place;
    
    public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getIs_completed() {
		return is_completed;
	}
	public void setIs_completed(int is_completed) {
		this.is_completed = is_completed;
	}
    public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

    public TodoItem(String title, String desc,String category, String due_date, int importance, String duration ){
    	this.category = category;
        this.title=title;
        this.desc=desc;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/dd kk:mm:ss");
        this.current_date= f.format(new Date());
        this.due_date = due_date;
        this.is_completed = 0;
        this.importance = importance;
        this.duration= duration;
    }
    public TodoItem(String title, String desc,String category, String due_date, int is_completed){
    	this.category = category;
        this.title=title;
        this.desc=desc;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/dd kk:mm:ss");
        this.current_date= f.format(new Date());
        this.due_date = due_date;
        this.is_completed = is_completed;
    }
    public TodoItem(String title, String desc,String category, String due_date, int is_completed, int importance, String duration){
    	this.category = category;
        this.title=title;
        this.desc=desc;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/dd kk:mm:ss");
        this.current_date= f.format(new Date());
        this.due_date = due_date;
        this.is_completed = is_completed;
        this.importance = importance;
        this.duration = duration;
    }
    
    public TodoItem(String title, String desc,String category, String due_date, int is_completed, int importance, String duration,String place){
    	this.category = category;
        this.title=title;
        this.desc=desc;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/dd kk:mm:ss");
        this.current_date= f.format(new Date());
        this.due_date = due_date;
        this.is_completed = is_completed;
        this.importance = importance;
        this.duration = duration;
        this.place = place;
    }
    public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
        return current_date;
    }

    @Override
	public String toString() {
    	String open= "";
    	if(this.is_completed == 1) open = "[v]" ;
    	for(int i=0;i<importance;i++) {
    		System.out.print("★");
    		
    	}
		return " "+this.Id + " ["+this.category +"] "+this.title+ open+" - "+this.desc + " - "+this.due_date +" - "+ this.current_date +" 예상 소모 시간: "+ this.duration;
	}
    
    public String toString2() {
    	System.out.println("장소는 > "+place);
    	String open= "";
    	if(this.is_completed == 1) open = "[v]" ;
    	for(int i=0;i<importance;i++) {
    		System.out.print("★");
    		
    	}
		return " "+this.Id + " ["+this.category +"] "+this.title+ open+" - "+this.desc + " - "+this.due_date +" - "+ this.current_date +" 예상 소모 시간: "+ this.duration;
	}
    
	public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }
	
}
