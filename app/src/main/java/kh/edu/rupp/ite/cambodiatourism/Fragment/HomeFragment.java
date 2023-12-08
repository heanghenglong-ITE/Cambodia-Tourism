package kh.edu.rupp.ite.cambodiatourism.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kh.edu.rupp.ite.cambodiatourism.Adapter.MoreAdapter;
import kh.edu.rupp.ite.cambodiatourism.Adapter.PopularAdapter;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.MoreDomain;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.PopularDomain;
import kh.edu.rupp.ite.cambodiatourism.R;
import kh.edu.rupp.ite.cambodiatourism.databinding.FragmentHomeBinding;
import kh.edu.rupp.ite.cambodiatourism.model.api.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // load list place from server (api)
        loadPlaceListFromServer();
    }

    private void loadPlaceListFromServer() {

        // create retrofit client

        Retrofit httpClient = new Retrofit.Builder()
                .baseUrl("https://heanghenglong-ite.github.io/madapi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create Service object
        ApiService apiService = httpClient.create(ApiService.class);

        // Load place list from server
        Call<List<PopularDomain>> task = apiService.loadPopularList();
        task.enqueue(new Callback<List<PopularDomain>>() {
            @Override
            public void onResponse(Call<List<PopularDomain>> call, Response<List<PopularDomain>> response) {

                if (response.isSuccessful()) {
                    List<PopularDomain> placeList = response.body();
                    showPlaceList(placeList);
                }else {
                    Toast.makeText(getContext(), "Load Place list failed!",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<PopularDomain>> call, Throwable t) {
                Toast.makeText(getContext(), "Load Place list failed!",Toast.LENGTH_LONG).show();
                Log.e("[HomeFragment]","Load Place Failed:" + t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void showPlaceList(List<PopularDomain> placeList){

        // Create layout manager
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        binding.recyclerView.setLayoutManager(layoutManager);

        // create adapter
        PopularAdapter adapter = new PopularAdapter();
        adapter.submitList(placeList);
        binding.recyclerView.setAdapter(adapter);

    }
}