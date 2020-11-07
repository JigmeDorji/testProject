package com.test.srv.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jigme.dorji on 5/4/2020.
 */
@Service("commonService")
public class CommonService {

    @Autowired
    private CommonDao commonDao;


}
