package like.sirvan.bira.App;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import like.sirvan.bira.Activity.MainActivity;
import like.sirvan.bira.R;

public class MyAlertDialog {

    Context context;
    Activity activity;

    public MyAlertDialog(Activity activity , Context context) {
        this.activity = activity;
        this.context = context;
    }
    public void Show(String notification, final String function,final String number,final String password){

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
        builder.setTitle("توجه");
        builder.setMessage(notification);
        builder.setIcon(R.drawable.ic_baseline_error_outline_24);
        builder.setBackground(context.getResources().getDrawable(R.drawable.alert_dialog_bg, null));
        builder.setPositiveButton("ارسال", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SMSUtils.sendSMS(context, number, "*#" + password + function);
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
