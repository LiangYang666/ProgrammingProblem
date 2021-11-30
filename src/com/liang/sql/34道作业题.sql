show databases;
create database study34;
use study34;
DROP TABLE IF EXISTS EMP;
DROP TABLE IF EXISTS DEPT;
DROP TABLE IF EXISTS SALGRADE;

CREATE TABLE DEPT
(DEPTNO int(2) not null ,
 DNAME VARCHAR(14) ,
 LOC VARCHAR(13),
 primary key (DEPTNO)
);

CREATE TABLE EMP
(EMPNO int(4)  not null ,
 ENAME VARCHAR(10),
 JOB VARCHAR(9),
 MGR INT(4),
 HIREDATE DATE  DEFAULT NULL,
 SAL DOUBLE(7,2),
 COMM DOUBLE(7,2),
 primary key (EMPNO),
 DEPTNO INT(2)
);

CREATE TABLE SALGRADE
( GRADE INT,
  LOSAL INT,
  HISAL INT );


INSERT INTO DEPT ( DEPTNO, DNAME, LOC ) VALUES (
                                                   10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT ( DEPTNO, DNAME, LOC ) VALUES (
                                                   20, 'RESEARCH', 'DALLAS');
INSERT INTO DEPT ( DEPTNO, DNAME, LOC ) VALUES (
                                                   30, 'SALES', 'CHICAGO');
INSERT INTO DEPT ( DEPTNO, DNAME, LOC ) VALUES (
                                                   40, 'OPERATIONS', 'BOSTON');
commit;

INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7369, 'SMITH', 'CLERK', 7902,  '1980-12-17'
                                  , 800, NULL, 20);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7499, 'ALLEN', 'SALESMAN', 7698,  '1981-02-20'
                                  , 1600, 300, 30);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7521, 'WARD', 'SALESMAN', 7698,  '1981-02-22'
                                  , 1250, 500, 30);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7566, 'JONES', 'MANAGER', 7839,  '1981-04-02'
                                  , 2975, NULL, 20);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7654, 'MARTIN', 'SALESMAN', 7698,  '1981-09-28'
                                  , 1250, 1400, 30);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7698, 'BLAKE', 'MANAGER', 7839,  '1981-05-01'
                                  , 2850, NULL, 30);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7782, 'CLARK', 'MANAGER', 7839,  '1981-06-09'
                                  , 2450, NULL, 10);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7788, 'SCOTT', 'ANALYST', 7566,  '1987-04-19'
                                  , 3000, NULL, 20);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7839, 'KING', 'PRESIDENT', NULL,  '1981-11-17'
                                  , 5000, NULL, 10);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7844, 'TURNER', 'SALESMAN', 7698,  '1981-09-08'
                                  , 1500, 0, 30);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7876, 'ADAMS', 'CLERK', 7788,  '1987-05-23'
                                  , 1100, NULL, 20);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7900, 'JAMES', 'CLERK', 7698,  '1981-12-03'
                                  , 950, NULL, 30);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7902, 'FORD', 'ANALYST', 7566,  '1981-12-03'
                                  , 3000, NULL, 20);
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
                  DEPTNO ) VALUES (
                                      7934, 'MILLER', 'CLERK', 7782,  '1982-01-23'
                                  , 1300, NULL, 10);
commit;

INSERT INTO SALGRADE ( GRADE, LOSAL, HISAL ) VALUES (
                                                        1, 700, 1200);
INSERT INTO SALGRADE ( GRADE, LOSAL, HISAL ) VALUES (
                                                        2, 1201, 1400);
INSERT INTO SALGRADE ( GRADE, LOSAL, HISAL ) VALUES (
                                                        3, 1401, 2000);
INSERT INTO SALGRADE ( GRADE, LOSAL, HISAL ) VALUES (
                                                        4, 2001, 3000);
INSERT INTO SALGRADE ( GRADE, LOSAL, HISAL ) VALUES (
                                                        5, 3001, 9999);
