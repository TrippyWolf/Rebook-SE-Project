package com.example.rebook.launch;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebook.R;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    public static final int SELECT_ADDRESS=0;
    private RecyclerView deliveryRecyclerView;
    private Button changeOraddNewAddressBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");


        changeOraddNewAddressBtn= findViewById(R.id.change_or_add_address_btn);
        deliveryRecyclerView=  findViewById(R.id.delivery_recyclerview);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList= new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.python_programming,"Python Programming",2,"Rs. 300/-","Rs. 500",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.learn_language,"Integrated chinese",0,"Rs. 300/-","Rs. 500",1,1,2));
        cartItemModelList.add(new CartItemModel(0,R.drawable.dmbs,"Database-DBMS",2,"Rs. 300/-","Rs. 500",1,0,0));
        cartItemModelList.add(new CartItemModel(1,"Price (3 items )"," Rs. 1500","Free","Rs. 900","Rs.600"));

        CartAdapter cartAdapter= new CartAdapter(cartItemModelList);
        deliveryRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        changeOraddNewAddressBtn.setVisibility(View.VISIBLE);

        changeOraddNewAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAddressesIntent = new Intent(DeliveryActivity.this,MyAddressesActivity.class);
                myAddressesIntent.putExtra("MODE",SELECT_ADDRESS);
                startActivity(myAddressesIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
