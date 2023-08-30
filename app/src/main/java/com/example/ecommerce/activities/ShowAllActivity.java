package com.example.ecommerce.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.ecommerce.R;
import com.example.ecommerce.adapters.ShowAllAdapter;
import com.example.ecommerce.models.ShowAllModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShowAllActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ShowAllAdapter showAllAdapter;
    List<ShowAllModel> showAllModelList;

    Toolbar toolbar;

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        toolbar = findViewById(R.id.show_all_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String type = getIntent().getStringExtra("type");
        firestore = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.show_all_rec);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        showAllModelList = new ArrayList<>();
        showAllAdapter = new ShowAllAdapter(this, showAllModelList);
        recyclerView.setAdapter(showAllAdapter);

        if (type == null || type.isEmpty()){
            firestore.collection("ShowAll").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (DocumentSnapshot doc : task.getResult().getDocuments()) {
                            ShowAllModel showAllModel = doc.toObject(ShowAllModel.class);
                            showAllModelList.add(showAllModel);
                        }
                        showAllAdapter.notifyDataSetChanged();
                    }
                }
            });
        }

        if (type != null && type.equalsIgnoreCase("art")){
            firestore.collection("ShowAll").whereEqualTo("type", "art").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (DocumentSnapshot doc : task.getResult().getDocuments()) {
                            ShowAllModel showAllModel = doc.toObject(ShowAllModel.class);
                            showAllModelList.add(showAllModel);
                        }
                        showAllAdapter.notifyDataSetChanged();
                    }
                }
            });
        }

        if (type != null && type.equalsIgnoreCase("computer")){
            firestore.collection("ShowAll").whereEqualTo("type", "computer").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (DocumentSnapshot doc : task.getResult().getDocuments()) {
                            ShowAllModel showAllModel = doc.toObject(ShowAllModel.class);
                            showAllModelList.add(showAllModel);
                        }
                        showAllAdapter.notifyDataSetChanged();
                    }
                }
            });
        }

        if (type != null && type.equalsIgnoreCase("business")){
            firestore.collection("ShowAll").whereEqualTo("type", "business").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (DocumentSnapshot doc : task.getResult().getDocuments()) {
                            ShowAllModel showAllModel = doc.toObject(ShowAllModel.class);
                            showAllModelList.add(showAllModel);
                        }
                        showAllAdapter.notifyDataSetChanged();
                    }
                }
            });
        }

        if (type != null && type.equalsIgnoreCase("literature")){
            firestore.collection("ShowAll").whereEqualTo("type", "literature").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (DocumentSnapshot doc : task.getResult().getDocuments()) {
                            ShowAllModel showAllModel = doc.toObject(ShowAllModel.class);
                            showAllModelList.add(showAllModel);
                        }
                        showAllAdapter.notifyDataSetChanged();
                    }
                }
            });
        }

        if (type != null && type.equalsIgnoreCase("psy")){
            firestore.collection("ShowAll").whereEqualTo("type", "psy").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (DocumentSnapshot doc : task.getResult().getDocuments()) {
                            ShowAllModel showAllModel = doc.toObject(ShowAllModel.class);
                            showAllModelList.add(showAllModel);
                        }
                        showAllAdapter.notifyDataSetChanged();
                    }
                }
            });
        }

        if (type != null && type.equalsIgnoreCase("science")){
            firestore.collection("ShowAll").whereEqualTo("type", "science").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (DocumentSnapshot doc : task.getResult().getDocuments()) {
                            ShowAllModel showAllModel = doc.toObject(ShowAllModel.class);
                            showAllModelList.add(showAllModel);
                            showAllAdapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }
    }
}
