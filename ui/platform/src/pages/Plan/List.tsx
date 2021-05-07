/**
 * 计划列表
 */
import React from 'react';
import ProTable from '@ant-design/pro-table';
import {request} from "@@/plugin-request/request";

const PlanList = () => {

  const columns = [
    {
      title: '产品编号',
      dataIndex: 'productCode',
    },
    {
      title: '产品名称',
      dataIndex: 'productName',
    },
    {
      title: '类型',
      dataIndex: 'type',
    },
    {
      title: '计划数量',
      dataIndex: 'planQuantity',
    },
    {
      title: '状态',
      dataIndex: 'status',
    },
  ];

  return (
    <ProTable
      rowKey="id"
      headerTitle="查询表格"
      columns={columns}
      request={(params => request("/platform/plans", {params}).then((res) => {
        return {data: res.content, tota: res.totalPages}
      }))}
    />
  );
}

export default PlanList;
