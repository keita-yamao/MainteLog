SET CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS locations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(255) NOT NULL
);

INSERT INTO locations (location) VALUES
('入庫室'),
('処理室'),
('加熱室'),
('包装室'),
('出荷庫');

CREATE TABLE IF NOT EXISTS makers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    maker VARCHAR(255) NOT NULL
);

INSERT INTO makers (maker) VALUES
('ロジステクノス'),
('三和テクノロジー'),
('大和技研工業'),
('讃岐製作所'),
('富士機械');

CREATE TABLE IF NOT EXISTS machines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location_id INT,
    maker_id INT,
    machine VARCHAR(255) NOT NULL,
    cost INT,
    installation_date DATE,
    FOREIGN KEY (location_id) REFERENCES locations(id),
    FOREIGN KEY (maker_id) REFERENCES makers(id)
);

INSERT INTO machines (location_id, maker_id, machine, cost, installation_date) VALUES
(1, 1, '荷受け用フォークリフト', 5000000, '2020-01-15'),
(2, 2, '処理コンベア', 8000000, '2019-05-20'),
(3, 3, 'ロースター', 12000000, '2021-03-10'),
(4, 4, '包装機', 15000000, '2018-11-25'),
(5, 5, '出荷フォークリフト', 3000000, '2020-07-30');

CREATE TABLE IF NOT EXISTS maintenance_logs(
    id INT AUTO_INCREMENT PRIMARY KEY,
    machine_id INT,
    description VARCHAR(255),
    maintenance_date DATE,
    implementer VARCHAR(255),
    maintenance_type VARCHAR(10),
    FOREIGN KEY (machine_id) REFERENCES machines(id)
);

INSERT INTO maintenance_logs (machine_id, description, maintenance_date, implementer, maintenance_type) VALUES
(1, 'マストの溶接', '2023-01-10', '田中太郎', '修理'),
(2, '駆動モーターの異音確認', '2023-02-15', '佐藤花子', '定期点検'),
(3, '温度センサー点検', '2023-03-20', '鈴木一郎', '定期点検'),
(4, 'コンベアーベルトの交換', '2023-04-25', '高橋次郎', '定期交換'),
(5, 'バッテリー液の補充', '2023-05-30', '山田三郎', '定期点検');
