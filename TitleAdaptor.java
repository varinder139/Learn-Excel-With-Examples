package varinder.study.learnexcelwithexamples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TitleAdaptor extends RecyclerView.Adapter<TitleAdaptor.MyViewHolder>{

    private Context mcontext;
    private ArrayList<String> titleList;
    private CustomItemClickListener clickListener;

    public TitleAdaptor(Context mcontext, ArrayList<String> titleList, CustomItemClickListener clickListener){
        this.mcontext = mcontext;
        this.titleList = titleList;
        this.clickListener = clickListener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mcontext).inflate(R.layout.title_layout,parent, false);

                final MyViewHolder viewHolder = new MyViewHolder(view);

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickListener.onItemClick(view, viewHolder.getPosition());
                    }
                });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titleText.setText(titleList.get(position).replace("_"," "));


    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titleText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleText = (TextView)itemView.findViewById(R.id.title_text);

        }
    }
    public void updateList(ArrayList<String> newList){
        titleList = new ArrayList<>();
        titleList.addAll(newList);
        notifyDataSetChanged();

    }
}

Here the Design title_layout.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    >

    <androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardCornerRadius="12dp"
        android:padding="5dp"
        android:layout_margin="5dp"
        >


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

    <ImageView
        android:id="@+id/title_img"
        android:layout_width="40dp"
        android:layout_height="40dp"
        android:src="@drawable/function"
        />
    <TextView
        android:id="@+id/title_text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="title will be here"
        android:textSize="16sp"
        android:textStyle="bold"
        android:layout_margin="4dp"
        android:textColor="#07816F"/>


</LinearLayout>
    </androidx.cardview.widget.CardView>
</LinearLayout>
