create table t_project_members (
    project_id bigint not null references t_projects(id) on delete cascade,
    user_id bigint not null references t_users(id) on delete cascade,
    primary key (project_id, user_id)
)