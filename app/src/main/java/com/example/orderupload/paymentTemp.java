package com.example.orderupload;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class paymentTemp extends AppCompatActivity {

    TextView vendName;
    EditText money;
    Button button;

    float monIn=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_temp);

        vendName=(TextView)findViewById(R.id.vendNameText);
        money=(EditText)findViewById(R.id.money);
        button=(Button)findViewById(R.id.confirmButton);

        String vendorName=getIntent().getStringExtra("vendName");
        vendName.setText(vendorName);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextAct();
            }
        });

    }

    public void openNextAct()
    {
        monIn=Float.valueOf(money.getText().toString());

        if(!(monIn==-1))
        {
            Intent paymentData = new Intent();
            paymentData.putExtra("payAmount",monIn);
            setResult(RESULT_OK, paymentData);
        }
        else
        {
            setResult(RESULT_CANCELED);
        }
        finish();
    }
}