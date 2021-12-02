package com.example.bie_daalt.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bie_daalt.Interface.ItemClickListener;
import com.example.bie_daalt.R;


public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtproductname,txtproductdescription,txtproductprice;
    public ImageView img;
    public ItemClickListener listener;
    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.product_image);
        txtproductname = itemView.findViewById(R.id.product_name);
        txtproductdescription = itemView.findViewById(R.id.product_description);
        txtproductprice = itemView.findViewById(R.id.product_price );
    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v)
    {
        listener.onClick(v, getAdapterPosition(),false);
    }
}
