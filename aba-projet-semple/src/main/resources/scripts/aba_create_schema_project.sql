DROP TABLE EXEMPLE IF EXISTS;


CREATE TABLE EXEMPLE (
  ID           BIGINT IDENTITY 	    NOT NULL,
  NOM 	       VARCHAR(255) 		NOT NULL,
  DATE_OBJET   DATE 				NOT NULL,
  PRIMARY KEY (ID)
 );
 