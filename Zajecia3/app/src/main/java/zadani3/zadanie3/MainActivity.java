package zadani3.zadanie3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.provider.MediaStore;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

import zadani3.zadanie3.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    static final int action = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Kliknięto przycisk FAB",
                        Toast.LENGTH_SHORT).show();
                Random rand = new Random();
                int random = rand.nextInt(100);

                if (random < 50) {
                    fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));
                }
            }
        });
    }

    public void Kliknij(View view) {
        Toast.makeText(getApplicationContext(),
                "Kliknięto przycisk Button",
                Toast.LENGTH_SHORT).show();
        Intent intencja = new Intent(this, LoginActivity.class);
        startActivity(intencja);
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
        //if (id == R.id.action_settings) {
          //  return true;
        //}

        Intent intencja = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intencja, action);

        switch (id) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),
                        "Przycisk Settings",
                        Toast.LENGTH_SHORT).show();
            case R.id.profile:
                Toast.makeText(getApplicationContext(),
                        "Przycisk Profile",
                        Toast.LENGTH_SHORT).show();
            case R.id.about:
                Toast.makeText(getApplicationContext(),
                        "Przycisk About",
                        Toast.LENGTH_SHORT).show();
            case R.id.logout:
                Toast.makeText(getApplicationContext(),
                        "Przycisk Logout",
                        Toast.LENGTH_SHORT).show();
            case R.id.exit:
                Toast.makeText(getApplicationContext(),
                        "Przycisk Exit",
                        Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(), imageBitmap));

        super.onActivityResult(requestCode, resultCode, data);
    }
}