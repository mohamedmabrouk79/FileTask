package com.example.mohamedmabrouk.filetask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed Mabrouk on 09/05/2016.
 */
public class show_fragment extends Fragment {
    private RecyclerView recyclerView;
    private Button save;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.show_fragment,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ShowAdapter adapter=new ShowAdapter(getAllBooks());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }
    public List<String> getAllBooks(){
        List<String> list=new ArrayList<>();
        try{
            FileInputStream fileInputStream=getActivity().openFileInput("books.txt");
            InputStreamReader reader=new InputStreamReader(fileInputStream);
            char[] buffers=new char[100];
            String s="";
            int charRead;
            while ((charRead=reader.read(buffers))>0){
                String  ReadString=String.copyValueOf(buffers,0,charRead);
                s+=ReadString;
                buffers=new char[100];
                do {
                   list.add(s.substring(0,s.indexOf(" ")));
                    break;
                }while (true);
            }

        }catch (Exception e){

        }
        return list;
    }
    private class ShowHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ShowHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.textView);
        }

        public void bindshowbooks(String s){
            textView.setText(s);
        }
    }

    private class ShowAdapter extends RecyclerView.Adapter<ShowHolder>{
    private List<String> list;

        public ShowAdapter(List<String> lists){
            this.list=lists;
        }
        @Override
        public ShowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(getActivity());
            View view=inflater.inflate(R.layout.show_books_list,parent,false);
            return new ShowHolder(view);
        }

        @Override
        public void onBindViewHolder(ShowHolder holder, int position) {
         String s=list.get(position);
            holder.bindshowbooks(s);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

}
