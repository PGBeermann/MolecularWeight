package org.example.molecularweight.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main extends Activity {
    EditText txt1;
    Button btn1;
    WebView webview;
    Elementos em=new Elementos();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview=(WebView)findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.addJavascriptInterface(new WebAppInterface(this),"Android");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        txt1=(EditText)findViewById(R.id.txt1);

        return true;
    }

    public void Calculate(View v){
        String s=txt1.getText().toString();
        String s2="";
        s2=em.Evaluar(s);
        Toast.makeText(getBaseContext(), s2, Toast.LENGTH_LONG).show();
        Evaluate(s2);
    }

    public void Evaluate(String s){
        String txt="<HTML><BODY><p>Respuesta:</p>";
        txt+="<script>var r=eval('"+s+"');r=Math.round(r*1000)/1000;document.write('<H1>'+r+' g/mol</H1>');";
        txt+="Android.setValue(r);"+"</script>";
        txt+="</BODY></HTML>";
        webview.loadData(txt,"text/html;charset=UTF-8",null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
