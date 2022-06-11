package like.sirvan.bira.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import like.sirvan.bira.App.G;
import like.sirvan.bira.R;

public class SettingActivity extends AppCompatActivity {
    String phone;
    TextView txtPhoneNumberInSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("تنظیمات");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            phone = extras.getString("phone");

        }
        txtPhoneNumberInSetting = findViewById(R.id.txtPhoneNumberInSetting);
        txtPhoneNumberInSetting.setTypeface(G.faceBold);
        txtPhoneNumberInSetting.setText( " روی آن است"+ phone +" تنظیمات برای دستگاهی که شماره");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}