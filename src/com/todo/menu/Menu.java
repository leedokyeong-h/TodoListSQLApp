package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println("\n    프로그램 기능");
        System.out.println("항목 추가하기 ( add )");
        System.out.println("항목 제거하기 ( del )");
        System.out.println("항목 편집하기  ( edit )");
        System.out.println("전체 항목보기 ( ls )");
        System.out.println("전체 카테고리보기 ( ls_cate )");
        System.out.println("제목, 설명 - 키워드 검색하기 ( find <키워드> )");
        System.out.println("카테고리 - 키워드 검색하기 ( find_cate <키워드> )");
        System.out.println("제목 순으로 나열하기 ( ls_name )");
        System.out.println("제목 역순으로 나열하기 ( ls_name_desc )");
        System.out.println("입력 순으로 나열하기 ( ls_date )");
        System.out.println("입력 역순으로 나열하기 ( ls_date_desc )");
        System.out.println("항목 완료하기 ( comp <키워드> )");
        System.out.println("완료된 항목만 출력하기 ( ls_comp )");
        System.out.println("중요도 표시하기 ( import <키워드> )");
        System.out.println("소요시간 변경하기 ( durat <키워드> )");
        System.out.println("장소와 같이보기 ( place )");
        System.out.println("json으로 저장 ( json_out )");
        System.out.println("json 불러오기 ( json_in )");
        System.out.println("오늘 할일! ( Today )");
        System.out.println("나가기 ( exit )");
    }
    public static void prompt() {
        System.out.print("\n명령어를 입력해 주세요 > ");
    }
}
