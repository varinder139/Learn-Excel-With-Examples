package varinder.study.learnexcelwithexamples;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.view.View;

public class Main2Activity extends AppCompatActivity {

    CardView CV_users;
    CardView CV_addusers;
    CardView CV_reports;
    CardView CV_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        CV_users = (CardView)findViewById(R.id.users);
        CV_addusers = (CardView)findViewById(R.id.addusers);
        CV_reports = (CardView)findViewById(R.id.reports);
        CV_setting = (CardView)findViewById(R.id.setting);

        CV_users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main2Activity.this,Introduction.class));

            }
        });

        CV_addusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,fomulas_function.class));

            }
        });

        CV_reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main2Activity.this,Shortcut.class));

            }
        });

        CV_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" +
                        getPackageName())));

            }
        });






    }


}
