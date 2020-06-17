package com.javaex.phone;

import java.util.List;


public class PhoneApp {
    public static void main(String[] args) {

        PhoneView phoneView = new PhoneView();
        PhoneDao phoneDao = new PhoneDao();
        List<PersonVo> personList;

        boolean run = true;

        phoneView.showStart();

        while (run) {
            int menuNum = phoneView.showMenu();

            switch (menuNum) {

                case 1:
                    personList = phoneDao.getPersonList();
                    phoneView.showList(personList);
                    break;

                case 2:
                    PersonVo personVo = phoneView.showAdd();
                    phoneDao.personInsert(personVo);
                    phoneView.showAddResult();
                    break;

                case 3:
                    personVo = phoneView.showUpdate();
                    phoneDao.personUpdate(personVo);
                    phoneView.showUpdateResult();
                    break;

                case 4:
                    int delNo = phoneView.showDel();
                    phoneDao.personDelete(delNo);
                    phoneView.showDelResult();
                    break;

                case 5:
                    String keyword = phoneView.showSearch();
                    personList = phoneDao.getPersonList();
                    phoneView.showList(personList, keyword);
                    break;

                case 6:
                    phoneView.showEnd();
                    run = false;
                    break;

                default:
                    phoneView.showEtc();
                    break;
            }
        }
    }
}
