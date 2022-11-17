package com.cognizant.FEMS.util;

import com.cognizant.FEMS.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.List;

@FeignClient(value="UserFeign", url="http://localhost:8081/user")
public interface UserFeignClient {
    @RequestMapping(method = RequestMethod.POST, value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    User register(@RequestBody LinkedHashMap<String, String> body);

    @RequestMapping(method = RequestMethod.GET, value = "/username", produces = MediaType.APPLICATION_JSON_VALUE)
    User getByUsername(@RequestParam String username);

    @RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    User getById(@RequestParam int id);

    @RequestMapping(method = RequestMethod.GET, value = "/listingId", produces = MediaType.APPLICATION_JSON_VALUE)
    User getByListingId(@RequestParam int listingId);

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> getAll();

    @RequestMapping(method = RequestMethod.PUT, value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    User update(@RequestBody User u);

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    User delete(@RequestParam int id);
}
