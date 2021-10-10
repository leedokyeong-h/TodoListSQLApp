package com.todo.dao;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TodoItem {
    private String title;
    private String desc;
    private String current_date;
    private String category;
    private int is_completed=0;
	
	private String due_date;
    private int Id;
    
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

    public TodoItem(String title, String desc,String category, String due_date){
    	this.category = category;
        this.title=title;
        this.desc=desc;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/dd kk:mm:ss");
        this.current_date= f.format(new Date());
        this.due_date = due_date;
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
    	if(is_completed == 1) open = "[v]" ;
		return Id + " ["+category +"] "+title+open+" - "+desc + " - "+due_date +" - "+ current_date;
	}
    
	public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }
}
