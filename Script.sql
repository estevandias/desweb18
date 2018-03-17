-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Pais`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Pais` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Pais` (
  `idPais` INT UNSIGNED NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `populacao` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPais`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Modalidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Modalidade` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Modalidade` (
  `idModalidade` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` CHAR(1) NOT NULL,
  PRIMARY KEY (`idModalidade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ano`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Ano` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Ano` (
  `idAno` INT NOT NULL,
  `tipo` CHAR(1) NOT NULL,
  PRIMARY KEY (`idAno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Olimpiada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Olimpiada` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Olimpiada` (
  `ouro` INT NOT NULL,
  `prata` INT NOT NULL,
  `bronze` INT NOT NULL,
  `Pais_idPais` INT UNSIGNED NOT NULL,
  `Modalidade_idModalidade` INT NOT NULL,
  `Ano_idAno` INT NOT NULL,
  PRIMARY KEY (`Pais_idPais`, `Modalidade_idModalidade`, `Ano_idAno`),
  INDEX `fk_Olimpiada_Modalidade1_idx` (`Modalidade_idModalidade` ASC),
  INDEX `fk_Olimpiada_Ano1_idx` (`Ano_idAno` ASC),
  CONSTRAINT `fk_Olimpiada_Pais`
    FOREIGN KEY (`Pais_idPais`)
    REFERENCES `mydb`.`Pais` (`idPais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Olimpiada_Modalidade1`
    FOREIGN KEY (`Modalidade_idModalidade`)
    REFERENCES `mydb`.`Modalidade` (`idModalidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Olimpiada_Ano1`
    FOREIGN KEY (`Ano_idAno`)
    REFERENCES `mydb`.`Ano` (`idAno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
