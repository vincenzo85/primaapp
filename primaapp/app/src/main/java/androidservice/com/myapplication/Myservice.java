package androidservice.com.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Utente on 26/07/2016.
 */
public class Myservice extends IntentService {

    public static final int NUOVIPOST=0;
    public static final int POSTTAG=1;
    public static final String KEY="001";
    //con questa chiave posso chiamare il service in funzione della costante

    public Myservice(String name) {
        super(name);
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

        final int i = intent.getIntExtra(KEY, -1);

        String risultato="nessun risultato ricevuto";


        switch (i)
        {
            case NUOVIPOST:

                synchronized (this)
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
                }


                break;
            case POSTTAG:
                break;


        }




    }
}
