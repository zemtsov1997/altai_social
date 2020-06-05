package ru.altai.service.api.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.Map;

public class HttpClientHelper {

    private static volatile HttpClientHelper instance;

    public String sendGetRequest(String url) {
        String result = null;
        try {
            result = this.sendRequest(url, "GET", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String sendGetRequest(String url, Map<String, Object> params) {
        url += UrlUtil.convertParamsForGetRequest(params);
        String result = null;
        try {
            result = this.sendRequest(url, "GET", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String sendPostRequest(String url, String data) {
        String result = null;
        try {
            result = this.sendRequest(url, "POST", data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String sendPutRequest(String url, String data) {
        String result = null;
        try {
            result = this.sendRequest(url, "PUT", data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendDeleteRequest(String url) {
        try {
            this.sendRequest(url, "PUT", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendRequest(String url, String method, String data) throws Exception {
        String result = null;

        HttpRequestBase httpRequestBase = null;

        if (method.equals("GET")) {
            httpRequestBase = new HttpGet(url);
        } else if (method.equals("POST")) {
            httpRequestBase = new HttpPost(url);
            ((HttpPost)httpRequestBase).setEntity(new StringEntity(data));
        } else if (method.equals("PUT")) {
            httpRequestBase = new HttpPut(url);
            ((HttpPut)httpRequestBase).setEntity(new StringEntity(data));
        } else if (method.equals("DELETE")) {
            httpRequestBase = new HttpDelete(url);
        }

        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = httpClient.execute(httpRequestBase);

        Integer status = httpResponse.getStatusLine().getStatusCode();
        switch (status) {
            case 200:
                HttpEntity httpEntity = httpResponse.getEntity();
                result = EntityUtils.toString(httpEntity);
                break;
            default:
                throw new Exception("Status code is :" + status);
        }

        return result;
    }

    public static HttpClientHelper getInstance() {
        HttpClientHelper localInstance = instance;
        if (localInstance == null) {
            synchronized (HttpClientHelper.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new HttpClientHelper();
                }
            }
        }
        return localInstance;
    }

}
