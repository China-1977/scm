/**
 * Form 表单文本输入框校验
 * @param rule 规则
 * @param value 输入文本
 * @param label Form.Item label
 * @param len 限制长度
 * @returns 错误信息
 */
import Constants from "@/utils/Constants";

const checkContent = (rule, value, label, len) => {
  const length = len || 50;
  let message = `内容超长，最多允许输入${length}个字符`;
  if (value.length <= length) {
    return Promise.resolve();
  }
  message = label ? `${label}${message}` : message;
  return Promise.reject(message);
};

/**
 * 特殊字符校验
 * @param rule 规则
 * @param value 输入内容
 * @param label Form.Item label
 * @returns {Promise<never>|Promise<void>}
 */
const checkSpecialChar = (rule, value, label) => {
  const pattern = new RegExp("[%--`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）――|{}【】‘；：”“'。，、？]");
  if (!pattern.test(value)) {
    return Promise.resolve();
  }
  let message = '禁止输入特殊字符';
  message = label ? `${label}${message}` : message;
  return Promise.reject(message);
}

/**
 * 特殊字符校验 不包括百分号
 * @param rule 规则
 * @param value 输入内容
 * @param label Form.Item label
 * @returns {Promise<never>|Promise<void>}
 */
const checkSpecialCharPercent = (rule, value, label) => {
  const pattern = new RegExp("[-`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）――|{}【】‘；：”“'。，、？]");
  if (!pattern.test(value)) {
    return Promise.resolve();
  }
  let message = '禁止输入特殊字符';
  message = label ? `${label}${message}` : message;
  return Promise.reject(message);
}
/**
 * 空格校验
 * @param rule 规则
 * @param value 输入内容
 * @param label Form.Item label
 * @returns {Promise<never>|Promise<void>}
 */
const checkSpaceChar = (rule, value, label) => {
  const pattern = new RegExp("[^\u3000&|^\u0020&|^\u00A0&]");
  if (pattern.test(value)) {
    return Promise.resolve();
  }
  let message = '禁止输入空格';
  message = label ? `${label}${message}` : message;
  return Promise.reject(message);
}

/**
 * 特殊字符校验
 * @param rule 规则
 * @param value 输入内容
 * @param label Form.Item label
 * @param max 最大值
 * @param min 最小值
 * @returns {Promise<never>|Promise<void>}
 */
const checkNumber = (rule, value, label, max, min) => {
  let message = '请输入正规手机号';
  if (max === null || max === undefined) {
    max = Constants.NUMBER.POSITIVE.max;
  }
  /*if (min === null || min === undefined) {
    min = 0.00000001;
  }*/
  if (value !== 0) {
    if (value < 0) {
      message = label + "不能小于0";
    } else if (value > max) {
      message = label + "不能大于" + max + "";
    } else if (value < min) {
      message = label + "不能小于0.00000001";
    } else {
      return Promise.resolve();
    }
  } else {
    message = label + "必须大于0";
  }

  return Promise.reject(message);


}

/**
 * 手机号校验
 * 这里的正则意思为首字母必须为1的数字，长度可在最外层自行max设置，
 * 根据自己需求更改pattern（正则）格式为"[ ？]"
 * @param rule 规则
 * @param value 输入内容
 * @param label Form.Item label
 * @returns {Promise<never>|Promise<void>}
 */
const checkPhoneNumber = (rule, value) => {
  const pattern = new RegExp("[/^1\d{10}$/]");
  if (pattern.test(value)) {
    return Promise.resolve();
  }
  const message = '请输入正规手机号';
  return Promise.reject(message);
}

/**
 * 校验工具类，需引入本类后使用
 * import validator from '@/utils/validator'
 *
 * 使用方法
 * validator.checkContent(rule, value,'字段名称','字段限制长度')
 */
const validator = {
  checkContent: (rule, value, label, len) => checkContent(rule, value, label, len),
  checkSpecialChar: (rule, value, label) => checkSpecialChar(rule, value, label),
  checkNumber: (rule, value, label, max, min) => checkNumber(rule, value, label, max, min),
  checkPhoneNumber: (rule, value) => checkPhoneNumber(rule, value),
  checkSpaceChar: (rule, value) => checkSpaceChar(rule, value),
  checkSpecialCharPercent: (rule, value, label) => checkSpecialCharPercent(rule, value, label),
}

export default validator;
