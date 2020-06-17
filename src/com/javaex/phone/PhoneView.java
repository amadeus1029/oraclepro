package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneView {
    private Scanner sc;

    public PhoneView() {
        this.sc = new Scanner(System.in);
    }

    public void showStart() {
        System.out.println("*****************************************");
        System.out.println("*            전화번호 관리 프로그램           *");
        System.out.println("*****************************************");
    }

    public int showMenu() {
        System.out.println("");
        System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
        System.out.println("-----------------------------------------");
        System.out.print(">메뉴번호: ");
        return sc.nextInt();
    }

    public void showList(List<PersonVo> personList) {
        System.out.println("<1.리스트>");
        int i = 1;
        for (PersonVo p : personList) {
            System.out.println(i + "." + p.showInfo());
            i++;
        }
    }
    // 검색결과를 가져와 화면에 출력하는 메소드
    public void showList(List<PersonVo> personList, String keyword) {
        int i = 1;
        boolean result = false;
        for (PersonVo p : personList) {
            if(p.getName().contains(keyword) || p.getHp().contains(keyword) || p.getCompany().contains(keyword)) {
                System.out.println(i + "." + p.showInfo());
                result = true;
            }
            i++;
        }
        if(!result) {
            System.out.println("[일치하는 결과 없습니다.]");
        }
    }

    public PersonVo showAdd() {
        sc.nextLine();
        System.out.println("<2.등록>");
        System.out.print(">이름: ");
        String name = sc.nextLine();
        System.out.print(">휴대전화: ");
        String hp = sc.nextLine();
        System.out.print(">회사번호: ");
        String company = sc.nextLine();
        return new PersonVo(name,hp,company);
    }

    public void showAddResult() {
        System.out.println("[1건 등록되었습니다.]");
    }

    public PersonVo showUpdate() {
        sc.nextLine();
        System.out.println("<3.수정>");
        System.out.print(">번호: ");
        int personId = sc.nextInt();
        System.out.print(">이름: ");
        String name = sc.nextLine();
        System.out.print(">휴대전화: ");
        String hp = sc.nextLine();
        System.out.print(">회사번호: ");
        String company = sc.nextLine();
        return new PersonVo(personId,name,hp,company);
    }

    public void showUpdateResult() {
        System.out.println("[1건 수정되었습니다.]");
    }

    public int showDel() {
        System.out.println("<4.식제>");
        System.out.print(">번호 : ");
        return sc.nextInt();
    }

    public void showDelResult() {
        System.out.println("[1건 삭제되었습니다.]");
    }

    public String showSearch() {
        sc.nextLine();
        System.out.println("<5.검색>");
        System.out.print(">이름: ");
        return sc.nextLine();
    }

    public void showEtc() {
        System.out.println("[다시 입력해 주세요.]");
    }

    public void showEnd() {
        System.out.println("===================================");
        System.out.println("*             감사합니다             *");
        System.out.println("===================================");
        sc.close();
    }
}
