import axios from 'axios';
import * as actionTypes from './actionTypes';
import {getToken} from "../../../methods";

export const authStart = () => {
  return {
    type: actionTypes.AUTH_START
  }
};

export const regSuccess = () => {
  return {
    type: actionTypes.REG_SUCCESS
  }
};

export const authSuccess = token => {
  return {
    type: actionTypes.AUTH_SUCCESS,
    token: token
  }
};

export const authFail = error => {
  return {
    type: actionTypes.AUTH_FAIL,
    error: error
  }
};

export const logout = () => {
  localStorage.removeItem('token');

  return {
    type: actionTypes.AUTH_LOGOUT,
  };
};

export const signIn = (data) => {
  return dispatch => {
    dispatch(authStart());
    const options = {
      method: 'POST',
      url: 'http://localhost:8002/token',
      data: data,
    };
    axios(options)
      .then(res => {
        console.log(res);
        const token = res.headers.authorization.slice(7);
        dispatch(authSuccess(token));
        localStorage.setItem('token', token);
      })
      .catch(err => {
        dispatch(authFail(err.response));
      });
  }
};

export const signUp = (data) => {
  return dispatch => {
    dispatch(authStart());
    const options = {
      method: 'POST',
      url: 'http://localhost:8002/appUsers',
      data: data,
    };
    axios(options)
      .then(res => {
        console.log(res.data);
        dispatch(regSuccess());
        dispatch(signIn({
          username: data.username,
          password: data.password,
        }));
      })
      .catch(err => {
        dispatch(authFail(err.response))
      });
  }
};

export const authCheckState = () => {
  return dispatch => {
    const token = getToken();
    if (!token) {
      dispatch(logout());
    } else {
      dispatch(authSuccess(token));
    }
  }
};