package com.example.sampleroyaandroid.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleroyaandroid.databinding.ItemCountriesBinding;
import com.example.sampleroyaandroid.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {

    private List<CountryModel> listCountries=new ArrayList();
    private Context context;

    public CountriesAdapter(List<CountryModel> listCountries, Context context) {
        this.listCountries = listCountries;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCountriesBinding binding = ItemCountriesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listCountries.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ItemCountriesBinding binding;

        ViewHolder(@NonNull ItemCountriesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

}
