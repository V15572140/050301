package com.example.asus.a101;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private EditText edh;
    private EditText edw;
    private RadioButton rbm;
    private RadioButton rbf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button)findViewById(R.id.button1);

        edh =(EditText) findViewById(R.id.height);
        edw =(EditText) findViewById(R.id.weight);
        rbm =(RadioButton) findViewById(R.id.male);
        rbf =(RadioButton) findViewById(R.id.female);

        b1.setOnClickListener(new Button.OnClickListener (){
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(edh.getText().toString()+"");
                double weight = Double.parseDouble(edw.getText().toString()+"");

                String Sex="";
                if (rbm.isChecked()){
                    Sex="M";
                }else{
                    Sex="F";
                }
                Intent intent= new Intent();
                intent.setClass(MainActivity,this,Main2Activity.class);

                Bundle b = new Bundle();
                b.putDouble("h",height);
                b.putDouble("w",weight);
                b.putString("Sex",Sex);

                intent.putExtra(b);
                startActivity(intent);
                )


            }


        }
    }


    }
    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (resultCode) {

            case RESULT_OK:


                Bundle bundle = data.getExtras();

                String Sex = bundle.getString("Sex");

                double height = bundle.getDouble("h");

                double weight = bundle.getDouble("w");


                edh.setText("" + height);

                edw.setText("" + weight);

                if (Sex.equals("M")) {

                    rbm.setChecked(true);

                } else {

                    rbf.setChecked(true);

                }

                break;

            default:

                break;

        }

    }

}


}
