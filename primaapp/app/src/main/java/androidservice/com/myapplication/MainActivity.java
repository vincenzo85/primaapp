package androidservice.com.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService (View v)
    {
        Intent intent = new Intent(this, Myservice.class) ;
        intent.putExtra(Myservice.KEY, Myservice.NUOVIPOST);
        startService(intent);

    }

    public void stopService (View v){

        Intent intent = new Intent(this, Myservice.class) ;
        stopService(intent);


    }
}
