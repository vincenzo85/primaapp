package androidservice.com.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.telecom.Connection;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import androidservice.com.myapplication.Sqlite.HttpUtils;
import androidservice.com.myapplication.Sqlite.httprequest;

/**
 * Created by Utente on 26/07/2016.
 */
public class Myservice extends IntentService {

    public static final int NUOVIPOST=0;
    public static final int POSTTAG=1;
    public static final String KEY="001";
    //con questa chiave posso chiamare il service in funzione della costante

    public Myservice() {
        super("nulla da dire");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service started..", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Toast.makeText(this, "Service stop", Toast.LENGTH_LONG).show();


        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        /*synchronized (this)
        {
            int count = 0;
            while (count<10)
            {

                try {
                    wait(1500);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }*/

       final int i = intent.getIntExtra(KEY, -1);

        String risultato="nessun risultato ricevuto";


        switch (i) {
            case NUOVIPOST:

                synchronized (this) {
                    int count = 0;
                    while (count < 10) {

                        try {
                            wait(1500);
                            count++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }


                break;
            case POSTTAG:
                String url="http://openamat.altervista.org/api/get_recent_posts/";
                try {
                    URL connectionUrl = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection) connectionUrl.openConnection();
                    OutputStream os = connection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                    writer.flush();
                    writer.close();
                    os.close();

                    /////e ora????





                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;
        }



        }




    }

