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
    maker VARCHAR(255) NOT NULL,
    address VARCHAR(255)
    );

INSERT INTO makers (maker, address) VALUES
('ロジステクノス', '東京都港区'),
('三和テクノロジー', '大阪府箕面市'),
('大和技研工業', '奈良県大和高田市'),
('讃岐製作所', '香川県高松市'),
('富士機械', '静岡県浜松市');

CREATE TABLE IF NOT EXISTS contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    maker_id INT,
    contact_person VARCHAR(255),
    phone_number VARCHAR(20),
    email VARCHAR(255),
    FOREIGN KEY (maker_id) REFERENCES makers(id)
);

INSERT INTO contacts (maker_id, contact_person, phone_number, email) VALUES
(1, '田中太郎', '090-1234-5678', 'tanaka@example.com'),
(2, '佐藤花子', '080-2345-6789', 'satou@example.com'),
(3, '鈴木一郎', '070-3456-7890', 'suzuki@example.com'),
(4, '高橋次郎', '060-4567-8901', 'takahashi@example.com'),
(5, '山田三郎', '050-5678-9012', 'yamada@example.com'),
(1, '田中花子', '090-8765-4321', 'tanaka-hana@example.com'),
(2, '佐藤太郎', '080-9876-5432', 'satou-taro@example.com'),
(3, '鈴木花子', '070-8765-4321', 'suzuki-hana@example.com');

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
