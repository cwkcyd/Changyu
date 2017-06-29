package plan.daily.cwk.com.changyu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
        Log.e(TAG, "changyu");
        Log.e(TAG, "changyu_new");

        printLog();
        printLog();
    }

    private void printLog() {
        System.out.println("printLog " + TAG);
    }
}
