package sdis.fichebilan;

import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // création instanciation de l'outil SQLiteOpenHelper
        BDDFicheBilan maPremBase = new BDDFicheBilan(this);
        //création de ma BddSQLiteDatabase
        //SQLiteDatabase MaFicheBilan = maPremBase.getWritableDatabase();

        //MaFicheBilan.close();
        //maPremBase.close();
    }

}