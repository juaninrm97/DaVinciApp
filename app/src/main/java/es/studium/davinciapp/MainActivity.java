package es.studium.davinciapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import es.studium.davinciapp.ui.Inventor;
import es.studium.davinciapp.ui.Painter;
import es.studium.davinciapp.ui.Scientist;
import es.studium.davinciapp.ui.Sculptor;
import es.studium.davinciapp.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar la Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configurar el DrawerLayout y NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Configurar el NavigationView para manejar los clics en los ítems del menú lateral
        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                // Si se selecciona el ítem "Inicio", se carga el HomeFragment
                loadFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.nav_painter) {
                loadFragment(new Painter());  // Cargar fragmento Painter
            } else if (item.getItemId() == R.id.nav_sculptor) {
                loadFragment(new Sculptor());  // Cargar fragmento Sculptor
            } else if (item.getItemId() == R.id.nav_scientist) {
                loadFragment(new Scientist());  // Cargar fragmento Scientist
            } else if (item.getItemId() == R.id.nav_inventor) {
                loadFragment(new Inventor());  // Cargar fragmento Inventor
            }
            // Cerrar el DrawerLayout después de seleccionar un ítem
            drawerLayout.closeDrawers();
            return true;
        });

        // Cargar el fragmento de inicio por defecto cuando la actividad se inicie
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment()); // Esto carga el HomeFragment al inicio
        }
    }

    // Método para cargar un fragmento
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú de opciones (los 3 puntos en la Toolbar)
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejar la selección de opciones del menú con if-else
        if (item.getItemId() == R.id.nav_alta) {
            Toast.makeText(this, "Seleccionaste Alta", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.nav_baja) {
            Toast.makeText(this, "Seleccionaste Baja", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.nav_modificacion) {
            Toast.makeText(this, "Seleccionaste Modificación", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
