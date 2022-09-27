CREATE TABLE order (
	id int8 NOT NULL,
	userId varchar(255) NOT NULL,
	status varchar(255) NOT NULL,
	products char(30) ARRAY[varchar(30)]
	createdAt date,
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

insert into order(id, userId, status) values (1,  '0052', 'Created');