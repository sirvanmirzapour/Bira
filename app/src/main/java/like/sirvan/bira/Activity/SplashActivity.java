package like.sirvan.bira.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

import like.sirvan.bira.App.G;
import like.sirvan.bira.Model.FunctionModel;
import like.sirvan.bira.R;

public class SplashActivity extends AppCompatActivity {

    TextView txtVersion;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        introToApp();

        txtVersion = findViewById(R.id.txtVersion);
        txtVersion.setText(" V " + getVersion());
        txtVersion.setTypeface(G.faceBold);

    }

    private void introToApp() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
            }
        }, 2500);
    }



    private String getVersion() {
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

}