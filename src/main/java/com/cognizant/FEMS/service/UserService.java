package com.cognizant.FEMS.service;

import com.cognizant.FEMS.model.User;
import com.cognizant.FEMS.util.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserFeignClient ufc;

    @Autowired
    public UserService(UserFeignClient ufc) {
        this.ufc = ufc;
    }

    @Override
    public User register(LinkedHashMap<String, String> body) {
        return ufc.register(body);
    }

    @Override
    public User getByUsername(String username) {
        return ufc.getByUsername(username);
    }

    @Override
    public User getById(int id) {
        return ufc.getById(id);
    }

    @Override
    public User getByListingId(int listingId) {
        return ufc.getByListingId(listingId);
    }

    @Override
    public List<User> getAll() {
        return ufc.getAll();
    }

    @Override
    public User update(User u) {
        return ufc.update(u);
    }

    @Override
    public User delete(int id) {
        return ufc.delete(id);
    }
}
