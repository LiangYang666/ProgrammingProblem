# 查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩

select student.s_id,student.s_name,a.avg from student
inner join (
    select s_id,avg(s_score) from score
    group by s_id having avg(s_score)>=60
) a
on student.id=a.s_id

























create table visit_table
( visit_date varchar(20) comment '访问日期' ,
  visit_time varchar(20)  comment '访问时间',
  user_id bigint comment '用户');


insert into visit_table values ( '2022-08-02' , '2022-08-02 00:02:05',  111 );
insert into visit_table values ( '2022-08-02' , '2022-08-02 00:04:02' , 111   );
insert into visit_table values ( '2022-08-02' , '2022-08-02 00:05:32' , 111  );
insert into visit_table values ( '2022-08-02' , '2022-08-02 00:24:59' , 222   );
insert into visit_table values ( '2022-08-02' , '2022-08-02 00:26:56' , 222  );
insert into visit_table values ( '2022-08-02' , '2022-08-02 00:31:41' , 111 );
insert into visit_table values ( '2022-08-01' , '2022-08-01 00:32:29' , 111   );
insert into visit_table values ( '2022-08-01' , '2022-08-01 00:41:40' , 111  );
insert into visit_table values ( '2022-08-03' , '2022-08-03 00:45:47' , 111    );
insert into visit_table values ( '2022-08-03' , '2022-08-03 00:49:29' , 111  );

select user_id, count(user_id) from visit_table group by visit_date


where visit_date between '2020-08-01' and '2020-08-03';
select user_id from
(select * from visit_table where visit_date between '2020-08-01' and '2020-08-03') a
where count(a.visit_date)>=2
group by a.visit_date;

select user_id from
visit_table
where count(visit_date)>=2
group by visit_date;

select user_id from visit_table;


select t.user_id, count(t.user_id) from
(select * from visit_table where visit_date between '2022-08-01' and '2022-08-03') t
group by t.user_id
having count(t.user_id)>=2;

select t.user_id, count(t.visit_date) from
    (select * from visit_table where visit_date between '2022-08-01' and '2022-08-03') t
group by visit_date;

(select user_id from
    (select * from visit_table where visit_date='2022-08-01') t1
group by user_id) tt1
union
(select t2.user_id from
    (select * from visit_table where visit_date='2022-08-02') t2
 group by t2.user_id) tt2;
