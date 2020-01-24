package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;

import java.util.List;

public interface AttrService {

    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
   // List<PmsBaseAttrInfo> findAttrInfoById(String id);
    void deleteAttrInfoById(String id);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);
   // void saveAttrValue(PmsBaseAttrValue pmsBaseAttrValue);
   //List<PmsBaseAttrValue> findAttrValueById(String id);
   // void deleteAttrValueById(String id);
    void deleteAttrValueByAttrId(String attrId);
}
