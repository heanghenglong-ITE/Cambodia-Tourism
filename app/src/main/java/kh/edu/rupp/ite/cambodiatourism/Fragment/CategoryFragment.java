package kh.edu.rupp.ite.cambodiatourism.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kh.edu.rupp.ite.cambodiatourism.Activity.Beaches;
import kh.edu.rupp.ite.cambodiatourism.Activity.Camps;
import kh.edu.rupp.ite.cambodiatourism.Activity.Desert;
import kh.edu.rupp.ite.cambodiatourism.Activity.Forest;
import kh.edu.rupp.ite.cambodiatourism.Activity.Mountain;
import kh.edu.rupp.ite.cambodiatourism.Adapter.CategoryAdapter;
import kh.edu.rupp.ite.cambodiatourism.Data.CategoryData;
import kh.edu.rupp.ite.cambodiatourism.R;
import kh.edu.rupp.ite.cambodiatourism.databinding.FragmentCategoryBinding;

public class CategoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<CategoryData> dataList;
    private CategoryAdapter adapter;
    private SearchView searchView;
    private FragmentCategoryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        recyclerView = view.findViewById(R.id.recyclerView);
        searchView = view.findViewById(R.id.search);

        searchView.clearFocus();
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
        dataList = generateItemList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new CategoryAdapter(requireContext(), dataList);
        recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    private List<CategoryData> generateItemList() {
        List<CategoryData> dataList = new ArrayList<>();
        dataList.add(new CategoryData("Beaches", R.drawable.cat1, Beaches.class));
        dataList.add(new CategoryData("Camps", R.drawable.cat2, Camps.class));
        dataList.add(new CategoryData("Forest", R.drawable.cat3, Forest.class));
        dataList.add(new CategoryData("Desert", R.drawable.cat4, Desert.class));
        dataList.add(new CategoryData("Mountain", R.drawable.cat5, Mountain.class));
        return dataList;
    }

    private void searchList(String text) {
        List<CategoryData> dataSearchList = new ArrayList<>();
        for (CategoryData data : dataList) {
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()) {
            Toast.makeText(requireContext(), "No matching results found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setSearchList(dataSearchList);
        }
    }
}
