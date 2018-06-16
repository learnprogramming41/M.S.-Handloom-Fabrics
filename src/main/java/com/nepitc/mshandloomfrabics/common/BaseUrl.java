/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepitc.mshandloomfrabics.common;

import java.net.MalformedURLException;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nishan Dhungana
 */
public class BaseUrl {

    public static String getUrlBase(HttpServletRequest request) throws MalformedURLException {
        URL requestUrl = new URL(request.getRequestURL().toString());
        String portString
                = requestUrl.getPort() == -1 ? "" : ":" + requestUrl.getPort();
        return requestUrl.getProtocol()
                + "://" + requestUrl.getHost() + portString + "/";
    }
}
