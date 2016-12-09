-- CategoryDaoTest
-- testFindCategory
-- ID = 1L
INSERT INTO category(name) VALUES('testFindCategoryNameDB');
-- testUpdateCategoryHasNameChanged
-- ID = 2L
INSERT INTO category(name) VALUES('testUpdateCategoryChangedNameDB');
-- testUpdateCategoryHasRightName
-- ID = 3L
INSERT INTO category(name) VALUES('testUpdateCategoryRightNameDB');

-- TaskDaoTest
-- testFindableByLabel
-- ID_TASK = 1L
INSERT INTO task(label) VALUES('testFindableLabelDB');
-- testListTasksForGivenUserAndCategory
-- ID_USER = 1L
INSERT INTO users(name, USER_TYPE) VALUES('testUserDB', 'USER_FREE');
-- ID_CATEGORY = 4L
INSERT INTO category(name) VALUES('testCategoryDB');
-- ID_TASK = 2L
INSERT INTO task(label, id_user, id_category) VALUES('testListByUserAndCategoryDB', 1, 4);

-- ID_TASK = 3L
INSERT INTO task(label, endingDate, id_user, id_category) VALUES('testListTasksNotFinished', '2016-12-31', 1, 4);