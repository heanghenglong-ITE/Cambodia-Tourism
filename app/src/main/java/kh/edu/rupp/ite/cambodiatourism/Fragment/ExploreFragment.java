package kh.edu.rupp.ite.cambodiatourism.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kh.edu.rupp.ite.cambodiatourism.Adapter.ExploreAdapter;
import kh.edu.rupp.ite.cambodiatourism.Domain.ExploreDomain;
import kh.edu.rupp.ite.cambodiatourism.R;
import kh.edu.rupp.ite.cambodiatourism.databinding.FragmentExploreBinding;

public class ExploreFragment extends Fragment {

    private FragmentExploreBinding binding;

    private RecyclerView.Adapter adapterExplore;
    private RecyclerView recyclerViewExplore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExploreBinding.inflate(inflater, container, false);

        View view = binding.getRoot();

        initRecyclerView(view);

        return view;
    }

    private void initRecyclerView(View view) {
        ArrayList<ExploreDomain> items = new ArrayList<>();
        items.add(new ExploreDomain("","",""));
        items.add(new ExploreDomain("","",""));
        items.add(new ExploreDomain("","",""));

        recyclerViewExplore = view.findViewById(R.id.view_explore);
        recyclerViewExplore.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false));
        adapterExplore = new ExploreAdapter(items);
        recyclerViewExplore.setAdapter(adapterExplore);

    }
}