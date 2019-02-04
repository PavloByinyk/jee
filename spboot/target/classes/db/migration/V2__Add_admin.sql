insert into usr (id, active, password, username) value (1, true, '$2a$08$IjVvEekpNEsmyqPmfVtoOO35wvIFGFcxNVvPi4s8r.L7GsjoVPb7a', 'Admin');
insert into user_role (user_id, roles)  value (1, 'ADMIN');
insert into user_role (user_id, roles)  value (1, 'USER');
