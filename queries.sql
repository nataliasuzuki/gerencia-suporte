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
'1',
'Joinville',
'Brasil',
'09:00',
'18:00',
'Rede',
'47 99999-1111');

INSERT INTO `gerencia-suporte_db`.`usuarios` (
`id`,
`nome`,
`senha`)
VALUES (
'1',
'guest',
'guest');