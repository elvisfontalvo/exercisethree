
 CREATE SCHEMA `workshops` ;

 use workshops;

 CREATE TABLE `workshops`.`workers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


INSERT INTO `workshops`.`workers` (`name`, `lastname`, `phone`, `mail`) VALUES ('Elvis', 'Fontalvo', '3221234566', 'elvis.fontalvo@gmail.com');
INSERT INTO `workshops`.`workers` (`name`, `lastname`, `phone`, `mail`) VALUES ('Ivan', 'Fontalvo', '3221234567', 'ivan.fontalvo@gmail.com');
INSERT INTO `workshops`.`workers` (`name`, `lastname`, `phone`, `mail`) VALUES ('Deivi', 'Fontalvo', '3221234568', 'deivi.fontalvo@gmail.com');
INSERT INTO `workshops`.`workers` (`name`, `lastname`, `phone`, `mail`) VALUES ('Jesus', 'Fontalvo', '3221234569', 'jesus.fontalvo@gmail.com');