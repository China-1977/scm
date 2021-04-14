import moment from 'moment';

/**
 *  前端常量值,需引入本类后使用
 *  import Constants from "@/utils/Constants";
 *
 *  使用方式：
 *  Constants.SUPPLIER.TYPE
 */
const tableHeigh = () => {
  return window.innerHeight - 500;
};
const Constants = {
  // InputNumber 数值限制方案   注意: 解构时可以不删掉原有的属性,但是需要放到最下面,组件会顺序加载取最后的值进行覆盖
  NUMBER: {
    // 方案1: 正整数，数值最大为8位数
    POSITIVE_INTEGER: {
      max: 99999999,
      min: 1,
      precision: 0,
      step: 1,
    },
    // 方案1: 正整数，数值最大为8位数
    POSITIVE_INTEGER_ZERO: {
      max: 99999999,
      min: 0,
      precision: 0,
      step: 1,
    },
    // 方案1: 正整数，数值最大为8位数
    POSITIVE_NO_PRECISION: {
      max: 99999999.99999999,
      min: 0.00000001,
      precision: 8,
    },
    // 方案2: 正数，保留8位小数，数值最大为8位数
    POSITIVE: {
      max: 99999999.99999999,
      min: 0.00000001,
      precision: 8,
      // step: 0.00000001,
    },
    // 方案3：正数精度2
    POSITIVE_PRECISION_2: {
      max: 99999999.99,
      min: 0,
      precision: 2,
      // step: 0.00000001,
    },
    // 方案4：正数精度3
    POSITIVE_PRECISION_3: {
      max: 99999999.99,
      min: 0,
      precision: 3,
      // step: 0.00000001,
    },
    // 方案2: 负数，保留8位小数，数值最大为8位数
    NEGATIVE: {
      max: -0.00000001,
      min: -99999999.99999999,
      precision: 8,
      // step: 0.00000001,
    },
    // bom损耗率专用
    BOM_LOSS_RATE: {
      max: 100,
      min: 0,
    },
    // 物料交付周期默认
    MATERIAL_DELIVERY_CYCLE: {
      max: 999,
      min: 0,
    }
  },
  // 模态框宽度大小
  MODAL: {
    WIDTH: {
      XS: '75%',
      SM: '80%',
      MD: '90%',
      LG: '95%',
      LT: '50%',
    },
  },
  // 表横向滚动条
  TABLE: {
    SCROLL: {
      XS: {
        x: 1200,
        // y: window.innerHeight - 500,
      },
      SM: {
        x: 1300,
        // y: window.innerHeight - 500,
      },
      MD: {
        x: 1800,
        // y: window.innerHeight - 500,
      },
      LG: {
        x: 1600,
        // y: window.innerHeight - 500,
      },
      LLG: {
        x: 1800,
        // y: window.innerHeight - 500,
      },
      LLLG: {
        x: 2000,
        // y: window.innerHeight - 500,
      },
      LLLLG: {
        x: 2500,
        // y: window.innerHeight - 500,
      },
      LLLLLG: {
        x: 2700,
        // y: window.innerHeight - 500,
      },
    },
    COLUMNS: {
      WAREHOUSE: 163, // 仓库
      WAREHOUSE_LENGTH: 10, // 仓库
      DATE: 100, // 日期
      TIME: 150, // 时间
      BIG_TIME: 180,//大日期
      CODE: 150, // 单据编号
      MATERIAL_CODE: 130, // 存货编码
      SUPPLIER_CODE: 150, // 加工商编码
      NUMBER: 120, // 数量
      BIG_NUMBER: 150, // 数量
      TOTAL_NUMBER: 180, // 数量
      NUMBER_EDIT: 200, // 编辑行数量
      PHONE: 80,// 电话
      PRICE: 100, // 价格
      QUALITY_STATUS: 130, // 质检状态
      QUALITY_ITEM_STATUS: 120, // 质检状态
      MATERIAL_CODE_LENGTH:15, // 存活编码长度
      // 物流联系人
      LOGISTICS: {
        width: 120,
        ellipsis: true,
      },
      // 物流单号
      LOGISTIC_CODE: {
        width: 120,
        ellipsis: true,
      },
      // 物流联系人手机号
      LOGISTIC_CONTACT_PHONE: {
        width: 120,
        ellipsis: true,
      },
      // 物料名称
      MATERIAL_NAME: {
        width: 220,
        ellipsis: true,
      },
      MATERIAL_CATEGORY: 100, // 存货分类
      MATERIAL_CATEGORY_LENGTH: 5, // 存货分类展示字数长度
      // 69码
      MATERIAL_CODE_MARK: {
        width: 110,
        ellipsis: true,
      },
      // （原料、包材）供应商、加工商
      SUPPLIER: {
        width: 163,
        ellipsis: true,
      },
      STATUS: 90, //状态
      TYPE: 120, //状态
      INDEX: 50, // 序号
      // 创建人、（制单人）、账号名称
      CREATOR: {
        width: 100,
        ellipsis: true,
      },
      // 单位
      UNIT: {
        width: 90,
        ellipsis: true,
      },
      // 箱规
      BOX_GAUGE: {
        width: 60,
        ellipsis: true,
      },
      // 规格
      SPECIFICATION: {
        width: 90,
        ellipsis: true,
      },
      //备注，供应商反馈
      REMARK: {
        width: 190,
        ellipsis: true,
      },
      // 批次号
      BATCH: {
        width: 140,
        ellipsis: true,
      },
      // 配方编码
      FORMULA_CODE: {
        ellipsis: true,
        width: 100,
      }
    },
    PAGING: {showSizeChanger: true, pageSizeOptions: [10, 20, 50, 100, 1000]},
  },
  // BOM管理基本信息
  BOM: {
    DOWNLOAD_URL: '/base/bom/downloadExcel',
    IMPORT_URL: '/base/bom/importExcel',
  },

  //税率维护
  TAX_RATE:{
    NAME: "TAX_RATE"
  },

  // 生产计划
  PRODUCT_STATUS: {
    TYPE: {
      NAME: 'SCJH_STATUS',
      // 存在不确定因素（可根据字典类型加字典CODE查询）（可根据字典类型缓存到redis中）
      STATUS_WAIT_COMMIT: '1', // 等待提交
      STATUS_WAIT_AUDIT: '2', // 等待审核
      STATUS_WAIT_ORDER: '3', // 等待下单
      STATUS_WAIT_CONFIRM: '4', // 待确认
      STATUS_PRODUCTION: '5', // 生产中
      STATUS_FINISHED: '6', // 已完成
    },
    CREATE_LENGTH: {
      PRODUCT_NAME: 50,
      PRODUCT_REMARK: 200,
    },
    PRODUCE_NUM: {
      MIN: 1,
      MAX: 99999999.99999999,
    },
    MESSAGE_STATUS: 'PRODUCT_MESSAGE_STATUS',
    DATENOW: moment().locale('zh-cn').format('YYYY-MM-DD'),
  },

  // 生产计划明细常量
  PRODUCT_PLAN_ITEM: {
    TYPE: {
      NAME: 'PRODUCT_PLAN_ITEM_STATUS',
      // 存在不确定因素（可根据字典类型加字典CODE查询）（可根据字典类型缓存到redis中）
      CAN_ORDER: '1', // 可下单
      COMPLETED: '2', // 已完成
    },
  },

  // 生产订单常量
  PRODUCT_ORDER: {
    TYPE: {
      NAME: 'PRODUCT_ORDER_STATUS',
      // 存在不确定因素（可根据字典类型加字典CODE查询）（可根据字典类型缓存到redis中）
      STATUS_WAIT_COMMIT: '1', // 待提交
      STATUS_WAIT_AUDIT: '2', // 待审核
      STATUS_WAIT_SURE: '3', // 待确定
      STATUS_EXECUTING: '4', // 生产中
      STATUS_FINISHED: '5', // 已完成
    },
  },


  // 生产订单类型常量
  PRODUCT_ORDER_TYPE: {
    TYPE: {
      NAME: 'PRODUCT_ORDER_TYPE',
      // 存在不确定因素（可根据字典类型加字典CODE查询）（可根据字典类型缓存到redis中）
      TYPE_FINISHED_PRODUCT: '1', // 成品
      STATUS_SEMI_FINISHED: '2', // 半成品
      STATUS_SUIT: '3', // 套装
      STATUS_OUTSOURCING: '4', // 委外
      STATUS_REWORK: '5', // 委外
    },
  },
  // 采购计划单据状态
  PURCHASE_PLAN: {
    TYPE: {
      NAME: 'PURCHASE_PLAN_STATUS',
      STATUS_WAIT_COMMIT: '1', // 等待提交
      STATUS_WAIT_AUDIT: '2', // 等待审核
      STATUS_WAIT_ORDER: '3', // 等待下单
      STATUS_WAIT_CONFIRM: '4', // 待确认
      STATUS_PRODUCTION: '5', // 生产中
      STATUS_FINISHED: '6', // 已完成
    },
    // 物料对应的采购计划类型
    MATERIAL_TYPE: {
      NAME: 'PURCHASE_PLAN_MATERIAL_TYPE',
      TYPE_RAW: '1', // 原料
      TYPE_PACKAGE: '2', // 包材
    },
    CREATE_LENGTH: {
      PRODUCT_NAME: 20,
      PRODUCT_REMARK: 200,
    },
    PRODUCE_NUM: {
      MIN: 1,
      MAX: 9999999999.9999,
    },
    MESSAGE_STATUS: 'PURCHASE_PLAN_MESSAGE_STATUS',
    DATENOW: moment().locale('zh-cn').format('YYYY-MM-DD'),
  },
  // 采购订单常量
  PURCHASE_ORDER: {
    TYPE: {
      NAME: 'PURCHASE_ORDER_STATUS',
      // 存在不确定因素（可根据字典类型加字典CODE查询）（可根据字典类型缓存到redis中）
      STATUS_WAIT_COMMIT: '1', // 待提交
      STATUS_WAIT_AUDIT: '2', // 待审核
      STATUS_WAIT_SURE: '3', // 待确定
      STATUS_EXECUTING: '4', // 生产中
      STATUS_FINISHED: '5', // 已完成
    },
  },

  // 用户信息
  USER: {
    URL: 'common/user/realname',
    TYPE: {
      ALL: '',
    },
  },

  // 原料入库单
  MATERIAL_IN: {
    STATUS: {
      NAME: 'MATERIAL_IN_STATUS',
    },
  },
  SEMI_FINISHED_IN: {
    TYPE: {
      NAME: 'SEMI_FINISHED_IN_STATUS',
      STATUS_WAIT_SUBMIT: '1', // 待提交
      STATUS_WAIT_AUDIT: '2', // 待审核
      STATUS_COMPLETED: '3'// 已入库
    },
    MESSAGE: {
      KEY: 'SEMI_FINISHED_IN_MESSAGE',
      content: '操作成功'
    }
  },
  // 其他出库单
  OTHER_OUT: {
    TYPE: {
      NAME: 'STOCK_OTHEROUT_STATUS',
      STATUS_WAIT_AUDIT: '1', // 待审核
      STATUS_LSSUED: '2', // 已出库
      STATUS_REVIEWED: '3', // 已审核
    },
  },

  // 其他出库
  OTHER_OUT_TYPE: 'OTHER_OUT_TYPE',

  // 其他入库
  OTHER_IN_TYPE: 'OTHER_IN_TYPE',


  // 其它出入库
  STOCK_OTHER: {

    EXCEL_PATH: {
      IN_IMPORT: 'stock/otherIn/otherInImport',
    },
    COMBINE_CODE: 'BM',// 其它出入库单据类型
    OUT: {
      SOURCE_TYPE_CODE: 'STOCK_OTHER_OUT_BILL_TYPE',// 其它出入库单据类型
      TYPE: {
        NAME: 'STOCK_OTHER_STATUS',
        STOCK_OTHER_WAIT_SUBMIT: '0', // 待提交
        STOCK_OTHER_WAIT_CONFIRM: '1', // 待出库
        STOCK_OTHER_FINISH: '2', // 已出库
      },
      VALUES: {
        '0': {text: '待提交'},
        '1': {text: '待出库'},
        '2': {text: '已出库'},
      },
    },
    IN: {
      SOURCE_TYPE_CODE: 'STOCK_OTHER_BILL_TYPE',// 其它出入库单据类型
      TYPE: {
        NAME: 'STOCK_OTHER_STATUS',
        STOCK_OTHER_WAIT_SUBMIT: '0', // 待提交
        STOCK_OTHER_WAIT_CONFIRM: '1', // 待入库
        STOCK_OTHER_FINISH: '2', // 已入库
      },
      VALUES: {
        '0': {text: '待提交'},
        '1': {text: '待入库'},
        '2': {text: '已入库'},
      },
    }
  },

  // 调拨出库单
  AllOCATION_OUT: {
    // 单据类型
    TYPE: {
      NAME: 'STOCK_ALLOCATIONOUT_TYPE',
      OUT_PRODUCT: '01', // 成品调拨单
      OUT_MATERIAL: '02', // 原料调拨单
      OUT_PACKAGING: '03', // 包材调拨单
      OUT_APPENDAGE: '04', // 附属商品调拨单
      OUT_SEMI_FINISHED: '05',// 半成品调拨单
    },
    // 单据状态
    STATUS: {
      NAME: 'STOCK_ALLOCATIONOUT_STATUS',
      WAIT_SUBMIT: '01', // 待提交
      WAIT_DELIVERY: '03', // 待出库
      ISSUED: '04', // 已出库
    },
    EXCEL_PATH: {
      OUT_IMPORT: 'stock/allocationOut/allocationOutImport',
    },
    VALUES: {
      '01': {text: '待提交'},
      '03': {text: '待出库'},
      '04': {text: '已出库'},
    },
  },
  // 包材库字典编码
  PACKING_LIBRARY:{
    TYPE: {
      INDUSTRY: 'PACKING_LIBRARY_INDUSTRY',
      PACKING_MATERIAL:'PACKING_LIBRARY_PACKING_MATERIAL',
      UNIT:'PACKING_LIBRARY_UNIT'
    }
  },

  // 退货调拨出库单
  REFUND_AllOCATION_OUT: {
    // 单据类型
    TYPE: {
      NAME: 'STOCK_REFUND_ALLOCATIONOUT_TYPE',
      OUT_PRODUCT: '01', // 成品调拨单
      OUT_APPENDAGE: '02', // 附属商品调拨单
    },
    // 单据状态
    STATUS: {
      NAME: 'STOCK_REFUND_ALLOCATIONOUT_STATUS',
      WAIT_DELIVERY: '01', // 待出库
      ISSUED: '02', // 已出库
    },
    EXCEL_PATH: {
      OUT_IMPORT: 'stock/allocationOut/allocationOutImport',
    },
    VALUES: {
      '01': {text: '待出库'},
      '02': {text: '已出库'},
    },
  },

  // 材料退货单
  SHIPMENT_REFUND: {
    STATUS: {
      NAME: 'SHIPMENT_REFUND_STATUS',
      DELETE: '0', // 删除
      CREATE: '1', // 待提交
      WAIT_REFUND: '2', // 待退货
      WAIT_RECEIVE: '3', // 已退货
      FINISH_REFUND: '4', // 已接收
    },
  },
  // 材料退库单
  MATERIAL_REFUND: {
    STATUS: {
      NAME: 'RETURN_ORDER_STATUS',
      CREATE: '1', // 待提交
      WAIT_REFUND: '2', // 待退库
      WAIT_RECEIVE: '3', // 已退库
      FINISH_REFUND: '4', // 已接收
    },
  },
  // 成品退库
  WMS_RETURN: {
    STATUS: {
      NAME: 'WMS_RETURN_STATUS',
      STATUS_WAIT_SUBMIT: '01', // 待提交
      STATUS_WAIT_OUT_STOCK: '02', // 待出库
      STATUS_OVER_OUT_STOCK: '03', // 待接收
      STATUS_OVER_IN_STOCK: '04', // 已接受
    },
    REASON: {
      NAME: 'WMS_RETURN_REASON',
    },
    MIN_VALUE: 1,
  },
  /**
   * excel 下载地址
   */
  PRODUCT_EXCEL_PATH: {
    PLAN_EXPORT: 'api/product/plan/downExcel',
    ITEM_EXPORT: 'api/product/plan/item/downExcel',
    PLAN_IMPORT: 'product/plan/planImport',
    SALE_IMPORT: 'api/stock/salesOut/import',
    SALE_RETURN_IMPORT: 'stock/salesReturnImport/batchImport',
    SALE_OUT_IMPORT: 'stock/salesOutImport/batchImport',
    SUPPLIER_CODE_IMPORT: 'purchase/compareToCode/supplierImport',
    SUPPLIER_CONTRACT_IMPORT: 'purchase/contractToCode/supplierImport',
    DISTRIBUTION_EXPORT: 'api/distribution/downExcel',
    INVENTORY_SURPLUS_LOSSES_IMPORT: 'inventoryAdjustment/batchImport',
    SUPPLIER_PRICE_IMPORT: 'base/supplierPrice/downloadTemplate'
  },
  /**
   * excel上传地址
   */
  EXCEL_IMPORT_PATH: {
    SUPPLIER_IMPORT: 'base/supplier/batchImport',
    CUSTOMER_IMPORT: 'base/customer/batchImport',
    SUPPLIER_PRICE_IMPORT: 'base/supplierPrice/supplierPriceImport'
  },
  /*
  * 包材库图片上传
   */
  PACKING_IMPORT_PATH:{
    IMAGE_IMPORT: 'packing/library/batchImport'
  },
  /**
   * 采购计划下载地址
   */
  CGJH_EXCEL_PATH: {
    PLAN_EXPORT: 'purchase/plan/purchasePlanDownExcel',
    ITEM_EXPORT: 'purchase/plan/purchaseDetailsExcel',
    PLAN_IMPORT: 'purchase/plan/planImport',
  },
  /**
   * 采购订单下载地址
   */
  CGDD_EXCEL_PATH: {
    PLAN_EXPORT: 'purchase/order/downExcel',
  },
  // 领料出库单
  PACKING: {
    TYPE: {
      NAME: 'PACKING_STATUS',
    },
  },
  // 供应商常量
  SUPPLIER: {
    // 供应商分类 ，其中key为指定的键名称，value为数据字典中的字典编码
    TYPE: {
      NAME: 'supplierType',
      MATERIAL: 'YL', // 原料供应商类型
      PACKAGE: 'BC', // 包材供应商类型
      PRODUCT: 'WW', // 加工商
      LOGISTICS: 'WL', //物流供应商
      OTHER: 'QT', // 其它
      LIBRARY:'BK01' // 包材库
    },
    URL: 'common/supplier/listSupplier',
    URL1:'common/supplier/getSupplierByType',
    PACKING_RUL:'packingSupplier/listPackingSupplier',
    // 供应商等级
    GRADE: {
      NAME: 'supplierGrade',
    },
    // 币种
    CURRENCY: {
      NAME: 'CURRENCY',
      RMB: '01', // 人民币
    },
    // 供应商固定的不能选的叶子节点
    FIXED: ['YL', 'BC'], // WL物流供应商 QT其它
    // 供应商分类固定的不需要有子类的分类
    CATEGORY: {
      FIXED: ['WW', 'WL', 'QT'], // WW 加工商 WL物流供应商 QT其它
    }
  },
  // 仓库常量
  WAREHOUSE: {
    // 仓库分类 ，其中key为指定的键名称，value为数据字典中的字典编码
    TYPE: {
      NAME: 'WAREHOUSE_TYPE',
      OEM: '1', // OEM成品仓库
      PRODUCT: '2', // WMS仓
      MATERIAL: '3', // OEM材料仓
    },
    // 模糊查询
    URL_LIKE: 'common/warehouse/listWarehouseName',
    URL_LIKE_NAME: 'common/warehouse/listWarehouse',
    URL: 'common/warehouse/listEnabled',
    // 发货列表模糊查询
    SHIPMENT_URL: 'common/warehouse/likeListWarehouse',
  },
  // 物料常量
  MATERIAL: {
    URL: 'common/material/listMaterial',
    URL1: 'common/material/listMaterialSum',
    URL2: 'common/material/materialList',
    TYPE: {
      NAME: 'BASE_MATERIAL_TYPE',
      PACKAGE_MATERIAL: '11', // 包材
      RAW_MATERIAL: '12', // 原材料
      SEMI_FINISHED: '13', // 半成品
      COMPOUND_MATERIAL: '1300', // 复合材料
      PRODUCT: '14', // 成品
      SERVICE: '15', // 服务
      APPENDAGE: '16', // 附属品
    },
  },
  /**
   * excel 下载(导入)地址
   */
  MATERIAL_EXCEL_PATH: {
    MATERIAL_EXPORT: 'api/base/material/batchExport',
    MATERIAL_IMPORT: 'http://localhost:8000/api/base/material/batchImport',
  },
  /**
   * 库存预警 导入 地址
   */
  WARNING_EXCEL_PATH: {
    MATERIAL_IMPORT: 'api/stock/warning/warningImport',
  },
  /**
   * 仓库管理excel 下载(导入)地址
   */
  CKGL_EXCEL_PATH: {
    PLAN_EXPORT: 'api/base/warehouse/downloadExcel',
    PUT_EXCEL: 'http://localhost:8000/api/base/warehouse/putExcel',
  },
  // 时间日期相关
  DAY: {
    TIME_START: '00:00:00', // 每天的开始时间戳
    TIME_END: '23:59:59', // 每天的结束时间戳
  },
  MONTH: {
    DAY_START: '01', // 每月的第一天
    DAY_END: '31', // 每月最后一天
  },
  DATE_FORMAT: {
    YEAR: 'YYYY',
    MONTH: 'YYYY-MM',
    DAY: 'YYYY-MM-DD',
    HOURS: 'YYYY-MM-DD HH',
    MINUTES: 'YYYY-MM-DD HH:mm',
    SECONDS: 'YYYY-MM-DD HH:mm:ss',
    START_DAY: 'YYYY-MM-DD 00:00:00',
    END_DAY: 'YYYY-MM-DD 23:59:59',
  },
  // 财务管理
  FINANCE: {
    // 凭证单据类型
    CERTIFICATE: {
      TYPE: {
        MATERIAL: '101',
        INVOICE: '201',
        INVOICE_RED: '202',
        FREIGHT: '203',
        FREIGHT_RED: '204',
        PAYMENT: '205',
        OTHER_PAYMENT: '206',
        RECEIVABLE: '301',
        OTHER_RECEIVABLE: '302',
        SALES: '303',
        SALES_RED: '304',
      },
      STATUS: {
        INITIAL: '0',
        PUSHED: '1',
        FAILED: '2',
        SUCCESS: '3'
      }
    },
    // 科目列表
    SUBJECTS_CODE: {
      URL: 'finance/cost/code',
    },
    //发票
    INVOICE: {
      STATUS: {
        TO_AUDIT: '01', // 待审核
        AUDITED: '02', // 已审核
        VERIFIED: '03', // 已验证
      },
      TYPE: {
        ORDINARY_INVOICE: '01', // 普通发票
        RED_INVOICE: '02', // 红字发票
        FREIGHT_INVOICE: "03", // 运费发票
        SPECIAL_INVOICE: "04", //"增值税专用发票"),
        RED_SPECIAL_INVOICE: "05", //"增值税专用发票-红字")
        SPECIAL_FREIGHT_INVOICE: "06", // 运费发票
        LIST: [
          {code: "01", type: 1, text: "增值税普通发票"},
          {code: "04", type: 1, text: "增值税专用发票"},
          {code: "02", type: 2, text: "增值税普通发票-红字"},
          {code: "05", type: 2, text: "增值税专用发票-红字"},
          {code: "03", type: 3, text: "增值税普通发票-运费"},
          {code: "06", type: 3, text: "增值税专用发票-运费"},
        ]
      },
      ORDER_TYPE: {
        WMS_IN: '01', // wms入库单
        WMS_RETURN: '02', // wms退库单
        MATERIAL_IN: '03', // 材料入库单
        MATERIAL_RETURN: '04', // 材料退库单
        SEMI_IN: '05', // 半成品入库单
      },
    },
    // 付款申请单状态
    PAYMENT_REQUEST_STATUS: {
      WAIT_PUSH: '5', //"待推送",
      WAIT_CHECK: '0', //"待审核"),
      REJECTED: '1', //"已驳回"),
      WAIT_PAY: '2', //"待付款"),
      PARTIAL_PAYED: '3', //"部分付款"),
      ALL_PAYED: '4', //"已付款"),
    }
  },
  // 质检状态
  QUALITY_STATUS: {
    WAIT_QUALITY: '0', // "待质检",
    RELEASE: '1', // "合格放行"),
    SPECIAL_RELEASE: '2', // "特批放行"),
    UNQUALIFIED_FACTORY: '3', // "不合格-工厂"),
    UNQUALIFIED_GARDEN: '4', // "不合格-半亩"),
  },
  // 配货子表状态
  DISTRIBUTION: {
    TYPE: {
      NAME: 'DISTRIBUTION_STATUS',
      // 配货订单状态 ，其中key为指定的键名称，value为数据字典中的字典编码
      STATUS_WAIT_COMMIT: '1', // 待提交
      STATUS_WAIT_SHIP: '2', // 待发货
      STATUS_PARTIAL_SHIPMENT: '3', // 部分发货
      STATUS_ALL_SHIPMENTS: '4', // 全部发货
      STATUS_FINISHED: '5', // 已完成
      STATUS_CANCEL: '6', // 已取消
      STATUS_COMMIT: '20', // 已提交(用于主表)
    },
    DIRECTION: {
      WMS: '0',
      OEM_MATERIAL: '1',
      CODE: 'DISTRIBUTION_DIRECTION',
    },
    COLLECTION: {
      TYPE: {
        '01': {text: "已出库", status: "Success"},
        '02': {text: "已退回", status: "Error"},
      }
    },
    PUSH_SYSTEM: {
      NAME:'PUSH_SYSTEM_OMS',
      TYPE:{
        JY_OMS:'0',
        NEW_OMS:'1',
      }
    }
  },
  // 币种
  CURRENCY: 'CURRENCY',
  // 异动单据类型
  STOCK_CHANGES_TYPE: 'STOCK_CHANGES_TYPE',

  // message弹出框持续时间
  MESSAGE_DURATION: {
    TIME: {
      ERROR: 5, // 5s
      INFO: 2, // 2s
    },
  },
  // 调拨入库单号
  ALLOCATION_IN: {
    STATUS: {
      NAME: 'STOCK_ALLOCATION_IN_STATUS',
      STATUS_WAIT_IN_STOCK: '02', // 待入库
      STATUS_OVER_IN_STOCK: '03', // 已入库
    },
    TYPE: {
      NAME: 'STOCK_ALLOCATIONOUT_TYPE',
      PRODUCT: '01', // 成品
      MATERIAL: '02', // 物料
    },
    VALUES: {
      '02': {text: '待入库'},
      '03': {text: '已入库'},
    }
  },

  // wms入库
  WMS_IN: {
    CODE_URL: 'common/wmsIn/code',
    STATUS: {
      NAME: 'STOCK_WMS_IN_STATUS',
      STATUS_CLOSE: '00',//已关闭
      STATUS_WAIT_SUBMIT: '01', // 待提交
      STATUS_WAIT_IN_STOCK: '02', // 待入库
      STATUS_OVER_IN_STOCK: '03', // 已入库
    },
  },
  STOCK_INFO: {
    MATERIAL: {
      ALL: true,
    },
  },
  // 其他出库单
  MATERIAL_RETURN: {
    MESSAGE_STATUS: 'WARN_INFO',
    EXCEL_PATH: {
      OUT_IMPORT: 'stock/otherOut/otherOutImport',
    },
    TYPE: {
      NAME: 'STOCK_MATERIAL_RETURN_STATUS',
      STATUS_WAIT_RETURN: '01', // 待退货
      STATUS_WAIT_RECEIVE: '02', // 待接收
      STATUS_REVIEWED: '03', // 已接收
    },
    REASON: 'MATERIAL_RETURN_REASON',
  },
  // 统一组件大小 default | middle | small
  SIZE: {
    PRO_TABLE: 'middle',
    ITEM_TABLE: 'small',
  },

  // 发货列表常量
  SRM_SHIPMENT_STATUS: {
    TYPE: {
      NAME: 'SRM_SHIPMENT_STATUS',
      // 存在不确定因素（可根据字典类型加字典CODE查询）（可根据字典类型缓存到redis中）
      STATUS_NOT_RECEIVED: '1', // 待发货
      STATUS_TO_BE_RECEIVED: '2', // 待收货
      STATUS_RECEIVED_GOODS: '3', // 已收货
      STATUS_RECEIVED: '4', // 部分入库
      COMPLETED: '5', // 已完成
    },
    VALUE: {
      '1': {text: '待发货'},
      '2': {text: '待收货'},
      '3': {text: '已收货'},
      '4': {text: '部分入库'},
      '5': {text: '已完成'},
    },
  },
  // 失败日志操作模块编码
  SCM_FAILED_LOG_OPERATION_CODE: {
    TYPE: {
      NAME: 'OPERATION_CODE',
      CODE_PURCHASE_INVOICE: '001', // 采购发票
      CODE_FINANCIAL_MATERIALS_OUT_STOCK: '002', // 财务原料出库
      CODE_FINANCIAL_ACCOUNTING: '003', // 财务记账
      CODE_COLLECT_GOODS_CREDENTIALS: '004', // 采货凭证
      CODE_CANCEL_THE_ACCOUNT_DELETE_CREDENTIAL_INFORMATION: '005', //取消记账删除凭证信息
    },
    VALUE: {

      '1': {code: '001', text: '采购发票'},
      '2': {code: '002', text: '财务原料出库'},
      '3': {code: '003', text: '财务记账'},
      '4': {code: '004', text: '采货凭证'},
      '5': {code: '005', text: '取消记账删除凭证信息'},
    },
  },
  // 质检状态
  PRODUCT_IN_ITEM_QUALITY_STATUS: {
    CODE: 'PRODUCT_IN_ITEM_QUALITY_STATUS'
  },
  // 成品发货列表常量
  SRM_FACTORY_SHIPMENT_STATUS: {
    TYPE: {
      NAME: 'SRM_FACTORY_SHIPMENT_STATUS',
      // 存在不确定因素（可根据字典类型加字典CODE查询）（可根据字典类型缓存到redis中）
      STATUS_DELIVERED: '1', // 已发货
      STATUS_COMPLETED: '2', // 已完成
    },
  },
  // 成品发货列表常量
  SRM_FACTORY_SHIPMENT_ITEM_STATUS: {
    TYPE: {
      NAME: 'SRM_FACTORY_SHIPMENT_ITEM_STATUS',
      // 存在不确定因素（可根据字典类型加字典CODE查询）（可根据字典类型缓存到redis中）
      STATUS_NORMAL: '1', // 正常
      STATUS_NULLIFY: '2', // 作废
    },
    VALUE:{
      '1':{code:'1',text:'正常'},
      '2':{code:'2',text:'作废'},
    }
  },
  // 地址是备货仓
  WARE_HOUSE_STOCK: {
    STOCK_UP: '备货仓',
  },

  // 客户分类编码
  CUSTOMER: {
    TYPE: {
      NAME: 'CUSTOMER_CLASSIFICATION_CODE',
    },
    URL: 'common/customer/getLikeMore',
  },
  // 财务价格
  PRICE: {
    MIN: 1,
    MAX: 9999999999.999999
  },
  // 财务单据类型
  FINANCE_BUSINESS_TYPE: {
    // 原料盘盈入库
    MATERIAL_CHECK_IN: '3',
    // 原料调拨入
    MATERIAL_ALLOT_IN: '4',
    // 包材调拨入
    PACKAGE_ALLOT_IN: '27',
    // 包材盘盈入库单
    PACKING_CHECK_IN: '32',
    // 半成品调拨入
    SEMI_ALLOT_IN: '37',
    // 半成品盘盈入库单
    SEMI_CHECK_IN: '40',
    // 成品盘点入库
    PRODUCT_CHECK_IN: '9',
    // 成品调拨入
    PRODUCT_ALLOT_IN: '10',
    // 半成品入库单
    SEMIFINISH_PRODUCT_IN: '23',
    // wms入库单
    WMS_PRODUCT_IN: '7',
    // 成品销售退库单
    PRODUCT_SALE_RETURN: '13',
    // wms 退库单
    WMS_PRODUCT_RETURN:"8",
    // 套装礼盒入库单
    SUIT_BOX_IN:"31"
  },
  // 财务记账状态
  FINANCE_BILL_STATUS: {
    // 未记账
    NO_ACCOUNTING: '0',
    // 已记账
    ACCOUNTING: '1',
    // 已生成凭证
    CREATE_VOUCHER: '2'
  },
  // 付款单单据类型
  FINANCE_PAYMENT_TYPE: {
    // 采购订单
    PURCHASE_ORDER: '0',
    // 生产订单
    PRODUCTION_ORDER: '1',
    // 采购发票
    PURCHASE_INVOICE: '2',
    // 运费发票
    FREIGHT_INVOICE: '3',
    // 空白单据
    BLANK: '4',
    // 付款申请单
    PAYMENT_REQUEST: '5'
  },
  // 凭证推送状态
  FINANCE_CERTIFICATE_PUSH_STATUS: {
    /**
     * 待推送
     */
    INITIAL: '0',
    /**
     * 已推送
     */
    PUSHED: '1',
    /**
     * 推送失败
     */
    FAILED: '2',
    /**
     * 推送成功
     */
    SUCCESS: '3'
  },
  // 付款单、收款单凭证状态
  FINANCE_PAYMENT_STATUS: {
    // 待生成凭证
    WAIT_CREATE_VOUCHER: '0',
    // 已生成凭证
    CREATED_VOUCHER: '1'
  },
  // 应收单单据类型
  FINANCE_RECEIVABLES_TYPE: {
    INVOICE: '0',
    // 空白单据
    BLANK: '1'
  },
  CLOSING_DEAL_STATUS: {
    // 待结账
    WAIT_CLOSING: '0',
    // 已结账
    CLOSING: '1',
    // 取消结账
    CANCEL_CLOSING: '2'
  },
  FORM_LAYOUT: {
    labelCol: {
      lg: {span: 8},
      md: {span: 10},
      xs: {span: 12},
    },
    wrapperCol: {
      lg: {span: 16},
      md: {span: 14},
      xs: {span: 12},
    },
  },
  // 退货原因
  REFUND_CASE: {
    NAME: 'REFUND_CASE',
  },
  // 工作台导航类型
  WORK_BENCH_NAVIGATION: {
    TYPE: {
      BUTTON: 'Button',
      LINK: 'Link',
    }
  },
  // scm工作台
  WORKBENCH_MESSAGE: {
    TYPE: {
      BOM: '1', // bom
      PRODUCT_PLAN: '2', // 生产计划
      PRODUCT_ORDER: '3', // 生产订单
      PURCHASE_PLAN: '4', // 采购计划
      PURCHASE_ORDER: '5', // 采购订单
    },
  },
  // 用户信息
  DEPARTMENT: {
    URL: 'common/department/getByName',
  },
  // 操作日志字典类型
  OPERATION_LOG_TYPE: {
    CODE: 'OPERATION_LOG_TYPE',
  },
  // 整单字典类型
  ORDER_RELATION: {
    CODE: 'ORDER_RELATION',
  },

  // 操作日志字典类型
  PURCHASE_PLAN_ITEM_STATUS: {
    CODE: 'PURCHASE_PLAN_ITEM_STATUS',
  },
  // 质检报告上传
  FILE_ACCEPT: '.xlsx,.xls,.doc,.docx,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,' +
    '.pdf,application/pdf,.jpg,.jpeg,.png,.rar,.zip,.tz',
  FILE_TYPE: [".doc", ".docx", ".pdf", ".xlsx", ".xls", ".jpg", ".jpeg", ".png", ".rar", ".zip", ".tz"],
  FILE_MESSAGE: "只能上传图片、WORD、PDF、EXCEL、压缩格式文件",
  FILE_SIZE: 30, // M
  DEPARTMENT_DATA: {
    '01': '总经办',
    '0101': '总经理办',
    '0102': '信息部',
    '02': '财务部',
    '03': '人资部',
    '04': '运营中心',
    '05': '产品部',
    '0501': '产品研发',
    '0502': '产品策划',
    '0503': '产品数据部',
    '06': '品牌部',
    '0601': '品牌策划',
    '0602': '品牌设计',
    '0603': '品牌推广',
    '07': '客服部',
    '0701': '售前组',
    '070101': '售前组一',
    '070102': '售前组二',
    '070103': '售前组三',
    '0702': '售后组',
    '0703': '审单组',
    '0704': '客户关系',
    '08': '采购部',
    '09': '仓储部',
    '10': '物流部',
    '1001': '预包装',
    '1002': '现场',
    '1003': '成品',
    '11': '生产部',
    '12': '质检部',
    '15': '工厂行政',
    '16': '工厂办公室',
    '17': '公司办公室',
    '18': '计划部',
    '1801': '计划组',
    '1802': '采购订单执行组',
    '19': '生产部',
    '1901': '生产车间',
    '1902': '仓储',
    '190201': '包材库',
    '190202': '原料库',
    '190203': '成品库',
    '20': '综合部',
    '2001': '人资行政',
    '2002': '资金管理组',
    '2003': '质检组',
    '2004': '供应商管理组',
    '2005': '工厂综合',
    '21': '供应中心',
    '2101': '采购部',
    '2102': '采购订单执行组',
    '22': 'OEM管理部',
    '2201': 'OEM管理组',
    '23': '后端EMT',
    '2301': '后端EMT部',
    '24': '研发部',
    '25': '广州办事处',
  },
  SELECT_ALL: '666',
  UNSELECT_ALL: '888',
};
export default Constants;
