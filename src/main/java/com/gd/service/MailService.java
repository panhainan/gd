package com.gd.service;

import com.gd.dto.MailType;

/** 
 * 使用Spring发送邮件 
 *  
 */  
public interface MailService {  
      
    void sendSingleMail(MailType mailType);  
  
} 