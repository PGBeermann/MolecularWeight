package org.example.molecularweight.app;


import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
        Context mContext;
        double v;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
        @JavascriptInterface
        public void setValue(double vx){
            this.v=vx;
            Toast.makeText(mContext, String.valueOf(vx), Toast.LENGTH_SHORT).show();
        }
    }

