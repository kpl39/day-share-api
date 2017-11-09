
CREATE TABLE PARENTS (
    PARENT_ID SERIAL PRIMARY KEY,
    USER_ID VARCHAR,
    EMAIL VARCHAR,
    USERNAME VARCHAR,
    FIRST_NAME VARCHAR,
    LAST_NAME VARCHAR,
    ADDRESS1 VARCHAR,
    ADDRESS2 VARCHAR,
    LATITUDE DECIMAL,
    LONGITUDE DECIMAL,
    CITY VARCHAR,
    STATE VARCHAR,
    ZIPCODE VARCHAR,
    PROFILE_IMAGE_URL VARCHAR,
    FACEBOOK_ID VARCHAR,
    TWITTER_ID VARCHAR,
    DESCRIPTION VARCHAR
);

CREATE TABLE GROUPS (
    GROUP_ID SERIAL PRIMARY KEY,
    NAME VARCHAR
);

CREATE TABLE CHILDREN (
    CHILD_ID SERIAL PRIMARY KEY,
    FIRST_NAME VARCHAR,
    LAST_NAME VARCHAR,
    PARENT_ID INT REFERENCES PARENTS(PARENT_ID),
    GENDER VARCHAR(1)
);

CREATE TABLE CALENDAR_DAY (
    ID SERIAL PRIMARY KEY,
    DAY_CAL DATE,
    START_TIME TIME,
    END_TIME TIME,
    CARE_TAKER_ID INT REFERENCES USERS(ID),
    GROUP_ID INT REFERENCES GROUPS(ID)
);

CREATE TABLE ATTENDANCE (
    ID SERIAL PRIMARY KEY,
    PARENT_ID INT REFERENCES USERS(ID),
    CHILD_ID INT REFERENCES CHILDREN(ID),
    DAY_ID INT REFERENCES CALENDAR_DAY(ID)
);

--CREATE TABLE GROUP_MEMBERSHIP (
--    ID SERIAL PRIMARY KEY,
--    GROUP_ID INT REFERENCES GROUPS(ID),
--    PARENT_ID INT REFERENCES USERS(ID),
--    CHILD_ID INT REFERENCES CHILDREN(ID),
--    TYPE VARCHAR (1)
--);


CREATE TABLE GROUP_MEMBERSHIP (
  PARENT_ID INT NOT NULL,
  GROUP_ID INT NOT NULL,
  PRIMARY KEY (PARENT_ID, GROUP_ID),
  CONSTRAINT GROUP_MEMBERSHIP_IBFK_1
   FOREIGN KEY (PARENT_ID) REFERENCES PARENTS (PARENT_ID),
  CONSTRAINT GROUP_MEMBERSHIP_IBFK_2
   FOREIGN KEY (GROUP_ID) REFERENCES GROUPS (GROUP_ID)
);

CREATE TABLE METADATA_CATEGORIES (
    METADATA_CATEGORY_ID SERIAL PRIMARY KEY,
    NAME VARCHAR,
    DESCRIPTION VARCHAR
);

CREATE TABLE CHILD_METADATA (
    CHILD_METADATA_ID SERIAL PRIMARY KEY,
    CHILD_ID INT REFERENCES CHILDREN(CHILD_ID),
    METADATA_CATEGORY_ID INT REFERENCES METADATA_CATEGORIES(METADATA_CATEGORY_ID),
    NAME VARCHAR,
    DESCRIPTION VARCHAR
);