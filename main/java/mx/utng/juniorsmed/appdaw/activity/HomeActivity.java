package mx.utng.juniorsmed.appdaw.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {
    private Button btnFacebook;
    private Button btnAbout;
    private Button btnTwitter;
    private Button btnPage;
    private ImageView imgTemary;
    private ImageView imgUnitOne;
    private ImageView imgUnitTwo;
    private ImageView imgUnitThree;
    private ImageView imgLibrary;
    private ImageView imgNotice;
    private ImageView imgPodcast;
    private TextView usuarioTextView;
    private TextView correoTextView;
    private ImageView imagenImageView;
    private GoogleApiClient googleApiClient;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    //Menu and items variables
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private NavigationView navView;

    public static final String user="names";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_home);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        //Inicializamos Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user !=  null){
                    setUserData(user);
                }else{
                    goToLogin();
                }
            }
        };

        firebaseUser = firebaseAuth.getCurrentUser();

        mDrawerLayout = (DrawerLayout) findViewById(mx.utng.juniorsmed.appdaw.R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mx.utng.juniorsmed.appdaw.R.string.open, mx.utng.juniorsmed.appdaw.R.string.closes);
        mDrawerLayout.addDrawerListener(mToggle);

        navView = (NavigationView) findViewById(mx.utng.juniorsmed.appdaw.R.id.nv);

        View header = navView.getHeaderView(0);
        usuarioTextView = (TextView)header.findViewById(mx.utng.juniorsmed.appdaw.R.id.txtNombreUsuario);
        correoTextView = (TextView)header.findViewById(mx.utng.juniorsmed.appdaw.R.id.txtShowEmail);
        imagenImageView = (ImageView)header.findViewById(mx.utng.juniorsmed.appdaw.R.id.img_user);

        //setUserData(firebaseUser);

        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navView);
        setTitle("Inicio");

        btnAbout = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_about);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_about = new Intent(getApplicationContext(), AboutUsActivity.class);
                startActivity(go_about);
            }
        });


        imgTemary = (ImageView) findViewById(mx.utng.juniorsmed.appdaw.R.id.img_temary);
        imgTemary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_tem = new Intent(getApplicationContext(), FirstTemActivity.class);
                startActivity(go_tem);
            }
        });

        imgUnitOne = (ImageView) findViewById(mx.utng.juniorsmed.appdaw.R.id.img_unit_one);
        imgUnitOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent go_unit1 = new Intent(getApplicationContext(), UnitOneActivity.class);
                    startActivity(go_unit1);
                    finish();
                }catch (Exception e){
                    Toast.makeText(HomeActivity.this, "Error ..." + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        imgUnitTwo = (ImageView) findViewById(mx.utng.juniorsmed.appdaw.R.id.img_unit_two);
        imgUnitTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_unit2 = new Intent(getApplicationContext(), UnitTwoActivity.class);
                startActivity(go_unit2);
                finish();
            }
        });

        imgUnitThree = (ImageView) findViewById(mx.utng.juniorsmed.appdaw.R.id.img_unit_three);
        imgUnitThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_unit3 = new Intent(getApplicationContext(), UnitThreeActivity.class);
                startActivity(go_unit3);
                finish();
            }
        });


        imgLibrary = (ImageView) findViewById(mx.utng.juniorsmed.appdaw.R.id.img_library);
        imgLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_library = new Intent(getApplicationContext(), LibraryActivity.class);
                startActivity(go_library);
            }
        });

        imgPodcast = (ImageView) findViewById(mx.utng.juniorsmed.appdaw.R.id.img_podcast);
        imgPodcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_podcast = new Intent(getApplicationContext(), PodcastActivity.class);
                startActivity(go_podcast);
            }
        });
        imgNotice = (ImageView) findViewById(mx.utng.juniorsmed.appdaw.R.id.img_notice);
        imgNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_notice = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(go_notice);
            }
        });

        btnFacebook = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_facebook);
        btnFacebook.setOnClickListener(this);

        btnTwitter = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_twitter);
        btnTwitter.setOnClickListener(this);

        btnPage = (Button)findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_page);
        btnPage.setOnClickListener(this);


    }

    private void setUserData(FirebaseUser user) {
        if (user.getDisplayName()!=null){
            usuarioTextView.setText(user.getDisplayName());
        }

        if(user.getPhotoUrl()!=null){
            Glide.with(getBaseContext()).load(user.getPhotoUrl()).into(imagenImageView);
        }

        correoTextView.setText(user.getEmail());

    }
    @Override

    protected void onStart(){
        super.onStart();

        firebaseAuth.addAuthStateListener(firebaseAuthListener);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectItemDrawer(MenuItem menuItem){
        Fragment myFragment;
        Class fragmentClass = null;
        switch (menuItem.getItemId()){
            case mx.utng.juniorsmed.appdaw.R.id.profile:
                Intent newIntent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(newIntent);
                break;
            /*case R.id.profile:
                fragmentClass = ProfileFragment.class;
                break;*/
            case mx.utng.juniorsmed.appdaw.R.id.logOut:
                logOut();
            default:
                fragmentClass = null;
        }
        try{
            myFragment = (Fragment) fragmentClass.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(mx.utng.juniorsmed.appdaw.R.id.flcontent, myFragment).commit();
            menuItem.setChecked(true);
            setTitle(menuItem.getTitle());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        mDrawerLayout.closeDrawers();
    }

    public void logOut() {
        firebaseAuth.signOut();

        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if (status.isSuccess()) {
                    goToLogin();
                } else {
                    Toast.makeText(getApplicationContext(), mx.utng.juniorsmed.appdaw.R.string.not_close_session, Toast.LENGTH_SHORT).show();
                }
            }
        });

        finish();
    }

    private void goToLogin(){
        Intent intentLogin = new Intent(HomeActivity.this, LoginActivity.class);
        intentLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intentLogin);
    }

    private void setupDrawerContent (NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                selectItemDrawer(item);
                return true;
            }
        });
    }

    @Override
    public  void  onClick(View view) {
        switch (view.getId()) {
            case mx.utng.juniorsmed.appdaw.R.id.btn_facebook:
                Uri btnFacebook = Uri.parse("https://www.facebook.com/UTNGDOLORESHIDALGO-222209577812067/?ref=hl");
                Intent intent = new Intent(Intent.ACTION_VIEW, btnFacebook);
                startActivity(intent);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_twitter:
                Uri btnTwitter = Uri.parse("https://twitter.com/UTNGDolores");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, btnTwitter);
                startActivity(intent1);
                break;
            case mx.utng.juniorsmed.appdaw.R.id.btn_page:
                Uri uri = Uri.parse("http://www.utng.edu.mx/");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent2);
                break;
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStop() {
        super.onStop();

        if(firebaseAuthListener != null){
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }
}

