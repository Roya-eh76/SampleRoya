package com.example.sampleroyaandroid.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleroyaandroid.R;
import com.example.sampleroyaandroid.databinding.ItemCountriesBinding;
import com.example.sampleroyaandroid.model.CountryModel;
import com.squareup.picasso.Picasso;

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
      holder.binding.nameTextView.setText(listCountries.get(position).getName());
      holder.binding.capitalTextView.setText(listCountries.get(position).getCapital());
//      holder.binding.languageTextView.setText((CharSequence) listCountries.get(position).getLanguages().get(position));

   /*     Picasso.get()
                .load(listCountries.get(position).get)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.binding.imageView);*/
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

            binding.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"click",Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

}
