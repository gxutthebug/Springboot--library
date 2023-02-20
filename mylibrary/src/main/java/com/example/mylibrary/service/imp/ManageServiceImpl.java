package com.example.mylibrary.service.imp;

import com.example.mylibrary.Mapper.ManageMapper;
import com.example.mylibrary.domain.Manage;
import com.example.mylibrary.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private ManageMapper manageMapper;

    @Override
    public Manage SelectBymgename(String id) {
        return manageMapper.SelectBymgename(id);
    }
}
