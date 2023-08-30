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
insert into role(role_name) value ('admin');
insert into role(role_name) value ('user');
insert into account(name, username, password, phone, email, address, status, id_role)
    value ('Trong Tai', 'trongtai', '123456', '0369911511', 'trongtai@gmail.com','Thanh Hoa', 1, 1);
insert into account(name, username, password, phone, email, address, status, id_role)
    value ('Van Trung', 'vantrung', '123456', '0335278797', 'vantrung@gmail.com','Ha Noi', 1, 1);
insert into account(name, username, password, phone, email, address, status, id_role)
    value ('Quang Anh', 'quanganh', '123456', '0365478954', 'quanganh@gmail.com','Nghe An', 1, 1);
insert into account(name, username, password, phone, email, address, status, id_role)
    value ('Quoc Trieu', 'quoctrieu', '123456', '0369911911', 'quoctrieu@gmail.com','Ha Noi', 1, 1);
insert into account(name, username, password, phone, email, address, status, id_role)
    value ('User 1', 'user1', '123456', '0369911654', 'user1@gmail.com','Thanh Hoa', 1, 2);
insert into account(name, username, password, phone, email, address, status, id_role)
    value ('User 2', 'user2', '123456', '0369911698', 'user2@gmail.com','Thanh Hoa', 1, 2);
insert into account(name, username, password, phone, email, address, status, id_role)
    value ('User 3', 'user3', '123456', '0369911854', 'user3@gmail.com','Thanh Hoa', 0, 2);
insert into account(name, username, password, phone, email, address, status, id_role)
    value ('User 4', 'user4', '123456', '0369911964', 'user4@gmail.com','Thanh Hoa', 0, 2);

insert into category(name, description) value ('Politics', 'Politics content');
insert into category(name, description) value ('Military', 'Military content');
insert into category(name, description) value ('Economy', 'Economy content');

insert into blog(tittle, content, create_at, id_category, id_account)
    value ('military','abcd1', '2023/04/22',2,1);
insert into blog(tittle, content, create_at, id_category, id_account)
    value ('Politics','abcd2', '2023/05/22',1,1);
insert into blog(tittle, content, create_at, id_category, id_account)
    value ('Economy','abcd3', '2023/06/22',3,1);
insert into blog(tittle, content, create_at, id_category, id_account)
    value ('Economy','abcd4', '2023/07/22',3,1);

insert into comment(content, id_blog) value ('hay hay', 1);
insert into comment(content, id_blog) value ('hay qua', 1);
insert into comment(content, id_blog) value ('good', 1);
insert into comment(content, id_blog) value ('great', 1);


