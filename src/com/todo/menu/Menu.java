package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println("\n    ���α׷� ���");
        System.out.println("�׸� �߰��ϱ� ( add )");
        System.out.println("�׸� �����ϱ� ( del )");
        System.out.println("�׸� �����ϱ�  ( edit )");
        System.out.println("��ü �׸񺸱� ( ls )");
        System.out.println("��ü ī�װ����� ( ls_cate )");
        System.out.println("����, ���� - Ű���� �˻��ϱ� ( find <Ű����> )");
        System.out.println("ī�װ� - Ű���� �˻��ϱ� ( find_cate <Ű����> )");
        System.out.println("���� ������ �����ϱ� ( ls_name )");
        System.out.println("���� �������� �����ϱ� ( ls_name_desc )");
        System.out.println("�Է� ������ �����ϱ� ( ls_date )");
        System.out.println("�Է� �������� �����ϱ� ( ls_date_desc )");
        System.out.println("�׸� �Ϸ��ϱ� ( comp <Ű����> )");
        System.out.println("�Ϸ�� �׸� ����ϱ� ( ls_comp )");
        System.out.println("�߿䵵 ǥ���ϱ� ( import <Ű����> )");
        System.out.println("�ҿ�ð� �����ϱ� ( durat <Ű����> )");
        System.out.println("��ҿ� ���̺��� ( place )");
        System.out.println("json���� ���� ( json_out )");
        System.out.println("json �ҷ����� ( json_in )");
        System.out.println("���� ����! ( Today )");
        System.out.println("������ ( exit )");
    }
    public static void prompt() {
        System.out.print("\n��ɾ �Է��� �ּ��� > ");
    }
}
