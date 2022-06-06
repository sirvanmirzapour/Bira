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
import java.util.Optional;

import like.sirvan.bira.Adapter.FunctionAdapter;
import like.sirvan.bira.Model.FunctionModel;
import like.sirvan.bira.R;

public class MainActivity extends AppCompatActivity {

   private  PermissionListener permissionListener;
   private RecyclerView rvFunction;
   private FunctionAdapter adapter;
   private List<FunctionModel> models = new ArrayList<>();
   private LinearLayout llAddDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Click();
        DataToRecyclerView();

      /*  Dexter.withContext(MainActivity.this)
                .withPermission(Manifest.permission.SEND_SMS)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {
                        Log.d("sirvan","Granted");
                    }
                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {
                        Log.d("sirvan","Denied");
                    }
                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        Log.d("sirvan","ShouldBeShown");
                    }
                }).check();
                */


    }


    private void init(){
        rvFunction = findViewById(R.id.rvFunction);
        llAddDevice = findViewById(R.id.llAddDevice);
    }

    private void Click(){
        llAddDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ActivityGetNumber.class);
                startActivity(i);

            }
        });
    }

    private void DataToRecyclerView(){
        LinearLayoutManager llmVertical = new LinearLayoutManager(this);
        llmVertical.setReverseLayout(true);
        rvFunction.setLayoutManager(llmVertical);
        rvFunction.setHasFixedSize(true);
        if(loadData() != null){
            adapter = new FunctionAdapter(this,loadData());
            rvFunction.setAdapter(adapter);
            Toast.makeText(getApplicationContext(),loadData().size()+"",Toast.LENGTH_LONG).show();
        }

    }


    private ArrayList<FunctionModel> loadData(){

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

    private void getData(){


    }
}