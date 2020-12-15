-- create by psql-generator
-- time: 2020-12-15 09:29:15

-- create table: demo.dummy.company_group
drop table if exists demo.dummy.company_group;

create table if not exists demo.dummy.company_group
(
    id bigserial primary key,
     group_id text not null,
     group_name text ,
     company_id text not null,
     user_id text ,
     create_time timestamp not null default current_timestamp,
     update_time timestamp not null default current_timestamp);


CREATE  INDEX  IF NOT EXISTS idx_company_group_group_id ON demo.dummy.company_group (group_id);
CREATE  INDEX  IF NOT EXISTS idx_company_group_company_id ON demo.dummy.company_group (company_id);

comment on column demo.dummy.company_group.id is '自增id';
comment on column demo.dummy.company_group.group_id is '组id';
comment on column demo.dummy.company_group.group_name is '自定义组名';
comment on column demo.dummy.company_group.company_id is '公司id';
comment on column demo.dummy.company_group.user_id is '用户唯一标识';
comment on column demo.dummy.company_group.create_time is '创建时间';
comment on column demo.dummy.company_group.update_time is '更新时间';

