package mx.utng.juniorsmed.appdaw.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import mx.utng.juniorsmed.appdaw.R;

public class FirstTemActivity extends AppCompatActivity {
    private Dialog myDialog;
    private  TextView txtClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tem_first);
        myDialog = new Dialog(this);
    }

    public void ShowPopup (View v){
        myDialog.setContentView(R.layout.activity_cont_one);
        txtClose = (TextView) myDialog.findViewById(R.id.txt_close_unit_one);

        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void ShowPopupII (View v){
        myDialog.setContentView(R.layout.activity_cont_two);
        txtClose = (TextView) myDialog.findViewById(R.id.txt_close_unit_two);

        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void ShowPopupIII (View v){
        myDialog.setContentView(R.layout.activity_cont_three);
        txtClose = (TextView) myDialog.findViewById(R.id.txt_close_unit_three);

        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void ShowPopupIV (View v){
        myDialog.setContentView(R.layout.activity_cont_four);
        txtClose = (TextView) myDialog.findViewById(R.id.txt_close_unit_four);

        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void ShowPopupV (View v){
        myDialog.setContentView(R.layout.activity_cont_five);
        txtClose = (TextView) myDialog.findViewById(R.id.txt_close_unit_five);

        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }
}



