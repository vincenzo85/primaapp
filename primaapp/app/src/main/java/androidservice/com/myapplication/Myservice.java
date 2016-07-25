package androidservice.com.myapplication;

import android.app.IntentService;
import android.content.Intent;

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
    protected void onHandleIntent(Intent intent) {

    }
}
