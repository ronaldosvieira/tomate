create extension if not exists "uuid-ossp";

create database tomate
    with
    owner = postgres
    encoding = 'UTF8'
    connection limit = -1
    is_template = False;

create table entry (
    id serial primary key,
    hash uuid not null default uuid_generate_v4(),
    start_time timestamp with time zone not null,
    end_time timestamp with time zone not null,
    created_at timestamp with time zone not null default now(),
    updated_at timestamp with time zone
);

create table tag (
    id serial primary key,
    hash uuid not null default uuid_generate_v4(),
    name varchar(255) not null,
    created_at timestamp with time zone not null default now()
);

create table entry_tag (
    entry_id int not null references entry,
    tag_id int not null references tag
);