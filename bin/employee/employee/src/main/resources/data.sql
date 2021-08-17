create table employee
(
id integer not null,
name varchar(100) not null,
location varchar (100),
birth_date timestamp,
primary key(id)
);

insert into employee (id,name,location,birth_date)
values(1,'sejal','hyderabad',sysdate());

insert into employee (id,name,location,birth_date)
values(2,'archit','delhi',sysdate());

insert into employee (id,name,location,birth_date)
values(3,'saloni','kolkata',sysdate());

insert into employee (id,name,location,birth_date)
values(4,'saurabh','ranchi',sysdate());
