package com.cognizant.FEMS.util;

import com.cognizant.FEMS.model.Listing;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.List;


@FeignClient(value = "ListingFeign", url = "http://localhost:8080/listing")
public interface ListingFeignClient {

        @RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
        Listing getById(@RequestParam int id);

        @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
        List<Listing> getAll();

        @RequestMapping(method = RequestMethod.PUT, value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
        Listing update(@RequestBody Listing listing);

        @RequestMapping(method = RequestMethod.DELETE, value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
        Listing deleteListing(@RequestParam int id);

        @RequestMapping(method = RequestMethod.GET, value = "/locationId", produces = MediaType.APPLICATION_JSON_VALUE)
        List<Listing> getByLocationId(@RequestParam int locationId);

        @RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
        Listing createListing(@RequestBody LinkedHashMap<String,String> body);

}
