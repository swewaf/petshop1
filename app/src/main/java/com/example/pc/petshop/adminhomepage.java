package com.example.pc.petshop;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


public class adminhomepage  extends AppCompatActivity {

    DatabaseReference UDB;
    private FirebaseAuth mAuth;
    Button button;
    DatabaseReference databaseref;
    DatabaseReference databaseReferences;
    TextView username;
    TextView mail;
    TextView phone;
    TextView city1;
    TextView wwh;
    Switch allow;
    Switch available;
    FirebaseAuth firebaseAuth;
    private TextView location;
    DatabaseReference database;
    String address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminhome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth = FirebaseAuth.getInstance();
        //
Button b=findViewById(R.id.btnSugesstion);
Button event = findViewById(R.id.addEvent);
Button alleventt = findViewById(R.id.btnViewEvent);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adminhomepage.this, view_all_suggestion.class);
                startActivity(intent);
            }


            ///


//addEvent
        });

        alleventt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adminhomepage.this, viewallEvent.class);
                startActivity(intent);
            }


            ///


//addEvent
        });
        ///////////////////
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adminhomepage.this, createEvent.class);
                startActivity(intent);
            }


            ///


//addEvent
        });

        ////////////////////////////
    }

    public void logout(View view) {
        mAuth.signOut();
        if(mAuth.getCurrentUser() == null) {
            Toast.makeText(this, "تم تسجيل الخروج بنجاح", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, home.class));
        }
    }


}
