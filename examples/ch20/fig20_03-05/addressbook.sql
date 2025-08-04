DROP TABLE IF EXISTS addresses;

CREATE TABLE addresses
(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	first VARCHAR (50) NOT NULL,
	last VARCHAR (50) NOT NULL,
	email VARCHAR (254) NOT NULL,
	phone VARCHAR (18) NOT NULL
);

INSERT INTO addresses (first,last,email,phone)
VALUES 
    ('Anastasia','Popov','demo1@deitel.com','555-5555'),
    ('Mina','Gamal','demo2@deitel.com','555-1234'),
    ('无忌','张','wujiz@bookzhou.com','0719-55551122'),  -- 张无忌 → 名: 无忌, 姓: 张
    ('敏','赵','zming@bookzhou.com','0719-55551133'),    -- 赵敏 → 名: 敏, 姓: 赵
    ('芷若','周','zhiruo@bookzhou.com','0719-55551144'), -- 周芷若 → 名: 芷若, 姓: 周
    ('翠山','张','cuishan@bookzhou.com','0719-55551155'),-- 张翠山 → 名: 翠山, 姓: 张
    ('三丰','张','sanfeng@bookzhou.com','0719-55551166');-- 张三丰 → 名: 三丰, 姓: 张