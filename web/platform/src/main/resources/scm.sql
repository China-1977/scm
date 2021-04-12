DROP TABLE plan;
CREATE TABLE plan(
    id VARCHAR(32) NOT NULL   COMMENT '主键' ,
    plan_code VARCHAR(32) NOT NULL   COMMENT '计划编号 年月日+存货编码' ,
    product_id VARCHAR(32) NOT NULL   COMMENT '产品ID' ,
    product_code VARCHAR(32) NOT NULL   COMMENT '产品编号' ,
    product_name VARCHAR(32) NOT NULL   COMMENT '产品名称' ,
    type VARCHAR(32) NOT NULL   COMMENT '类型 采购 purchase、生产 produce、委外 outsource' ,
    start_date DATE NOT NULL   COMMENT '开始时间' ,
    end_date DATE NOT NULL   COMMENT '截止时间' ,
    status VARCHAR(32)   DEFAULT READ COMMENT '状态 准备 READ、开始 START、暂停 SUSPEND、完成 FINISH、停止 STOP' ,
    plan_quantity BIGINT NOT NULL   COMMENT '计划数量' ,
    allocated_quantity BIGINT   DEFAULT 0 COMMENT '已分配数量' ,
    completed_quantity BIGINT   DEFAULT 0 COMMENT '已完成数量' ,
    upate_datetime DATETIME NOT NULL   COMMENT '更新时间' ,
    crate_datetime DATETIME NOT NULL   COMMENT '创建时间' ,
    PRIMARY KEY (id)
) COMMENT = '计划';

ALTER TABLE plan COMMENT '计划';
DROP TABLE orders;
CREATE TABLE orders(
    id VARCHAR(32) NOT NULL   COMMENT '主键' ,
    merchant_id VARCHAR(32) NOT NULL   COMMENT '合作商ID' ,
    merchant_name VARCHAR(32) NOT NULL   COMMENT '合作商名称' ,
    sign_datetime DATETIME    COMMENT '签约时间' ,
    status VARCHAR(32)   DEFAULT WAIT_SUBMIT COMMENT '状态 待提交 WAIT_SUBMIT 已提交/待接收 WAIT_COOPERATE 已接收/进行中 COOPERATING  已完成 FINISHED 已拒绝 REJECTED' ,
    update_datetime DATETIME NOT NULL   COMMENT '更新时间' ,
    create_datetime DATETIME NOT NULL   COMMENT '创建时间' ,
    PRIMARY KEY (id)
) COMMENT = '订单';

ALTER TABLE orders COMMENT '订单';
DROP TABLE orders_item;
CREATE TABLE orders_item(
    id VARCHAR(32) NOT NULL   COMMENT '主键' ,
    merchant_id VARCHAR(32) NOT NULL   COMMENT '合作商ID' ,
    order_id VARCHAR(32) NOT NULL   COMMENT '订单ID' ,
    plan_id VARCHAR(32) NOT NULL   COMMENT '计划ID' ,
    plan_code VARCHAR(32) NOT NULL   COMMENT '计划编号 年月日+存货编码' ,
    product_id VARCHAR(32) NOT NULL   COMMENT '产品ID' ,
    product_code VARCHAR(32) NOT NULL   COMMENT '产品编号' ,
    product_name VARCHAR(32) NOT NULL   COMMENT '产品名称' ,
    product_price DECIMAL(32,8) NOT NULL   COMMENT '产品单价' ,
    type VARCHAR(32) NOT NULL   COMMENT '类型 采购 purchase、生产 produce、委外 outsource' ,
    process_cost DECIMAL(32,8) NOT NULL   COMMENT '加工费' ,
    order_quantity BIGINT NOT NULL   COMMENT '订单数量' ,
    delivery_quantity BIGINT   DEFAULT 0 COMMENT '已交付数量' ,
    status VARCHAR(32)   DEFAULT READ COMMENT '状态 准备 READ、开始 START、暂停 SUSPEND、完成 FINISH、停止 STOP' ,
    due_datetime DATETIME NOT NULL   COMMENT '交付日期' ,
    PRIMARY KEY (id)
) COMMENT = '订单明细';

