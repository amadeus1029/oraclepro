package com.javaex.phone;
import java.util.List;


public class PhoneApp {
    public static void main(String[] args) {

        PhoneView phoneView = new PhoneView();
        PhoneDao phoneDao = new PhoneDao();
        List<PersonVo> personList;
        int count;

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
                    count = phoneDao.personInsert(personVo);
                    phoneView.showAddResult(count);
                    break;

                case 3:
                    personList = phoneDao.getPersonList();
                    personVo = phoneView.showUpdate(personList);
                    count = phoneDao.personUpdate(personVo);
                    phoneView.showUpdateResult(count);
                    break;

                case 4:
                    personList = phoneDao.getPersonList();
                    int delNo = phoneView.showDel(personList);
                    count = phoneDao.personDelete(delNo);
                    phoneView.showDelResult(count);
                    break;

                case 5:
                    String keyword = phoneView.showSearch();
                    personList = phoneDao.getPersonList(keyword);
                    phoneView.showSearchResult(personList);
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
