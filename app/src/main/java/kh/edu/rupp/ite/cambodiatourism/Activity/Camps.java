package kh.edu.rupp.ite.cambodiatourism.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kh.edu.rupp.ite.cambodiatourism.Adapter.CampsAdapter;
import kh.edu.rupp.ite.cambodiatourism.Adapter.CategoryAdapter;
import kh.edu.rupp.ite.cambodiatourism.Data.CampsData;
import kh.edu.rupp.ite.cambodiatourism.Data.CategoryData;
import kh.edu.rupp.ite.cambodiatourism.R;

import kh.edu.rupp.ite.cambodiatourism.model.api.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// ...

public class Camps extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<CampsData> dataList;
    private CampsAdapter adapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camps);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        // Initialize data and adapter
        dataList = new ArrayList<>(); // Initialize an empty list

        adapter = new CampsAdapter(dataList);

        // Set up RecyclerView with GridLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        // Initialize SearchView
        searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        // Make API request
        fetchCampsData();
    }

    private void fetchCampsData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.example.com/") // Replace with your API base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<CampsData>> call = apiService.getCamps();
        call.enqueue(new Callback<List<CampsData>>() {
            @Override
            public void onResponse(Call<List<CampsData>> call, Response<List<CampsData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    dataList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(Camps.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CampsData>> call, Throwable t) {
                Toast.makeText(Camps.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void searchList(String text) {
        // Implement search logic if needed
        // This can be done on the dataList obtained from the API response
    }
}

