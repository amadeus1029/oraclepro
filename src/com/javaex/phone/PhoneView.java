package com.javaex.phone;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PhoneView {
    private Scanner sc;


    //입력시작
    public PhoneView() {
        this.sc = new Scanner(System.in);
    }

    //안내문구
    public void showStart() {
        System.out.println("*****************************************");
        System.out.println("*            전화번호 관리 프로그램           *");
        System.out.println("*****************************************");
    }

    //메뉴
    public int showMenu() {
        while(true) {
            try {
                System.out.println("");
                System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
                System.out.println("-----------------------------------------");
                System.out.print(">메뉴번호: ");
                return sc.nextInt();
            } catch (InputMismatchException e) {
                showEtc();
                sc.nextLine();
            }
        }
    }

    //리스트 출력
    public void showList(List<PersonVo> personList) {
        System.out.println("<1.리스트>");
        for (PersonVo p : personList) {
            System.out.println(p.showInfo());
        }
    }

    //검색 출력
    public void showList(List<PersonVo> personList, String keyword) {
        boolean result = false;
        for (PersonVo p : personList) {
            if(p.getName().contains(keyword) || p.getHp().contains(keyword) || p.getCompany().contains(keyword)) {
                System.out.println(p.showInfo());
                result = true;
            }
        }
        if(!result) {
            System.out.println("[일치하는 결과가 없습니다.]");
        }
    }

    //리스트 추가 출력
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

    //리스트 추가결과 출력
    public void showAddResult() {
        System.out.println("[1건 등록되었습니다.]");
    }

    //리스트 업데이트 출력
    public PersonVo showUpdate(List<PersonVo> personList) {
        sc.nextLine();
        System.out.println("<3.수정>");
        while(true) {
            try {
                System.out.print(">번호: ");
                int personId = sc.nextInt();
                sc.nextLine();
                boolean checkEmpty = false;
                for(PersonVo p : personList) {
                    if(p.getPersonId() == personId) {
                        checkEmpty = true;
                    }
                }
                if(!checkEmpty) {
                    System.out.println("존재하지 않는 번호입니다");
                    continue;
                }
                System.out.print(">이름: ");
                String name = sc.nextLine();
                System.out.print(">휴대전화: ");
                String hp = sc.nextLine();
                System.out.print(">회사번호: ");
                String company = sc.nextLine();
                return new PersonVo(personId,name,hp,company);
            }  catch (InputMismatchException e) {
                System.out.println("[번호는 숫자만 입력하실 수 있습니다]");
                sc.nextLine();
            }
        }
    }

    //리스트 업데이트결과 출력
    public void showUpdateResult() {
        System.out.println("[1건 수정되었습니다.]");
    }

    //리스트 삭제 출력
    public int showDel(List<PersonVo> personList) {
        System.out.println("<4.식제>");
        while(true) {
            try {
                System.out.print(">번호: ");
                int personId = sc.nextInt();
                boolean checkEmpty = false;
                for(PersonVo p : personList) {
                    if(p.getPersonId() == personId) {
                        checkEmpty = true;
                    }
                }
                if(!checkEmpty) {
                    System.out.println("존재하지 않는 번호입니다");
                    continue;
                }
                return personId;
            }  catch (InputMismatchException e) {
                System.out.println("[번호는 숫자만 입력하실 수 있습니다]");
                sc.nextLine();
            }
        }
    }

    //리스트 삭제결과 출력
    public void showDelResult() {
        System.out.println("[1건 삭제되었습니다.]");
    }

    //리스트 검색 출력
    public String showSearch() {
        sc.nextLine();
        System.out.println("<5.검색>");
        System.out.print(">검색어: ");
        return sc.nextLine();
    }

    //메뉴 입력 실수 출력
    public void showEtc() {
        System.out.println("[다시 입력해 주세요.]");
    }

    //메뉴 종료 출력
    public void showEnd() {
        System.out.println("=========================================");
        System.out.println("*                감사합니다                *");
        System.out.println("=========================================");
        sc.close();
    }
}
