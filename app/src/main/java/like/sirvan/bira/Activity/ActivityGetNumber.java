package like.sirvan.bira.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.ArrayList;

import like.sirvan.bira.Model.FunctionModel;
import like.sirvan.bira.R;

public class ActivityGetNumber extends AppCompatActivity {

    private EditText EdtName,
            EdtPhone,
            EdtPass,
            EdtNameOne,
            EdtCodeOne,
            EdtNameTwo,
            EdtCodeTwo,
            EdtNameThree,
            EdtCodeThree;
    private LinearLayout llSaveInGetNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_number);
        init();
        click();

        Toolbar toolbar = findViewById(R.id.toolbarGetNumber);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    private void init() {
        EdtName = findViewById(R.id.edtNameOfDevice);
        EdtPhone = findViewById(R.id.edtNumberOfDevice);
        EdtPass = findViewById(R.id.edtPassOfDevice);
        EdtNameOne = findViewById(R.id.edtNameOfFunctionOne);
        EdtCodeOne = findViewById(R.id.edtCodeOfFunctionOne);
        EdtNameTwo = findViewById(R.id.edtNameOfFunctionTwo);
        EdtCodeTwo = findViewById(R.id.edtCodeOfFunctionTwo);
        EdtNameThree = findViewById(R.id.edtNameOfFunctionThree);
        EdtCodeThree = findViewById(R.id.edtCodeOfFunctionThree);
        llSaveInGetNumber = findViewById(R.id.llSaveInGetNumber);

    }
    private void click(){
        llSaveInGetNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(getData()){
                   onBackPressed();
                   Toast.makeText(getApplicationContext(),"اضافه شد",Toast.LENGTH_LONG).show();
               }else {
                   Snackbar.make(llSaveInGetNumber,"خطا در اضافه کردن داده",Snackbar.LENGTH_LONG).show();
               }

            }
        });
    }
    private boolean getData(){
            String name = EdtName.getText().toString();
            String phone = EdtPhone.getText().toString();
            String pass = EdtPass.getText().toString();
            String codeOne = EdtCodeOne.getText().toString();
            String nameOne = EdtNameOne.getText().toString();
            String codeTwo = EdtCodeTwo.getText().toString();
            String nameTwo = EdtNameTwo.getText().toString();
            String codeThree = EdtCodeThree.getText().toString();
            String nameThree = EdtNameThree.getText().toString();

            ArrayList<FunctionModel> model = new ArrayList<>();
            model.add(new FunctionModel(name,phone,pass,nameOne,codeOne,nameTwo,codeTwo,nameThree,codeThree));
        SharedPreferences sharedPreferences = getSharedPreferences("listFunction", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(model);
        editor.putString("list", json);
        editor.apply();
       if(editor.commit()){
           return true;
       }else return false;

    }

}