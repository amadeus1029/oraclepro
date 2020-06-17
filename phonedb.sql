-- 테이블/시퀀스 삭제
drop table person;
drop sequence seq_person_id;


-- 테이블 생성
create table person(
    person_id   number(5),
    name        varchar2(30) not null,
    hp          varchar2(20),
    company     varchar2(20),
    PRIMARY key(person_id)
    
);

-- 시퀀스 생성
create SEQUENCE seq_person_id
    INCREMENT by 1
    start with 1;


-- 테이블 인서트
insert into person
values(seq_person_id.nextVal, '이효리','010-1111-1111','02-1111-1111');
insert into person
values(seq_person_id.nextVal, '정우성','010-2222-2222','02-2222-2222');
insert into person
values(seq_person_id.nextVal, '유재석','010-3333-3333','02-3333-3333');
insert into person
values(seq_person_id.nextVal, '이정재','010-4444-4444','02-4444-4444');
insert into person
values(seq_person_id.nextVal, '서장훈','010-5555-5555','02-5555-5555');


-- 테이블 셀렉트
select  person_id,
        name,
        hp,
        company
from    person;


-- 테이블 업데이트
update  person
set     hp = '010-9999-9999',
        company = '02-9999-9999'
where   person_id = 4;


-- 테이블 딜리트
delete  person
where   person_id = '5';