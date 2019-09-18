package com.example.def;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.def.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView szovegmezo1,szovegmezo2;
    private Button gomb1, gomb2, gomb3;
    private ImageView kep;
    String szavak[][] = {
            {"Hagyjuk", "Haggyuk"},
            {"Fogyjon","Foggyon"},{"Játszik","Jáccik"},{"Különbség","Külömbség"},{"Fagyjon","Faggyon"}, {"Álljunk","Ájjunk"},
            {"Fonjanak","Fonnyanak"},{"Vetjük","Vettyük"},{"Bánja","Bánnya"},{"Bűnje","Bűnnye"},{"Fenjük","Fennyük"},{"Fonjon","Fonnyon"},
            {"Kenjük","Kennyük"},{"Kínjunk","Kínnyunk"},{"Sünjeim","Sünnyeim"},{"Vénjei","Vénnyeim"},{"Vonjam","Vonnyam"},{"Csenjük","Csennyük"},
            {"Elunja","Elunnya"},{"Gyónjon","Gyónnyon"},{"Ikonja","Ikonnya"},{"Irónjai","Írónnyai"},{"Klánja","Klánnya"},{"Klónjuk","Klónnyuk"},
            {"Liánja","Liánnya"},{"Leányjaink","Leánnyaink"},{"Ómenje","Ómennye"},{"Osonjon","Osonnyon"},{"Özönjön","Özönnyön"},{"Ráunjunk","Ráunnyunk"},
            {"Szánjon","Szánnyon"},{"Trónja","Trónnya"},{"Üzenjen","Üzennyen"},{"Banánjaik","Banánnyaik"},{"Bödönjében","Bödönnyében"},{"Dékánja","Dékánnya"},
            {"Démonjuk","Dámonnyuk"},{"Fácánjaim","Fácánnyaim"},{"Fazonja","Fazonnya"},{"Főbűnjeim","Főbűnnyeim"},{"Illanjon","Illannyon"},{"Ispánjával","Ispánnyával"},
            {"Kabinjában","Kabinnyában"},{"Kazánja Kazánnya"},{"Kitinjével","Kitinnyével"},{"Kívánjon","Kívánnyon"},{"Kuponja","Kupponnya"},{"Óceánjai","Ócánnyai"},
            {"Orkánjával","Orkánnyával"},{"Csontjaink","Csontyaink"},{"Ártson","Árcson"},{"Ártja","Ártya"},{"Botja","Bottya"},{"Ejtse","Ejcse"},{"Értse","Ércse"},
            {"Értjük","Értyük"},{"Futja","Futtya"},{"Fűtsük","Fűccsük"},{"Hűtsenek","Hűccsenek"},{"Intsen","Incsen"},{"Intjük","Intyük"},{"Irtson","Ircson"},
            {"Irtja","Irtya"},{"Látjuk","Láttyuk"},{"Műtsenek","Műccsenek"},{"Oltja","Oltya"},{"Oltsanak","Olcsanak"},{"Ontsátok","Oncsátok"},
            {"Öltse","Ölcse"},{"Öntsenek","Öncsenek"},{"Tátsátok","Táccsátok"},{"Áhítja","Áhíttya"},{"Ámítjátok","Ámíttyátok"},{"Ámítsátok","Ámíccsátok"},{"Ásítson","Ásíccson"},
            {"Avatja","Avattya"},{"Bántjátok","Bánttyátok"},{"Bántjátok","Bánttyátok"},{"Bántsátok","Bánccsátok"},{"Bojtja","Bojtya"},{"Boltjaink","Boltyaink"},{"Bontsátok","Bonccsátok"},
            {"Döntsük","Döncsük"},{"Építsétek","Épíccsétek"},{"Fejtsük","Fejcsük"},{"Féltsétek","Félcsétek"},{"Fojtjuk","Fojtyuk"},{"Fojtsátok","Fojcsátok"},{"Fojtsátok","Fojcsátok"},
            {"Hajtjuk","Hajtyuk"},{"Hajtsuk","Hajcsuk"},{"Hántjuk","Hántyuk"},{"Hántsátok","Háncsátok"},{"Hintjük","Hintyük"},{"Hintsétek","Hincsétek"},{"Kertje","Kertye"},
            {"Költsük","Kölcsük"},{"Lejtsen","Lejcsen"},{"Mártjuk","Mártyuk"},{"Mártsuk","Márcsuk"},{"Mentjük","Mentyük"},{"Mentsétek","Mencsétek"},{"Okítja","Okíttya"},
            {"Okítsam","Okíccsam"},{"Pultja","Pultya"},{"Rántjuk","Ránytuk"},{"Rántsuk","Ráncsuk"},{"Rejtsétek","Rejcsétek"},{"Rejtjük","Rejtyük"},{"Rontjátok","Rontyátok"},
            {"Rontsátok","Roncsátok"},{"Sajtjaim","Sajtyaim"},{"Sejtjük","Sejtyük"},{"Sejtsük","Sejcsük"},{"Sértsem","Sércsem"},{"Sértjük","Sértyük"},{"Sújtson","Sújcson"},
            {"Sújtsanak","Sújcsanak"},{"Szítjátok","Szíttyátok"},{"Szítsátok","Szíccsátok"},{"Tartsam","Tarcsam"},{"Tartjátok","Tartyátok"},{"Tiltja","Tiltya"},{"Tiltsuk","Tilcsuk"},
            {"Töltsem","Tölcsem"},{"Töljük","Töltyük"},{"Újítja","Újíttya"},{"Újítsátok","Újíccsátok"},{"Üdítsétek","Üdíccsétek"},{"Szomszédság","Szomszéccság"}
    };
    Random random = new Random();
    int arrayLength = szavak.length;
    int randomInteger,randomszo,wordIndex1,wordIndex2,goodanswer,wronganswer;
    String str1 = "Összes kérdés/Jó/Rossz válaszok száma: ";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// veletlen szópár kiválasztésa
        randomInteger = random.nextInt(arrayLength);
        randomszo = random.nextInt(2);
