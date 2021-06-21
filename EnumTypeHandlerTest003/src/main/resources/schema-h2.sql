create schema bichengfei;
set schema bichengfei;

CREATE TABLE `users`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(200) DEFAULT NULL,
    `sex`      int(11)      DEFAULT NULL,
    `nation`   int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`)
);