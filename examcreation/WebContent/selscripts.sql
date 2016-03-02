	select * from aditya.questions;
select * from aditya.subjects;
select * from aditya.students;
select * from aditya.studentmarks;
select * from aditya.questionpapers;
select * from aditya.examquestions;
select * from aditya.questions where id IN (select questionid from aditya.examquestions where questionpaperid=34)

SELECT * from questionpapers where branch like '%ECE%' and subject like '%Java%' and studyYear = 1;

select * from aditya.questions  inner join  aditya.examquestions  on aditya.questions.question =  examquestions.questionid where questionpaperid=2;

select * from aditya.questions where id IN (select questionid from aditya.examquestions where questionpaperid=7)
select * from aditya.Students  where  branch like '%ECE%' and yearjoined like '%2015%';
select * from aditya.subjects ;
select subject from aditya.subjects where branch = 'ECE';

select * from aditya.MCQ  where type like '%MCQ%' and branch like '%ECE%' and yearjoined =1 and subject like '%JAVA%' and semester =1 ;

SELECT E.firstname, E.rollnumber, D.subject,D.semester,D.internal1,D.internal2,D.finalmarks          
FROM aditya.students E, aditya.studentmarks D
WHERE E.id  = D.studentid and branch="ECE" and semester=1 and subject="JAVA"
