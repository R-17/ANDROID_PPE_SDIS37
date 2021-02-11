package sdis.fichebilan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDDFicheBilan extends SQLiteOpenHelper {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD="BDDFicheBilan";


    public BDDFicheBilan(Context context){
        super(context, NOM_BDD, null, VERSION_BDD);
    }

    @Override
    public void onCreate(SQLiteDatabase objbdd){

        String Intervention = "CREATE TABLE Intervention(num INT PRIMARY KEY,adresse TEXT,heurePresumee TEXT,lieu TEXT,details TEXT);";
        objbdd.execSQL(Intervention);

        String Accident = "CREATE TABLE Accident(num INT PRIMARY KEY,FOREIGN KEY(num) REFERENCES Intervention(num));";
        objbdd.execSQL(Accident);

        String Malaise = "CREATE TABLE Malaise(num INT PRIMARY KEY,FOREIGN KEY(num) REFERENCES Intervention(num));";
        objbdd.execSQL(Malaise);

        String Autre = "CREATE TABLE Autre(num INT PRIMARY KEY,FOREIGN KEY(num) REFERENCES Intervention(num));";
        objbdd.execSQL(Autre);

        String Accident_divers = "CREATE TABLE Accident_divers(num INT PRIMARY KEY,FOREIGN KEY(num) REFERENCES Accident(num));";
        objbdd.execSQL(Accident_divers);

        String CentreSecours = "CREATE TABLE CentreSecours (id INTEGER PRIMARY KEY,nom TEXT);";
        objbdd.execSQL(CentreSecours);

        String TypeTraumatisme = "CREATE TABLE TypeTraumatisme(id INT,libelle TEXT,PRIMARY KEY(id));";
        objbdd.execSQL(TypeTraumatisme);

        String Accident_de_la_route = "CREATE TABLE Accident_de_la_route(num INT,blesse TEXT,contre TEXT,FOREIGN KEY(num) REFERENCES Accident(num));";
        objbdd.execSQL(Accident_de_la_route);

        String ChefAgres = "CREATE TABLE ChefAgres(id INT PRIMARY KEY,nom TEXT,prenom TEXT,signature BLOB,id_1 INT NOT NULL,FOREIGN KEY(id_1) REFERENCES CentreSecours(id));";
        objbdd.execSQL(ChefAgres);

        String Bilan = "CREATE TABLE Bilan(id INT PRIMARY KEY,dateInitiale TEXT,heureInitiale TEXT,num INT NOT NULL,id_1 INT NOT NULL,FOREIGN KEY(num) REFERENCES Intervention(num),FOREIGN KEY(id_1) REFERENCES ChefAgres(id));";
        objbdd.execSQL(Bilan);

        String DetresseVitale = "CREATE TABLE DetresseVitale(id INT PRIMARY KEY,conscienceParole INT,conscienceDesoriente INT,conscienceSomnolence INT,conscienceAgitation INT,consciencePci INT,consciencePciDuree INT,sensibiliteSuperieure INT,sensibiliteInferieure INT,reactionYeuxSeul INT,reactionYeuxOrdre INT,reactionPupile INT,reactionJambeSeul INT,reactionJambeOrdre INT,reactionBrasSeul INT,reactionBrasOrdre INT,cardioPoulsRadial INT,cardioPoulsRadialRegulier INT,cardioPoulsFrequence INT,cardioPaleur INT,cardioAutoTensionSystolique INT,cardioAutoTensionDiastolique INT,ventilationFrequence INT,ventilationFrequenceReguliere INT,ventilationSensationEtouffement INT,ventilationSifflementRaleGargouillement INT,ventalationCyanose INT,ventilationSueur INT,ventilationSaturation INT,ventilationSaturationTypeAir TEXT,FOREIGN KEY(id) REFERENCES Bilan(id));";
        objbdd.execSQL(DetresseVitale);

        String UrgenceVitale = "CREATE TABLE UrgenceVitale(id INT PRIMARY KEY,hemoragie INT,conscience INT,ventilation INT,poulsCarotidient INT,FOREIGN KEY(id) REFERENCES Bilan(id));";
        objbdd.execSQL(UrgenceVitale);

        String Surveillance = "CREATE TABLE Surveillance(id INT PRIMARY KEY,heure TEXT,infoComplementaire TEXT,evacuationVers TEXT,evacuationPar TEXT,evacuationMedicalisee INT,evacuationMedicaliseeAvec TEXT,evacuationIntubation INT,evacuationPerfusion INT,evacuationScoreGlasgow INT,PRIMARY KEY(id),FOREIGN KEY(id) REFERENCES Bilan(id));";
        objbdd.execSQL(Surveillance);

        String Complementaire = "CREATE TABLE Complementaire(id INT PRIMARY KEY,hopital TEXT,traitement TEXT,avoirAlergie INT,alergie TEXT NOT NULL,plainte TEXT,evs INT,gesteImmobilisation INT,gesteVentilation INT,gesteRcp INT,gesteDsa INT,gesteRcpDuree INT,gesteOxygene INT,gestedebitOxygene INT,gesteCollierCervical INT,gesteAtelle INT,gesteGelEau INT,gesteDemiAssis INT,gestePlatDos INT,gestePls INT,FOREIGN KEY(id) REFERENCES Bilan(id));";
        objbdd.execSQL(Complementaire);

        String Traumatisme = "CREATE TABLE Traumatisme(id INT PRIMARY KEY,description TEXT,id_1 INT NOT NULL,id_2 INT NOT NULL,FOREIGN KEY(id_1) REFERENCES TypeTraumatisme(id),FOREIGN KEY(id_2) REFERENCES Complementaire(id));";
        objbdd.execSQL(Traumatisme);

        String Victime = "CREATE TABLE Victime(id INT PRIMARY KEY,nom TEXT,prenom TEXT,DDN TEXT,sexe INT,adresse TEXT,CP TEXT,ville TEXT,id_1 INT NOT NULL,FOREIGN KEY(id_1) REFERENCES Bilan(id));";
        objbdd.execSQL(Victime);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
