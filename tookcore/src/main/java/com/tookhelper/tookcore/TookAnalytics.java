package com.tookhelper.tookcore;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class TookAnalytics {

    public static void Event(final String eventTitle, final String APIKEY, final Context context){

        String url = "http://192.168.1.46/took_analytics/index.php";
        final String packageName = context.getPackageName();


        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(context, "Event Gone Succeess",Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, "İşlem Başarısız",Toast.LENGTH_LONG).show();

                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters = new HashMap<String, String>();
                parameters.put("event_title", eventTitle);
                parameters.put("api_key", APIKEY);
                parameters.put("package_name", packageName);
                return parameters;
            }

        };
        queue.add(stringRequest);

    }


    public static void ShowToast(Context context, String info, long time) {

        final Toast toast = Toast.makeText(context, Html.fromHtml("<font color='#e3f2fd' ><b>" + info + "</b></font>"), Toast.LENGTH_LONG);
        View view = toast.getView();
        view.setBackgroundColor(Color.parseColor("#E95D5D"));
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();

    }
}
