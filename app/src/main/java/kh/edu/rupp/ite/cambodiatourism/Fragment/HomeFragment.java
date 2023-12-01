package kh.edu.rupp.ite.cambodiatourism.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kh.edu.rupp.ite.cambodiatourism.Adapter.MoreAdapter;
import kh.edu.rupp.ite.cambodiatourism.Adapter.PopularAdapter;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.MoreDomain;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.PopularDomain;
import kh.edu.rupp.ite.cambodiatourism.R;
import kh.edu.rupp.ite.cambodiatourism.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private ArrayList<PopularDomain> items;
    private RecyclerView.Adapter adapterPopular,adapterMore;
    private RecyclerView recyclerViewPopular, recyclerViewMore;

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View view = binding.getRoot();

        initRecyclerView(view);

        return view;

    }

    private void initRecyclerView(View view){
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("pic1","Kos kong","kos Kong king"));
        items.add(new PopularDomain("pic2","muldulkiri","Muldulkiri king"));
        items.add(new PopularDomain("pic3","Siem reab","siem rean king"));

        recyclerViewPopular = view.findViewById(R.id.view_pop);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false));
        adapterPopular = new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);


        ArrayList<MoreDomain> moreList = new ArrayList<>();
        moreList.add(new MoreDomain("Beaches","cat1"));
        moreList.add(new MoreDomain("Camps","cat2"));
        moreList.add(new MoreDomain("Forest","cat3"));
        moreList.add(new MoreDomain("Desert","cat4"));
        moreList.add(new MoreDomain("Mountain","cat5"));

        recyclerViewMore = view.findViewById(R.id.view_more);
        recyclerViewMore.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false));
        adapterMore = new MoreAdapter(moreList);
        recyclerViewMore.setAdapter(adapterMore);

    }
}