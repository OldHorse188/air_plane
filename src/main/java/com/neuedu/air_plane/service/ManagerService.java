package com.neuedu.air_plane.service;

import com.neuedu.air_plane.dao.ManagerDao;
import com.neuedu.air_plane.model.Manager;
import org.springframework.stereotype.Service;

@Service // 将service注入到ioc容器当中
public class ManagerService extends BaseService<ManagerDao,Manager> {


}
