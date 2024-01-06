package kh.edu.rupp.ite.cambodiatourism.Fragment;

import android.content.Intent;
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
import java.util.stream.Collectors;

import kh.edu.rupp.ite.cambodiatourism.Activity.DetailActivity;
import kh.edu.rupp.ite.cambodiatourism.Adapter.CategoryAdapter;
import kh.edu.rupp.ite.cambodiatourism.Adapter.MoreAdapter;
import kh.edu.rupp.ite.cambodiatourism.Adapter.PopularAdapter;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.CategoryDomain;
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
    private RecyclerView.Adapter adapterMore;
    private RecyclerView recyclerViewMore;
    private RecyclerView recyclerView;
    private PopularAdapter adapter;
    private List<CategoryDomain> originalCategoryDomains;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter = new PopularAdapter(getActivity(), new ArrayList<>());
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(categoryDomain -> {
            // Open the detail view when an item is clicked
            openDetailView(categoryDomain);
        });


        makeApiRequest("all");


        intiRecyclerView(rootView);

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

        Call<List<CategoryDomain>> call = apiService.getTourism();

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

    private List<CategoryDomain> filterByCategory(List<CategoryDomain> categoryDomains, String category) {
        // Filter the list based on the selected category
        // You can implement your own logic here
        // For simplicity, this example filters by matching the category name
        return categoryDomains.stream()
                .filter(item -> category.equalsIgnoreCase(item.getCategory()))
                .collect(Collectors.toList());
    }


    private void intiRecyclerView(View view){
        ArrayList<MoreDomain> moreList = new ArrayList<>();
        moreList.add(new MoreDomain("Beach","cat1"));
        moreList.add(new MoreDomain("Camps","cat2"));
        moreList.add(new MoreDomain("Forest","cat3"));
        moreList.add(new MoreDomain("Desert","cat4"));
        moreList.add(new MoreDomain("Mountain","cat5"));

        recyclerViewMore = view.findViewById(R.id.recyclerView_more);
        recyclerViewMore.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        adapterMore = new MoreAdapter(moreList);
        recyclerViewMore.setAdapter(adapterMore);
    }
}