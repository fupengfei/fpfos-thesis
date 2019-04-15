package com.fupengfei.thesis.service;

import com.fupengfei.thesis.bean.enums.RedisKey;
import com.fupengfei.thesis.entity.StaffSecrecy;
import com.fupengfei.thesis.exception.ApiException;
import com.fupengfei.thesis.exception.ApiExceptionCode;
import com.fupengfei.thesis.repository.jpa.StaffSecrecyJpaRepository;
import com.fupengfei.thesis.service.core.AbstractService;
import com.fupengfei.thesis.utils.BeanUtils;
import com.fupengfei.thesis.utils.Md5Util;
import org.springframework.stereotype.Service;

/**
 * @author Fu Pengfei
 * @Date 2019-04-11
 * @Description TODO
 */

@Service
public class StaffSecrecyService extends AbstractService<StaffSecrecy, StaffSecrecyJpaRepository> {
    public StaffSecrecyService() {
        super(StaffSecrecy.class);
    }

    public String login(String email, String passwd) {

        StaffSecrecy staffSecrecy = jpaResponse.findByEmail(email);
        if (null == staffSecrecy) {
            throw new ApiException(ApiExceptionCode.BAD_ACCOUNT);
        }

        if (!vaildPasswd(passwd, staffSecrecy.getPasswordSalt(), staffSecrecy.getPasswordHash())) {
            throw new ApiException(ApiExceptionCode.BAD_PASSWORD);
        }


        String staffPrimaryCode = staffSecrecy.getStaff().getPrimaryCode();
        String tokenSalt = Md5Util.generateSalt();
        String tokenHash = Md5Util.generateMd5Hex(tokenSalt, staffPrimaryCode);
        String token = tokenHash + staffPrimaryCode;
        redisUtils.set(RedisKey.TOKEN, tokenSalt, staffPrimaryCode);
        return token;
    }

    private boolean vaildPasswd(String passwd, String passwdSalt, String passwdHash) {

        return Md5Util.verifyMd5Hex(passwdSalt, passwd, passwdHash);
    }

    public String modifyPasswd(String oldPasswd, String newPasswd) {

//        String newUserToken = UUID.randomUUID().toString().replace("-", "");
//        String newUserTokenSalt = Md5Util.generateSalt();
//        String newUserTokenHash = Md5Util.generateMd5Hex(newUserTokenSalt, newUserToken);
        return "";
    }

    public static void main(String[] args) {
        String newUserToken = BeanUtils.uuid().substring(0,16);
        String newUserTokenSalt = Md5Util.generateSalt();
        String newUserTokenHash = Md5Util.generateMd5Hex(newUserTokenSalt, newUserToken);

        System.out.println(newUserToken);
        System.out.println(newUserTokenSalt);
        System.out.println(newUserTokenHash);
    }
}
