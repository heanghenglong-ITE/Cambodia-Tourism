package kh.edu.rupp.ite.cambodiatourism.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

import kh.edu.rupp.ite.cambodiatourism.Fragment.CategoryFragment;
import kh.edu.rupp.ite.cambodiatourism.R;
import kh.edu.rupp.ite.cambodiatourism.databinding.FragmentCategoryBinding;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import androidx.annotation.Nullable;

public class DetailActivity extends AppCompatActivity {

    private TextView detailDescriptionTextView;
    private Button moreButton;
    private boolean isTextExpanded = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailDescriptionTextView = findViewById(R.id.detailDescriptionTextView);
        moreButton = findViewById(R.id.moreButton);

        // Set the initial text and make the "More" button visible
        String initialText = "Your initial text here";
        detailDescriptionTextView.setText(initialText);
        moreButton.setVisibility(View.VISIBLE);

        // Set an onClickListener for the "More" button
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toggle the visibility of the extended text
                if (isTextExpanded) {
                    // Collapse the TextView to show limited lines
                    detailDescriptionTextView.setMaxLines(3);
                    moreButton.setText("more...");
                } else {
                    // Expand the TextView to show the full text
                    detailDescriptionTextView.setMaxLines(Integer.MAX_VALUE);
                    moreButton.setText("less...");
                }
                isTextExpanded = !isTextExpanded;
            }
        });

        Button BackBotton = findViewById(R.id.BackButton);

        BackBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Retrieve data from the intent
        int itemId = getIntent().getIntExtra("itemId", -1);
        String itemName = getIntent().getStringExtra("itemName");
        String itemLocation = getIntent().getStringExtra("itemLocation");
        String itemDescription = getIntent().getStringExtra("itemDescription");
        String detailUrl = getIntent().getStringExtra("detailUrl");
        String itemMap = getIntent().getStringExtra("itemMap");
        String itemarea = getIntent().getStringExtra("itemarea");
        String itemseason = getIntent().getStringExtra("itemseason");
        String itemroad = getIntent().getStringExtra("itemroad");
        String itemfacity = getIntent().getStringExtra("itemfacity");
        String itemfabuilding = getIntent().getStringExtra("itemfabuilding");
        String itemlink = getIntent().getStringExtra("itemlink");


        // Change to "detailUrl"

        // Set data to the views in the detail layout
        ImageView detailImageView = findViewById(R.id.detailImageView);
        TextView detailNameTextView = findViewById(R.id.detailNameTextView);
        TextView detailLocationTextView = findViewById(R.id.detailLocationTextView);
        TextView detailDescriptionTextView = findViewById(R.id.detailDescriptionTextView);
        TextView detailTextViewmap = findViewById(R.id.TextViewmap);
        TextView detailTextViewarea = findViewById(R.id.TextViewarea);
        TextView detailTextViewseason = findViewById(R.id.TextViewseason);
        TextView detailTextroad = findViewById(R.id.TextViewroad);
        TextView detailTextfacity = findViewById(R.id.TextViewfacity);
        TextView detailTextViewfabuilding = findViewById(R.id.TextViewfabuilding);
        TextView detailTextViewlink = findViewById(R.id.TextViewLink);

        // Load image using Picasso (add Picasso library to your dependencies)
        Picasso.get().load(getIntent().getStringExtra("imageUrl")).into(detailImageView);

        detailNameTextView.setText(itemName);
        detailLocationTextView.setText(itemLocation);
        detailDescriptionTextView.setText(itemDescription);
        detailTextViewmap.setText(itemMap);
        detailTextViewarea.setText(itemarea);
        detailTextViewseason.setText(itemseason);
        detailTextroad.setText(itemroad);
        detailTextfacity.setText(itemfacity);
        detailTextViewfabuilding.setText(itemfabuilding);
        detailTextViewlink.setText(itemlink);




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
