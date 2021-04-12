![微信服务商之供应链](scm.png)

分类：成品、半成品、原料、包材、附属品
产品：BOM、单价、规格、质量、名称
商户：营业执照、对公账户、负责人、等级
仓库：地址、负责人、所属商户、等级
计划：产品、时间、备货计划、生产计划
合同：产品、价格、数量、交付日期、商户信息、公户信息
订单：采购订单、生产订单、委外订单、返修订单、计划来源、合同来源
交付：多商户、多个订单、多个仓库、批次、物流费、质检
库存：调拨、交付、销售、其它（研发、报废、盘点）
流水：单价、数量（入库、出库、在途、当前库存）、仓库、商户、合同、订单、计划、批次、物流费
发票：合同、订单、商户、公户

```shell

rpm -ev mysql-community-server-8.0.23-1.el8.x86_64 --nodeps
rpm -ev mysql-community-libs-8.0.23-1.el8.x86_64 --nodeps

yum -y install mysql-community-server
yum module disable mysql
systemctl start  mysqld.service
systemctl status  mysqld.service
systemctl  enable mysqld.service

```