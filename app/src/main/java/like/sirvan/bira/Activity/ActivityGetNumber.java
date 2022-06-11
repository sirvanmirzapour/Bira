package like.sirvan.bira.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

import like.sirvan.bira.App.G;
import like.sirvan.bira.Model.FunctionModel;
import like.sirvan.bira.R;

public class ActivityGetNumber extends AppCompatActivity {

    private EditText EdtName, EdtPhone, EdtNameOne, EdtNameTwo, EdtNameThree;
    private LinearLayout llCodeOfFunctionOne, llCodeOfFunctionTwo, llCodeOfFunctionThree;
    private LinearLayout llColorOfFunctionOne, llColorOfFunctionTwo, llColorOfFunctionThree;
    private TextView txtCodeOfFunctionOne, txtCodeOfFunctionTwo, txtCodeOfFunctionThree;
    private TextView txtColorOfFunctionOne, txtColorOfFunctionTwo, txtColorOfFunctionThree;
    private LinearLayout llSaveInGetNumber;
    private String codeOne, codeTwo, codeThree;

    private CharSequence[] mAlertItem;
    private CharSequence[] listCode;

    private ImageView imgColorPicker;
    private LinearLayout llSaveColor, llSelectColor;
    private View viewColor;
    private TextView txtSaveColor;
    private Bitmap bitmap;

