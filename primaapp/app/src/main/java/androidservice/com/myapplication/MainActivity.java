package androidservice.com.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button save,load;
    EditText name,email;

    //creo un oggetto della classe haanfler class
    DataHaandler handler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=(Button)findViewById(R.id.save);
        load=(Button)findViewById(R.id.load);
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //get the value of name ed email frome edittext
                String getName=name.getText().toString();
                String getEmail=email.getText().toString();
                //l'handler ha bisogno del context

                /*
                public DataHaandler(Context ctx) {
                this.ctx =ctx;
                dataBaseHelper = new DataBaseHelper(ctx);}
                */
                handler = new DataHaandler(getBaseContext());
                //apro il database
                handler.open();
                // public Cursor retunData () return sqLiteDatabase.query(TABLE_NAME,new String[]{NAME,EMAIL},null,null,null,null,null,null);}
                //di conseguenza mi serve un cursor
                /*Cursor c = handler.retunData(); //controllo se il cursor è al primo elemento faccio un loop
                if(c.moveToFirst())
                {
                    do{
                        getName = c.getString(0);
                        getEmail=c.getString(1);
                    }
                    while(c.moveToNext());
                 }*/
                long id = handler.insertData(getName,getEmail);
                Toast.makeText(getBaseContext(),"Data inserted",Toast.LENGTH_LONG).show();
                handler.close();













            }
        });


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

    public void handlemessage (View v)
    {
        Intent intent = new Intent(this, Myservice.class) ;
        intent.putExtra(Myservice.KEY, Myservice.POSTTAG);
        startService(intent);

    }



}
