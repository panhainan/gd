package com.gd.entity;
/**
 * 
 * @author hrz
 * @date 2015-3-21
 */
public class Permission {
	private long id;
	private String permission;
	private String description;
	private boolean available;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", permission=" + permission
				+ ", description=" + description + ", available=" + available
				+ "]";
	}
	
}
