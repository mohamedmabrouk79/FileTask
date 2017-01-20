package com.example.mohamedmabrouk.filetask;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class ADDNewBook extends AppCompatActivity {
  private EditText bookname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnew_book);
        bookname=(EditText)findViewById(R.id.bookName);
    }

    public void save(View  view){

        try{
            FileOutputStream fileOutputStream=openFileOutput("books.txt", Context.MODE_APPEND);
            OutputStreamWriter writer=new OutputStreamWriter(fileOutputStream);
            writer.append(bookname.getText().toString()+" ");
            writer.close();
            bookname.setText("");
            Toast.makeText(this, " Add ", Toast.LENGTH_SHORT).show();
        }catch (Exception e){

        }
    }
}
