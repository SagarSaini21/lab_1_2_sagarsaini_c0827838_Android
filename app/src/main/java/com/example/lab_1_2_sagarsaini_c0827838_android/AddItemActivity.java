package com.example.lab_1_2_sagarsaini_c0827838_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
    EditText name, price, desc;
    Button addItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        name=findViewById(R.id.upname);
        price=findViewById(R.id.upprice);
        desc=findViewById(R.id.updesc);
        addItem=findViewById(R.id.btnUpdate);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(AddItemActivity.this);
                myDB.additem(name.getText().toString().trim(),
                        desc.getText().toString().trim(),
                        price.getText().toString().trim());

            }
        });
    }
}