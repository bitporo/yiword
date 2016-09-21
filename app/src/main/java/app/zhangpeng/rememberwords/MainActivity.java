package app.zhangpeng.rememberwords;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements
        SharedPreferences.OnSharedPreferenceChangeListener,
        NavigationView.OnNavigationItemSelectedListener{

    SharedPreferences preferences;//read
    SharedPreferences.Editor editor;//write
    public DBmanager dBmanager;
    public TextView tx6;
    TextView tx9;
    Calendar Date_CET;
    Calendar Today;
    Calendar Last_day;
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {//实现sp接口，实现监听方法
        tx9.setText(Integer.toString(preferences.getInt("days",1))+"天");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        LinearLayout lo1=(LinearLayout) findViewById(R.id.lo1);
        LinearLayout lo2=(LinearLayout) findViewById(R.id.lo2);
        DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition ps = new ParsePosition(0);
        ParsePosition PA = new ParsePosition(0);
        TextView change=(TextView)findViewById(R.id.textView10);
        Button button=(Button)findViewById(R.id.button);
        Date_CET= Calendar.getInstance();
        Today= Calendar.getInstance();
        Last_day=Calendar.getInstance();
        tx6 =(TextView)findViewById(R.id.textView6);
        tx9=(TextView)findViewById(R.id.textView9);
        setSupportActionBar(toolbar);
        preferences=getSharedPreferences("days",MODE_PRIVATE);
        editor=preferences.edit();
        Date_CET.setTime(sd.parse("2016-12-17",ps));
        Today.setTime(new Date());
        dBmanager=new DBmanager(this);
        dBmanager.openDatabase();
        tx9.setText(Integer.toString(preferences.getInt("days",1))+"天 ");
        tx6.setText(Integer.toString(days(Date_CET,Today))+"天");
        preferences.registerOnSharedPreferenceChangeListener(this);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        lo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        lo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,words.class);
                startActivity(intent);
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_fragment df=new dialog_fragment();
                df.setCancelable(false);
                df.show(getFragmentManager(),"choice");
            }
        });
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
            Intent intent=new Intent(MainActivity.this,about.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            Intent intent=new Intent(MainActivity.this,helpActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_send) {
            Intent intent=new Intent(MainActivity.this,about.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public int days(Calendar aday,Calendar bday){
        int days;
        if (aday.get(Calendar.YEAR)==bday.get(Calendar.YEAR))
        {
            days=aday.get(Calendar.DAY_OF_YEAR)-bday.get(Calendar.DAY_OF_YEAR);
        }
        else
        {
            days=bday.getMaximum(Calendar.DAY_OF_YEAR)-bday.get(Calendar.DAY_OF_YEAR)+aday.get(Calendar.DAY_OF_YEAR);
        }
        return days;
    }
}

