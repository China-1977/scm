import React from 'react';
import { Row, Col } from 'antd';
import logo from '@/assets/logo.svg';
import styles from './index.less';

const colStyle = {
  textAlign: 'center',
};

export default () => (
  <Row style={{ marginTop: 100 }}>
    <Col style={colStyle} span={24}>
      <img className={`${styles.logo} ${styles.opacity}`} src={logo} alt="" />
    </Col>
    <Col style={colStyle} span={24} className={`${styles.title} ${styles.opacity}`}>
      供应链管理系统
    </Col>
    <Col style={colStyle} span={24} className={`${styles.etitle} ${styles.opacity}`}>
      Supply Chain Management
    </Col>
  </Row>
);
