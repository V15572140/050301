package com.example.asus.a101;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    private String Sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent = this.getIntent();
        Bundle = Intent.getExtras();

        String Sex = Bundle.getString("Sex");
        double height = Bundle.getDouble("h");
        double weight = Bundle.getDouble("w");

        String BMI_result = this.getBMI(height, weight);
        String BMI_advice = this.getAdvice(Sex, height, weight);

        TextView BMI = (TextView) findViewById(R.id.BMI);

        BMI.setText(BMI_result);

        TextView tvAdvice = (TextView) findViewById(R.id.Advice);

        tvAdvice.setText(BMI_advice);


        Button b2 = (Button) findViewById(R.id.button2);

        b2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                setResult(RESULT_OK, Intent);

                finish();


            }



            }

        });

    }
    private String format(double num) {

        DecimalFormat nf = new DecimalFormat("@##");

        String s = nf.format(num);

        return s;

    private String getAdvice(String Sex, double height, double weight) {
            double BMI_MAX;

            double BMI_MIN;

            double BMI = weight / (height * height);

            if (Sex.equals("M")) {

                BMI_MAX = 25.0;

                BMI_MIN = 20.0;

            } else {

                BMI_MAX = 22.0;

                BMI_MIN = 18.0;

            }

            if (BMI > BMI_MAX) {

                return getString(R.string.advice_heavy);

            } else if (BMI < BMI_MIN) {

                return getString(R.string.advice_light);

            } else {

                return getString(R.string.advice_average);

            }

        }


    }


}

    private String getBMI(double height, double weight) {

        double BMI_value = weight / (height * height);

        return getString(R.string.report_result) + format(BMI_value);
    }
}
}
