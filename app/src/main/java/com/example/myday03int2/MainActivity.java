package com.example.myday03int2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String[] CLUBS =
            {"Liverpool", "Man City", "Chelsea", "Man Utd", "Arsenal"};

    String mSelected;
    ArrayList<Integer> mMultiSelected;

    Button mDialogSimple;
    Button mDialogList;
    Button mDialogSingleChoice;
    Button mDialogMultipleChoice;
    Button mDialogCustom;
    Button mDialogCustom2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDialogSimple = findViewById(R.id.button_dialog_simple);
        mDialogList = findViewById(R.id.button_dialog_list);
        mDialogSingleChoice =  findViewById(R.id.button_dialog_single_choice);
        mDialogMultipleChoice = findViewById(R.id.button_dialog_multi_choice);
        mDialogCustom =  findViewById(R.id.button_dialog_custom);
        mDialogCustom2 = findViewById(R.id.button_dialog_custom2);
        mDialogSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("รับขนมจีบซาลาเปาเพิ่มมั้ยครับ?");

                builder.setPositiveButton("รับ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(),"ขอบคุณครับ", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("ไม่รับ", null);
                builder.create();

                // สุดท้ายอย่าลืม show() ด้วย
                builder.show();
            }
        });
        mDialogList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Favorite Team");

                builder.setItems(CLUBS, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selected = CLUBS[which];
                        Toast.makeText(getApplicationContext(), "คุณชอบ " + selected, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("ไม่ชอบซักทีม", null);
                builder.create();

                // สุดท้ายอย่าลืม show() ด้วย
                builder.show();
            }
        });
        mDialogSingleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Favorite Team");
                builder.setSingleChoiceItems(CLUBS, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mSelected = CLUBS[which];
                    }
                });
                builder.setPositiveButton("ยืนยัน", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // เซฟค่าลง database หรือ SharedPreferences.
                        Toast.makeText(getApplicationContext(), "คุณชอบ " + mSelected, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("ไม่ชอบซักทีม", null);
                builder.create();

                builder.show();
            }
        });
        mDialogCustom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Dialog Sample");
                dialog.setContentView(R.layout.activity_dialog_custom2);

                final EditText username;
                final EditText password;
                Button buttonCancel;
                Button buttonLogin;

                username = dialog.findViewById(R.id.username);
                password = dialog.findViewById(R.id.password);

                buttonCancel = dialog.findViewById(R.id.button_cancel);
                buttonLogin = dialog.findViewById(R.id.button_login);
                buttonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                buttonLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Check username password
                        if (username.getText().equals("se@se.com") &&
                        password.getText().equals("123")) {
                                Toast.makeText(getApplicationContext(), "Login success!",
                                        Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Failed!",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });

        dialog.show();
        }
    });
    }
}
