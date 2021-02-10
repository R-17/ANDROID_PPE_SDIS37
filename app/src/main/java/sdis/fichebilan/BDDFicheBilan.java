package sdis.fichebilan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class BDDFicheBilan extends SQLiteOpenHelper {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD="BDDFicheBilan";

    public BDDFicheBilan(Context context){
        super(context, NOM_BDD, null, VERSION_BDD);
    }

    @Override
    public void onCreate(SQLiteDatabase objbdd){
        String Bilan = "CREATE TABLE Bilan(id INT,dateInitiale TEXT,heureInitiale TEXT,num INT NOT NULL,id_1 INT NOT NULL,PRIMARY KEY(id),FOREIGN KEY(num) REFERENCES Intervention(num),FOREIGN KEY(id_1) REFERENCES ChefAgres(id));";
        String ChefAgres = "CREATE TABLE ChefAgres(id INT,nom TEXT,prenom TEXT,signature BLOB,id_1 INT NOT NULL,PRIMARY KEY(id),FOREIGN KEY(id_1) REFERENCES CentreSecours(id));";
        String CentreSecours = "CREATE TABLE CentreSecours (id INTEGER PRIMARY KEY,nom TEXT);";
        String Victime = "CREATE TABLE Victime(id INT,nom TEXT,prenom TEXT,DDN TEXT,sexe INT,adresse TEXT,CP TEXT,ville TEXT,id_1 INT NOT NULL,PRIMARY KEY(id),FOREIGN KEY(id_1) REFERENCES Bilan(id));";
        String Intervention = "CREATE TABLE Intervention(num INT,adresse TEXT,heurePresumee TEXT,lieu TEXT,details TEXT,PRIMARY KEY(num));";
        String Malaise = "CREATE TABLE Malaise(num INT,PRIMARY KEY(num),FOREIGN KEY(num) REFERENCES Intervention(num));";
        String Autre = "CREATE TABLE Autre(num INT,PRIMARY KEY(num),FOREIGN KEY(num) REFERENCES Intervention(num));";
        String Accident = "CREATE TABLE Accident(num INT,PRIMARY KEY(num),FOREIGN KEY(num) REFERENCES Intervention(num));";
        String Accident_divers = "CREATE TABLE Accident_divers(num INT,PRIMARY KEY(num),FOREIGN KEY(num) REFERENCES Accident(num));";
        String Accident_de_la_route = "CREATE TABLE Accident_de_la_route(num INT,blesse TEXT,contre TEXT,PRIMARY KEY(num),FOREIGN KEY(num) REFERENCES Accident(num));";
        String Surveillance = "CREATE TABLE Surveillance(id INT,heure TEXT,infoComplementaire TEXT,evacuationVers TEXT,evacuationPar TEXT,evacuationMedicalisee INT,evacuationMedicaliseeAvec TEXT,evacuationIntubation INT,evacuationPerfusion INT,evacuationScoreGlasgow INT,PRIMARY KEY(id),FOREIGN KEY(id) REFERENCES Bilan(id));";
        String DetresseVitale = "CREATE TABLE DetresseVitale(id INT,conscienceParole INT,conscienceDesoriente INT,conscienceSomnolence INT,conscienceAgitation INT,consciencePci INT,consciencePciDuree INT,sensibiliteSuperieure INT,sensibiliteInferieure INT,reactionYeuxSeul INT,reactionYeuxOrdre INT,reactionPupile INT,reactionJambeSeul INT,reactionJambeOrdre INT,reactionBrasSeul INT,reactionBrasOrdre INT,cardioPoulsRadial INT,cardioPoulsRadialRegulier INT,cardioPoulsFrequence INT,cardioPaleur INT,cardioAutoTensionSystolique INT,cardioAutoTensionDiastolique INT,ventilationFrequence INT,ventilationFrequenceReguliere INT,ventilationSensationEtouffement INT,ventilationSifflementRaleGargouillement INT,ventalationCyanose INT,ventilationSueur INT,ventilationSaturation INT,ventilationSaturationTypeAir TEXT,PRIMARY KEY(id),FOREIGN KEY(id) REFERENCES Bilan(id));";
        String UrgenceVitale = "CREATE TABLE UrgenceVitale(id INT,hemoragie INT,conscience INT,ventilation INT,poulsCarotidient INT,PRIMARY KEY(id),FOREIGN KEY(id) REFERENCES Bilan(id));";
        String Complementaire = "CREATE TABLE Complementaire(id INT,hopital TEXT,traitement TEXT,avoirAlergie INT,alergie TEXT NOT NULL,plainte TEXT,evs INT,gesteImmobilisation INT,gesteVentilation INT,gesteRcp INT,gesteDsa INT,gesteRcpDuree INT,gesteOxygene INT,gestedebitOxygene INT,gesteCollierCervical INT,gesteAtelle INT,gesteGelEau INT,gesteDemiAssis INT,gestePlatDos INT,gestePls INT,PRIMARY KEY(id),FOREIGN KEY(id) REFERENCES Bilan(id));";
        String Traumatisme = "CREATE TABLE Traumatisme(id INT,description TEXT,id_1 INT NOT NULL,id_2 INT NOT NULL,PRIMARY KEY(id),FOREIGN KEY(id_1) REFERENCES TypeTraumatisme(id),FOREIGN KEY(id_2) REFERENCES Complementaire(id));";
        String TypeTraumatisme = "CREATE TABLE TypeTraumatisme(id INT,libelle VARCHAR(50),PRIMARY KEY(id));";



        objbdd.execSQL(Bilan);
        objbdd.execSQL(ChefAgres);
        objbdd.execSQL(CentreSecours);
        objbdd.execSQL(Victime);
        objbdd.execSQL(Intervention);
        objbdd.execSQL(Malaise);
        objbdd.execSQL(Autre);
        objbdd.execSQL(Accident);
        objbdd.execSQL(Accident_divers);
        objbdd.execSQL(Accident_de_la_route);
        objbdd.execSQL(Surveillance);
        objbdd.execSQL(DetresseVitale);
        objbdd.execSQL(UrgenceVitale);
        objbdd.execSQL(Complementaire);
        objbdd.execSQL(Traumatisme);
        objbdd.execSQL(TypeTraumatisme);

    }


}
