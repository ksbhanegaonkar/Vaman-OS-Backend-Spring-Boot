INSERT INTO PERMISSIONS (NAME) VALUES 
('can_create_user'),
('can_update_user'),
('can_read_user'),
('can_delete_user');

INSERT INTO ROLES (NAME) VALUES 
		('role_admin'),('role_user');

INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID) VALUES 
    (1,1), /* can_create_user assigned to role_admin */
    (2,1), /* can_update_user assigned to role_admin */
    (3,1), /* can_read_user assigned to role_admin */
    (4,1), /* can_delete_user assigned to role_admin */
    (3,2);  /* can_read_user assigned to role_user */
    
INSERT INTO USERS (
    USERNAME,PASSWORD,
    EMAIL,ENABLED,ACCOUNT_EXPIRED,CREDENTIALS_EXPIRED,ACCOUNT_LOCKED) VALUES (
    'admin','{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi',
    'william@gmail.com',true,false,false,false),
    ('user','{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi',
    'john@gmail.com',true,false,false,false);
     
INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
    VALUES 
    (1, 1) /* role_admin assigned to admin user */,
    (2, 2) /* role_user assigned to user user */ ;
    