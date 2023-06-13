package com.example.chick.request;

import com.example.chick.entity.Store;
import com.example.chick.models.StoreDTO;

import java.util.ArrayList;

public class OrderRequest {
    private StoreDTO store;
    private ArrayList<Long> foodsetsId;

    public OrderRequest() {
    }

    public OrderRequest(StoreDTO store, ArrayList<Long> foodsetsId) {
        this.store = store;
        this.foodsetsId = foodsetsId;
    }

    public StoreDTO getStore() {
        return store;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }

    public ArrayList<Long> getFoodsetsId() {
        return foodsetsId;
    }

    public void setFoodsetsId(ArrayList<Long> foodsetsId) {
        this.foodsetsId = foodsetsId;
    }
}
