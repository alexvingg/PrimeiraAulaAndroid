package br.com.primeiraaula;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text =  (TextView) findViewById(R.id.textView);
        text.setText(point.toString());

        final Button buttonOne = (Button) findViewById(R.id.button);
        int numberOne = (int)(Math.random()*100);

        int numberTwo = (int)(Math.random()*100);
        final Button buttonTwo = (Button) findViewById(R.id.button2);

        buttonOne.setText(String.valueOf(numberOne));
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Integer.parseInt(buttonOne.getText().toString()) > Integer.parseInt(buttonTwo.getText().toString())){
                    point = point + 1;
                    Toast toast = Toast.makeText(MainActivity.this, "Você marcou um ponto", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(MainActivity.this, "Você errou.", Toast.LENGTH_SHORT);
                    toast.show();
                    point = point - 1;
                }

                text.setText(point.toString());

                int numberOne = (int)(Math.random()*100);
                int numberTwo = (int)(Math.random()*100);

                while (numberOne == numberTwo){
                    numberTwo = (int)(Math.random()*100);
                }
                
                buttonOne.setText(String.valueOf(numberOne));
                buttonTwo.setText(String.valueOf(numberTwo));

                //Toast toast = Toast.makeText(MainActivity.this, "Button one", Toast.LENGTH_SHORT);
                //toast.show();
            }
        });


        buttonTwo.setText(String.valueOf(numberTwo));
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(buttonTwo.getText().toString()) > Integer.parseInt(buttonOne.getText().toString())){
                    point++;
                    Toast toast = Toast.makeText(MainActivity.this, "Você marcou um ponto", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(MainActivity.this, "Você errou.", Toast.LENGTH_SHORT);
                    toast.show();
                    point--;
                }
                int numberOne = (int)(Math.random()*100);
                int numberTwo = (int)(Math.random()*100);

                while (numberOne == numberTwo){
                    numberTwo = (int)(Math.random()*100);
                }

                buttonOne.setText(String.valueOf(numberOne));
                buttonTwo.setText(String.valueOf(numberTwo));

                text.setText(point.toString());
            }
        });

    }

    private boolean validaNumero(Integer numeroClicado, Integer numero){
        return numeroClicado > numero;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            System.out.println("Action Settings");
            Toast toast = Toast.makeText(this, "Action Settings", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }

        if (id == R.id.action_profile){
            Toast toast = Toast.makeText(this, "Action Profile", Toast.LENGTH_SHORT);
            toast.show();
            System.out.println("Action Profile");
            return true;
        }

        // show it


        return super.onOptionsItemSelected(item);
    }
}
