-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `enjoytrip` ;

-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `enjoytrip` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `enjoytrip` ;

-- -----------------------------------------------------
-- Table `enjoytrip`.`sido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`sido` (
  `sido_code` INT NOT NULL,
  `sido_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`gugun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`gugun` (
  `gugun_code` INT NOT NULL,
  `gugun_name` VARCHAR(30) NULL DEFAULT NULL,
  `sido_code` INT NOT NULL,
  PRIMARY KEY (`gugun_code`, `sido_code`),
  INDEX `gugun_to_sido_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  CONSTRAINT `gugun_to_sido_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_info` (
  `content_id` INT NOT NULL,
  `content_type_id` INT NULL DEFAULT NULL,
  `title` VARCHAR(100) NULL DEFAULT NULL,
  `addr1` VARCHAR(100) NULL DEFAULT NULL,
  `addr2` VARCHAR(50) NULL DEFAULT NULL,
  `zipcode` VARCHAR(50) NULL DEFAULT NULL,
  `tel` VARCHAR(50) NULL DEFAULT NULL,
  `first_image` VARCHAR(200) NULL DEFAULT NULL,
  `first_image2` VARCHAR(200) NULL DEFAULT NULL,
  `readcount` INT NULL DEFAULT NULL,
  `sido_code` INT NULL DEFAULT NULL,
  `gugun_code` INT NULL DEFAULT NULL,
  `latitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `longitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `mlevel` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  INDEX `attraction_to_content_type_id_fk_idx` (`content_type_id` ASC) VISIBLE,
  INDEX `attraction_to_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  INDEX `attraction_to_gugun_code_fk_idx` (`gugun_code` ASC) VISIBLE,
  CONSTRAINT `attraction_to_content_type_id_fk`
    FOREIGN KEY (`content_type_id`)
    REFERENCES `enjoytrip`.`content_type` (`content_type_id`),
  CONSTRAINT `attraction_to_gugun_code_fk`
    FOREIGN KEY (`gugun_code`)
    REFERENCES `enjoytrip`.`gugun` (`gugun_code`),
  CONSTRAINT `attraction_to_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_description`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_description` (
  `content_id` INT NOT NULL,
  `homepage` VARCHAR(100) NULL DEFAULT NULL,
  `overview` VARCHAR(10000) NULL DEFAULT NULL,
  `telname` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_attraciton_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_detail` (
  `content_id` INT NOT NULL,
  `cat1` VARCHAR(3) NULL DEFAULT NULL,
  `cat2` VARCHAR(5) NULL DEFAULT NULL,
  `cat3` VARCHAR(9) NULL DEFAULT NULL,
  `created_time` VARCHAR(14) NULL DEFAULT NULL,
  `modified_time` VARCHAR(14) NULL DEFAULT NULL,
  `booktour` VARCHAR(5) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_basic_content_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`members`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`members` (
  `user_id` VARCHAR(16) NOT NULL,
  `user_name` VARCHAR(10) NOT NULL,
  `user_password` VARCHAR(16) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `is_admin` CHAR(1) NOT NULL DEFAULT 'N',
  `sido_code` INT NULL DEFAULT NULL,
  `gugun_code` INT NULL DEFAULT NULL,
  `delete_at` TIMESTAMP NULL DEFAULT NULL,
  `create_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  INDEX `members_to_sido_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  CONSTRAINT `members_to_sido_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`sido` (`sido_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`favorite` (
  `favorite_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NOT NULL,
  `content_id` INT NOT NULL,
  PRIMARY KEY (`favorite_id`),
  INDEX `favorite_to_attraction_info_content_id_fk_idx` (`content_id` ASC) VISIBLE,
  INDEX `favorite_to_members_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `favorite_to_attraction_info_content_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`),
  CONSTRAINT `favorite_to_members_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`members` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`hotplaces`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`hotplaces` (
  `hotplace_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NOT NULL,
  `hotplace_title` VARCHAR(45) NOT NULL,
  `hotplace_name` VARCHAR(45) NOT NULL,
  `hotplace_description` VARCHAR(1000) NOT NULL,
  `hotplace_create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hotplace_status` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`hotplace_id`),
  INDEX `hotplaces_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `hotplaces_to_members_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`members` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`notices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`notices` (
  `notice_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NOT NULL,
  `notice_title` VARCHAR(45) NOT NULL,
  `notice_contents` VARCHAR(1000) NOT NULL,
  `notice_view_cnt` INT NOT NULL DEFAULT '0',
  `notice_create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`notice_id`),
  INDEX `notices_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `notices_to_members_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`members` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`plans`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`plans` (
  `plan_id` INT NOT NULL AUTO_INCREMENT,
  `plan_create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `plan_startdate` TIMESTAMP NOT NULL,
  `plan_enddate` TIMESTAMP NOT NULL,
  `plan_title` VARCHAR(45) NOT NULL,
  `plan_contents` VARCHAR(1000) NULL DEFAULT NULL,
  `user_id` VARCHAR(16) NOT NULL,
  `plan_path` JSON NOT NULL,
  PRIMARY KEY (`plan_id`),
  INDEX `plans_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `plans_to_members_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`members` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`tips`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`tips` (
  `tip_id` INT NOT NULL AUTO_INCREMENT,
  `tip_title` VARCHAR(45) NOT NULL,
  `tip_contents` VARCHAR(1000) NOT NULL,
  `user_id` VARCHAR(16) NOT NULL,
  `tip_view_cnt` INT NOT NULL DEFAULT '0',
  `tip_like_cnt` INT NOT NULL DEFAULT '0',
  `tip_create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`tip_id`),
  INDEX `tips_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `tips_to_members_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`members` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
