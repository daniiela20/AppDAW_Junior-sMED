package mx.utng.juniorsmed.appdaw.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import mx.utng.juniorsmed.appdaw.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private ImageView profileIV;
    private TextView nameProfile, emailProfile;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        setupActionBar();

        profileIV = (ImageView) findViewById(R.id.perfilImageView);
        nameProfile = (TextView) findViewById(R.id.nombrePerfilTextView);
        emailProfile = (TextView) findViewById(R.id.correoPerfilTextView);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseUser = firebaseAuth.getCurrentUser();
        setUserData(firebaseUser);
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Mi perfil");
        }
    }

    private void setUserData(FirebaseUser user) {
        if (user.getDisplayName()!=null){
            nameProfile.setText(user.getDisplayName());
        }

        if(user.getPhotoUrl()!=null){
            Glide.with(getBaseContext()).load(user.getPhotoUrl()).into(profileIV);
        }

        emailProfile.setText(user.getEmail());

    }

}
