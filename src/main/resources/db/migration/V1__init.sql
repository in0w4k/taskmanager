create table t_users (
    id bigserial primary key,
    username varchar(255) not null unique,
    password varchar(255) not null,
    email varchar(255) not null unique,
    role varchar(50) not null
);

create table t_projects (
    id bigserial primary key,
    name varchar(255) not null,
    description text,
    created_at timestamp default current_timestamp,
    owner_id bigint references t_users(id) on delete cascade
);

create table t_tasks (
    id bigserial primary key,
    title varchar(255) not null,
    description text,
    status varchar(50) not null,
    priority varchar(50) not null,
    project_id bigint references t_projects(id) on delete cascade,
    assignee_id bigint references t_users(id) on delete set null
)