INSERT INTO Category(ID, CATEGORY_NAME, PARENT_ID, CATEGORY_PATH) VALUES (1, 'Electronic', null, 'Electronic');
INSERT INTO Category(ID, CATEGORY_NAME, PARENT_ID, CATEGORY_PATH) VALUES (2, 'Computer', 1, 'Electronic >> Computer');
INSERT INTO Category(ID, CATEGORY_NAME, PARENT_ID, CATEGORY_PATH) VALUES (3, 'Mini Computer', 2, 'Electronic >> Computer > Mini Computer');
INSERT INTO Category(ID, CATEGORY_NAME, PARENT_ID, CATEGORY_PATH) VALUES (4, 'Wall Computer', 2, 'Electronic >> Computer > Wall Computer');
INSERT INTO Category(ID, CATEGORY_NAME, PARENT_ID, CATEGORY_PATH) VALUES (5, 'Television', 1, 'Electronic >> Television');
INSERT INTO Category(ID, CATEGORY_NAME, PARENT_ID, CATEGORY_PATH) VALUES (6, 'LED', 5, 'Electronic >> Television >> LED');
INSERT INTO Category(ID, CATEGORY_NAME, PARENT_ID, CATEGORY_PATH) VALUES (7, 'QED', 5, 'Electronic >> Television >> QED');

INSERT INTO Product(ID, DISCOUNTED_PRICE, IMAGE_LINK, PRODUCT_NAME, RETAIL_PRICE, CATEGORY_ID, STOCK)
VALUES(1, 100, 'www.google.com', 'Samsung QED 55 In', 1000, 7, 55);

INSERT INTO Product(ID, DISCOUNTED_PRICE, IMAGE_LINK, PRODUCT_NAME, RETAIL_PRICE, CATEGORY_ID, STOCK)
VALUES(2, 100, 'www.google.com', 'Samsung LED 47 In', 1000, 6, 22);

INSERT INTO Product(ID, DISCOUNTED_PRICE, IMAGE_LINK, PRODUCT_NAME, RETAIL_PRICE, CATEGORY_ID, STOCK)
VALUES(3, 10, 'www.google.com', 'Samsung LED 22 In', 500, 6, 22);

INSERT INTO Product_Attribute(Id, Name) VALUES (1, 'CPU');
INSERT INTO Product_Attribute(Id, Name) VALUES (2, 'MEMORY');