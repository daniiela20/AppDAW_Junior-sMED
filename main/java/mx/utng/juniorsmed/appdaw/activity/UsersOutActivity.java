package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UsersOutActivity extends AppCompatActivity {
    private ImageView imgOutUnitOne;
    private ImageView imgOutUnitTwo;
    private ImageView imgOutUnitThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_users_out);

        imgOutUnitOne = (ImageView) findViewById(mx.utng.juniorsmed.appdaw.R.id.img_out_unit_one);
        imgOutUnitOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out_unit_one = new Intent(getApplicationContext(), Unit1EngineeringWebActivity.class);
                startActivity(out_unit_one);
            }
        });

        imgOutUnitTwo = (ImageView) findViewById(mx.utng.juniorsmed.appdaw.R.id.img_out_unit_two);
        imgOutUnitTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out_unit_two = new Intent(getApplicationContext(), Unit2ArchitectureInformationActivity.class);
                startActivity(out_unit_two);
            }
        });

        imgOutUnitThree = (ImageView) findViewById(mx.utng.juniorsmed.appdaw.R.id.img_out_unit_three);
        imgOutUnitThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out_unit_three = new Intent(getApplicationContext(), Unit3DevelopmentWebActivity.class);
                startActivity(out_unit_three);
            }
        });
    }
}
