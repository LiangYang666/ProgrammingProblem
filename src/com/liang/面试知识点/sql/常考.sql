# 查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩

select student.s_id,student.s_name,a.avg from student
inner join (
    select s_id,avg(s_score) from score
    group by s_id having avg(s_score)>=60
) a
on student.id=a.s_id