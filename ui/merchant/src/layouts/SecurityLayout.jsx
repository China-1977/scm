import React from 'react';
import {connect} from 'dva';
import {PageLoading} from '@ant-design/pro-layout';
import {Redirect, history} from 'umi';

class SecurityLayout extends React.Component {
  state = {
    isReady: false,
  };

  componentDidMount() {
    this.setState({
      isReady: true,
    });
    const {dispatch} = this.props;

    if (dispatch) {
      dispatch({
        type: 'user/getUserInfo',
      });
    }
  }

  render() {
    const {isReady} = this.state;
    const {children, loading, token} = this.props; // You can replace it to your authentication rule (such as check token exists)
    // 你可以把它替换成你自己的登录认证规则（比如判断 token 是否存在）

    const isLogin = token;

    if ((!isLogin && loading) || !isReady) {
      return <PageLoading/>;
    }
    if (!isLogin && window.location.pathname !== '/user/login') {
      const search = !history.location.query.redirect ? `redirect=${window.location.href}` : `redirect=${history.location.query.redirect}`;
      return <Redirect to={{pathname: '/user/login', search}}/>;
    }

    return children;
  }
}

export default connect(({user, loading}) => ({
  token: user.token,
  loading: loading.models.user,
}))(SecurityLayout);
