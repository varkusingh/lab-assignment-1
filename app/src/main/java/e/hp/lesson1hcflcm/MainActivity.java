package e.hp.lesson1hcflcm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int n2;
    int n1;
    int ansLCM, ansHCF;
    EditText num1, num2;

    int gcdLCM(int num1,int num2)  {
        if(num1==0||num2==0)
            return 0;
        if(num1==num2)
            return num1;
        if(num1>num2)
            return (gcdLCM(num1-num2,num2));
        return(gcdLCM(num1,num2-num1));
    }
    int gcdHCF(int num1,int num2) {
        if (num1 == 0 )
            return num2;
        if(num2 == 0)
            return num1;
        if (num1 == num2)
            return num1;
        if (num1 > num2)
            return (gcdHCF(num1 - num2, num2));
        return (gcdHCF(num1, num2 - num1));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        num1 = findViewById(R.id.editText1);
        num2 = findViewById(R.id.editText2);

        Button lcm, hcf;
        lcm = findViewById(R.id.lcmButton);
        hcf = findViewById(R.id.hcfButton);








        lcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Integer.parseInt(num1.getText().toString());
                n2 = Integer.parseInt(num2.getText().toString());
                ansLCM =n1*n2/(gcdLCM(n1,n2));
                Toast.makeText(MainActivity.this, ""+ansLCM, Toast.LENGTH_LONG).show();
            }
        });

        hcf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Integer.parseInt(num1.getText().toString());
                n2 = Integer.parseInt(num2.getText().toString());
                ansHCF =gcdHCF(n1,n2);
                Toast.makeText(MainActivity.this, ""+ansHCF, Toast.LENGTH_LONG).show();
            }
        });


    }
}
