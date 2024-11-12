create table videos(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    descricao text not null,
    url varchar(255) not null,
    primary key(id)
);