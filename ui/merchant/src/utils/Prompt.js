/**
 * 提示信息公共存放类
 *
 */
const Prompt = {

  //--------------------------------↓公共部分↓------------------------------------

  //增删改查提示信息
  CRUD: {
    //成功
    SUCCESS: {
      CS: '添加成功',
      RS: '查询成功',
      US: '更新成功',
      DS: '删除成功'
    },
    //失败
    FAILURE: {
      CF: '添加失败',
      RF: '查询失败',
      UF: '更新失败',
      DF: '删除失败'
    }
  },

  //公共提示信息
  COMMON: {
    DELETE_CONFIRM: {
      content: '确定要删除该单据吗？',
      key: 'DELETE_MESSAGE_KEY',
    },
    DELETE_CHECK_COUNT: {
      content: "至少保留一条数据!",
      key: 'REMOVE_DATA_SAVE_ONE'
    },
    //点击“修改”、“通过”、“驳回”、“反审”按钮
    STATE_SUCCESS: {
      content: '单据状态发生变更，请刷新页面后再操作',
      key: 'STATE_MESSAGE_KEY'
    },
    CANCEL_SUCCESS: {
      content: '确定要放弃创建单据吗？取消后将清空所有已填数据',
      key: 'CANCEL_MESSAGE_KEY'
    },
    COMMIT_SUCCESS: {
      content: '提交成功',
      key: 'COMMIT_MESSAGE_KEY'
    },
    CHECK_SAVE: {
      content: '请完成保存后进行确定操作',
      key: 'is_editing',
    },
    CHECK_ITEM_EMPTY: {
      content: '请填写明细后进行保存操作',
      key: 'data_empty',
    },
    SAVE_SUCCESS: {
      content: '保存成功',
      key: 'SAVE_MESSAGE_KEY'
    },
    EXPORT_SUCCESS: {
      content: '数据导出成功',
      key: 'EXPORT_MESSAGE_KEY'
    },
    IMPORT_SUCCESS: {
      content: '数据导入成功',
      key: 'IMPORT_MESSAGE_KEY'
    },
    CHECK_SUPPLIER_EMPTY: {
      content: '供应商数据已被禁用',
      key: 'SUPPLIER_EMPTY_KEY'
    }
  },

  //-----------------------------------↓个人部分↓---------------------------------

  //命名规则: 请以自己的模块为名

  //发货单
  SHIPMENT: {
    //S结尾为成功
    SHIPMENT_SUCCESS: '发货成功',
    //F结尾为失败
    SHIPMENT_FAILURE: '发货失败',
    //发货数量提示信息
    NUMBER: {
      1: '提示1',
      2: '提示2',
      3: '提示3',
    },
    //批次号提示信息
    BATCH: {
      1: '提示1',
      2: '提示2',
      3: '提示3',
    }
  },

  /**
   * 半成品入库单
   */
  SEMI_FINISH: {
    RECEIVED_QUANTITY_CHECK: {
      content: '请填写入库数量',
      key: 'RECEIVED_QUANTITY_MESSAGE_KEY',
    },
    RECEIVED_QUANTITY_MORE_CHECK: {
      content: '入库数量大于发货数量，请重新填写',
      key: 'RECEIVED_QUANTITY_MESSAGE_KEY',
    }
  },
  MATERIAL_RETURN: {
    CHECK_MORE_QUANTITY: {
      content: '退库数量不能大于可退库数量',
      key: 'DATA_TOO_LAGER',
    },
    CHECK_EMPTY_QUANTITY: {
      content: '退库数量不能为空',
      key: 'DATA_NOT_NULL',
    }
  },
  INVOICE: {
    CHECK_SAVE: {
      content: '价税合计不等于金额加税额，请重新填写',
      key: 'CHECK_SAVE'
    },
    CHECK_MORE_QUANTITY: {
      content: '开票数量不能大于可开票数量',
      key: 'CHECK_SAVE'
    }
  }
};

export default Prompt;
