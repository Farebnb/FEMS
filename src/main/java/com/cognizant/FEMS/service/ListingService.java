package com.cognizant.FEMS.service;

import com.cognizant.FEMS.model.Listing;
import com.cognizant.FEMS.util.ListingFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ListingService implements IListingService{

    @Autowired
    ListingFeignClient lfc;

    @Autowired
    public ListingService(ListingFeignClient lfc){
        this.lfc = lfc;
    }

    @Override
    public Listing getById(int id) {
        return lfc.getById(id);
    }

    @Override
    public List<Listing> getAll(){
        return lfc.getAll();
    }

    @Override
    public Listing update(Listing listing) {
        return lfc.update(listing);
    }

    @Override
    public Listing deleteListing(int id) {
        return lfc.deleteListing(id);
    }

    @Override
    public List<Listing> getByLocationId(int locationId){
        return lfc.getByLocationId(locationId);
    }

    @Override
    public Listing createListing(LinkedHashMap<String, String> body) {
        return lfc.createListing(body);
    }
}
