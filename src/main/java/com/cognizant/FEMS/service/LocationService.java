package com.cognizant.FEMS.service;

import com.cognizant.FEMS.model.Location;
import com.cognizant.FEMS.util.ListingFeignClient;
import com.cognizant.FEMS.util.LocationFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class LocationService implements ILocationService {

    @Autowired
    LocationFeignClient kfc;

    @Autowired
    public LocationService(LocationFeignClient kfc){
        this.kfc = kfc;
    }

    @Override
    public Location getById(int id) {
        return kfc.getById(id);
    }

    @Override
    public List<Location> getAll() {
        return kfc.getAll();
    }

    @Override
    public Location update(Location location) {
        return kfc.update(location);
    }

    @Override
    public Location deleteLocation(int id) {
        return kfc.deleteLocation(id);
    }

    @Override
    public Location createListing(LinkedHashMap<String, String> body) {
        return kfc.createListing(body);
    }
}
