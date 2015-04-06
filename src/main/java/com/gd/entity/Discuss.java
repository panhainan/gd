package com.gd.entity;

import java.util.Date;
import java.util.List;

public class Discuss {
		private long disc_id;
		private Activity disc_acti;
		private User disc_user_send;
		private User disc_user_rece;
		private String disc_content;
		private Date disc_time;
		private boolean disc_rece_read;
		private List<Discuss> disc_area_disc;
		private Discuss disc_rped_disc;
		public Discuss() {
			super();
		}
		
		public Discuss getDisc_rped_disc() {
			return disc_rped_disc;
		}

		public void setDisc_rped_disc(Discuss disc_rped_disc) {
			this.disc_rped_disc = disc_rped_disc;
		}

		public long getDisc_id() {
			return disc_id;
		}
		public void setDisc_id(long disc_id) {
			this.disc_id = disc_id;
		}
		public Activity getDisc_acti() {
			return disc_acti;
		}
		public void setDisc_acti(Activity disc_acti) {
			this.disc_acti = disc_acti;
		}
		public User getDisc_user_send() {
			return disc_user_send;
		}
		public void setDisc_user_send(User disc_user_send) {
			this.disc_user_send = disc_user_send;
		}
		public User getDisc_user_rece() {
			return disc_user_rece;
		}
		public void setDisc_user_rece(User disc_user_rece) {
			this.disc_user_rece = disc_user_rece;
		}
		
		
		public List<Discuss> getDisc_area_disc() {
			return disc_area_disc;
		}
		public void setDisc_area_disc(List<Discuss> disc_area_disc) {
			this.disc_area_disc = disc_area_disc;
		}
		public String getDisc_content() {
			return disc_content;
		}
		public void setDisc_content(String disc_content) {
			this.disc_content = disc_content;
		}
		public Date getDisc_time() {
			return disc_time;
		}
		public void setDisc_time(Date disc_time) {
			this.disc_time = disc_time;
		}
		
		public boolean isDisc_rece_read() {
			return disc_rece_read;
		}
		public void setDisc_rece_read(boolean disc_rece_read) {
			this.disc_rece_read = disc_rece_read;
		}

		@Override
		public String toString() {
			return "Discuss [disc_id=" + disc_id + ", disc_acti=" + disc_acti
					+ ", disc_user_send=" + disc_user_send
					+ ", disc_user_rece=" + disc_user_rece + ", disc_content="
					+ disc_content + ", disc_time=" + disc_time
					+ ", disc_rece_read=" + disc_rece_read
					+ ", disc_area_disc=" + disc_area_disc
					+ ", disc_rped_disc=" + disc_rped_disc + "]";
		}
		
		
		
		
		
}
