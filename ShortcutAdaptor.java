package varinder.study.learnexcelwithexamples;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ShortcutAdaptor extends RecyclerView.Adapter<ShortcutAdaptor.ShortCutViewHolder>{

    private Context mcontext;
    private ArrayList<String> titleList;
    private CustomItemClickListener clickListener;

    public ShortcutAdaptor(Context mcontext, ArrayList<String> titleList, CustomItemClickListener clickListener){
        this.mcontext = mcontext;
        this.titleList = titleList;
        this.clickListener = clickListener;

    }

    @NonNull
    @Override
    public ShortCutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mcontext).inflate(R.layout.activity_shortcut_adaptor,parent, false);

        final ShortcutAdaptor.ShortCutViewHolder viewHolder = new ShortcutAdaptor.ShortCutViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(view, viewHolder.getPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShortcutAdaptor.ShortCutViewHolder holder, int position) {
        holder.titleText.setText(titleList.get(position).replace("_"," "));


    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public class ShortCutViewHolder extends RecyclerView.ViewHolder{

        TextView titleText;

        public ShortCutViewHolder(@NonNull View itemView) {
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


design for shortcut Adaptor

activity_shortcut_adaptor.xml


<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
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
            android:layout_height="wrap_content"
            >


            <TextView
                android:id="@+id/title_text"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="title will be here"
                android:textSize="16sp"
                android:textStyle="bold"
                android:layout_margin="4dp"
                android:textColor="#088808"
                />


        </LinearLayout>
    </androidx.cardview.widget.CardView>
</LinearLayout>

