import {Modal} from "antd";

export const modalInfo = (mes) => {
  Modal.info({
    title: '温馨提示：',
    content: mes,
  });
}
export const modalWarn = (mes) => {
  Modal.warn({
    title: '警告：',
    content: mes,
  });
}
export const modalError = (mes) => {
  Modal.error({
    title: '错误：',
    content: mes,
  });
}