    private String hex;
    private String colorOne, colorTwo, colorThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_number);
        init();
        setTypeFace();
        click();
        colorPicker();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("اضافه کردن");

    }

    private void init() {
        imgColorPicker = findViewById(R.id.imgColorPicker);
        llSaveColor = findViewById(R.id.llSaveColor);
        llSelectColor = findViewById(R.id.llSelectColor);
        viewColor = findViewById(R.id.viewColor);
        txtSaveColor = findViewById(R.id.txtSaveColor);

        EdtName = findViewById(R.id.edtNameOfDevice);
        EdtPhone = findViewById(R.id.edtNumberOfDevice);
        EdtNameOne = findViewById(R.id.edtNameOfFunctionOne);
        EdtNameTwo = findViewById(R.id.edtNameOfFunctionTwo);
        EdtNameThree = findViewById(R.id.edtNameOfFunctionThree);

        llCodeOfFunctionOne = findViewById(R.id.llCodeOfFunctionOne);
        txtCodeOfFunctionOne = findViewById(R.id.txtCodeOfFunctionOne);
        llColorOfFunctionOne = findViewById(R.id.llColorOfFunctionOne);
        txtColorOfFunctionOne = findViewById(R.id.txtColorOfFunctionOne);

        llCodeOfFunctionTwo = findViewById(R.id.llCodeOfFunctionTwo);
        txtCodeOfFunctionTwo = findViewById(R.id.txtCodeOfFunctionTwo);
        llColorOfFunctionTwo = findViewById(R.id.llColorOfFunctionTwo);
        txtColorOfFunctionTwo = findViewById(R.id.txtColorOfFunctionTwo);

        llCodeOfFunctionThree = findViewById(R.id.llCodeOfFunctionThree);
        txtCodeOfFunctionThree = findViewById(R.id.txtCodeOfFunctionThree);
        llColorOfFunctionThree = findViewById(R.id.llColorOfFunctionThree);
        txtColorOfFunctionThree = findViewById(R.id.txtColorOfFunctionThree);

        llSaveInGetNumber = findViewById(R.id.llSaveInGetNumber);

        mAlertItem = new CharSequence[]{
                "خاموش کردن",
                "روشن کردن",
                "وضعیت ",
                "فعال کردن",
                "فعال کردن",
                "وضعیت دزدگیر",
                "فعال کردن الارم",
                "غیر فعال کردن الارم",
                "خاموش کردن",
                "روشن کردن",
                "وضعیت ",
                "فعال کردن",
                "فعال کردن",
                "وضعیت دزدگیر",
                "فعال کردن الارم",
                "غیر فعال کردن الارم",
        };

        listCode = new CharSequence[]{
                "*0#",
                "*1#",
                "*2#",
                "*3#",
                "*4#",
                "*5#",
                "*6#",
                "*7#",
                "*8#",
                "*9#",
                "*10#",
                "*11#",
                "*12#",
                "*13#",
                "*14#",
                "*15#",
        };


        colorOne = "#1A237E";
        colorTwo = "#1A237E";
        colorThree="#1A237E";

    }

    private void setTypeFace() {

        EdtName.setTypeface(G.faceBold);
        EdtPhone.setTypeface(G.faceBold);
        EdtNameOne.setTypeface(G.faceBold);
        EdtNameTwo.setTypeface(G.faceBold);
        EdtNameThree.setTypeface(G.faceBold);

        txtCodeOfFunctionOne.setTypeface(G.faceBold);
        txtCodeOfFunctionTwo.setTypeface(G.faceBold);
        txtCodeOfFunctionThree.setTypeface(G.faceBold);

        txtColorOfFunctionOne.setTypeface(G.faceBold);
        txtColorOfFunctionTwo.setTypeface(G.faceBold);
        txtColorOfFunctionThree.setTypeface(G.faceBold);


    }

    private void click() {
        llSaveInGetNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getData()) {
                    onBackPressed();
                    Toast.makeText(getApplicationContext(), "اضافه شد", Toast.LENGTH_LONG).show();
                } else {
                    Snackbar.make(llSaveInGetNumber, "خطا در اضافه کردن داده", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        llCodeOfFunctionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alert(1);

            }
        });
        llCodeOfFunctionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alert(2);

            }
        });
        llCodeOfFunctionThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alert(3);

            }
        });
        llColorOfFunctionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        llColorOfFunctionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectColor(1);
            }
        });
        llColorOfFunctionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectColor(2);
            }
        });
        llColorOfFunctionThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectColor(3);
            }
        });

    }

    private boolean getData() {
        String name;
        String phone;
        String nameOne;
        String nameTwo;
        String nameThree;
        ArrayList<FunctionModel> model;
        if (loadData() != null) {
            model = new ArrayList<>(loadData());
        } else {
            model = new ArrayList<>();
        }

        if (!EdtName.getText().toString().equals("")) {
            if (EdtName.getText().toString().length() <= 10) {
                if (EdtPhone.getText().toString().length() == 11 && isMobileNumber(EdtPhone.getText().toString())) {

                    name = EdtName.getText().toString();
                    phone = EdtPhone.getText().toString();
                    nameOne = EdtNameOne.getText().toString();
                    nameTwo = EdtNameTwo.getText().toString();
                    nameThree = EdtNameThree.getText().toString();

                    model.add(new FunctionModel(name, phone, "1234", nameOne, "codeOne", colorOne, nameTwo, "codeTwo", colorTwo, nameThree, "codeThree", colorThree));


                } else
                    Toast.makeText(getApplicationContext(), "شماره موبایل صحیح نیست", Toast.LENGTH_LONG).show();

            } else
                Toast.makeText(getApplicationContext(), "نام خیلی طولانی است", Toast.LENGTH_LONG).show();

        } else
            Toast.makeText(getApplicationContext(), "نام نباید خالی باشد", Toast.LENGTH_LONG).show();


        SharedPreferences sharedPreferences = getSharedPreferences("listFunction", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(model);
        editor.putString("list", json);
        editor.apply();
        if (editor.commit()) {
            return true;
        } else return false;

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


    private void Alert(int k) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this, R.style.RightJustifyTextView);
        builder.setTitle("کارکرد کلید را انتخاب کنید");
        builder.setSingleChoiceItems(mAlertItem, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int item) {

                if (k == 1) {
                    codeOne = listCode[item].toString();
                    txtCodeOfFunctionOne.setText(mAlertItem[item].toString());
                    dialogInterface.dismiss();
                }
                if (k == 2) {
                    codeTwo = listCode[item].toString();
                    txtCodeOfFunctionTwo.setText(mAlertItem[item].toString());
                    dialogInterface.dismiss();
                }
                if (k == 3) {
                    codeThree = listCode[item].toString();
                    txtCodeOfFunctionThree.setText(mAlertItem[item].toString());
                    dialogInterface.dismiss();
                }

            }
        });
        builder.setBackground(this.getResources().getDrawable(R.drawable.alert_dialog_bg, null));
        builder.show();

    }

    private void selectColor(int k) {
        if (k == 1) {
            llSelectColor.setVisibility(View.VISIBLE);
            llSaveColor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    colorPicker();
                    llSelectColor.setVisibility(View.GONE);
                    GradientDrawable gdDefault = new GradientDrawable();
                    try {
                        gdDefault.setColor(Color.parseColor(hex));
                        txtColorOfFunctionOne.setTextColor(Color.parseColor("#000000"));
                        colorOne = hex;
                    }catch (Exception e){
                        gdDefault.setColor(Color.parseColor("#000000"));
                        txtColorOfFunctionOne.setTextColor(Color.parseColor("#ffffff"));
                        colorOne = hex;
                    }
                    gdDefault.setCornerRadius(50);
                    llColorOfFunctionOne.setBackground(gdDefault);
                }
            });


        }
        if (k == 2) {
            llSelectColor.setVisibility(View.VISIBLE);
            llSaveColor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    colorPicker();
                    colorTwo = hex;
                    llSelectColor.setVisibility(View.GONE);
                    GradientDrawable gdDefault = new GradientDrawable();
                    try {
                        gdDefault.setColor(Color.parseColor(hex));
                        txtColorOfFunctionTwo.setTextColor(Color.parseColor("#000000"));
                        colorOne = hex;
                    }catch (Exception e){
                        gdDefault.setColor(Color.parseColor("#000000"));
                        txtColorOfFunctionTwo.setTextColor(Color.parseColor("#ffffff"));
                        colorOne = hex;
                    }

                    gdDefault.setCornerRadius(50);
                    llColorOfFunctionTwo.setBackground(gdDefault);
                }
            });


        }
        if (k == 3) {
            llSelectColor.setVisibility(View.VISIBLE);
            llSaveColor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    colorPicker();
                    colorThree = hex;
                    llSelectColor.setVisibility(View.GONE);
                    GradientDrawable gdDefault = new GradientDrawable();
                    try {
                        gdDefault.setColor(Color.parseColor(hex));
                        txtColorOfFunctionThree.setTextColor(Color.parseColor("#000000"));
                        colorOne = hex;
                    }catch (Exception e){
                        gdDefault.setColor(Color.parseColor("#000000"));
                        txtColorOfFunctionThree.setTextColor(Color.parseColor("#ffffff"));
                        colorOne = hex;
                    }

                    gdDefault.setCornerRadius(50);
                    llColorOfFunctionThree.setBackground(gdDefault);
                }
            });


        }
    }

    private void colorPicker() {

        imgColorPicker.setDrawingCacheEnabled(true);
        imgColorPicker.buildDrawingCache(true);
        try {
            imgColorPicker.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                        bitmap = imgColorPicker.getDrawingCache();
                        int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());
                        int r = Color.red(pixel);
                        int g = Color.green(pixel);
                        int b = Color.blue(pixel);

                        hex = "#" + Integer.toHexString((pixel));
                        viewColor.setBackgroundColor(Color.rgb(r, g, b));


                    }
                    return true;
                }
            });

        } catch (Exception e) {
        }

    }

    private boolean isMobileNumber(String mobile_number) {
        if (mobile_number != null && mobile_number.startsWith("0")) {
            return true;
        }
        return false;


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