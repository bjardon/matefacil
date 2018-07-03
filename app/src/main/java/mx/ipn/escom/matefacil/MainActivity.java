package mx.ipn.escom.matefacil;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ListView lvContent;
    String data[] = new String[] {"Calculo Diferencial", "Calculo Integral"};
    String differential[] = new String[] {"Funciones", "Limites", "Continuidad", "Derivadas", "Aplicaciones de la derivada"};
    String integral[] = new String[] {"Teorema fundamental del Calculo", "Integral indefinida", "Metodos de integracion", "Aplicaciones de la integral"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvContent = (ListView) findViewById(R.id.lvContent);
        ArrayAdapter<String> elements = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, this.data);
        lvContent.setAdapter(elements);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Boton flotante", Toast.LENGTH_LONG).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.nav_action_open, R.string.nav_action_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toast.makeText(getApplicationContext(), "Bienvenido a Matefacil", Toast.LENGTH_SHORT).show();
        System.gc();

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a |parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        ArrayAdapter<String> adapter = null;

        if (id == R.id.nav_home) {
            setTitle(R.string.nav_action_home);
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, this.data);
        } else if (id == R.id.nav_diferential) {
            setTitle(R.string.nav_action_difcalc);
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, this.differential);
        } else if (id == R.id.nav_integral) {
            setTitle(R.string.nav_action_intcalc);
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, this.integral);
        }

        this.lvContent.setAdapter(adapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void goToHome() {
    }
}
