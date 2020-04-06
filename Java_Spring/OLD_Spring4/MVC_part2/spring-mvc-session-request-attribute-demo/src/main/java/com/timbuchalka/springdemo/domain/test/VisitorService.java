package com.timbuchalka.springdemo.domain.test;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VisitorService {
	
	public VisitorCount updateCount(VisitorCount vc) {
		vc.setCount(vc.getCount() + 1);
		return vc;
	}
	
	public void registerVisitor(VisitorData sessionData, VisitorData incomingVisitor) {
		List<Visitor> visitors = sessionData.getVisitors();
		sessionData.setCurrentVisitorName(incomingVisitor.getCurrentVisitorName());
		sessionData.setCurrentVistorEmail(incomingVisitor.getCurrentVistorEmail());
		visitors.add(new Visitor(incomingVisitor.getCurrentVisitorName(), incomingVisitor.getCurrentVistorEmail()));
	}

}
