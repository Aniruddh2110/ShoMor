package com.example.shomore.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shomore.Adapters.PopularAdapter;
import com.example.shomore.Domains.PopularDomain;
import com.example.shomore.R;
import com.example.shomore.beachActivity;
import com.example.shomore.beachplaceActivity;
import com.example.shomore.heriplaceActivity;
import com.example.shomore.profileActivity;
import com.example.shomore.reliplaplaceActivity;
import com.example.shomore.settingActivity;
import com.example.shomore.waterplaceActivity;
import com.example.shomore.wildplaceActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;
    LinearLayout settingbtn;
    SearchView searchView;
    ListView listView;
    ArrayList arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initRecyclerView();

        searchView=findViewById(R.id.placesearch);
        listView=findViewById(R.id.listsearch);

        arrayList=new ArrayList();

        arrayList.add("Miramar Beach");
        arrayList.add("Baga Beach");
        arrayList.add("Candolim Beach");
        arrayList.add("Vagator Beach");
        arrayList.add("Butterfly Beach");
        arrayList.add("Palolem Beach");
        arrayList.add("Majorda Beach");
        arrayList.add("Betalbatim Beach");
        arrayList.add("Keri Beach");
        arrayList.add("Chapora Beach");


        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity2.this, beachActivity.class);
                startActivity(intent);
                finish();
            }
        });

        settingbtn=findViewById(R.id.settingbtn);
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this, settingActivity.class);
                startActivity(intent);
                finish();
            }
        });

        LinearLayout profilebtn = findViewById(R.id.profilebtn);
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the desired activity
                openprofileActivity();
            }

            private void openprofileActivity() {

                    Intent intent = new Intent(MainActivity2.this, profileActivity.class);
                    startActivity(intent);

            }
        });

        ConstraintLayout beachesbtn = findViewById(R.id.beachesbtn);
        beachesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the desired activity
                openbeachActivity();
            }

            private void openbeachActivity() {

                Intent intent = new Intent(MainActivity2.this, beachplaceActivity.class);
                startActivity(intent);
            }
        });

        ConstraintLayout  waterfallbtn = findViewById(R.id.waterfallbtn);
        waterfallbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the desired activity
                openwaterActivity();
            }

            private void openwaterActivity() {

                Intent intent = new Intent(MainActivity2.this, waterplaceActivity.class);
                startActivity(intent);
            }
        });

        ConstraintLayout  wildlifebtn = findViewById(R.id.wildlifebtn);
        wildlifebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the desired activity
                openwildlifeActivity();
            }

            private void openwildlifeActivity() {

                Intent intent = new Intent(MainActivity2.this, wildplaceActivity.class);
                startActivity(intent);
            }
        });

        ConstraintLayout  heritagebtn = findViewById(R.id.heritagebtn);
        heritagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the desired activity
                openheritageActivity();
            }

            private void openheritageActivity() {

                Intent intent = new Intent(MainActivity2.this, heriplaceActivity.class);
                startActivity(intent);
            }
        });

        ConstraintLayout  religiousbtn = findViewById(R.id.religiousbtn);
        religiousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the desired activity
                openreligiousActivity();
            }

            private void openreligiousActivity() {

                Intent intent = new Intent(MainActivity2.this, reliplaplaceActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain(  "Palolem Beach", "Canacona",  "Located in the charming town of Canacona, Goa, " +
                "Palolem Beach is a picturesque destination known for its crescent-shaped shoreline, " +
                "swaying palm trees, and pristine white sands. " +
                "The beach is approximately 70 km from Panaji, the capital of Goa, " +
                "and is easily accessible by road.",  2,  true, 4.8,  "beach",  true, 1000));
        items.add(new PopularDomain(  "Dudhsagar Waterfall", "Sonaulim",  "Dudhsagar Waterfall is situated inside the Bhagwan" +
                " Mahavir wildlife sanctuary in Sanguem district of Goa close to the border with Karnataka. " +
                "It is about 60 km from state capital Panaji. " +
                "Water plummets from a height of over 1,000 ft " +
                "to form one of the most amazing natural phenomena in Goa.", 1,false,  5,  "waterfall",  false,  2500));
        items.add(new PopularDomain(  "Bondla Wildlife Sanctuary",  "Usagao-Ganjem",  "Although it is the smallest of all the wildlife sanctuaries in Goa, " +
                "Bondla Wildlife Sanctuary is also the most popular with children, families and eco-tourists. " +
                "Its convenient location in the Ponda Taluka combined with its manageable size of just 8 sq. km; " +
                "make it an ideal destination for a day trip.", 3, true,  4.3, "wildlife",  true, 3000));
        items.add(new PopularDomain(  "Aguada Fort",  "Panjim",  "Fort Aguada is a well-preserved seventeenth-century Portuguese fort," +
                " along with a lighthouse, standing in Goa, India, " +
                "on Sinquerim Beach, overlooking the Arabian Sea." +
                " It is an ASI protected Monument of National Importance in Goa. " +
                "Fort Aguada's ramparts overlook Sinquerim Beach and the Arabian Sea.", 2, false,  4.0, "heritage",  false, 3500));
        items.add(new PopularDomain(  "Basilica of Bom Jesus",  "Panjim",  "The Basilica of Bom Jesus is a monument typical of the classic forms of plane architecture, " +
                "introduced by the Society of Jesus, otherwise known as the Jesuits. " +
                "The façade, which is of granite, represents features of five styles of architecture: " +
                "Roman, Ionic, Doric, Corinthian and Composite.", 1, true,  4.7, "religious",  true, 4000));

        recyclerViewPopular=findViewById(R.id.view_pop);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterPopular=new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);

    }
}
