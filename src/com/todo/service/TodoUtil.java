package com.todo.service;

import java.text.*;
import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.*;
import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String category,title, desc,due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[�׸� �߰�]\n"
				+ "���� > ");
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.println("�ߺ��� �����Դϴ�!");
			return;
		}
		System.out.print("ī�װ� > ");
		category = sc.next();
		sc.nextLine();
		System.out.print("���� > ");
		desc = sc.nextLine().trim();
		System.out.print("�������� > ");
		due_date = sc.nextLine().trim();
		System.out.print("�߿䵵 > ");
		int importance = sc.nextInt();
		System.out.print("�ɸ��� �ð� > ");
		sc.nextLine();
		String duration = sc.nextLine().trim();
		TodoItem t = new TodoItem(title, desc, category, due_date,importance, duration);
		if(list.addItem(t)>0)
			System.out.println("�߰��Ǿ����ϴ�.");
	}
	

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[�׸� ����]\n"
				+"������ �׸��� ��ȣ�� �Է��Ͻÿ� > ");
		int index = sc.nextInt();
		if (l.deleteItem(index)>0)
			System.out.print("�����Ǿ����ϴ�.\n");
	}

	public static void deletecomp(TodoList l) {
		int count=0;
		for (TodoItem item : l.getList()) {
			if(item.getIs_completed() == 1) {
				if (l.deleteItem(item.getId())>0)
					count++;
			}
		}
		System.out.printf("\n�� %d���� �׸��� �����߽��ϴ�.\n",count);
	}

	public static void updateItem(TodoList l) {
		String new_category,new_title, new_desc, new_due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[�׺� ����]\n"
				+"������ �׸��� ��ȣ�� �Է��Ͻÿ� > ");
		
		int index = sc.nextInt();
		
		System.out.print("�� �׸� > ");
		new_title = sc.next().trim();
		System.out.print("�� ī�װ� > ");
		new_category = sc.next();
		sc.nextLine();
		System.out.print("�� ���� > ");
		new_desc = sc.nextLine().trim();
		System.out.print("�� �������� > ");
		new_due_date = sc.nextLine().trim();
		System.out.print("�� �߿䵵 > ");
		int new_importance = sc.nextInt();
		System.out.print("�� �ɸ��� �ð� > ");
		sc.nextLine();
		String new_duration = sc.nextLine().trim();
		TodoItem t = new TodoItem(new_title, new_desc, new_category, new_due_date,new_importance, new_duration);
		t.setId(index);
		if(l.updateItem(t) > 0)
			System.out.println("�����Ǿ����ϴ�.");
		
	}
	public static void listCateAll(TodoList l) {
		int count=0;
		for (String item : l.getCategories()) {
			System.out.print(item + " ");
			count++;
		}
		System.out.printf("\n�� %d���� ī�װ��� ��ϵǾ� �ֽ��ϴ�.",count);
		
	}

	public static void listAll(TodoList l) {
		System.out.printf("[��ü ���, �� %d��]\n", l.getCount());
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
	}
	
	
	public static void findList(TodoList l,String keyword) {
		int count=0;
		for (TodoItem item : l.getList(keyword)) {
			if(item.getTitle().contains(keyword)||item.getDesc().contains(keyword)) {
				System.out.println(item.toString());
				count++;
			}
		}
		System.out.printf("�� %d���� �׸��� ã�ҽ��ϴ�.\n",count);
	}
	public static void findplace(TodoList l) {
		int count=0;
		for (TodoItem item : l.getListplace()) {
			System.out.println(item.toString2());
			count++;
		}
		System.out.printf("�� %d���� �׸��� ã�ҽ��ϴ�.\n",count);
	}
	public static void findCateList(TodoList l,String cate) {
		int count=0;
		for (TodoItem item : l.getListCategory(cate)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("\n�� %d���� �׸��� ã�ҽ��ϴ�.\n",count);
	}
	
	public static void listAll(TodoList l, String orderby, int ordering) {
		System.out.printf("[��ü ���, �� %d��]\n", l.getCount());
		for (TodoItem item : l.getOrderedList(orderby, ordering)) {
			System.out.println(item.toString());
		}
	}
	
	public static void completeItem(TodoList l, int comp) {
		if(l.compItem(comp)>0)
			System.out.println("�Ϸ� üũ�Ͽ����ϴ�.\n");
		
	}
	
	public static void importItem(TodoList l, int com) {

		Scanner sc = new Scanner(System.in);
		System.out.print("�� �߿䵵 > ");
		int importance = sc.nextInt();
		if(l.importItem(com,importance)>0)
			System.out.println("�߿䵵 �����Ͽ����ϴ�.\n");
		
	}
	
	public static void duratItem(TodoList l, int com) {

		Scanner sc = new Scanner(System.in);
		System.out.print("�� �ҿ�ð� > ");
		String duration = sc.nextLine().trim();
		if(l.duratItem(com,duration)>0)
			System.out.println("�ҿ�ð� �����Ͽ����ϴ�.\n");
		
	}
	
	public static void complistAll(TodoList l) {
		int count =0;
		for (TodoItem item : l.getComp()) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("\n�� %d���� �׸��� ã�ҽ��ϴ�.\n",count);
	}
	public static void json_out(TodoList l) {
		Gson gson = new Gson();
		String jsonstr = gson.toJson(l.getList());
		try {
			FileWriter writer = new FileWriter("Todolist.txt");
			writer.write(jsonstr);
			writer.close();
			
		}catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("���Ͽ� ����Ǿ����ϴ�.");
	}
	
	public static void json_in(TodoList l) {
		Gson gson = new Gson();
		Scanner sc = new Scanner(System.in);
		String jsonstr2 = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Todolist.txt"));
			jsonstr2 = br.readLine();
			br.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("���Ͽ��� �����͸� �����Խ��ϴ�.");
		
		TodoItem[] list = gson.fromJson(jsonstr2, TodoItem[].class);
		List<TodoItem> list1 = Arrays.asList(list);
		for(TodoItem item: list1) {
			System.out.println(item);
		}
		System.out.println("�� �׸���� �����ͺ��̽��� �ְڽ��ϱ�? (y , n)");
		String answer = sc.next().trim();
		int count=0;
		if(answer.equalsIgnoreCase("y")) {
			for(TodoItem item: list1) {
				if(l.addItem(item)>0)
					count++;
			}
		}
		System.out.printf("\n�� %d���� �׸��� �߰��߽��ϴ�.\n",count);
	}
	
	public static void Today(TodoList l){
		try {
	
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println(f.format(new Date())+" ���� �ؾ� �� ����Ʈ �Դϴ�.");
		String today = f.format(new Date());
		for(TodoItem item: l.getListtoday()) {
			if(item.getDue_date().equals(f.format(new Date()))) {
				System.out.println(item.toString());
			}
		}
		Date date1;
			date1 = f.parse(today);
		System.out.println("\n���� ���� ���� ����Ʈ �Դϴ�! ");
		for(TodoItem item: l.getListtoday()) {
			Date date2 = f.parse(item.getDue_date());
			if((date1.after(date2)) && (item.getIs_completed()==0)  ) {
				System.out.println(item.toString());
			}
			
		}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