commit;


# =================================================================///
# 1、取得每个部门最高薪水的人员名称
select d.* from DEPT d;
select  d.DNAME, max(SAL) from EMP e join DEPT d on e.DEPTNO=d.DEPTNO group by DNAME;
select d.DNAME, t.*
from
     (select e.DEPTNO, max(SAL) from EMP e group by e.DEPTNO) t
join DEPT d on t.DEPTNO=d.DEPTNO;

select e.ENAME, t.*
from  EMP e
join
(select e.DEPTNO, max(SAL) max_sal from EMP e group by e.DEPTNO) t
on t.max_sal=e.SAL and t.DEPTNO=e.DEPTNO;

# 2、哪些人的薪水在部门的平均薪水之上
select e.ENAME
from EMP e join
(select e.DEPTNO, avg(e.SAL) avgsal from EMP e group by e.DEPTNO) t
on e.DEPTNO=t.DEPTNO
where e.SAL>=t.avgsal;

# 3.取得部门中（所有人的）平均的薪水等级
select * from SALGRADE;
select DEPTNO, avg(GRADE)
from EMP e
    join SALGRADE s on (e.SAL<=s.HISAL and e.SAL>=s.LOSAL)
group by e.DEPTNO;

# 4、不准用组函数（Max ），取得最高薪水
select e.SAL
from EMP e
order by
e.SAL desc
limit 0,1;

# 自连接
select e.SAL from EMP e
where e.SAL
          not in (select distinct a.SAL from EMP a
                    join EMP b on a.SAL<b.SAL);

# 5、取得平均薪水最高的部门的部门编号
select DEPTNO, avg(e.SAL) avg_sal from EMP e group by DEPTNO
order by avg_sal desc
limit 0, 1;

select max(t.avg_sal)
from
    (select avg(e.SAL) avg_sal
    from EMP e group by DEPTNO) t;

# 6、取得平均薪水最高的部门的部门名称
select d.DEPTNO, d.DNAME from
        (select DEPTNO, avg(e.SAL) avg_sal from EMP e group by DEPTNO
        order by avg_sal desc
        limit 0, 1) t
join DEPT d on d.DEPTNO=t.DEPTNO;


select d.DNAME, d.DEPTNO, avg(sal) avg_sal
from EMP e
join DEPT d on e.DEPTNO=d.DEPTNO
group by d.DEPTNO
order by avg_sal desc
limit 1;

# 7、求平均薪水的等级最低的部门的部门名称
# 平均薪水是800
# 平均薪水是900
# 那么他俩都是1级别。
select t.DNAME, t.DEPTNO, s.GRADE
from
    (select d.DNAME ,e.DEPTNO, avg(e.SAL) avg_sal
     from EMP e
              join DEPT d on e.DEPTNO = d.DEPTNO
     group by e.DEPTNO) t
join SALGRADE s on t.avg_sal<=s.HISAL and t.avg_sal>=s.LOSAL
right join
    (select min(s.GRADE) min_grade
    from
        (select d.DNAME ,e.DEPTNO, avg(e.SAL) avg_sal
        from EMP e
        join DEPT d on e.DEPTNO = d.DEPTNO
        group by e.DEPTNO) t
    join SALGRADE s on t.avg_sal<=s.HISAL and t.avg_sal>=s.LOSAL) tt
on tt.min_grade=s.GRADE;

select t.*, s.GRADE
from
    (select d.DNAME ,e.DEPTNO, avg(e.SAL) avg_sal
    from EMP e
          join DEPT d on e.DEPTNO = d.DEPTNO
    group by e.DEPTNO) t
join SALGRADE s on t.avg_sal<=s.HISAL and t.avg_sal>=s.LOSAL
where s.GRADE=
    (select min(s.GRADE) min_grade
     from
         (select d.DNAME ,e.DEPTNO, avg(e.SAL) avg_sal
          from EMP e
                   join DEPT d on e.DEPTNO = d.DEPTNO
          group by e.DEPTNO) t
             join SALGRADE s on t.avg_sal<=s.HISAL and t.avg_sal>=s.LOSAL);

