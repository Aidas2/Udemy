package com.timbuchalka.springdemo.domain.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VisitorData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5075218314653537512L;
	
		private String currentVisitorName;
		private String currentVistorEmail;
		private List<Visitor> visitors = new ArrayList<Visitor>();
		
		public VisitorData() {
			
		}
		
		public VisitorData(String currentVisitorName, String currentVistorEmail, List<Visitor> visitors) {
			super();
			this.currentVisitorName = currentVisitorName;
			this.currentVistorEmail = currentVistorEmail;
			this.visitors = visitors;
		}

		public String getCurrentVisitorName() {
			return currentVisitorName;
		}

		public void setCurrentVisitorName(String currentVisitorName) {
			this.currentVisitorName = currentVisitorName;
		}

		public String getCurrentVistorEmail() {
			return currentVistorEmail;
		}

		public void setCurrentVistorEmail(String currentVistorEmail) {
			this.currentVistorEmail = currentVistorEmail;
		}

		
		public List<Visitor> getVisitors() {
			return visitors;
		}

		public void setVisitors(List<Visitor> visitors) {
			this.visitors = visitors;
		}

		@Override
		public String toString() {
			return "VisitorData [currentVisitorName=" + currentVisitorName + ", currentVistorEmail="
					+ currentVistorEmail + ", visitors=" + visitors + "]";
		}
}
