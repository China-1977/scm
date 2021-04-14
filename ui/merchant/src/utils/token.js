import Cookies from 'js-cookie';

export const TOKEN_KEY = 'sessionKey';

export const setToken = (token) => {
  Cookies.set(TOKEN_KEY, token);
};

export const removeToken = () => {
  Cookies.remove(TOKEN_KEY);
};

export const getToken = () => {
  const token = Cookies.get(TOKEN_KEY);
  if (token) {
    return token;
  }
  return false;
};
