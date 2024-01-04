package kh.edu.rupp.ite.cambodiatourism.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import kh.edu.rupp.ite.cambodiatourism.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Retrieve data from the intent
        int itemId = getIntent().getIntExtra("itemId", -1);
        String itemName = getIntent().getStringExtra("itemName");
        String itemLocation = getIntent().getStringExtra("itemLocation");
        String itemDescription = getIntent().getStringExtra("itemDescription");
        String detailUrl = getIntent().getStringExtra("detailUrl"); // Change to "detailUrl"

        // Set data to the views in the detail layout
        ImageView detailImageView = findViewById(R.id.detailImageView);
        TextView detailNameTextView = findViewById(R.id.detailNameTextView);
        TextView detailLocationTextView = findViewById(R.id.detailLocationTextView);
        TextView detailDescriptionTextView = findViewById(R.id.detailDescriptionTextView);

        // Load image using Picasso (add Picasso library to your dependencies)
        Picasso.get().load(getIntent().getStringExtra("imageUrl")).into(detailImageView);

        detailNameTextView.setText(itemName);
        detailLocationTextView.setText(itemLocation);
        detailDescriptionTextView.setText(itemDescription);

        // Open the website link in a browser when the detail view is created
        openWebsiteLink(detailUrl);
    }

    private void openWebsiteLink(String detailUrl) {
        if (detailUrl != null && !detailUrl.isEmpty()) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(detailUrl));
            startActivity(browserIntent);
        }
    }
}
