insert into user(id,username,password,role) values (1,'admin','admin','USER');

insert into subjects(id,code,name) values (36,'bb2n4n07','Növényélettani vizsgálómódszerek II. GY');
insert into rooms(id,room) values (26,'Déli Tömb 4-428 Paál Árpád terem');
insert into courses(id,subject_id,instructor,day,start_time,end_time,room_id,subject_type,course_code) values (48,36,'Pólya Sára,Solti Ádám Dr.,Rudnóy Szabolcs Dr.,Bratek Zoltán Dr.,Fodor Ferenc Dr.,Nyitrai Péter Dr.,Parádi István Dr.','Péntek','14:00','18:00',26,'gyakorlat',1);

insert into subjects(id,code,name) values (0,'lh5t1029','Kompetenciaalapú földrajztanítás');
insert into rooms(id,room) values (0,'Déli Tömb 1-225 Bulla Béla terem (FFI-TF zárt)');
insert into courses(id,subject_id,instructor,day,start_time,end_time,room_id,subject_type,course_code) values (1,0,'Koszegi Margit','Hétfo','11:00','12:00',0,'gyakorlat',2);

insert into timetable(id,owner_id) values (1,1);

insert into timetable_course(timetable_id,course_id) values(1,48);
insert into timetable_course(timetable_id,course_id) values(1,1);