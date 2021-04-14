import {parse} from 'querystring';
import pathRegexp from 'path-to-regexp';
import {Input, Tooltip, Modal} from 'antd';
import React from 'react';
import config from '../../config/config';
import request, {errorHandler} from '@/utils/request';
import {ExclamationCircleOutlined} from "@ant-design/icons";
import Constants from "@/utils/Constants";

/* eslint no-useless-escape:0 import/prefer-default-export:0 */
const reg = /(((^https?:(?:\/\/)?)(?:[-;:&=\+\$,\w]+@)?[A-Za-z0-9.-]+(?::\d+)?|(?:www.|[-;:&=\+\$,\w]+@)[A-Za-z0-9.-]+)((?:\/[\+~%\/.\w-_]*)?\??(?:[-\+=&;%@.\w_]*)#?(?:[\w]*))?)$/;
export const isUrl = (path) => reg.test(path);

export const getPageQuery = () => parse(window.location.href.split('?')[1]);
/**
 * props.route.routes
 * @param router [{}]
 * @param pathname string
 */

export const getAuthorityFromRouter = (router = [], pathname) => {
  const authority = router.find(
    ({routes, path = '/'}) =>
      (path && pathRegexp(path).exec(pathname)) ||
      (routes && getAuthorityFromRouter(routes, pathname)),
  );
  if (authority) return authority;
  return undefined;
};
export const getRouteAuthority = (path, routeData) => {
  let authorities;
  routeData.forEach((route) => {
    // match prefix
    if (pathRegexp(`${route.path}/(.*)`).test(`${path}/`)) {
      if (route.authority) {
        authorities = route.authority;
      } // exact match

      if (route.path === path) {
        authorities = route.authority || authorities;
      } // get children authority recursively

      if (route.routes) {
        authorities = getRouteAuthority(path, route.routes) || authorities;
      }
    }
  });
  return authorities;
};

export function getRouterPathname() {
  if (config.history.type === 'hash') {
    return window.location.hash.replace('#', '');
  }
  return window.location.pathname;
}

export function isDifferentRouter(pathname) {
  return getRouterPathname() !== pathname;
}

/**
 * Moment日期对象转为String字符串
 * @param moment date类型
 * @param format 格式
 * @returns {YYYY-MM-DD}
 */
export function momentToDateStringFormat(moment, format) {
  return moment.format(format);
}

/**
 * Moment日期对象转为String字符串
 * @param moment  date类型
 * @returns {YYYY-MM-DD}
 */
export function momentToDateString(moment) {
  return moment.format('YYYY-MM-DD');
}

/**
 * Moment时间戳对象转为String字符串
 * @param moment  datetime类型
 * @returns {YYYY-MM-DD HH:mm:dd}
 */
export function momentToDatetimeString(moment) {
  return moment.format('YYYY-MM-DD HH:mm:dd');
}

/**
 * 排序处理
 * @param columns         table的columns数组
 * @param sorterResult    pro-table的onchange返回排序信息
 * @param orders          业务模块定义的数组state，用于存储排序规则（正序/倒序）
 * @param setOrders       orders state对应的setter方法
 * @param orderFields     业务模块定义的数组state，用于存储排序字段名称
 * @param setOrderFields  orderFields state对应的setter方法
 */
export function handleSorter(
  columns,
  sorterResult,
  orders,
  setOrders,
  orderFields,
  setOrderFields,
) {
  if (sorterResult.field) {
    let {field} = sorterResult;
    columns.map((col, index) => {
      if (col.dataIndex === sorterResult.field) {
        if (col.sortKey) {
          field = col.sortKey;
        }
        return false;
      }
    });
    const idx = orderFields.indexOf(field);
    if (idx !== -1) {
      orderFields.splice(idx, 1);
      orders.splice(idx, 1);
    }
    setOrders([...orders, sorterResult.order]);
    setOrderFields([...orderFields, field]);
  }
}

/**
 * 将数组转为英文逗号分隔的字符串，用于后台接口数据转换
 * @param params  请求参数JSON对象
 */
export function sorterToParams(params) {
  if (params?.orders) {
    params.orders = params.orders.join(',');
  }
  if (params?.orderFields) {
    params.orderFields = params.orderFields.join(',');
  }
  return params;
}

/**
 * table中需要省略超长文本，在onCell中调用此函数，返回style，需要配合ellipsisRender函数使用
 * @see {@link ellipsisRender}
 * @return style json
 */
export function ellipsisOnCell() {
  return {
    style: {
      maxWidth: 150,
      overflow: 'hidden',
      whiteSpace: 'nowrap',
      textOverflow: 'ellipsis',
      cursor: 'pointer',
    },
  };
}

/**
 * table中需要省略超长文本，在render中调用此函数，传入文本全部内容，需要配合ellipsisOnCell函数使用
 * @see {@link ellipsisOnCell}
 * @return <Tooltip>
 */
export function ellipsisRender(text) {
  return (
    <Tooltip placement="topLeft" title={text}>
      {text}
    </Tooltip>
  );
}

/**
 * 文件下载方法
 * @param url 访问地址
 * @param params 后台参数
 * @param options request 配置项
 * @param callback 导出完成执行的方法
 * @param fileType 文件类型
 */
export function download(url, params, options, callback, fileType) {
  let opts = options ? {...options, method: options.method || 'POST'} : {method: 'POST'}
  if (opts.method.toLocaleLowerCase() === 'post') {
    opts = { ...opts, data: params }
  } else {
    opts = { ...opts, params }
  }
  console.info("url",url);
  request(url, {
    ...opts,
    getResponse: true,
    responseType: 'blob',
    errorHandler:error => {
      if (callback) {
        callback();
      }
      errorHandler(error)
    }
  }).then((resp) => {
    const blob = new Blob([resp.data], {
      type:
        fileType ||
        'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8',
    });
    const {response} = resp;
    const linkUrl = window.URL.createObjectURL(blob);
    const link = document.createElement('a');
    link.style.display = 'none';
    link.href = linkUrl;
    let fileName = '';
    if (response.headers.get('content-disposition')) {
      const str = response.headers.get('content-disposition');
      fileName = str.substring(str.indexOf('=') + 1);
    }
    link.setAttribute('download', decodeURIComponent(fileName));
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
    if (callback) {
      callback();
    }
  });
}

/**
 * 去除input记忆
 * @param onChange
 * @returns {*}
 */
export const renderFormItem = (onChange) => {
  return <Input onChange={onChange} placeholder="请输入" allowClear autoComplete="off"/>;
};

/**
 * 去除空格
 * @param e
 * @returns {string|StringChain|LoDashExplicitWrapper<string>|this}
 */
export const handleValueDeal = (e) => {
  return e.target.value.trim()
};



export const completeConfirm = (onOk, title, content, onCancel) => {
  title = title || '确定要放弃操作吗';
  content = content || '取消后将还原所有已填数据';
  Modal.confirm({
    title,
    icon: <ExclamationCircleOutlined />,
    content,
    okText: '确定',
    okType: 'danger',
    cancelText: '取消',
    onOk() {
      if (onOk && typeof onOk === 'function') {
        onOk();
      }
    },
    onCancel() {
      if (onCancel && typeof onCancel === 'function') {
        onCancel();
      }
    },
  });
};

export const logConfirm = (onOk, title, content, onCancel) => {
  title = title || '确定要关闭吗';
  Modal.confirm({
    title,
    icon: <ExclamationCircleOutlined />,
    content,
    okText: '确定',
    okType: 'danger',
    cancelText: '取消',
    onOk() {
      if (onOk && typeof onOk === 'function') {
        onOk();
      }
    },
    onCancel() {
      if (onCancel && typeof onCancel === 'function') {
        onCancel();
      }
    },
  });
};

export const scientificToNumber=(num)=>{
  if (num === null ){
    return num;
  }
  if (num === 0){
    return '0';
  }
  if (!num || "-".toString().match(num)) {
    return null;
  }
  let str = num.toString();
  let reg1 = /^(\d+)(e)([\-]?\d+)$/;
  let reg2 = /^(\d+\.\d+)(e)([\-]?\d+)$/;
  let arr, len,
    zero = '';
  if (!reg1.test(str) && !reg2.test(str)) {
    return num;
  } else if (reg1.test(str)){
    arr = reg1.exec(str);
    len = Math.abs(arr[3]) - 1;
    for (let i = 0; i < len; i++) {
      zero += '0';
    }
    return '0.' + zero + arr[1];
  } else {
    arr = reg2.exec(str);
    len = Math.abs(arr[3]) - 1;
    for (let j = 0; j < len; j++) {
      zero += '0';
    }
    let suffix = arr[1].split('.')[0].concat(arr[1].split('.')[1]);
    return '0.' + zero + suffix;
  }
};
export const indexRender = (text, record, index) => {
  return index + 1;
};
/**
 * 科学计数法转换
 * @param num
 * @returns {string | *}
 */
export function toNonExponential(num) {
  if (typeof num !== 'number'){
    return num;
  }
  let m = num.toExponential().match(/\d(?:\.(\d*))?e([+-]\d+)/);
  return num.toFixed(Math.max(0, (m[1] || '').length - m[2]));
}
export const handleWarehouseMap = (warehouse) => {
  let ware = warehouse;
  if (warehouse != null) {
    if (warehouse.length > Constants.TABLE.COLUMNS.WAREHOUSE_LENGTH) {
      ware = warehouse.substring(0, Constants.TABLE.COLUMNS.WAREHOUSE_LENGTH);
      ware += "...";
    }
  } else {
    return <span>-</span>
  }
  return (
    <Tooltip title={warehouse}>
      <span>{ware}</span>
    </Tooltip>
  );
};
export const handleWordMap = (word, length) => {
  let ware = word;
  if (word != null) {
    if (word.length > length) {
      ware = word.substring(0, length);
      ware += "...";
    }
  } else {
    return <span>-</span>
  }
  return (
    <Tooltip title={word}>
      <span>{ware}</span>
    </Tooltip>
  );
};

/**
 * 减法运算
 * @param num1  被减数
 * @param num2 减数
 * @returns {number} 减值
 */
export const numSub = (num1, num2) => {
  var baseNum, baseNum1, baseNum2;
  var precision;// 精度
  try {
    baseNum1 = num1.toString().split(".")[1].length;
  } catch (e) {
    baseNum1 = 0;
  }
  try {
    baseNum2 = num2.toString().split(".")[1].length;
  } catch (e) {
    baseNum2 = 0;
  }
  baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
  precision = (baseNum1 >= baseNum2) ? baseNum1 : baseNum2;
  return Number(((num1 * baseNum - num2 * baseNum) / baseNum).toFixed(precision));
};
/**
 * 加法运算: 思路为 放大倍数后相加在除回去
 * @param num1 加数1
 * @param num2 加数2
 * @returns {number} 总和
 */
export const numAdd = (num1, num2) => {
  var a;
  const op = String(num1).indexOf(".") + 1;//获取小数点的位置
  if(op > 0) {
     a = num1.toString().split(".")[1].length;
  } else {
     a = 0;
  }
  var b;
  const opp = String(num2).indexOf(".") + 1;//获取小数点的位置
  if(opp > 0) {
    b = num2.toString().split(".")[1].length;
  } else {
    b = 0;
  }
  if (a === 0 && b === 0){
    return Number(num1) + Number(num2);
  }
  var c = 10;
  if(a>b){
    for(var i=0; i<a;i++){
      c=c*10
    }
    return (Number(num1)*c+Number(num2)*c)/c
  }else {
    for(var i=0; i<b;i++){
      c=c*10
    }
    return (Number(num1)*c+Number(num2)*c)/c;
  }
};
/**
 * 处理字典项 list to map{ key: {text: '',status: ''}}
 * @param list
 */
export const handleValueEnum = (list = []) => {
  const map = {};
  list.forEach(item => {
    item.status? map[item?.code]={text: item?.text, status: item.status} :map[item?.code]=item?.text
  });
  return map;
};
/**
 * 处理物料名称  物料编码是12和1300的不显示名称
 * @param code 编码
 * @param name 名称
 * @returns {string | *}
 */
export function handleMaterialName(code,name) {
  if (code===null||code.startsWith(Constants.MATERIAL.TYPE.RAW_MATERIAL)
                 ||code.startsWith(Constants.MATERIAL.TYPE.COMPOUND_MATERIAL)){
    return null;
  }
  return name;
}

/**
 * 给Colums处理
 * @param columns
 * @param sortTab
 * @returns {*}
 */
export const handleFilterSorted = (columns, sortTab) => {
  columns.forEach((item) => {
    if (sortTab.filter(t => t === item.title).length > 0) {
      item.sorter = () => {
      };
    }
  });
  return columns;
};

// 乘法精度问题解决
export const mul = function (arg1,arg2) {
  let m=0;
  const s1 = arg1.toString();
  const s2 = arg2.toString();
  const arr1 = s1.split(".")[1];
  const arr2 = s2.split(".")[1];
  if (arr1 !== null && arr1 !== undefined){
    m = m + arr1.length;
  }
  if (arr2 !== null && arr2 !== undefined){
    m = m + arr2.length;
  }
  return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
};

/**
 * 不含税单价计算
 * @param price 含税单价
 * @param taxRate 税率
 * @returns {number}
 */
export const handleNoTaxPrice = (price,taxRate) => {
    if (price !== null && price !== undefined
      && taxRate !== null && taxRate !== undefined) {
      const noTaxPrice = Math.floor(price / (1 + (taxRate / 100)) * 100000000) / 100000000;
      return Number.isNaN(noTaxPrice)?0:Number(noTaxPrice).toFixed(8);;
    }
    return 0;
};


/**
 * 不含税金额计算
 * @param noTaxPrice 不含税单价
 * @param count 数量
 * @returns {number}
 */
export const handleNoTaxAmount = (noTaxPrice,count) => {
  if (noTaxPrice !== null && noTaxPrice !== undefined
    && count !== null && count !== undefined) {
    const noTaxAmount = Number(noTaxPrice) * Number(count);
    return Number.isNaN(noTaxAmount)?0:Number(noTaxAmount).toFixed(2);
  }
  return 0;
};

/**
 * 税额计算
 * @param amount 含税金额
 * @param noTaxAmount 不含税金额
 * @returns {number}
 */
export const handleTaxSum = (amount,noTaxAmount) => {
  if (amount !== null && amount !== undefined
    && noTaxAmount !== null && noTaxAmount !== undefined) {
    const taxSum = amount-noTaxAmount;
    return Number.isNaN(taxSum)?0:Number(taxSum).toFixed(2);
  }
  return 0;
};

/**
 * 含税金额计算
 * @param taxPrice 含税单价
 * @param count 数量
 * @returns {number}
 */
export const handleTaxAmount = (taxPrice,count) => {
  if (taxPrice !== null && taxPrice !== undefined
    && count !== null && count !== undefined) {
    const taxAmount = taxPrice * count;
    return Number.isNaN(taxAmount)?0:Number(taxAmount).toFixed(2);
  }
  return 0;
};


/**
 * 不含税金额根据税率修改
 * @param amount 价税合计
 * @param taxRate 税率
 * @returns {number}
 */
export const divideHandleNoTaxAmount = (amount,taxRate) => {
  if (amount !== null && amount !== undefined
    && taxRate !== null && taxRate !== undefined) {
    const noTaxAmount = Math.floor(amount / (1 + (taxRate / 100)) * 100000000) / 100000000;
    return Number.isNaN(noTaxAmount)?0:Number(noTaxAmount).toFixed(2);
  }
  return 0;
};
