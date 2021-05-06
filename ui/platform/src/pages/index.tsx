import React from 'react';
import ProTable from '@ant-design/pro-table';
import {PageHeaderWrapper} from '@ant-design/pro-layout';
import {useRequest} from "@@/plugin-request/request";

const IndexPage = () => {
  const columns = [
    {
      title: '姓名',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '年龄',
      dataIndex: 'age',
      key: 'age',
    },
    {
      title: '住址',
      dataIndex: 'address',
      key: 'address',
    },
  ];

  return (
    <PageHeaderWrapper>
      <ProTable
        headerTitle="查询表格"
        columns={columns}
        request={((params, sort, filter) => {
          const {data, error, loading} = useRequest("plans");
          return data;
        })}
      />
    </PageHeaderWrapper>
  );
}

export default IndexPage;
