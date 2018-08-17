package mx.utng.juniorsmed.appdaw.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener{

    //defining view objects
    private GoogleApiClient googleApiClient;
    private SignInButton signInButton;

    private EditText TextEmail;
    private EditText TextPassword;
    private Button btnRegistrar, btnLogin, btnTemario;
    private ProgressDialog progressDialog;

    private ProgressBar progressBar;
    //Variables de Google

    //GoogleApiClient mGoogleApiClient;
    GoogleSignInOptions googleSignInOptions;

    private static final String TAG="SignInActivity";
    private static final int RC_SIGN_IN = 9001;




    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.juniorsmed.appdaw.R.layout.activity_login);

        getSupportActionBar().hide();

        //Asiganamos las variables para ingresar con Google
        /*signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent, RC_SIGN_IN);
            }
        });*/




        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(mx.utng.juniorsmed.appdaw.R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        //inicializamos el objeto firebaseAuth


        //Referenciamos los views

        TextEmail = (EditText) findViewById(mx.utng.juniorsmed.appdaw.R.id.txtEmail);
        TextPassword = (EditText) findViewById(mx.utng.juniorsmed.appdaw.R.id.txtPass);

        btnRegistrar = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btnRegistar);
        btnLogin = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.botonLogin);
        btnTemario = (Button) findViewById(mx.utng.juniorsmed.appdaw.R.id.btn_temario);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        btnRegistrar.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        //como llamar a otra actividad
        btnTemario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, UsersOutActivity.class);
                startActivity(intent);
            }
        });

        //Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    goToMain();
                }
            }
        };

        //progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    //Firebase Auth
    @Override
    public void onStart() {
        super.onStart();

        firebaseAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (firebaseAuthStateListener != null){
            firebaseAuth.removeAuthStateListener(firebaseAuthStateListener);
        }
    }

    //Metodos de Google


    private void registrarUsuario(){

        //Obtenemos el email y la contraseña desde las cajas de texto
        String email = TextEmail.getText().toString().trim();
        String password  = TextPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){

                            Toast.makeText(LoginActivity.this,"Se ha registrado el usuario con el email: "+ TextEmail.getText(),Toast.LENGTH_LONG).show();
                        }else{
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {// si se presenta una colision


                                Toast.makeText(LoginActivity.this, "Ese usuario ya existe ", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(LoginActivity.this,"No se pudo registrar el usuario ",Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    private void loguearUsuario(){

        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = TextEmail.getText().toString().trim();
        String password  = TextPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Realizando consulta en linea...");
        progressDialog.show();

        //Loguear un usuario
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            int pos =email.indexOf("@");
                            String user =email.substring(0,pos);

                            Toast.makeText(LoginActivity.this,"Bienvenido: "+ TextEmail.getText(),Toast.LENGTH_LONG).show();
                            Intent intencion = new Intent(getApplication(),HomeActivity.class);
                            intencion.putExtra(HomeActivity.user, user);
                            startActivity(intencion);

                        }else{
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {// si se presenta una colision


                                Toast.makeText(LoginActivity.this, "Ese usuario ya existe ", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(LoginActivity.this,"No se pudo registrar el usuario ",Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });


    }

    //Método de Google
    private void signIn(){
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){
            firebaseAuthWithGoogle(result.getSignInAccount());
        }else{
            Toast.makeText(this, mx.utng.juniorsmed.appdaw.R.string.cannot_signin,Toast.LENGTH_SHORT).show();
        }
    }

    private void firebaseAuthWithGoogle(final GoogleSignInAccount signInAccount) {

        progressBar.setVisibility(View.VISIBLE);
        signInButton.setVisibility(View.GONE);

        AuthCredential credential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                signInButton.setVisibility(View.VISIBLE);

                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), getString(mx.utng.juniorsmed.appdaw.R.string.not_firebase_auth), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void goToMain() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFalied: " + connectionResult);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case mx.utng.juniorsmed.appdaw.R.id.btnRegistar:
                //Invocamos al método:
                registrarUsuario();
                break;
            case mx.utng.juniorsmed.appdaw.R.id.botonLogin:
                loguearUsuario();
                break;
            /*case R.id.sign_in_button:
                signIn();
                break;*/

        }

    }
}