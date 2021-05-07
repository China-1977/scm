/**
 * 计划列表
 */
import React from 'react';
import ProTable from '@ant-design/pro-table';
import {PageHeaderWrapper} from '@ant-design/pro-layout';
import {request} from "@@/plugin-request/request";

const PlanList = () => {
  const columns = [
    {
      title: '产品编号',
      dataIndex: 'productCode',
      key: 'productCode',
    },
    {
      title: '产品名称',
      dataIndex: 'productName',
      key: 'productName',
    },
    {
      title: '类型',
      dataIndex: 'type',
      key: 'type',
    },
    {
      title: '计划数量',
      dataIndex: 'planQuantity',
      key: 'planQuantity',
    },
    {
      title: '状态',
      dataIndex: 'status',
      key: 'status',
    },
  ];

  return (
    <PageHeaderWrapper>
      <ProTable
        headerTitle="查询表格"
        columns={columns}
        request={(params => request("/platform/plans", {params}).then((res) => {
          return {data: res.content, tota: res.totalPages, success: true}
        }))}
      />
    </PageHeaderWrapper>
  );
}

export default PlanList;
