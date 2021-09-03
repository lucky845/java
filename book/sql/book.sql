DROP DATABASE IF EXISTS book; ## 如果原来的数据库存在，就删除

CREATE DATABASE book; ## 创建数据库

USE book;
## 切换到数据库


##创建表t_user
CREATE TABLE t_user
(
    `id`       INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(32) NOT NULL,
    `email`    VARCHAR(50)
)CHARACTER SET = utf8;

##插入初始数据
INSERT INTO t_user(username, `password`, email)
VALUES ('admin', 'admin', 'admin@qq.com');

## 查询表
SELECT *
FROM t_user;

# ============================================================================

##创建图书表
CREATE TABLE t_book
(
    `id`       INT(11) PRIMARY KEY AUTO_INCREMENT, ## 主键
    `name`     VARCHAR(50)    NOT NULL,            ## 书名
    `author`   VARCHAR(50)    NOT NULL,            ## 作者
    `price`    DECIMAL(11, 2) NOT NULL,            ## 价格
    `sales`    INT(11)        NOT NULL,            ## 销量
    `stock`    INT(11)        NOT NULL,            ## 库存
    `img_path` VARCHAR(200)   NOT NULL             ## 书的图片路径
)CHARACTER SET = utf8;


## 插入初始化测试数据
INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, 'java从入门到放弃', '国哥', 80, 9999, 9, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '数据结构与算法', '严敏君', 78.5, 6, 13, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '怎样拐跑别人的媳妇', '龙伍', 68, 99999, 52, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '木虚肉盖饭', '小胖', 16, 1000, 50, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, 'C++编程思想', '刚哥', 45.5, 14, 95, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '蛋炒饭', '周星星', 9.9, 12, 53, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '赌神', '龙伍', 66.5, 125, 535, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, 'Java编程思想', '阳哥', 99.5, 47, 36, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, 'JavaScript从入门到精通', '婷姐', 9.9, 85, 95, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, 'cocos2d-x游戏编程入门', '国哥', 49, 52, 62, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, 'C语言程序设计', '谭浩强', 28, 52, 74, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, 'Lua语言程序设计', '雷丰阳', 51.5, 48, 82, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '西游记', '罗贯中', 12, 19, 9999, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '水浒传', '华仔', 33.05, 22, 88, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '操作系统原理', '刘优', 133.05, 122, 188, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '数据结构 java版', '封大神', 173.15, 21, 81, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, 'UNIX高级环境编程', '乐天', 99.15, 210, 810, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, 'javaScript高级编程', '国哥', 69.15, 210, 810, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '大话设计模式', '国哥', 89.15, 20, 10, 'static/img/default.jpg');

INSERT INTO t_book(`id`, `name`, `author`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '人月神话', '刚哥', 88.15, 20, 80, 'static/img/default.jpg');


## 查看表内容
SELECT id, NAME, author, price, sales, stock, img_path
FROM t_book;

## 查看分页情况`t_book`
SELECT * FROM t_book LIMIT 0 , 4;

###########################################################

## 订单表
CREATE TABLE t_order(
                        `order_id` VARCHAR(50) PRIMARY KEY,  	##订单号
                        `create_time` DATETIME ,	    ##订单时间
                        `price` DECIMAL(11,2) ,	        ##总金额
                        `status` INT, 	    ##物流状态：0-未发货、1-等待用户签收、2-用户已签收
                        `user_id` INT ,			        ##用户编号
                        FOREIGN KEY (`user_id`) REFERENCES t_user(`id`)
)CHARACTER SET = utf8;


## 订单项
CREATE TABLE t_order_item(
                             `id` INT PRIMARY KEY AUTO_INCREMENT,
                             `name` VARCHAR(100) ,		##商品名
                             `count` INT,                       ##商品数量
                             `price` DECIMAL(11,2),			    ##商品单价
                             `total_price` DECIMAL(11,2),		##商品总金额
                             `order_id` VARCHAR(50) ,	##订单号
                             FOREIGN KEY (`order_id`) REFERENCES t_order(`order_id`)
)CHARACTER SET = utf8;