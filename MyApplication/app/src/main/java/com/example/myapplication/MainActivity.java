package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import com.example.hardwarelibrary.*;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.os.ILEDService;
import android.os.ServiceManager;

public class MainActivity extends AppCompatActivity {
    private boolean led_flags = false;
    TextView text = null;
    Button btn_led = null;
    CheckBox led1 = null;
    CheckBox led2 = null;
    CheckBox led3 = null;
    CheckBox led4 = null;
    private ILEDService ledService = null;

    /*class BtnLEDListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            led_flags = !led_flags;
            if (led_flags)
                btn_led.setText("All OFF");
            else
                btn_led.setText("All ON");
        }
    }*/

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_led1:
                if (checked) {
                    //HardControl.ledCtrl(0, 1);
                    try {
                        ledService.ledCtrl(0, 1);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    //text.setText("LED1 ON");
                    Toast.makeText(getApplicationContext(), "LED1 ON", Toast.LENGTH_SHORT).show();
                }
                else {
                    //HardControl.ledCtrl(0, 0);
                    try {
                        ledService.ledCtrl(0, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    //text.setText("LED1 OFF");
                    Toast.makeText(getApplicationContext(), "LED1 OFF", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox_led2:
                if (checked) {
                    //HardControl.ledCtrl(1, 1);
                    try {
                        ledService.ledCtrl(1, 1);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    //text.setText("LED2 ON");
                    Toast.makeText(getApplicationContext(), "LED2 ON", Toast.LENGTH_SHORT).show();
                }
                else {
                    //HardControl.ledCtrl(1, 0);
                    try {
                        ledService.ledCtrl(1, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    //text.setText("LED2 OFF");
                    Toast.makeText(getApplicationContext(), "LED2 OFF", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox_led3:
                if (checked) {
                    //HardControl.ledCtrl(2, 1);
                    try {
                        ledService.ledCtrl(2, 1);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    text.setText("LED3 ON");
                }
                else {
                    //HardControl.ledCtrl(2, 0);
                    try {
                        ledService.ledCtrl(2, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    text.setText("LED3 OFF");
                }
                break;
            case R.id.checkbox_led4:
                if (checked) {
                    //HardControl.ledCtrl(3, 1);
                    try {
                        ledService.ledCtrl(3, 1);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    text.setText("LED4 ON");
                }
                else {
                    //HardControl.ledCtrl(3, 0);
                    try {
                        ledService.ledCtrl(3, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    text.setText("LED4 OFF");
                }
                break;
            // TODO: Veggie sandwich
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text_hello);
        btn_led = findViewById(R.id.button_led);
        //btn_led.setOnClickListener(new BtnLEDListener());
        led1 = findViewById(R.id.checkbox_led1);
        led2 = findViewById(R.id.checkbox_led2);
        led3 = findViewById(R.id.checkbox_led3);
        led4 = findViewById(R.id.checkbox_led4);
        //HardControl.ledOpen();
        ledService = ILEDService.Stub.asInterface(ServiceManager.getService("LED"));

        btn_led.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                led_flags = !led_flags;
                if (led_flags) {
                    btn_led.setText("All OFF");
                    text.setText("LED All OFF");
                    led1.setChecked(false);
                    led2.setChecked(false);
                    led3.setChecked(false);
                    led4.setChecked(false);
                    //HardControl.ledCtrl(0, 0);
                    try {
                        ledService.ledCtrl(0, 0);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    btn_led.setText("All ON");
                    text.setText("LED All ON");
                    led1.setChecked(true);
                    led2.setChecked(true);
                    led3.setChecked(true);
                    led4.setChecked(true);
                    //HardControl.ledCtrl(0, 1);
                    try {
                        ledService.ledCtrl(0, 1);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        /*
        led1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (led1.isChecked()) {
                    text.setText("LED1 ON");
                }
                else {
                    text.setText("LED1 OFF");
                }
            }
        });

        led2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (led2.isChecked()) {
                    text.setText("LED2 ON");
                }
                else {
                    text.setText("LED2 OFF");
                }
            }
        });

        led3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (led3.isChecked()) {
                    text.setText("LED3 ON");
                }
                else {
                    text.setText("LED3 OFF");
                }
            }
        });

        led4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (led4.isChecked()) {
                    text.setText("LED4 ON");
                }
                else {
                    text.setText("LED4 OFF");
                }
            }
        });
         */
    }
}
