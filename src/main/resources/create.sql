create table T_Production 
(
	id char(18) not null primary key,
	name char(20) not null,
	category int(3) default 0,
	price float default 0.0,
	note char(50),
	setupTime TIMESTAMP,
	updateTime TIMESTAMP,
	onlineTime TIMESTAMP,
	offlineTime TIMESTAMP,
	proCharacter varchar(50),
	status int default 0,
	instruction varchar(50)
	
); 
create table T_Pro_Children(
	id char(18) not null primary key,
	parent_id char(18) not null,
	child_id char(18) not null,
	constraint fk_parent foreign key (parent_id) references t_production(id) on delete set null on update cascade,
	constraint fk_child foreign key (child_id) references t_production(id) on delete set null on update cascade
) engine = InnoDB;

create table T_Image(
	id char(18) not null primary key,
	pro_id char(18) not null,
	path varchar(200),
	instruction varchar(50),
	uploadtime timestamp,
	constraint fk_id foreign key (pro_id) references t_production(id)
) engine = InnoDB;

create table T_User(
	id char(18) not null primary key,
	name varchar(50),
	phoneNumber varchar(20),
	role int
)engine = InnoDB;

create table T_Order(
	id char(18) not null primary key,
	order_time timestamp,
	order_note varchar(100),
	expect_deliver_time timestamp,
	actual_deliver_time timestamp,
	user_id CHAR(18),
	oprator_id char(18),
	delivor_id char(18),
	phoneNumber varchar(20),
	phone_backup varchar(20),
	payway int,
	sum float,
	constraint fk_user foreign key (user_id) references t_user(id),
	constraint fk_oprator foreign key (oprator_id) references t_user(id),
	constraint fk_delivor foreign key (delivor_id) references t_user(id)
)engine = InnoDB;

create table T_Order_Pro(
	id char(18) not null primary key,
	order_id char(18),
	pro_id char(18),
	number int,
	pro_name char(20),
	pro_price float,
	constraint fk_order foreign key (order_id) references t_order(id),
	constraint fk_pro foreign key (pro_id) references t_production(id)
)engine = InnoDB;

create table T_Comment(
	id char(18) not null primary key,
	user_id char(18),
	order_id char(18),
	pro_id char(18),
	tast int,
	speed int,
	attitude int,
	content varchar(200),
	comment_time timestamp,
	constraint fk_comment_user foreign key (user_id) references t_user(id),
	constraint fk_comment_order foreign key (order_id) references t_order(id),
	constraint fk_comment_pro foreign key (pro_id) references t_production(id)
)engine = InnoDB;

CREATE TABLE t_Category (
  id int(3)  NOT NULL primary key,
  name varchar(50) NOT NULL,
  priority int(3)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


 alter table t_production add constraint fk_category foreign key(category) REFERENCES t_Category(id);
 
 alter table t_pro_children drop foreign key fk_child;
 ALTER TABLE t_pro_children
 ADD CONSTRAINT fk_child FOREIGN KEY (child_id) REFERENCES t_production (id) ON DELETE CASCADE ON UPDATE RESTRICT;
 
 alter table t_comment add constraint fk_comment_pro_id FOREIGN KEY (pro_id) 
 references t_production(id) on delete cascade on update restrict;
 
 alter table t_comment add constraint fk_comment_user_id FOREIGN KEY (user_id) 
 references t_user(id) on delete cascade on update restrict;
 
  alter table t_comment add constraint fk_comment_order_id FOREIGN KEY (order_id) 
 references t_order(id) on delete cascade on update restrict;
 
 alter table t_pro_children add constraint fk_child FOREIGN KEY (child_id) 
 references t_production(id) on delete cascade on update restrict;
 
 alter table t_pro_children add constraint fk_parent FOREIGN KEY (parent_id) 
 references t_production(id) on delete cascade on update restrict;
 
  alter table t_image add constraint fk_image_pro_id FOREIGN KEY (pro_id) 
 references t_production(id) on delete cascade on update restrict;
 
 alter table t_order add constraint fk_order_user_id FOREIGN KEY (user_id) 
 references t_user(id) on delete cascade on update restrict;
 alter table t_order add constraint fk_order_oprator_id FOREIGN KEY (oprator_id) 
 references t_user(id) on delete cascade on update restrict;
 alter table t_order add constraint fk_order_delivor_id FOREIGN KEY (delivor_id) 
 references t_user(id) on delete cascade on update restrict;
 
 alter table t_order_pro add constraint fk_order_pro_order_id FOREIGN KEY (order_id) 
 references t_order(id) on delete cascade on update restrict;
 alter table t_order_pro add constraint fk_order_pro_pro_id FOREIGN KEY (pro_id) 
 references t_production(id) on delete cascade on update restrict;
 
  alter table t_pro_children add constraint fk_parent_pro FOREIGN KEY (parent_id) 
 references t_production(id) on delete cascade on update restrict;
  alter table T_Pro_Children add constraint fk_child_pro FOREIGN KEY (child_id) 
 references t_production(id) on delete cascade on update restrict;
 
 