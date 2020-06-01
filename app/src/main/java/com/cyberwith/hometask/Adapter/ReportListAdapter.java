package com.cyberwith.hometask.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.cyberwith.hometask.DetailsActivity;
import com.cyberwith.hometask.R;
import com.cyberwith.hometask.models.ReportListModel;
import java.io.Serializable;
import java.util.List;

public class ReportListAdapter extends RecyclerView.Adapter<ReportListAdapter.MyViewHolder> {

    private Context context;
    private List<ReportListModel> reportListModels;


    public ReportListAdapter(Context context, List<ReportListModel> reportListModels) {
        this.context = context;
        this.reportListModels = reportListModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_report_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ReportListModel reportListModel = reportListModels.get(position);
        String imageURL = "http://unionint.net/"+reportListModel.getImage();
        Glide.with(context.getApplicationContext()).load(imageURL).into(holder.imageView);
        holder.title.setText(reportListModel.getTitle());
        holder.price.setText("Price: "+reportListModel.getPrice()+"tk");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("imageURL", imageURL);
                intent.putExtra("title", reportListModel.getTitle());
                intent.putExtra("productID", reportListModel.getId());
                intent.putExtra("price", reportListModel.getPrice());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reportListModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title, price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.itemImageViewID);
            title = itemView.findViewById(R.id.itemTitleID);
            price = itemView.findViewById(R.id.itemPriceID);
        }
    }
}
