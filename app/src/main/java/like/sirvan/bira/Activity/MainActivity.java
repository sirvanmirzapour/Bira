package like.sirvan.bira.Activity;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textview.MaterialTextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import like.sirvan.bira.Adapter.FunctionAdapter;
import like.sirvan.bira.App.MyAlertDialog;
import like.sirvan.bira.Model.FunctionModel;
import like.sirvan.bira.R;

public class MainActivity extends AppCompatActivity {

    private PermissionListener permissionListener;
    private RecyclerView rvFunction;
    private FunctionAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }


    private void init() {
        rvFunction = findViewById(R.id.rvFunction);
    }

    private void selectPhone() {

        ArrayList<FunctionModel> temp = loadData();
        int size = Objects.requireNonNull(temp).size();
        CharSequence[] mAlertItem = new CharSequence[size];

        for (int i = 0; i < size; i++) {
            mAlertItem[i] = temp.get(i).getPhone();

        }

        Alert(mAlertItem);

    }

    private void Alert(CharSequence[] chr) {

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this, R.style.RightJustifyTextView);
        builder.setTitle("تنظیمات کدام شماره را تغییر میدهید؟");
        builder.setSingleChoiceItems(chr, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int item) {

                Intent i = new Intent(MainActivity.this, SettingActivity.class);
                i.putExtra("phone", chr[item]);
                startActivity(i);
                dialogInterface.dismiss();
            }
        });
        builder.setBackground(this.getResources().getDrawable(R.drawable.alert_dialog_bg, null));
        builder.show();

    }

    private void DataToRecyclerView(List<FunctionModel> data) {
        LinearLayoutManager llmVertical = new LinearLayoutManager(this);
        llmVertical.setReverseLayout(true);
        rvFunction.setLayoutManager(llmVertical);
        rvFunction.setHasFixedSize(true);
        if (loadData() != null) {
            adapter = new FunctionAdapter(this, data);
            rvFunction.setAdapter(adapter);

        }


    }


    private ArrayList<FunctionModel> loadData() {

        ArrayList<FunctionModel> model;
        SharedPreferences sharedPreferences = getSharedPreferences("listFunction", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("list", null);
        Type type = new TypeToken<ArrayList<FunctionModel>>() {
        }.getType();
        model = gson.fromJson(json, type);
        if (model != null) {

            return model;


        } else {
            return null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataToRecyclerView(loadData());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_add:
                Intent i = new Intent(getApplicationContext(), ActivityGetNumber.class);
                startActivity(i);
                return true;
            case R.id.action_settings:
                selectPhone();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}