import axios from 'axios';
import * as actionTypes from './actionTypes';

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
  sessionStorage.removeItem('token');

  return {
    type: actionTypes.AUTH_LOGOUT
  };
};

export const signIn = (data) => {
  return dispatch => {
    dispatch(authStart());
    const options = {
      method: 'POST',
      url: 'http://localhost:8001/token',
      data: data,
    };
    axios(options)
      .then(res => {
        console.log(res.data);
        const token = null;
        sessionStorage.setItem('token', token);
        dispatch(authSuccess(token));
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
      url: 'http://localhost:8001/appUsers',
      data: data,
    };
    axios(options)
      .then(res => {
        console.log(res.data);
        dispatch(regSuccess());
      })
      .catch(err => {
        dispatch(authFail(err.response))
      });
  }
};