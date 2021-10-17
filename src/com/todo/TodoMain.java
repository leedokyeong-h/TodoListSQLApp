package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
	
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		//l.importData("todolist.txt");
		boolean quit = false;
		Menu.displaymenu();
		do {
			Menu.prompt();
			String choice = sc.next();
			switch (choice) {

			case "add":
				TodoUtil.createItem(l);
				
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;

			case "ls_name":
				System.out.println("제목순으로 정렬하셨습니다.");
				TodoUtil.listAll(l, "title",1);	
				break;

			case "ls_name_desc":
				System.out.println("제목역순으로 정렬하셨습니다.");
				TodoUtil.listAll(l, "title",0);
				break;
				
			case "ls_date":
				System.out.println("날짜순으로 정렬하였습니다.");
				TodoUtil.listAll(l, "due_date", 1);
				break;
				
			case "ls_date_desc":
				System.out.println("날짜역순으로 정렬하였습니다.");
				TodoUtil.listAll(l, "due_date", 0);
				break;

			case "exit":
				quit = true;
				System.out.print("프로그램이 종료됩니다\n");
				break;
			
			case "help":
				Menu.displaymenu();
				break;
			
			case "find":
				String keyword = sc.nextLine().trim();
				TodoUtil.findList(l, keyword);
				break;
			
			case "find_cate":
				String cate = sc.nextLine().trim();
				TodoUtil.findCateList(l,cate);
				break;
				
			case "ls_cate":
				TodoUtil.listCateAll(l);
				break;
			
			case "comp":
				int comp = sc.nextInt();
				TodoUtil.completeItem(l,comp);
				break;
				
			case "ls_comp":
				TodoUtil.complistAll(l);
				break;
			case "import" :
				int com = sc.nextInt();
				TodoUtil.importItem(l,com);
				break;
				
			case "durat" :
				int coms = sc.nextInt();
				TodoUtil.duratItem(l, coms);
				break;
			case "place" :
				TodoUtil.findplace(l);
				break;
			case "comp_del" :
				TodoUtil.deletecomp(l);
				break;
			case "json_out" :
				TodoUtil.json_out(l);
				break;
			case "json_in" :
				TodoUtil.json_in(l);
				break;
				
			case "Today" :
				TodoUtil.Today(l);
				break;
			
			default:	
				System.out.println("해당 명령어가 없습니다. 다시 입력해 주세요! [ 기능 보기 ( help ) ]");
				break;
			}
			
		} while (!quit);
	}
}
