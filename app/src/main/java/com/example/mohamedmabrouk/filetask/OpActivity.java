package com.example.mohamedmabrouk.filetask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OpActivity extends AppCompatActivity {
public static final String ARGS="com.example.mohamedmabrouk.filetask.list";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op);
    }

    public void done(View view){
        switch (view.getId()){
            case R.id.add_book:
                startActivity(new Intent(this,ADDNewBook.class));
                break;
            case R.id.show_all_books:
                Intent  intent=new Intent(this, ShowAllBooks.class);
                startActivity(intent);
                break;
        }
    }


}
