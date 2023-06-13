package com.example.chick.models;

import com.example.chick.entity.Order;
import com.example.chick.entity.OrderFoodset;
import com.example.chick.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {
    private Long id;
    private String name;
    private String address;
    private Double longitude;
    private Double latitude;
    private Long yaId;

    public static StoreDTO toDto(Store store) {
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(store.getId());
        storeDTO.setName(store.getName());
        storeDTO.setAddress(store.getAddress());
        storeDTO.setLongitude(store.getLongitude());
        storeDTO.setLatitude(store.getLatitude());
        storeDTO.setYaId(store.getYaId());
        return storeDTO;
    }

    public static Store fromDto(StoreDTO storeDTO) {
        Store store = new Store();
        store.setId(storeDTO.getId());
        store.setName(storeDTO.getName());
        store.setAddress(storeDTO.getAddress());
        store.setLongitude(storeDTO.getLongitude());
        store.setLatitude(storeDTO.getLatitude());
        store.setYaId(storeDTO.getYaId());
        return store;
    }
}
