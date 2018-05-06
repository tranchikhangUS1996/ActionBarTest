package com.tranchikhang.actionbartest;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{
    private String[] Captions;
    private int[] Ids;
    private Listener listener;

    interface Listener {
        public void onClick(Pizza pizza);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public CaptionedImagesAdapter(String[] captions,int[] ids) {
        this.Captions = captions;
        this.Ids = ids;
    }

    @Override
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CaptionedImagesAdapter.ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_image);
        imageView.setImageResource(Ids[position]);
        imageView.setContentDescription(Captions[position]);
        TextView cap = (TextView) cardView.findViewById(R.id.info_text);
        cap.setText(Captions[position]);
        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(listener!=null) {
                    listener.onClick(Pizza.pizzas[position]);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Captions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView view) {
            super(view);
            cardView = view;
        }
    }
}
