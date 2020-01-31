create table tsn.tsn_evnt(evnt_id int primary key auto_increment, evnt_name varchar(140) unique not null, evnt_date date not null, evnt_strt_time timestamp not null,
						  evnt_end_time timestamp not null, evnt_loc varchar(140), evnt_crtd_by varchar(40), evnt_crtd_dt timestamp,
						  evnt_last_updt_by varchar(40),evnt_last_uptd_dt timestamp);
						  
create table tsn.tsn_mtng(mtng_id int primary key auto_increment, mtng_name varchar(140) unique not null, mtng_date date not null, mtng_strt_time timestamp not null,
						  mtng_end_time timestamp not null, mtng_loc varchar(140),mtng_status varchar(20), mtng_crtd_by varchar(40), mtng_crtd_dt timestamp,
						  mtng_last_updt_by varchar(40),mtng_last_uptd_dt timestamp);						  