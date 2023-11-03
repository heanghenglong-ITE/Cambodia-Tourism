package kh.edu.rupp.ite.cambodiatourism.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kh.edu.rupp.ite.cambodiatourism.Activity.Food;
import kh.edu.rupp.ite.cambodiatourism.Activity.Forest;
import kh.edu.rupp.ite.cambodiatourism.Activity.Hospital;
import kh.edu.rupp.ite.cambodiatourism.Activity.Hotel;
import kh.edu.rupp.ite.cambodiatourism.Activity.Sea;
import kh.edu.rupp.ite.cambodiatourism.Activity.Temple;
import kh.edu.rupp.ite.cambodiatourism.Activity.Wat;
import kh.edu.rupp.ite.cambodiatourism.Activity.Waterfall;
import kh.edu.rupp.ite.cambodiatourism.databinding.FragmentCategoryBinding;

public class CategoryFragment extends Fragment {

    private Button attracktionsButton;

    private FragmentCategoryBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);

        binding.attractionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Temple.class);
                startActivity(intent);
            }
        });

        binding.attractionsButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Wat.class);
                startActivity(intent);
            }
        });

        binding.attractionsButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Waterfall.class);
                startActivity(intent);
            }
        });

        binding.attractionsButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Sea.class);
                startActivity(intent);
            }
        });

        binding.attractionsButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Forest.class);
                startActivity(intent);
            }
        });

        binding.attractionsButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Hospital.class);
                startActivity(intent);
            }
        });

        binding.attractionsButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Food.class);
                startActivity(intent);
            }
        });

        binding.attractionsButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Hotel.class);
                startActivity(intent);
            }
        });



        return binding.getRoot();
    }
}