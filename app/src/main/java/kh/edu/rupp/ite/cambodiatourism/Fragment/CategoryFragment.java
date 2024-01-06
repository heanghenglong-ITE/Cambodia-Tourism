package kh.edu.rupp.ite.cambodiatourism.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kh.edu.rupp.ite.cambodiatourism.Activity.DetailActivity;
import kh.edu.rupp.ite.cambodiatourism.Adapter.CategoryAdapter;
import kh.edu.rupp.ite.cambodiatourism.R;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.CategoryDomain;
import kh.edu.rupp.ite.cambodiatourism.model.api.ApiService;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;
import android.widget.Button;

public class CategoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private List<CategoryDomain> originalCategoryDomains;  // To store the original data

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CategoryAdapter(getActivity(), new ArrayList<>());
        recyclerView.setAdapter(adapter);

        SearchView searchView = rootView.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle the submission if needed
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the list when the query text changes
                filterCategoryList(newText);
                return true;
            }
        });

        Button btnBeach = rootView.findViewById(R.id.btnBeach);
        Button btnCamps = rootView.findViewById(R.id.btnCamps);
        Button btnForest = rootView.findViewById(R.id.btnForest);
        Button btnDesert = rootView.findViewById(R.id.btnDesert);
        Button btnMountain = rootView.findViewById(R.id.btnMontain);
        Button btnTample = rootView.findViewById(R.id.btnTample);

        // Set click listeners for the buttons
        btnBeach.setOnClickListener(view -> makeApiRequest("beach"));
        btnCamps.setOnClickListener(view -> makeApiRequest("camps"));
        btnForest.setOnClickListener(view -> makeApiRequest("forest"));
        btnDesert.setOnClickListener(view -> makeApiRequest("desert"));
        btnMountain.setOnClickListener(view -> makeApiRequest("mountain"));
        btnTample.setOnClickListener(view -> makeApiRequest("tample"));
        adapter.setOnItemClickListener(categoryDomain -> {
            // Open the detail view when an item is clicked
            openDetailView(categoryDomain);
        });

        // Default to showing all categories
        makeApiRequest("all");

        return rootView;
    }

    private void openDetailView(CategoryDomain categoryDomain) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("itemId", categoryDomain.getId());
        intent.putExtra("itemName", categoryDomain.getName());
        intent.putExtra("itemLocation", categoryDomain.getLocation());
        intent.putExtra("itemDescription", categoryDomain.getDescription());
        intent.putExtra("imageUrl", categoryDomain.getImageUrl());
        intent.putExtra("itemMap", categoryDomain.getMap());
        intent.putExtra("itemarea", categoryDomain.getArea());
        intent.putExtra("itemseason", categoryDomain.getSeason());
        intent.putExtra("itemroad", categoryDomain.getRoad());
        intent.putExtra("itemfacity", categoryDomain.getFacity());
        intent.putExtra("itemfabuilding", categoryDomain.getFabuilding());
        intent.putExtra("itemlink", categoryDomain.getLink());
        startActivity(intent);
    }

    private void makeApiRequest(String category) {

        Retrofit httpClient = new Retrofit.Builder()
                .baseUrl("https://tochhit.github.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create Service object
        ApiService apiService = httpClient.create(ApiService.class);

        Call<List<CategoryDomain>> call = apiService.getTourismSpots();

        call.enqueue(new Callback<List<CategoryDomain>>() {
            @Override
            public void onResponse(@NonNull Call<List<CategoryDomain>> call, @NonNull Response<List<CategoryDomain>> response) {
                if (response.isSuccessful()) {
                    List<CategoryDomain> categoryDomains = response.body();
                    if (categoryDomains != null && !categoryDomains.isEmpty()) {
                        originalCategoryDomains = new ArrayList<>(categoryDomains);  // Save the original data
                        if ("all".equals(category)) {
                            adapter.setData(categoryDomains);
                        } else {
                            // Filter by category
                            List<CategoryDomain> filteredList = filterByCategory(categoryDomains, category);
                            adapter.setData(filteredList);
                        }
                    } else {
                        Log.e("APIResponse", "Empty or null response body");
                        Toast.makeText(getActivity(), "Error: Empty response", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("APIResponse", "Error: " + response.message());
                    Toast.makeText(getActivity(), "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<CategoryDomain>> call, @NonNull Throwable t) {
                Log.e("APIResponse", "Network error: " + t.getMessage());
                Toast.makeText(getActivity(), "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void filterCategoryList(String query) {
        if (originalCategoryDomains != null) {
            // If the original data is available, filter it based on the entered text
            List<CategoryDomain> filteredList = new ArrayList<>();
            for (CategoryDomain item : originalCategoryDomains) {
                if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(item);
                }
            }
            adapter.setData(filteredList);
        }
    }
    
    private List<CategoryDomain> filterByCategory(List<CategoryDomain> categoryDomains, String category) {
        // Filter the list based on the selected category
        // You can implement your own logic here
        // For simplicity, this example filters by matching the category name
        return categoryDomains.stream()
                .filter(item -> category.equalsIgnoreCase(item.getCategory()))
                .collect(Collectors.toList());
    }
    
}

