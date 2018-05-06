package com.tranchikhang.actionbartest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PizzasFragment extends Fragment implements CaptionedImagesAdapter.Listener {


    public PizzasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.pizza_fragment,container,false);
        String[] caption = new String[Pizza.pizzas.length];
        for (int i=0;i<Pizza.pizzas.length;i++) {
            caption[i] = Pizza.pizzas[i].getName();
        }
        int[] IdResource = new int[Pizza.pizzas.length];
        for(int i=0;i<Pizza.pizzas.length;i++) {
            IdResource[i] = Pizza.pizzas[i].getResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(caption,IdResource);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        return recyclerView;
    }

    @Override
    public void onClick(Pizza pizza) {
        String cap = pizza.getName();
        int resID = pizza.getResourceId();
        Intent intent =  new Intent(getActivity(),PizzaDetailActivity.class);
        intent.putExtra(PizzaDetailActivity.CAPTION_STRING,cap);
        intent.putExtra(PizzaDetailActivity.RESID_STRING,resID);
        getActivity().startActivity(intent);
    }
}
