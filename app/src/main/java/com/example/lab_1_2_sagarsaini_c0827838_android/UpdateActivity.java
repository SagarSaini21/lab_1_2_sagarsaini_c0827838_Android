package com.example.lab_1_2_sagarsaini_c0827838_android;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText name2,desc2,price2;
    Button updatebtn,deletebtn;
    MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
    String id,name,desc,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name2=findViewById(R.id.upname);
        desc2=findViewById(R.id.updesc);
        price2=findViewById(R.id.upprice);
        updatebtn=findViewById(R.id.btnUpdate);
        deletebtn=findViewById(R.id.btndelete);
        getIntentData();
        ActionBar ab = getSupportActionBar();
        ab.setTitle(name2.getText().toString());

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDB.updateData(id,name2.getText().toString(),desc2.getText().toString(),price2.getText().toString());

            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               alertmssg();
            }
        });


    }
    void getIntentData()
    {
    if(  (getIntent().hasExtra("id"))&&(getIntent().hasExtra("name"))&&(getIntent().hasExtra("desc")) &&(getIntent().hasExtra("price"))      )
        {
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            desc = getIntent().getStringExtra("desc");
            price = getIntent().getStringExtra("price");

            name2.setText(name);
            desc2.setText(desc);
            price2.setText(price);



        }else{
        Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
    }

    }


    void alertmssg()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(name2.getText().toString());
        builder.setMessage("Are you sure you want to delete this item?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                myDB.ondelete(id);
                finish();
            }
        });
        builder.setNegativeButton("No",null);
        builder.create().show();
    }
}