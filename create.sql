create table habits (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
create table tracks (id bigint not null, primary key (id)) engine=InnoDB;
create table users (user_id bigint not null auto_increment,
                    email varchar(255),
                    first_name varchar(255),
                    last_name varchar(255),
                    password varchar(255),
                    role varchar(255),
                    status varchar(255),
                    primary key (user_id)) engine=InnoDB;
