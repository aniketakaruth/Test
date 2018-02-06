package com.mowize.testapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mowize.testapp.models.MainCategory;

import java.util.List;

/**
 * Created by Ravi Mathpal on 06-02-2018.
 */

public class MainCategoryAdapter extends RecyclerView.Adapter<MainCategoryAdapter.Sample> {

    List<MainCategory> list;
    private onRowSelected listener;

    MainCategoryAdapter(List<MainCategory> list, onRowSelected listener) {
        this.list = list;
        this.listener = listener;
    }

    @Override
    public Sample onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_category_list, parent, false);
        Sample vh = new Sample(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Sample holder, final int position) {
        holder.count.setText("Total Subcategories: " + list.get(position).getListOfSubCategories().size());
        holder.name.setText(list.get(position).getCategoryName());
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRowSelected(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Sample extends RecyclerView.ViewHolder {

        private TextView name, count;
        private LinearLayout row;

        public Sample(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.categoryName);
            count = itemView.findViewById(R.id.categoryCount);
            row = itemView.findViewById(R.id.row);
        }
    }

    public interface onRowSelected {
        void onRowSelected(MainCategory mainCategory);
    }


}
