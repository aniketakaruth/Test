package com.mowize.testapp;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Ravi Mathpal on 06-02-2018.
 * This is a singleton object
 */

public class NetworkQueue {

    private static NetworkQueue instance;
    private static RequestQueue requestQueue;
    private static Cache cache;

    private NetworkQueue(){

    }

    /**
     * @return
     * This method was made for
     */
    public static NetworkQueue getInstance(Context context){
        if(instance == null){
            instance = new NetworkQueue();
            createRequestQueue(context);
        }
        return instance;
    }

    private static void createRequestQueue(Context context) {
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }

    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    private RequestQueue getRequestQueue() {
        return requestQueue;
    }

}
