package com.javaex.phone;

import java.util.List;

public class PhoneApp {
    public static void main(String[] args) {
        PhoneDao phoneDao = new PhoneDao();
        List<PersonVo> personList = phoneDao.getPersonList();

        PersonVo person01 = new PersonVo("이효리","010-1111-1111","02-1111-1111");
        PersonVo person02 = new PersonVo("정우성","010-2222-2222","02-2222-2222");
        PersonVo person03 = new PersonVo("유재석","010-3333-3333","02-3333-3333");
        PersonVo person04 = new PersonVo("이정재","010-4444-4444","02-4444-4444");
        PersonVo person05 = new PersonVo("서장훈","010-5555-5555","02-5555-5555");

        phoneDao.personInsert(person01);
        phoneDao.personInsert(person02);
        phoneDao.personInsert(person03);
        phoneDao.personInsert(person04);
        phoneDao.personInsert(person05);

        PersonVo person06 = new PersonVo(4,"이정재","010-9999-9999","02-9999-9999");
        phoneDao.personUpdate(person06);

        phoneDao.personDelete(5);

    }
}