ALTER TABLE orders_item COMMENT '订单明细';
DROP TABLE merchant;
CREATE TABLE merchant(
    id VARCHAR(32) NOT NULL   COMMENT '主键' ,
    code VARCHAR(32) NOT NULL   COMMENT '合作商编号' ,
    name VARCHAR(32) NOT NULL   COMMENT '合作商名称' ,
    description VARCHAR(32) NOT NULL   COMMENT '简介 年月日+存货编码' ,
    license_number VARCHAR(32) NOT NULL   COMMENT '营业执照编号' ,
    license_copy VARCHAR(32) NOT NULL   COMMENT '营业执照图片' ,
    trademark VARCHAR(32) NOT NULL   COMMENT '商标' ,
    member_id VARCHAR(32) NOT NULL   COMMENT '雇员ID' ,
    member_name VARCHAR(32) NOT NULL   COMMENT '联系姓名' ,
    member_phone VARCHAR(32) NOT NULL   COMMENT '联系电话' ,
    type VARCHAR(32) NOT NULL   COMMENT '类型 采购 purchase、生产 produce、委外 outsource' ,
    grade INT   DEFAULT 0 COMMENT '等级' ,
    status VARCHAR(32)   DEFAULT EDITTING COMMENT '状态 编辑中 EDITTING 审核中 AUDITING 已驳回 REJECTED 已完成 FINISHED 已作废 CANCELED' ,
    create_datetime DATETIME NOT NULL   COMMENT '创建时间' ,
    update_datetime DATETIME NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
) COMMENT = '合作商';

ALTER TABLE merchant COMMENT '合作商';
DROP TABLE merchant_member;
CREATE TABLE merchant_member(
    id VARCHAR(32) NOT NULL   COMMENT '主键' ,
    merchant_id VARCHAR(32) NOT NULL   COMMENT '合作商ID' ,
    member_id VARCHAR(32) NOT NULL   COMMENT '雇员ID' ,
    PRIMARY KEY (id)
) COMMENT = '合作商与雇员关联';

ALTER TABLE merchant_member COMMENT '合作商与雇员关联';
DROP TABLE member;
CREATE TABLE member(
    id VARCHAR(32) NOT NULL   COMMENT '主键' ,
    phone VARCHAR(32) NOT NULL   COMMENT '手机号' ,
    name VARCHAR(32) NOT NULL   COMMENT '姓名' ,
    description VARCHAR(32) NOT NULL   COMMENT '描述' ,
    card_number VARCHAR(32) NOT NULL   COMMENT '身份证号' ,
    card_copy VARCHAR(32) NOT NULL   COMMENT '身份证照片' ,
    create_datetime DATETIME NOT NULL   COMMENT '创建时间' ,
    update_datetime DATETIME NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
) COMMENT = '雇员';

ALTER TABLE member COMMENT '雇员';
DROP TABLE stock;
CREATE TABLE stock(
    id VARCHAR(32) NOT NULL   COMMENT '主键' ,
    product_id VARCHAR(32) NOT NULL   COMMENT '产品ID' ,
    product_name VARCHAR(32) NOT NULL   COMMENT '产品名称' ,
    merchant_id VARCHAR(32) NOT NULL   COMMENT '合作商ID' ,
    merchant_name VARCHAR(32) NOT NULL   COMMENT '合作商名称' ,
    warehouse_id VARCHAR(32) NOT NULL   COMMENT '仓库ID' ,
    warehouse_name VARCHAR(32) NOT NULL   COMMENT '仓库名称' ,
    stock_quantity BIGINT NOT NULL   COMMENT '库存剩余量' ,
    batch VARCHAR(32) NOT NULL   COMMENT '批次' ,
    PRIMARY KEY (id)
) COMMENT = '库存';

