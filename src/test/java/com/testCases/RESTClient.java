package com.testCases;/*
 * Created by MOAB on 31-Jul-17.
 */

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class RESTClient {

    static Logger log = Logger.getLogger(RESTClient.class.getName());

    public HttpResponse getResponse(String url) throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        request.setHeader("Accept", "application/json");
        HttpResponse response = client.execute(request);
        client.getConnectionManager().shutdown();
        return response;
    }


    public HttpResponse postResponse(String url, String body) throws Exception {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost(url);
        postRequest.setEntity(new StringEntity(body));
        postRequest.setHeader("Content-Type", "application/json");

        HttpResponse response = httpClient.execute(postRequest);
        httpClient.getConnectionManager().shutdown();
        return response;
    }

    public HttpResponse putResponse(String url, String body) throws Exception {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPut putRequest = new HttpPut(url);
        putRequest.setEntity(new StringEntity(body));
        putRequest.setHeader("Content-Type", "application/json");

        HttpResponse response = httpClient.execute(putRequest);
        httpClient.getConnectionManager().shutdown();
        return response;
    }

    public HttpResponse deleteResponse(String url) throws Exception {
        HttpClient httpClient = new DefaultHttpClient();
        HttpDelete deleteRequest = new HttpDelete(url);
        deleteRequest.setHeader("Content-Type", "application/json");
        HttpResponse response = httpClient.execute(deleteRequest);
        httpClient.getConnectionManager().shutdown();
        return response;
    }


}
