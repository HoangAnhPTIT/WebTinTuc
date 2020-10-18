use new_servlet;

INSERT INTO role(code,name) values('ADMIN', 'Quan Tri');
INSERT INTO role(code,name) values('USER', 'Nguoi Dung');

INSERT INTO user(username,password,fullname,status,roleid) values('admin', '123456', 'Cao Hoang Anh', 1, 1);
INSERT INTO user(username,password,fullname,status,roleid) values('nguyenvana', '123', 'Nguyen Van A', 1, 2);
INSERT INTO user(username,password,fullname,status,roleid) values('nguyenvanb', '234', 'Nguyen Van B', 1, 2);