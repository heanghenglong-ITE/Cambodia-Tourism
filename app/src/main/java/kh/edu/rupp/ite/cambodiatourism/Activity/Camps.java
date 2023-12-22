package kh.edu.rupp.ite.cambodiatourism.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.List;

import kh.edu.rupp.ite.cambodiatourism.Adapter.CampsAdapter;
import kh.edu.rupp.ite.cambodiatourism.Data.CampsData;
import kh.edu.rupp.ite.cambodiatourism.R;

import kh.edu.rupp.ite.cambodiatourism.model.api.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import androidx.recyclerview.widget.LinearLayoutManager;
public class Camps extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CampsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camps);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CampsAdapter();
        recyclerView.setAdapter(adapter);

        // Call Retrofit to perform the API requests
        loadPopularList();
        loadMoreList();
        // Add more calls as needed
    }

    private void loadPopularList() {
        ApiService apiService = createApiService();
        Call<List<CampsData>> call = apiService.getCamps(); // Assuming this endpoint returns a list of camps

        call.enqueue(new Callback<List<CampsData>>() {
            @Override
            public void onResponse(Call<List<CampsData>> call, Response<List<CampsData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setData(response.body());
                } else {
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<List<CampsData>> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void loadMoreList() {
        // Implement a similar structure for the "more" endpoint
    }

    private ApiService createApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://tochhit.github.io/host_api/chhit/") // Replace with your base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }
}


