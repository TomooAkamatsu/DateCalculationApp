INSERT INTO calc_pattern(date_id, date_name, calc_y, calc_m, calc_d)
VALUES('y-1', '一年前', -1, 0, 0),
('m6', '半年後', 0, 6, 0),
('d7', '一週間後', 0, 0, 7);

INSERT INTO users (username, password, authority)
VALUES
('admin', '89d88047a24281e6639384e0c7b4867d895d79f313831ffbd4a08e8b9b554e8136a6fb485913ddc4','ADMIN')
,('user', '57c36b4d764ea4d3d80d345fd958d6f86264f589df7c93483051496ddeaf0e92a92f911e72f3feff', 'USER');
