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
		
		System.out.print("[항목 추가]\n"
				+ "제목 > ");
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.println("중복된 제목입니다!");
			return;
		}
		System.out.print("카테고리 > ");
		category = sc.next();
		sc.nextLine();
		System.out.print("내용 > ");
		desc = sc.nextLine().trim();
		System.out.print("마감일자 > ");
		due_date = sc.nextLine().trim();
		System.out.print("중요도 > ");
		int importance = sc.nextInt();
		System.out.print("걸리는 시간 > ");
		sc.nextLine();
		String duration = sc.nextLine().trim();
		TodoItem t = new TodoItem(title, desc, category, due_date,importance, duration);
		if(list.addItem(t)>0)
			System.out.println("추가되었습니다.");
	}
	

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[항목 삭제]\n"
				+"삭제할 항목의 번호를 입력하시오 > ");
		int index = sc.nextInt();
		if (l.deleteItem(index)>0)
			System.out.print("삭제되었습니다.\n");
	}

	public static void deletecomp(TodoList l) {
		int count=0;
		for (TodoItem item : l.getList()) {
			if(item.getIs_completed() == 1) {
				if (l.deleteItem(item.getId())>0)
					count++;
			}
		}
		System.out.printf("\n총 %d개의 항목을 삭제했습니다.\n",count);
	}

	public static void updateItem(TodoList l) {
		String new_category,new_title, new_desc, new_due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[항복 수정]\n"
				+"수정할 항목의 번호를 입력하시오 > ");
		
		int index = sc.nextInt();
		
		System.out.print("새 항목 > ");
		new_title = sc.next().trim();
		System.out.print("새 카테고리 > ");
		new_category = sc.next();
		sc.nextLine();
		System.out.print("새 내용 > ");
		new_desc = sc.nextLine().trim();
		System.out.print("새 마감일자 > ");
		new_due_date = sc.nextLine().trim();
		System.out.print("새 중요도 > ");
		int new_importance = sc.nextInt();
		System.out.print("새 걸리는 시간 > ");
		sc.nextLine();
		String new_duration = sc.nextLine().trim();
		TodoItem t = new TodoItem(new_title, new_desc, new_category, new_due_date,new_importance, new_duration);
		t.setId(index);
		if(l.updateItem(t) > 0)
			System.out.println("수정되었습니다.");
		
	}
	public static void listCateAll(TodoList l) {
		int count=0;
		for (String item : l.getCategories()) {
			System.out.print(item + " ");
			count++;
		}
		System.out.printf("\n총 %d개의 카테고리가 등록되어 있습니다.",count);
		
	}

	public static void listAll(TodoList l) {
		System.out.printf("[전체 목록, 총 %d개]\n", l.getCount());
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
		System.out.printf("총 %d개의 항목을 찾았습니다.\n",count);
	}
	public static void findplace(TodoList l) {
		int count=0;
		for (TodoItem item : l.getListplace()) {
			System.out.println(item.toString2());
			count++;
		}
		System.out.printf("총 %d개의 항목을 찾았습니다.\n",count);
	}
	public static void findCateList(TodoList l,String cate) {
		int count=0;
		for (TodoItem item : l.getListCategory(cate)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("\n총 %d개의 항목을 찾았습니다.\n",count);
	}
	
	public static void listAll(TodoList l, String orderby, int ordering) {
		System.out.printf("[전체 목록, 총 %d개]\n", l.getCount());
		for (TodoItem item : l.getOrderedList(orderby, ordering)) {
			System.out.println(item.toString());
		}
	}
	
	public static void completeItem(TodoList l, int comp) {
		if(l.compItem(comp)>0)
			System.out.println("완료 체크하였습니다.\n");
		
	}
	
	public static void importItem(TodoList l, int com) {

		Scanner sc = new Scanner(System.in);
		System.out.print("새 중요도 > ");
		int importance = sc.nextInt();
		if(l.importItem(com,importance)>0)
			System.out.println("중요도 변경하였습니다.\n");
		
	}
	
	public static void duratItem(TodoList l, int com) {

		Scanner sc = new Scanner(System.in);
		System.out.print("새 소요시간 > ");
		String duration = sc.nextLine().trim();
		if(l.duratItem(com,duration)>0)
			System.out.println("소요시간 변경하였습니다.\n");
		
	}
	
	public static void complistAll(TodoList l) {
		int count =0;
		for (TodoItem item : l.getComp()) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("\n총 %d개의 항목을 찾았습니다.\n",count);
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
		System.out.println("파일에 저장되었습니다.");
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
		System.out.println("파일에서 데이터를 가져왔습니다.");
		
		TodoItem[] list = gson.fromJson(jsonstr2, TodoItem[].class);
		List<TodoItem> list1 = Arrays.asList(list);
		for(TodoItem item: list1) {
			System.out.println(item);
		}
		System.out.println("위 항목들을 데이터베이스에 넣겠습니까? (y , n)");
		String answer = sc.next().trim();
		int count=0;
		if(answer.equalsIgnoreCase("y")) {
			for(TodoItem item: list1) {
				if(l.addItem(item)>0)
					count++;
			}
		}
		System.out.printf("\n총 %d개의 항목을 추가했습니다.\n",count);
	}
	
	public static void Today(TodoList l){
		try {
	
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println(f.format(new Date())+" 금일 해야 할 리스트 입니다.");
		String today = f.format(new Date());
		for(TodoItem item: l.getListtoday()) {
			if(item.getDue_date().equals(f.format(new Date()))) {
				System.out.println(item.toString());
			}
		}
		Date date1;
			date1 = f.parse(today);
		System.out.println("\n아직 하지 않은 리스트 입니다! ");
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
