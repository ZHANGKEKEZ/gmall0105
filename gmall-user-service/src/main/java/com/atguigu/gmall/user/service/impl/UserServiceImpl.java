package com.atguigu.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<UmsMember> getAllUser() {

        return userMapper.selectAll();
    }

    @Override
    public void saveUser(UmsMember umsMember) {
        userMapper.insert(umsMember);
    }

    /**
     * 保存用户用户
     * @return
     */
    /**
     * 删除用户
     * @param memberId
     */
    @Override
    public void deleteUserByMemberId(String memberId) {
        UmsMember u=new UmsMember();
        u.setId(memberId);
        userMapper.delete(u);

    }

    @Override
    public void updateUserByMemberId(UmsMember umsMember) {
        userMapper.updateByPrimaryKey(umsMember);
    }



    /**
     * 根据用户id查询用户地址
     * @param memberId
     * @return
     */
    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddresses;
    }
}
