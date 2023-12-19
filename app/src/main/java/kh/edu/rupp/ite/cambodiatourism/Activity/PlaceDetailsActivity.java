package kh.edu.rupp.ite.cambodiatourism.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import kh.edu.rupp.ite.cambodiatourism.R;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.DetailDomain;
import kh.edu.rupp.ite.cambodiatourism.model.api.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceDetailsActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://heanghenglong-ite.github.io/madapi/";

    private TextView placeName;
    private TextView placeDescription;
    private TextView placeDetail;
    private TextView location;
    private TextView season;
    private TextView showLocation;
    private ImageView placeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        Intent intent = getIntent();
        int placeId = intent.getIntExtra("placeId",-1);

        placeName = findViewById(R.id.title);
        placeDescription = findViewById(R.id.description);
        placeDetail = findViewById(R.id.place_detail);
        location = findViewById(R.id.location);
        season = findViewById(R.id.season);
        showLocation = findViewById(R.id.show_location);
        placeImage = findViewById(R.id.place_image);

        ImageView icLeft = findViewById(R.id.ic_left);
        icLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getPlaceDetails(placeId);

    }

    private void getPlaceDetails(int placeId) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<DetailDomain> call = apiService.getPlaceDetails(placeId);
        call.enqueue(new Callback<DetailDomain>() {
            @Override
            public void onResponse(Call<DetailDomain> call, Response<DetailDomain> response) {
                if (response.isSuccessful()){
                    DetailDomain detailDomain = response.body();
                    displayPlaceDetails(detailDomain);
                }else {
                    Toast.makeText(PlaceDetailsActivity.this, "Failed to get place detai!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DetailDomain> call, Throwable t) {
                Toast.makeText(PlaceDetailsActivity.this, "Failed to get place details!", Toast.LENGTH_SHORT).show();
                Log.e("PlaceDetailsActivity", "Get place details failed: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void displayPlaceDetails(DetailDomain detailDomain){
        Picasso.get().load(detailDomain.getImageUrl()).into(placeImage);
        placeName.setText(detailDomain.getTitle());
        placeDescription.setText(detailDomain.getPlaceDescription());
        placeDetail.setText(detailDomain.getPlaceDetail());
        location.setText(detailDomain.getLocation());
        season.setText(detailDomain.getSeason());
        showLocation.setText(detailDomain.getShowLocation());
    }
}