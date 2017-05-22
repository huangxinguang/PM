package com.ectrip.service;

import com.ectrip.model.ModleDemand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/22 下午2:50.
 */
public interface ModleDemandService {

    List<ModleDemand> findModleDemandList(@Param("demandId")Integer demandId);
}