# 8、取得比普通员工(员工代码没有在 mgr 字段上出现的) 的最高薪水还要高的领导人姓名
select *
from EMP e
where e.EMPNO in
      (select distinct (e.MGR)
       from EMP e where e.MGR is not null)
and e.SAL>
    (select max(e.SAL)
    from EMP e
    where e.EMPNO not in
        (select distinct (e.MGR)
        from EMP e where e.MGR is not null));

# 9、取得薪水最高的前五名员工
select e.ENAME, e.SAL
from EMP e
order by e.SAL desc
limit 0, 5;
# 10、取得薪水最高的第六到第十名员工
select e.ENAME, e.SAL
from EMP e
order by e.SAL desc
limit 5, 5;
# 11、取得最后入职的 5 名员工
select e.ENAME, e.HIREDATE
from EMP e
order by HIREDATE desc
limit 5;

# 12、取得每个薪水等级有多少员工
select s.GRADE, count(*)
from
EMP e
join SALGRADE s
on e.SAL between s.LOSAL and s.HISAL
group by s.GRADE;

# 13、面试题：
# 有 3 个表 S(学生表)，C（课程表），SC（学生选课表）
# S（SNO，SNAME）代表（学号，姓名）
# C（CNO，CNAME，CTEACHER）代表（课号，课名，教师）
# SC（SNO，CNO，SCGRADE）代表（学号，课号，成绩）
# 问题：
# 1，找出没选过“黎明”老师的所有学生姓名。
# 2，列出 2 门以上（含2 门）不及格学生姓名及平均成绩。
# 3，即学过 1 号课程又学过 2 号课所有学生的姓名。

# 14、列出所有员工及领导的姓名
select e.ENAME '员工', ep.ENAME '领导'
from EMP e
join EMP ep
on e.MGR=ep.EMPNO;

# 15、列出受雇日期早于其直接上级的所有员工的编号,姓名,部门名称
select e.ENAME,d.DNAME  
from EMP e
join EMP b
on e.MGR=b.EMPNO
join DEPT d
on e.DEPTNO=d.DEPTNO
where e.HIREDATE<b.HIREDATE;

# 16、 列出部门名称和这些部门的员工信息, 同时列出那些没有员工的部门
select d.DNAME, e.*
from EMP e
right join DEPT d
on e.DEPTNO=d.DEPTNO;

# 17、列出至少有 5 个员工的所有部门
# 按照部门编号分组，计数，筛选出 >= 5
select *
from
    (select d.DNAME, count(*) total
    from EMP e
    join DEPT d on e.DEPTNO = d.DEPTNO
    group by e.DEPTNO)  t
where t.total>=5;

# 使用having
select d.DNAME, count(*) total
from EMP e
join DEPT d on e.DEPTNO=d.DEPTNO
group by e.DEPTNO
having total>=5;

# 18、列出薪金比"SMITH" 多的所有员工信息
select e.ENAME, e.SAL
from EMP e
where e.SAL>
    (select e.SAL
    from EMP e
    where e.ENAME='SMITH');

select a.ENAME, a.SAL
from EMP a
join EMP b
on b.ENAME='SMITH'
where a.SAL>b.SAL;

# 19、 列出所有"CLERK"( 办事员) 的姓名及其部门名称, 部门的人数
select e.ENAME, t.DNAME, t.total
from EMP e
join
     (select d.DEPTNO, d.DNAME, count(*) total
      from EMP e
               join DEPT d
                    on e.DEPTNO=d.DEPTNO
      group by e.DEPTNO) t
on e.DEPTNO=t.DEPTNO
where e.JOB='CLERK';

