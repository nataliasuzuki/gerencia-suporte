CREATE TABLE `gerencia-suporte_db`.`usuarios` (
`id` INT(11) NOT NULL,
`nome` VARCHAR(200) NOT NULL,
`senha` VARCHAR(200) NOT NULL,
PRIMARY KEY (`id`)) ENGINE = InnoDB;

CREATE TABLE `gerencia-suporte_db`.`dadossuporte` (
`id` INT(11) NOT NULL,
`Cidade` VARCHAR(200) NOT NULL,
`Pais` VARCHAR(200) NOT NULL,
`HoraInicio` VARCHAR(200) NOT NULL,
`HoraEncerra` VARCHAR(200) NOT NULL,
`TipoSuporte` VARCHAR(200) NOT NULL,
`Telefone` VARCHAR(200) NOT NULL,
PRIMARY KEY (`id`)) ENGINE = InnoDB;

INSERT INTO `gerencia-suporte_db`.`dadossuporte` (
`id`,
`Cidade`,
`Pais`,
`HoraInicio`,
`HoraEncerra`,
`TipoSuporte`,
`Telefone`)
VALUES (
'4',
'Boston',
'Estados Unidos',
'08:00',
'20:00',
'Rede',
'47999999999');