//változók inicializálása
        goodanswer = 0;
        wronganswer = 0;
        wordIndex1 = 0;
        wordIndex2 = 1;
//Szövegmezők feliratozása
        szovegmezo1 = (TextView) findViewById(R.id.szoveg1);
        szovegmezo1.setText("Eredmény");
        szovegmezo2 = (TextView) findViewById(R.id.szoveg2);
        szovegmezo2.setText(str1);
//gombok feliratozása
        gomb1 = (Button) findViewById(R.id.button1); // Felso gomb beallitas, szoveg beallitas es gombnyomas esemeny figyeles
        gomb2 = (Button) findViewById(R.id.button2); // Also gomb beallitas, szoveg beallitas es gombnyomas esemeny figyeles
        gomb3 = (Button) findViewById(R.id.button3); // Also gomb beallitas, szoveg beallitas es gombnyomas esemeny figyeles
        kep = (ImageView) findViewById(R.id.imageView);

        gomb3.setEnabled(false);

        gomb1.setText(szavak[randomInteger][wordIndex1]); // Kivalasztok egy szópárelemet véletlenül, ez a kiinduló állapot
        gomb2.setText(szavak[randomInteger][wordIndex2]);
        gomb3.setText("Tovább");
 //Felső gomb események
        gomb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gomb1.getText() == szavak[randomInteger][0]) { // megnézem hogy a kivalasztott szópr elem megegyezik-e a helyes elsõ szóval
                    goodanswer++;
                    kep.setImageResource(R.drawable.ok);
                    szovegmezo1.setText("Helyes");
                    gomb1.setBackgroundColor(Color.GREEN);
                    szovegmezo2.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                } else {
                    wronganswer++;
                    kep.setImageResource(R.drawable.ko);
                    szovegmezo1.setText("helytelen");
                    gomb1.setBackgroundColor(Color.RED);
                    szovegmezo2.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                }
                gomb2.setEnabled(false);
                gomb3.setEnabled(true);
            } });
//Alsó gomb események
        gomb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gomb2.getText() == szavak[randomInteger][1]) {
                    wronganswer++;
                    kep.setImageResource(R.drawable.ko);
                    szovegmezo1.setText("helytelen");
                    gomb2.setBackgroundColor(Color.RED);
                    szovegmezo2.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                } else {
                    goodanswer++;
                    kep.setImageResource(R.drawable.ok);
                    szovegmezo1.setText("Helyes");
                    gomb2.setBackgroundColor(Color.GREEN);
                    szovegmezo2.setText(str1+(goodanswer+wronganswer)+" / "+goodanswer+" / "+wronganswer);
                }
                gomb1.setEnabled(false);
                gomb3.setEnabled(true);
            } });
//Tovább gomb események
        gomb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Új véletlen szópár kiválasztása a tömbből
                randomInteger = random.nextInt(arrayLength);
                randomszo = random.nextInt(2);
                //Az adott szópáron belül véletlenszerűen jelenjenek meg a szavak a felső és alsó gombon
                if ( randomszo == 1 ) { wordIndex1 = 0;wordIndex2 = 1;} //Itt azt állítom be hogyha kiválasztottunk egy szópárból egy elemet akkor a különbözõ gpombokon a különbözõ szópár elemek jelenlenek meg
                    else {wordIndex1 = 1; wordIndex2 = 0;}
                //gombok kattinthatóvá tétele
                gomb1.setEnabled(true);
                gomb2.setEnabled(true);
                //Véletlenszavak kiszedése a tömbböl és a gombfeliratozás beállítása
                gomb1.setText(szavak[randomInteger][wordIndex1]);
                gomb2.setText(szavak[randomInteger][wordIndex2]);
                //Gomok újra kattinthatóvá tétele
                gomb1.setBackgroundColor(Color.LTGRAY);
                gomb2.setBackgroundColor(Color.LTGRAY);
                gomb3.setEnabled(false);
            } });
    }
}