package com.mowize.testapp;

import android.content.Context;
import android.util.Log;

import com.mowize.testapp.models.MainCategory;
import com.mowize.testapp.models.SubCategory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi Mathpal on 06-02-2018.
 */

public class MainActivityController {

    MainActivityView view;
    NetworkQueue queue;

    String response = "{\"categories_list\":[{\"category_name\":\"Insurance\",\"category_desc\":\"Insurance \",\"image_name\":\"\",\"id\":\"1\",\"parent_id\":\"0\",\"subcategory_children\":[{\"category_name\":\"Vehicle\",\"category_desc\":\"Vehicle\",\"image_name\":\"\",\"id\":\"5\",\"parent_id\":\"1\"},{\"category_name\":\"Term\",\"category_desc\":\"Term\",\"image_name\":\"\",\"id\":\"6\",\"parent_id\":\"1\"},{\"category_name\":\"Health\",\"category_desc\":\"Health\",\"image_name\":\"\",\"id\":\"7\",\"parent_id\":\"1\"},{\"category_name\":\"Property\",\"category_desc\":\"Property\",\"image_name\":\"\",\"id\":\"8\",\"parent_id\":\"1\"},{\"category_name\":\"Other\",\"category_desc\":\"Other\",\"image_name\":\"\",\"id\":\"9\",\"parent_id\":\"1\"}]},{\"category_name\":\"Accounts & Cards\",\"category_desc\":\"Accounts & Card\",\"image_name\":\"\",\"id\":\"2\",\"parent_id\":\"0\",\"subcategory_children\":[{\"category_name\":\"Credit Card\",\"category_desc\":\"Credit Card\",\"image_name\":\"\",\"id\":\"10\",\"parent_id\":\"2\"},{\"category_name\":\"Gift Card\",\"category_desc\":\"Gift Card\",\"image_name\":\"\",\"id\":\"11\",\"parent_id\":\"2\"},{\"category_name\":\"Loyalty Card\",\"category_desc\":\"Loyalty Card\",\"image_name\":\"\",\"id\":\"12\",\"parent_id\":\"2\"},{\"category_name\":\"Health Card\",\"category_desc\":\"Health Card\",\"image_name\":\"\",\"id\":\"13\",\"parent_id\":\"2\"},{\"category_name\":\"Wallet\",\"category_desc\":\"Wallet\",\"image_name\":\"\",\"id\":\"14\",\"parent_id\":\"2\"},{\"category_name\":\"Account\",\"category_desc\":\"Account\",\"image_name\":\"\",\"id\":\"15\",\"parent_id\":\"2\"}]},{\"category_name\":\"Investment\",\"category_desc\":\"Investment \",\"image_name\":\"\",\"id\":\"3\",\"parent_id\":\"0\",\"subcategory_children\":[{\"category_name\":\"Fixed Income Assets\",\"category_desc\":\"Fixed Income Assets\",\"image_name\":\"\",\"id\":\"16\",\"parent_id\":\"3\",\"subcategory_children\":[{\"category_name\":\"Money Back Policy\",\"category_desc\":\"Money Back Policy\",\"image_name\":\"\",\"id\":\"30\",\"parent_id\":\"16\"},{\"category_name\":\"PF\",\"category_desc\":\"PF\",\"image_name\":\"\",\"id\":\"31\",\"parent_id\":\"16\"},{\"category_name\":\"Bonds\",\"category_desc\":\"Bonds\",\"image_name\":\"\",\"id\":\"32\",\"parent_id\":\"16\"},{\"category_name\":\"FD\",\"category_desc\":\"FD\",\"image_name\":\"\",\"id\":\"33\",\"parent_id\":\"16\"},{\"category_name\":\"RD\",\"category_desc\":\"RD\",\"image_name\":\"\",\"id\":\"34\",\"parent_id\":\"16\"},{\"category_name\":\"PPF\",\"category_desc\":\"PPF\",\"image_name\":\"\",\"id\":\"29\",\"parent_id\":\"16\"},{\"category_name\":\"other\",\"category_desc\":\"other investment\",\"image_name\":\"\",\"id\":\"40\",\"parent_id\":\"16\"}]},{\"category_name\":\"Mutual Funds SIP\",\"category_desc\":\"Mutual Funds\",\"image_name\":\"\",\"id\":\"17\",\"parent_id\":\"3\"},{\"category_name\":\"Mutual Funds\",\"category_desc\":\"Mutual Funds\",\"image_name\":\"\",\"id\":\"18\",\"parent_id\":\"3\"},{\"category_name\":\"Listed Stocks\",\"category_desc\":\"Listed Stocks\",\"image_name\":\"\",\"id\":\"19\",\"parent_id\":\"3\"},{\"category_name\":\"Unlisted Stocks\",\"category_desc\":\"Unlisted\",\"image_name\":\"\",\"id\":\"20\",\"parent_id\":\"3\"},{\"category_name\":\"Real Estate\",\"category_desc\":\"Real Estate\",\"image_name\":\"\",\"id\":\"21\",\"parent_id\":\"3\",\"subcategory_children\":[{\"category_name\":\"Self Occupied\",\"category_desc\":\"Real Estate - Self Occupied\",\"image_name\":\"\",\"id\":\"35\",\"parent_id\":\"21\"},{\"category_name\":\"Rent Generating\",\"category_desc\":\"Rent Generating\",\"image_name\":\"\",\"id\":\"36\",\"parent_id\":\"21\"},{\"category_name\":\"Under Construction\",\"category_desc\":\"Under Construction\",\"image_name\":\"\",\"id\":\"37\",\"parent_id\":\"21\"}]},{\"category_name\":\"Jewellery\",\"category_desc\":\"Jewellery\",\"image_name\":\"\",\"id\":\"22\",\"parent_id\":\"3\"}]},{\"category_name\":\"Liabilities\",\"category_desc\":\"Liabilities\",\"image_name\":\"\",\"id\":\"4\",\"parent_id\":\"0\",\"subcategory_children\":[{\"category_name\":\"Car\",\"category_desc\":\"Car\",\"image_name\":\"\",\"id\":\"24\",\"parent_id\":\"4\"},{\"category_name\":\"Home\",\"category_desc\":\"Home\",\"image_name\":\"\",\"id\":\"23\",\"parent_id\":\"4\"},{\"category_name\":\"Loan Against Property\",\"category_desc\":\"Property\",\"image_name\":\"\",\"id\":\"26\",\"parent_id\":\"4\"},{\"category_name\":\"Education\",\"category_desc\":\"Education\",\"image_name\":\"\",\"id\":\"25\",\"parent_id\":\"4\"},{\"category_name\":\"Security\",\"category_desc\":\"Security\",\"image_name\":\"\",\"id\":\"27\",\"parent_id\":\"4\"},{\"category_name\":\"Personal\",\"category_desc\":\"Personal\",\"image_name\":\"\",\"id\":\"39\",\"parent_id\":\"4\"},{\"category_name\":\"Under Construction Loan\",\"category_desc\":\"Under Construction\",\"image_name\":\"\",\"id\":\"38\",\"parent_id\":\"4\"},{\"category_name\":\"Others\",\"category_desc\":\"Others\",\"image_name\":\"\",\"id\":\"28\",\"parent_id\":\"4\"}]}]}";

