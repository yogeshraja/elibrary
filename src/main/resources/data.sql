TRUNCATE users;
TRUNCATE authorities;

INSERT into users(uid,username,password,enabled) values(1,"yogesh","yogesh",true);
INSERT into users(uid,username,password,enabled) values(2,"admin","admin",true);

INSERT into authorities(aid,username,authority,uid) values(1,"yogesh","ROLE_USER",1);
INSERT into authorities(aid,username,authority,uid) values(2,"admin","ROLE_ADMIN",2);
INSERT into authorities(aid,username,authority,uid) values(3,"yogesh","ROLE_ADMIN",1);