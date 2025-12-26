insert into t_users (username, password, email, role) values
                                                          ('ilya', 'test123', 'ilya@test.test', 'ROLE_ADMIN'),
                                                          ('nurken', 'test456', 'nurken@test.test', 'ROLE_USER'),
                                                          ('rafi', 'test789', 'rafi@test.test', 'ROLE_USER');

insert into t_projects (name, description, created_at, owner_id) values
                                                                     ('Task Manager', 'Final Project for SE', current_timestamp, 1),
                                                                     ('Catinder', 'Final Project for IOS', '2025-12-23', 3);

insert into t_project_members (project_id, user_id) values
                                                        (1, 1),
                                                        (2, 1),
                                                        (2, 2),
                                                        (2, 3);

insert into t_tasks (title, description, status, priority, project_id, assignee_id) values
                                                                                        ('Create DB', 'Setup postgres and flyway', 'DONE', 'HIGH', 1, 1),
                                                                                        ('Implement Services', 'Write service-logic for User, Project and Task', 'IN_PROGRESS', 'HIGH', 1, 1),
                                                                                        ('Presentation IOS App', 'Show and tell about the created IOS App', 'TODO', 'MEDIUM', 2, 2);
