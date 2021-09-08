/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/5/31 21:03:25                           */
/*==============================================================*/


drop table if exists admin_info;

drop table if exists functions;

drop table if exists order_detail;

drop table if exists order_info;

drop table if exists powers;

drop table if exists product_info;

drop table if exists type;

drop table if exists user_info;

/*==============================================================*/
/* Table: admin_info                                            */
/*==============================================================*/
create table admin_info
(
   admin_id             int not null auto_increment,
   admin_name           varchar(16),
   pwd                  varchar(16),
   role                 varchar(8),
   primary key (admin_id)
);

/*==============================================================*/
/* Table: functions                                             */
/*==============================================================*/
create table functions
(
   function_id          int not null auto_increment,
   function_name        varchar(20),
   parentid             int,
   url                  varchar(50),
   isleaf               bool,
   nodeorder            int,
   primary key (function_id)
);

/*==============================================================*/
/* Table: order_detail                                          */
/*==============================================================*/
create table order_detail
(
   order_detail_id      int not null auto_increment,
   order_id             int,
   product_id           int not null,
   num                  int,
   primary key (order_detail_id)
);

/*==============================================================*/
/* Table: order_info                                            */
/*==============================================================*/
create table order_info
(
   order_id             int not null auto_increment,
   user_id              int not null,
   order_status         varchar(16),
   order_time           datetime,
   order_price          decimal(8,2),
   primary key (order_id)
);

/*==============================================================*/
/* Table: powers                                                */
/*==============================================================*/
create table powers
(
   admin_id             int not null,
   function_id          int not null,
   primary key (admin_id, function_id)
);

/*==============================================================*/
/* Table: product_info                                          */
/*==============================================================*/
create table product_info
(
   product_id           int not null auto_increment,
   type_id              int not null,
   code                 varchar(16) not null,
   product_name         varchar(255),
   brand                varchar(20),
   pic                  varchar(255),
   product_num          int,
   product_price        decimal(10,0),
   intro                text,
   bigpic               varchar(255),
   product_status       int,
   primary key (product_id)
);

/*==============================================================*/
/* Table: type                                                  */
/*==============================================================*/
create table type
(
   type_id              int not null auto_increment,
   type_name            varchar(20),
   primary key (type_id)
);

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
   user_id              int not null auto_increment,
   user_name            varchar(16) not null,
   user_password        varchar(16) not null,
   realname             varchar(16),
   sex                  varchar(4),
   address              varchar(255),
   question             varchar(50),
   answer               varchar(50),
   email                varchar(50),
   favorate             varchar(50),
   score                int,
   regdate              datetime,
   primary key (user_id)
);

alter table order_detail add constraint FK_Relationship_3 foreign key (product_id)
      references product_info (product_id) on delete restrict on update restrict;

alter table order_detail add constraint FK_order_order_detail foreign key (order_id)
      references order_info (order_id) on delete restrict on update restrict;

alter table order_info add constraint FK_user_order foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table powers add constraint FK_Relationship_5 foreign key (admin_id)
      references admin_info (admin_id) on delete restrict on update restrict;

alter table powers add constraint FK_Relationship_6 foreign key (function_id)
      references functions (function_id) on delete restrict on update restrict;

alter table product_info add constraint FK_Relationship_4 foreign key (type_id)
      references type (type_id) on delete restrict on update restrict;

