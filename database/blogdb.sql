create database CaseStudyModule3;
use CaseStudyModule3;
create table role(
    id int not null auto_increment primary key,
    role_name varchar(50) not null
);
create table account(
    id int auto_increment primary key,
    name varchar(50) not null,
    username varchar(50) not null unique,
    password varchar(50) not null,
    phone varchar(10) not null unique ,
    email varchar(50) not null unique ,
    address varchar(255) not null,
    status boolean not null ,
    id_role int,
    foreign key (id_role) references role(id)
);
create table category(
  id int auto_increment primary key ,
  name varchar(50) not null ,
  description text not null
);
create table blog (
    id int auto_increment primary key ,
    tittle text not null ,
    content text not null ,
    create_at date not null ,
    id_category int,
    id_account int,
    foreign key (id_category) references category(id),
    foreign key (id_account) references account(id)
);
create table comment(
    id int primary key auto_increment,
    content text not null ,
    id_blog int,
    foreign key (id_blog) references blog(id)
);
create table img_blog(
    id int primary key auto_increment,
    url_image text not null,
    id_blog int,
    foreign key (id_blog) references blog(id)
);
