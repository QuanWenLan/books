package com.dragon.book.service.my;
/**
 * 我的模块：修改信息service层
 *zzm
 */

import com.dragon.book.mapper.my.ModifyInformationDao;
import com.dragon.book.service.my.I.IModifyInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyInformationServiceImpl implements IModifyInformationService {

    @Autowired
    private ModifyInformationDao modifyInformationDao;

    /**
     * 修改信息Servicec层方法
     * @param xm
     * @param lxfs
     * @param dz
     * @param bm
     * @param grsm
     * @param userid
     */
    public void modifyInformation(String xm,String lxfs,String dz,String bm,String grsm,int userid){
        modifyInformationDao.upDataInformation(xm,lxfs,dz,bm,grsm,userid);
    }
}