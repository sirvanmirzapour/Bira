package like.sirvan.bira.App;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {

    public SharedPreferences setting;
    private static final String PREFERENCES = "MY_PREFERENCES";
    public static final String NUMBER = "NUMBER";
    public static final String PASS = "PASS";
    public static final String NAME = "NAME";

    public Prefs(Context context) {
        setting = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    public String getData(String key) {
        return setting.getString(key, "err");
    }

    public void setData(String key, String value) {
        SharedPreferences.Editor editor = setting.edit();
        editor.putString(key, value);
        editor.apply();
    }
}
