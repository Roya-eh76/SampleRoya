package com.example.sampleroyaandroid.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sampleroyaandroid.R;
import com.example.sampleroyaandroid.databinding.FragmentMainBinding;
import com.example.sampleroyaandroid.model.CountryModel;
import com.example.sampleroyaandroid.networkApi.ApiClient;
import com.example.sampleroyaandroid.networkApi.ApiCountries;
import com.example.sampleroyaandroid.repository.CountriesRepository;
import com.example.sampleroyaandroid.view.adapter.CountriesAdapter;
import com.example.sampleroyaandroid.viewModel.CountriesViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    private CountriesAdapter countriesAdapter;
    private CountriesViewModel countriesViewModel;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countriesViewModel =new ViewModelProvider(requireActivity()).get(CountriesViewModel.class);
         countriesViewModel.getList(requireContext()).observe(requireActivity(), new Observer<List<CountryModel>>() {
            @Override
            public void onChanged(List<CountryModel> countryModels) {
                countriesAdapter = new CountriesAdapter(countryModels, requireContext());
                binding.recyclerView.setAdapter(countriesAdapter);
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
                countriesAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        List<CountryModel> list=new ArrayList<>();
        countriesAdapter = new CountriesAdapter(list, requireContext());
        binding.recyclerView.setAdapter(countriesAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));


       getAllCountry();

        return binding.getRoot();
    }


    /*private  void setAdapter(List<CountryModel> models){
        // TODO: 30/11/2020 set adapter
        countriesAdapter = new CountriesAdapter(models, requireContext());
        binding.recyclerView.setAdapter(countriesAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));

    }
*/

    private void getAllCountry() {
        /*apiCountries.getCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CountryModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<CountryModel> countryModels) {
                        setAdapter(countryModels);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });*/



    }
}