# 20、列出最低薪金大于 1500 的各种工作及从事此工作的全部雇员人数
select e.JOB, min(e.SAL) min_sal, count(*) total
from EMP e
group by e.JOB
having min_sal>1500;

# 21、列出在部门"SALES"< 销售部> 工作的员工的姓名, 假定不知道销售部的部门编号.
select d.DNAME, e.ENAME
from EMP e
join DEPT d
on e.DEPTNO=d.DEPTNO
where d.DNAME='SALES';

select e.ENAME
from EMP e
where e.DEPTNO=(select DEPTNO from DEPT where DNAME='SALES');

# 22、列出薪金高于公司平均薪金的所有员工, 所在部门, 上级领导, 雇员的工资等级.

select e.ENAME, d.DNAME, b.ENAME '领导', s.GRADE
from EMP e
join DEPT d
on e.DEPTNO=d.DEPTNO
join EMP b
on e.MGR=b.EMPNO
join SALGRADE s
on e.SAL between s.LOSAL and s.HISAL
where e.SAL >= (select avg(SAL) from EMP);

# 23、 列出与"SCOTT" 从事相同工作的所有员工及部门名称
select e.ENAME, e.JOB, d.DNAME
from EMP e
join DEPT d
on e.DEPTNO=d.DEPTNO
where e.JOB=(select e.JOB from EMP e where e.ENAME='SCOTT')
and e.ENAME!='SCOTT';

# 24、列出薪金等于部门 30 中员工的薪金的其他员工的姓名和薪金.
select distinct e.SAL
from EMP e
where e.DEPTNO=30;
select *
from EMP e
where e.SAL in  (select distinct e.SAL
                 from EMP e
                 where e.DEPTNO=30)
and e.DEPTNO<>30;
select *
from EMP e
right join (select distinct e.SAL
            from EMP e
            where e.DEPTNO=30) t
on e.SAL=t.SAL
where e.DEPTNO<>30;

# 25、列出薪金高于在部门 30 工作的所有员工的薪金的员工姓名和薪金. 部门名称
select e.ENAME, e.SAL, d.DNAME
from EMP e
join DEPT d
on d.DEPTNO=e.DEPTNO
where e.SAL>(select max(e.SAL)
             from EMP e
             where e.DEPTNO=30)
and e.DEPTNO<>30;

# 26、列出在每个部门工作的员工数量, 平均工资和平均服务期限
# 没有员工的部门，部门人数是0
select d.DEPTNO, d.DNAME, ifnull(t.total, 0) , ifnull(t.avg_sal, 0), ifnull(t.服务时长, 0)
from DEPT d
left join (select e.DEPTNO, count(*) total, avg(e.SAL) avg_sal, avg(timestampdiff(year, e.HIREDATE , now())) '服务时长'
           from EMP e
           group by e.DEPTNO) t
on d.DEPTNO=t.DEPTNO;

select e.DEPTNO, ifnull(count(*), 0) total, ifnull(avg(e.SAL), 0), ifnull(avg(datediff( now(), e.HIREDATE)), 0) '服务时长'
from EMP e
group by e.DEPTNO;


# 27、 列出所有员工的姓名、部门名称和工资。
select e.ENAME, d.DNAME, e.SAL
from EMP e
join DEPT d
on d.DEPTNO=e.DEPTNO;

# 28、列出所有部门的详细信息和人数
select *
from EMP e;

select d.*, ifnull(t.total, 0) as total
from
DEPT d
left join
    (select e.DEPTNO DEPTNO, count(*) total
    from EMP e
    right join DEPT d
    on e.DEPTNO=d.DEPTNO
    group by e.DEPTNO) t
on t.DEPTNO=d.DEPTNO;

# 29、列出各种工作的最低工资及从事此工作的雇员姓名
select e.ENAME, t.*
from EMP e
right join
(select e.job, min(e.SAL) as sal
from EMP e
group by e.JOB) t
on t.sal=e.SAL and t.JOB=e.JOB;
