ALTER TABLE stock COMMENT '库存';
DROP TABLE stock_change;
CREATE TABLE stock_change(
    id VARCHAR(32) NOT NULL   COMMENT '主键' ,
    product_id VARCHAR(32) NOT NULL   COMMENT '产品ID' ,
    product_name VARCHAR(32) NOT NULL   COMMENT '产品名称' ,
    product_amount DECIMAL(32,8) NOT NULL   COMMENT '产品金额' ,
    freight DECIMAL(32,8) NOT NULL   COMMENT '运费' ,
    process_cost DECIMAL(32,8) NOT NULL   COMMENT '加工费' ,
    merchant_id VARCHAR(32) NOT NULL   COMMENT '合作商ID' ,
    merchant_name VARCHAR(32) NOT NULL   COMMENT '合作商名称' ,
    warehouse_id VARCHAR(32) NOT NULL   COMMENT '仓库ID' ,
    warehouse_name VARCHAR(32) NOT NULL   COMMENT '仓库名称' ,
    stock_quantity BIGINT NOT NULL   COMMENT '出入库之前的剩余量' ,
    in_quantity DECIMAL(32,8) NOT NULL   COMMENT '入库数量' ,
    out_quantity DECIMAL(32,8) NOT NULL   COMMENT '出库数量' ,
    batch VARCHAR(32) NOT NULL   COMMENT '批次' ,
    PRIMARY KEY (id)
) COMMENT = '库存异动';

ALTER TABLE stock_change COMMENT '库存异动';
DROP TABLE product;
CREATE TABLE product(
    id VARCHAR(32) NOT NULL   COMMENT '主键' ,
    merchant_id VARCHAR(32) NOT NULL   COMMENT '合作商ID' ,
    code VARCHAR(32) NOT NULL   COMMENT '产品编号' ,
    name VARCHAR(32) NOT NULL   COMMENT '产品名称' ,
    unit VARCHAR(32) NOT NULL   COMMENT '单位' ,
    type VARCHAR(32) NOT NULL   COMMENT '类型' ,
    price DECIMAL(32,8) NOT NULL   COMMENT '单价' ,
    status BIT(1) NOT NULL   COMMENT '状态' ,
    pictures JSON   DEFAULT [] COMMENT '图片' ,
    PRIMARY KEY (id)
) COMMENT = '产品';

ALTER TABLE product COMMENT '产品';
DROP TABLE delivery;
CREATE TABLE delivery(
    id VARCHAR(32) NOT NULL   COMMENT '主键' ,
    merchant_id VARCHAR(32) NOT NULL   COMMENT '合作商ID' ,
    merchant_name VARCHAR(32) NOT NULL   COMMENT '合作商名称' ,
    warehouse_id VARCHAR(32) NOT NULL   COMMENT '入库ID' ,
    warehouse_name VARCHAR(32) NOT NULL   COMMENT '入库名称' ,
    plan_id VARCHAR(32) NOT NULL   COMMENT '计划ID' ,
    plan_code VARCHAR(32) NOT NULL   COMMENT '计划编号' ,
    product_id VARCHAR(32) NOT NULL   COMMENT '产品ID' ,
    product_code VARCHAR(32) NOT NULL   COMMENT '产品编号' ,
    product_name VARCHAR(32) NOT NULL   COMMENT '产品名称' ,
    delivery_quantity DECIMAL(32,8) NOT NULL   COMMENT '通知数量' ,
    sign_quantity DECIMAL(32,8)   DEFAULT 0 COMMENT '签收数量' ,
    in_quantity DECIMAL(32,8)   DEFAULT 0 COMMENT '入库数量' ,
    status VARCHAR(32) NOT NULL   COMMENT '状态 待提交 wait_submit 已提交/接收 wait_cooperate 已接收/进行中 cooperating 已完成 finished 已拒绝 rejected' ,
    logistic_no VARCHAR(32)    COMMENT '物流编号' ,
    create_datetime DATETIME NOT NULL   COMMENT '创建时间' ,
    update_datetime DATETIME NOT NULL   COMMENT '更新时间' ,
    PRIMARY KEY (id)
) COMMENT = '订单交付';

ALTER TABLE delivery COMMENT '订单交付';
