package com.timbuchalka.springdemo.domain.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(names={"visitordata","visitorcount"})
@RequestMapping("/visitorRegister")
public class SessionRequestAttributeDemoController {
	
	@Autowired
	public VisitorService visitorService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(SessionRequestAttributeDemoController.class);
	
	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("test/sessionRequestAttributeViews/sessionRequestAttributeHome", "visitorstats", new VisitorData());
	}

	@ModelAttribute("visitordata")
	public VisitorData addVisitorData() {
		List<Visitor> visitors = new ArrayList<Visitor>();
		VisitorData vData = new VisitorData(null, null, visitors);
		return vData;
	}
	
	@ModelAttribute("visitorcount")
	public VisitorCount countVisitors() {
		return new VisitorCount(0);
	}

	@RequestMapping(value="/visitor", method=RequestMethod.POST)
//	@RequestMapping(value="/visitor")	// still treated as POST
//	@RequestMapping(value="/visitor", method=RequestMethod.GET) // causes error "Request method POST not supported"
	public String getVisitors(@ModelAttribute("visitor") VisitorData currentVisitor,
								HttpSession session,
								SessionStatus sessionStatus,
								HttpServletRequest request,
								@SessionAttribute(name="sessionStartTime") LocalDateTime startTime,
								@RequestAttribute(name="currentTime") LocalDateTime clockTime,
								Model model) {
		
		VisitorData visitorDataFromSession = (VisitorData) session.getAttribute("visitordata");
		visitorService.registerVisitor(visitorDataFromSession, currentVisitor);
		VisitorCount visitorCount = (VisitorCount) session.getAttribute("visitorcount");
		visitorService.updateCount(visitorCount);
		
		Long currentSessionDuration = visitorService.computeDuration(startTime);
		
		if(visitorCount.getCount() == 5) {
			sessionStatus.setComplete();
//			session.invalidate();
		}
		
//		model.addAttribute("timeHeading", visitorService.describeCurrentTime(clockTime));
//		model.addAttribute("durationHeading", visitorService.describeCurrentDuration(currentSessionDuration));

		Map<String, Object> modelMap = model.asMap();
		modelMap.put("timeHeading", visitorService.describeCurrentTime(clockTime));
		modelMap.put("durationHeading", visitorService.describeCurrentDuration(currentSessionDuration));
		
		
		// debug code
//		LOGGER.info(visitorDataFromSession.toString());
//		if(request.getMethod().equalsIgnoreCase("POST")) {
//			LOGGER.info("This is a POST request");
//		} else {
//			LOGGER.info("This is a GET request");
//		}
		
		return "test/sessionRequestAttributeViews/sessionRequestAttributeResult";
	}

}











