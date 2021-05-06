import { jsx as _jsx } from "react/jsx-runtime";
import ProTable from '@ant-design/pro-table';
import { PageHeaderWrapper } from '@ant-design/pro-layout';
import { useRequest } from "@@/plugin-request/request";
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
    return (_jsx(PageHeaderWrapper, { children: _jsx(ProTable, { headerTitle: "\u67E5\u8BE2\u8868\u683C", columns: columns, request: ((params, sort, filter) => {
                const { data, error, loading } = useRequest("plans");
                return data;
            }) }, void 0) }, void 0));
};
export default IndexPage;
//# sourceMappingURL=index.js.map