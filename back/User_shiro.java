package com.gd.entity;


public class User_shiro {
		private int id;
		private String name;
		private String password;
		private String salt;
		private Boolean locked = Boolean.FALSE;
		public User_shiro() {
			super();
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		 public String getSalt() {
		        return salt;
		    }

		    public void setSalt(String salt) {
		        this.salt = salt;
		    }

		    public String getCredentialsSalt() {
		        return name + salt;
		    }

		    public Boolean getLocked() {
		        return locked;
		    }

		    public void setLocked(Boolean locked) {
		        this.locked = locked;
		    }

		  

		    @Override
		    public String toString() {
		        return "User{" +
		                "id=" + id +
		                ", username='" +name + '\'' +
		                ", password='" + password + '\'' +
		                ", salt='" + salt + '\'' +
		                ", locked=" + locked +
		                '}';
		    }
		
		
}
