CREATE TABLE TBL_Rol (
	cd_id int IDENTITY(1,1) NOT NULL,
	nb_role varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AI NULL,
	CONSTRAINT PK_TBL_USER PRIMARY KEY (cd_id)
);
