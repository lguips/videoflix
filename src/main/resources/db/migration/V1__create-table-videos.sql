create table videos(
    id bigint not null auto_increment,
    title varchar(100) not null unique,
    description text not null,
    url varchar(255) not null,
    primary key(id)
);