    MainActivityController(MainActivityView view, Context context) {
        this.view = view;
        queue = NetworkQueue.getInstance(context);
    }

    public void makeServerRequest() {

//        StringRequest request = new StringRequest(Request.Method.POST, "http://52.25.112.60/Services", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//        try {
//            JSONObject jsonObject = new JSONObject(response);
//            JSONArray array = jsonObject.getJSONArray("categories_list");
//
//            List<MainCategory> listOfMainCategories = new ArrayList<>();
//
//            for (int i = 0; i < array.length(); i++) {
//
//                JSONObject object = array.getJSONObject(i);
//
//                MainCategory mainCategory = new MainCategory(object.getInt("id"), object.getString("category_name"));
//                JSONArray subs = object.getJSONArray("subcategory_children");
//
//                for (int j = 0; j < subs.length(); j++) {
//
//                    JSONObject cat = subs.getJSONObject(j);
//                    SubCategory subCategory = new SubCategory(cat.getInt("id"), cat.getString("category_name"));
//                    mainCategory.addSubCategory(subCategory);
//                }
//
//                listOfMainCategories.add(mainCategory);
//
//            }
//
//            view.showData(listOfMainCategories);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                if (error instanceof NoConnectionError) {
//
//                } else if (error instanceof ParseError) {
//
//                }
//            }
//        }) {
//            //adding parameters to the request
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("REQUEST_TYPE_SENT", "SERVICE_CATEGORY_LIST");
//                params.put("user_id", "1");
//                return params;
//            }
//
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String>  params = new HashMap<String, String>();
//                params.put("Content-Type", "application/json");
//                params.put("Decode", "2");
//                params.put("Gzip", "2");
//                params.put("Api_Version", "1");
//                params.put("Device_Type", "3");
//                params.put("App_Version", "4");
//
//                return params;
//            }
//
//        };
//
//        queue.addToRequestQueue(request);


        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray array = jsonObject.getJSONArray("categories_list");

            List<MainCategory> listOfMainCategories = new ArrayList<>();

            for (int i = 0; i < array.length(); i++) {

                JSONObject object = array.getJSONObject(i);

                MainCategory mainCategory = new MainCategory(object.getInt("id"), object.getString("category_name"));
                JSONArray subs = object.getJSONArray("subcategory_children");

                for (int j = 0; j < subs.length(); j++) {

                    JSONObject cat = subs.getJSONObject(j);
                    SubCategory subCategory = new SubCategory(cat.getInt("id"), cat.getString("category_name"));
                    mainCategory.addSubCategory(subCategory);
                }

                listOfMainCategories.add(mainCategory);

            }

            view.showData(listOfMainCategories);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}
