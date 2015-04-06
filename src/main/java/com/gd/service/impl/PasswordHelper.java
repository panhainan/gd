package com.gd.service.impl;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.gd.entity.User;
import com.gd.entity.VerifiedTeam;

/**
 * 
 * @author hrz
 * @date 2015-3-21
 */
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algorithmName = "md5";
    private final int hashIterations = 2;

    public void encryptPassword(User user) {

        user.setUser_salt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getUser_password(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();

        user.setUser_password(newPassword);
    }
    
    public void encryptPasswordForTeam(VerifiedTeam team){
    	team.setVari_salt(randomNumberGenerator.nextBytes().toHex());
    	String newPassword = new SimpleHash(
                algorithmName,
                team.getVari_password(),
                ByteSource.Util.bytes(team.getCredentialsSalt()),
                hashIterations).toHex();
    	team.setVari_password(newPassword);
    }
    
    public String checkPassword(String credentialsSalt,String password){
    	String newPassword = new SimpleHash(
                algorithmName,
                password,
                ByteSource.Util.bytes(credentialsSalt),
                hashIterations).toHex();
    			return newPassword;
    }
}