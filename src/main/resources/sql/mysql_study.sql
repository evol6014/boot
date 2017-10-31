
select * from dept;
select * from emp;

select * from country;

update emp
   set gender = 'F'
 where gender = 'f';
commit; 

select * from tbl_dept;
select * from tbl_emp;

delete from tbl_dept where deptno = 132;

select * from tbl_dept where deptno = 50;

insert into tbl_dept
select * from dept;

insert into tbl_emp
(comm, deptno, empno, ename, gender, hiredate, job, mgr, sal)
select comm, deptno, empno, ename, gender, hiredate, job, mgr, sal from emp;

insert into tbl_city
(ID, Name, countryCode, District, Population)
select ID, Name, countryCode, District, Population from city;

insert into tbl_country
(Code, Name, Continent, Region, SurfaceArea, IndepYear, Population,LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2)
select Code, Name, Continent, Region, SurfaceArea, IndepYear, Population,LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2 from country;

insert into tbl_profile 
(fname, curr)
values
("user01_profile", 1);

select * from tbl_profile;

select * from tbl_webboard limit 0, 10;
select count(*) from tbl_webboard;

select * from id_gen; 

select * from id_gen; 

delete table tbl_webboard;

