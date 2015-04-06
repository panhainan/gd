package com.gd.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;

public class SerializableUtils {
		public static String sessionToString(Session session){
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			try {
				ObjectOutputStream os = new ObjectOutputStream(bs);
				os.writeObject(session);
				return Base64.encodeToString(bs.toByteArray());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
		
		public static Session stringToSession(String sessionString){
			ByteArrayInputStream bs = new ByteArrayInputStream(Base64.decode(sessionString));
			ObjectInputStream os;
			try {
				os = new ObjectInputStream(bs);
				return (Session) os.readObject();
			}  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
}
