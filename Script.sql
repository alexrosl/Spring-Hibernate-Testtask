USE test;
DROP TABLE IF EXISTS part;

CREATE TABLE `part` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `quantity` int(11) NOT NULL,
  `required` bit(1) NOT NULL DEFAULT b'0',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

INSERT INTO `test`.`part`
(`name`,
`quantity`,
`required`
)
VALUES
('Материнская плата', 5, 1),
('HDD', 10, 1),
('звуковая карта', 11, 0),
('процессор', 37, 1),
('подсветка корпуса', 17, 0),
('корпус', 37, 1),
('память', 5, 1),
('SSD', 59, 0),
('блок питания', 12, 1),
('оптический привод', 54, 0),
('кулер', 7, 1),
('сетевая карта', 8, 0),
('сетевой адаптер', 51, 0),
('мышь', 99, 0),
('подставка', 12, 0),
('внешний жесткий диск', 45, 0),
('внутренний жесткий диск', 46, 1),
('кабель hdmi', 37, 0),
('кабель dvi', 96, 0),
('wifi модуль', 10, 0),
('ethernet разъем', 22, 0),
('крышка', 85, 0),
('шлейф', 45, 0),
('винт', 99, 0),
('кнопка', 37, 0),
('картридер', 23, 0),
('тв карта', 22, 0),
('спутниковая карта', 37, 0),
('usb разъем', 85, 0),
('smart lock', 84, 0),
('шнур', 15, 0),
('колонки', 0, 0),
('защитная пленка', 37, 0),
('графический планшет', 3, 0),
('клавиатура', 44, 1);



