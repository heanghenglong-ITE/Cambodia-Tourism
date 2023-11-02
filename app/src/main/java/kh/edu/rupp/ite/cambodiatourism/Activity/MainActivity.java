package kh.edu.rupp.ite.cambodiatourism.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import kh.edu.rupp.ite.cambodiatourism.Adapter.ExploreAdapter;
import kh.edu.rupp.ite.cambodiatourism.Adapter.MoreAdapter;
import kh.edu.rupp.ite.cambodiatourism.Adapter.PopularAdapter;
import kh.edu.rupp.ite.cambodiatourism.Domain.ExploreDomain;
import kh.edu.rupp.ite.cambodiatourism.Domain.MoreDomain;
import kh.edu.rupp.ite.cambodiatourism.Domain.PopularDomain;
import kh.edu.rupp.ite.cambodiatourism.Fragment.CategoryFragment;
import kh.edu.rupp.ite.cambodiatourism.Fragment.ExploreFragment;
import kh.edu.rupp.ite.cambodiatourism.Fragment.HomeFragment;
import kh.edu.rupp.ite.cambodiatourism.Fragment.SettingFragment;
import kh.edu.rupp.ite.cambodiatourism.R;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private RecyclerView.Adapter adapterPopular,adapterMore;
    private  RecyclerView recyclerViewPopular, recyclerViewMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(this);

        if (savedInstanceState == null) {
            loadFragment(new HomeFragment());
        }


    }


    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selecteFragment;
        if (item.getItemId() == R.id.home_menu){
            selecteFragment = new HomeFragment();
        } else if (item.getItemId() == R.id.explore_menu) {
            selecteFragment = new ExploreFragment();
        } else if (item.getItemId() == R.id.category_menu) {
            selecteFragment = new CategoryFragment();
        } else if (item.getItemId() == R.id.setting_menu) {
            selecteFragment = new SettingFragment();
        }else {
            return false;
        }


        loadFragment(selecteFragment);
        return true;
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain("pic1","Angkorwat","Siemreab"));
        items.add(new PopularDomain("pic2","Waterfall","PaiLen"));
        items.add(new PopularDomain("pic3","Montain","Bokkuo"));


        recyclerViewPopular=findViewById(R.id.view_pop);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterPopular=new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);


        // More HomeFragment
        ArrayList<MoreDomain> moreList= new ArrayList<>();
        moreList.add(new MoreDomain("Montain","cat1"));
        moreList.add(new MoreDomain("WaterFall","cat2"));
        moreList.add(new MoreDomain("Beach","cat3"));
        moreList.add(new MoreDomain("SignSeeing","cat4"));
        moreList.add(new MoreDomain("Temple","cat5"));

        recyclerViewMore=findViewById(R.id.view_more);
        recyclerViewMore.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterMore=new MoreAdapter(moreList);
        recyclerViewMore.setAdapter(adapterMore);
    }
}