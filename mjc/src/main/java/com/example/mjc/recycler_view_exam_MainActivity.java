package com.example.mjc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class recycler_view_exam_MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_exam_main);
        String [] names = {"이명지", "김명지", "김인보", "김컴공", "박인보"};
        String [] phones = {"3000-1331", "3000-1111", "3000-2222", "3000-3333", "3000-4444"};
        int [] face = {1,2,1,2,1};

        ArrayList<Student> students = new ArrayList<>();
        for(int i=0 ; i<5; i++){
            Student student = new Student(names[i], phones[i], face[i]);
            students.add(student);

        }
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(students));
       // recyclerView.addItemDecoration(new MyItemDecoration(phones));
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View child=recyclerView.findChildViewUnder(e.getX(), e.getY());
                int position = recyclerView.getChildAdapterPosition(child);
                Toast.makeText(getApplicationContext(), students.get(position).getName(), Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }
}
class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder>{
    private static ArrayList<Student> data;

    public CustomRecyclerViewAdapter(ArrayList<Student> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getNameView().setText(data.get(position).getName());
        holder.getPhoneView().setText(data.get(position).getPhone());
        holder.getImgView().setImageResource(R.drawable.ic_face1);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameView;
        private final TextView phoneView;
        private final ImageView imgView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgView = (ImageView) itemView.findViewById(R.id.imageView);
            this.nameView = (TextView) itemView.findViewById(R.id.textView);
            this.phoneView = (TextView) itemView.findViewById(R.id.textView2);

            nameView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Toast.makeText(itemView.getContext(), data.get(position).getPhone(), Toast.LENGTH_LONG).show();
                }
            });
        }

        public ImageView getImgView() {
            return imgView;
        }

        public TextView getNameView() {
            return nameView;
        }

        public TextView getPhoneView() {
            return phoneView;
        }
    }
}