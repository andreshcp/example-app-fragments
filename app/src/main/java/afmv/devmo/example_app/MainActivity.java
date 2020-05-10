package afmv.devmo.example_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentGreen, fragmentRed, fragmentInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentGreen = new GreenFragment();
        fragmentRed = new RedFragment();
        fragmentInicio = new InicioFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments, fragmentInicio).commit();

    }

    public void onCLick(View v) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btnRed: transaction.replace(R.id.contenedorFragments,fragmentRed);
                transaction.addToBackStack(null);
                break;
            case R.id.btnGreen: transaction.replace(R.id.contenedorFragments,fragmentGreen);
                break;

        }
        transaction.commit();

    }
}
