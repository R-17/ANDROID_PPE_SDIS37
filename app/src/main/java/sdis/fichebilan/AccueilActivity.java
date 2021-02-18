package sdis.fichebilan;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class AccueilActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_nouvelle_fiche;
    private Button btn_sortir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Liens entre contrôles graphiques et propriétés
        this.btn_sortir = (Button) findViewById(R.id.btn_sortir);
        this.btn_sortir.setOnClickListener(this);
        this.btn_nouvelle_fiche = (Button) findViewById(R.id.btn_nouvelle_fiche);
        this.btn_nouvelle_fiche.setOnClickListener(this);

    }

    //Naviguer dans l'application selon la view
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_nouvelle_fiche)
        {
            //Déclarer une variable de type intent lié à BilanComplementaireActivity.
            Intent unIntent = new Intent(this, BilanComplementaireActivity.class);
            //Démarrer l'activité.
            startActivity(unIntent);
        }
        else if (v.getId() == R.id.btn_sortir)
        {
            //Stopper l'activité
            finish();
            //Sortir sans erreur
            System.exit(0);
        }
    }
}