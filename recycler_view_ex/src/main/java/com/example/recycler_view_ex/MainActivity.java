package com.example.recycler_view_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 12
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1
        String [] names = {"이명지", "김인보", "나잘란", "진달래", "황금복", "최전선",
                "마진가", "백김치", "오리온", "조이풀"};

        //13
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(names));
    }
}
//2
class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder>{
    //7
    String[] data;
    // 생성자 generate > construct
    public CustomRecyclerViewAdapter(String[] data) {
        this.data = data;
    }

    // 8 메소드 오버라이딩
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //9
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //10
        holder.getTextView().setText(data[position]);
    }

    @Override
    public int getItemCount() {
        //11
        return data.length; //데이터 배열의 길이 => 아이템의 개수
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        //4
        private final TextView textView;
        //3 generate > construct
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //6
            this.textView = (TextView) itemView.findViewById(R.id.textView);
        }
        //5 generate > Getter
        public TextView getTextView() {
            return textView;
        }
    }
}