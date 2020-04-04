package com.timbuchalka.springdemo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ExecutionTimerInterceptor implements HandlerInterceptor {

	private static Logger LOGGER = LoggerFactory.getLogger(ExecutionTimerInterceptor.class);
	long PREHANDLE_TIME = 0;
	long POSTHANDLE_TIME = 0;
	long AFTER_COMPLETION_TIME = 0;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		AFTER_COMPLETION_TIME = System.currentTimeMillis();
		LOGGER.info("Info Message: AFTER_COMPLETION_TIME = "+ AFTER_COMPLETION_TIME);
		long HANDLER_EXECUTION_TIME = POSTHANDLE_TIME - PREHANDLE_TIME;
		long TOTAL_EXECUTION_TIME = AFTER_COMPLETION_TIME - PREHANDLE_TIME;
		LOGGER.info("Info Message: HANDLER_EXECUTION_TIME = " + HANDLER_EXECUTION_TIME);
		LOGGER.info("Info Message: TOTAL_EXECUTION_TIME = " + TOTAL_EXECUTION_TIME);

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		POSTHANDLE_TIME = System.currentTimeMillis();
		LOGGER.info("Info Message: POSTHANDLE_TIME = "+ POSTHANDLE_TIME);

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		PREHANDLE_TIME = System.currentTimeMillis();
		LOGGER.info("Info Message: PREHANDLE_TIME = "+ PREHANDLE_TIME);
		return true;
	}

}
