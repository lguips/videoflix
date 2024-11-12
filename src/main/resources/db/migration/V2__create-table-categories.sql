create table categories(
    id bigint not null auto_increment,
    title varchar(100) not null unique,
    color varchar(100) not null,
    primary key(id)
);