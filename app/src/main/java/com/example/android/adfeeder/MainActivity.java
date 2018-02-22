package com.example.android.adfeeder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import android.content.res.Configuration;
import java.util.Locale;




public class MainActivity extends AppCompatActivity {

    String oneYes = "at least you seem to like how it looks. ";
    String oneNo = "guess it could be more of an eye candy... ";
    String oneIdk = "how do you mean you don't know if it looks nice? ";
    String oneSod = "what on earth did they show you? ";
    String twoIntrusion = "But then, they seem to know everything these days, don't they? ";
    String twoLove = "And you're also a wonderful ad target! Don't let them take you up on that, ok? ";
    String twoAnnoyed = "Frankly, we hated it too. ";
    String twoPleasant = "A bit of a good surprise is kind of a nice touch, even in ads. ";
    String twoFml = "Shit, hope they stick it in their rear end. ";
    String twoSerious = "We're very very serious about all this. ";
    String threeYes = "\nDon't be such an easy prey. ";
    String threeNo = "\nWell done! Don't give up! ";
    String threeAlready = "\nWhy would they even waste their budget - they already got your money! ";
    String threeMaybe = "\nThough you're not sold yet, heh? ";
    String four03 = "K bro, I know how it feels. They must have thought better. ";
    String four46 = "But then, did they think you are one of the faceless general public? ";
    String four710 = "Because it seems like they know you pretty well. ";
    String customerName;
    String createMessage;
    int relevance = 5;
    int rg1checked;
    int rg2checked;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-8346913491042033~8795874117");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest request = new AdRequest.Builder().build();
        mAdView.loadAd(request);


    }

    public void Summarise (View view) {
        SeekBar relevanceO = (SeekBar) findViewById(R.id.seekbar_relevance);
        relevance = relevanceO.getProgress();
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);
        rg1checked = rg1.getCheckedRadioButtonId();
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.rg2);
        rg2checked = rg2.getCheckedRadioButtonId();
        EditText name = (EditText) findViewById(R.id.name);
        customerName = name.getText().toString();
        createMessage = "Ok " + customerName + ", ";
        createMessage ();
        TextView iMSoFull = findViewById(R.id.summary_text_view);
        iMSoFull.setText(createMessage);

    }

    public void createMessage() {

        CheckBox intrusion = (CheckBox) findViewById(R.id.privacy);
        CheckBox love = (CheckBox) findViewById(R.id.love);
        CheckBox annoyed = (CheckBox) findViewById(R.id.annoyed);
        CheckBox pleasant = (CheckBox) findViewById(R.id.good_surprise);
        CheckBox fml = (CheckBox) findViewById(R.id.fml);
        CheckBox seriously = (CheckBox) findViewById(R.id.seriously);

        if (rg1checked == R.id.yes1) {
            createMessage = createMessage + oneYes;
        }

        if (rg1checked == R.id.no1) {
            createMessage = createMessage + oneNo;
        }

        if (rg1checked == R.id.idk) {
            createMessage = createMessage + oneIdk;
        }

        if (rg1checked == R.id.sod_off) {
            createMessage = createMessage + oneSod;
        }

        if (intrusion.isChecked()) {
            createMessage = createMessage + twoIntrusion;
        }

        if (love.isChecked()) {
            createMessage = createMessage + twoLove;
        }

        if (annoyed.isChecked()) {
            createMessage = createMessage + twoAnnoyed;
        }

        if (pleasant.isChecked()) {
            createMessage = createMessage + twoPleasant;
        }

        if (fml.isChecked()) {
            createMessage = createMessage + twoFml;
        }

        if (seriously.isChecked()) {
            createMessage = createMessage + twoSerious;
        }

        if (rg2checked == R.id.yes2) {
            createMessage = createMessage + threeYes;
        }

        if (rg2checked == R.id.no2) {
            createMessage = createMessage + threeNo;
        }

        if (rg2checked == R.id.maybe) {
            createMessage = createMessage + threeMaybe;
        }

        if (rg2checked == R.id.using) {
            createMessage = createMessage + threeAlready;
        }

        if (relevance < 4) {
            createMessage = createMessage + four03;
        }

        if (relevance > 3 && relevance <7) {
            createMessage = createMessage + four46;
        }

        if (relevance > 6) {
            createMessage = createMessage + four710;
        }
        }

    }

