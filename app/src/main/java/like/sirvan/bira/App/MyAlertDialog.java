package like.sirvan.bira.App;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import like.sirvan.bira.Activity.MainActivity;
import like.sirvan.bira.R;

public class MyAlertDialog {

    Context context;

    public MyAlertDialog( Context context) {
        this.context = context;
    }
    public void Show(String notification, final String function,final String number){

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
        builder.setTitle("توجه");
        builder.setMessage(notification);
        builder.setIcon(R.drawable.ic_baseline_error_outline_24);
        builder.setBackground(context.getResources().getDrawable(R.drawable.alert_dialog_bg, null));
        builder.setPositiveButton("ارسال", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               // SMSUtils.sendSMS(context, number, "*#" + "1234" + function);

            /*    Dexter.withContext(context)
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
                        }).check();*/
            }
        });
        builder.setNegativeButton("بی خیال", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "دستور لغو شد", Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });

        builder.show();
    }
}
