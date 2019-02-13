/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  gsnurr3
 * Created: Jan 25, 2019
 */
-- USER AUTHORITY TABLE
INSERT INTO usr_authority(authority)
VALUES('GUEST');

INSERT INTO usr_authority(authority)
VALUES('CLIENT');

INSERT INTO usr_authority(authority)
VALUES('ADMIN');

-- CATEGORY TABLE
INSERT INTO forum_category(name, description)
VALUES('NEWS', 'This is the news forum.');

INSERT INTO forum_category(name, description)
VALUES('GENERAL', 'This is the general forum.');

INSERT INTO forum_category(name, description)
VALUES('GUILD', 'This is the guild forum.');