package kh.edu.rupp.ite.cambodiatourism.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView; // Import from androidx.appcompat.widget

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import kh.edu.rupp.ite.cambodiatourism.Activity.DetailActivity;
import kh.edu.rupp.ite.cambodiatourism.Adapter.CategoryAdapter;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.CategoryDomain;
import kh.edu.rupp.ite.cambodiatourism.model.api.ApiService;
import kh.edu.rupp.ite.cambodiatourism.R;
import kh.edu.rupp.ite.cambodiatourism.databinding.FragmentExploreBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ExploreFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private List<CategoryDomain> originalCategoryDomains;

    private FragmentExploreBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentExploreBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        recyclerView = binding.recyclerViewExplor;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new CategoryAdapter(requireContext(), new ArrayList<>());
        recyclerView.setAdapter(adapter);
        SearchView searchView = binding.searchView;

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle submission (if needed)
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the list based on the search query
                filterCategoryList(newText);
                return true;
            }
        });




        adapter.setOnItemClickListener(categoryDomain -> openDetailView(categoryDomain));

        makeApiRequest("all");

        return rootView;
    }

    private void openDetailView(CategoryDomain categoryDomain) {
        Intent intent = new Intent(requireContext(), DetailActivity.class);
        // Put extra data for the detail view
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

        ApiService apiService = httpClient.create(ApiService.class);

        Call<List<CategoryDomain>> call = apiService.getTourismSpots();

        call.enqueue(new Callback<List<CategoryDomain>>() {
            @Override
            public void onResponse(@NonNull Call<List<CategoryDomain>> call, @NonNull Response<List<CategoryDomain>> response) {
                if (response.isSuccessful()) {
                    List<CategoryDomain> categoryDomains = Objects.requireNonNull(response.body());
                    if (!categoryDomains.isEmpty()) {
                        originalCategoryDomains = new ArrayList<>(categoryDomains);
                        if ("all".equals(category)) {
                            adapter.setData(categoryDomains);
                        } else {
                            List<CategoryDomain> filteredList = filterByCategory(categoryDomains, category);
                            adapter.setData(filteredList);
                        }
                    } else {
                        Log.e("APIResponse", "Empty or null response body");
                        Toast.makeText(requireContext(), "Error: Empty response", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("APIResponse", "Error: " + response.code() + " - " + response.message());
                    Toast.makeText(requireContext(), "Error: " + response.code() + " - " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<CategoryDomain>> call, @NonNull Throwable t) {
                Log.e("APIResponse", "Network error: " + t.getMessage());
                Toast.makeText(requireContext(), "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void filterCategoryList(String query) {
        if (originalCategoryDomains != null) {
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
        return categoryDomains.stream()
                .filter(item -> category.equalsIgnoreCase(item.getCategory()))
                .collect(Collectors.toList());
    }
}