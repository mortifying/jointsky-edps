create table env_qty (
  id int unsigned auto_increment,
  name varchar(20) unique not null,
  max_value int(10) not null,
  min_value int(10) not null,
  primary key(id)
);

insert into env_qty (name,max_value, min_value) values ('so2', 39, 10 );
insert into env_qty (name,max_value, min_value) values ('nox', 49, 20 );