package net.jikuodong.spring.controller.base;
import net.jikuodong.spring.utils.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 对外公共基层控制器
 *
 * @author Lsy
 *
 */
public class BaseController {
	/** 日志 */
	protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	/** 通信请求 */
	protected HttpServletRequest request;

	/** 通信回复 */
	protected HttpServletResponse response;

	/** 控制器名称 */
	protected String controllerName;

	/**
	 * 得到PageData
	 */
	public PageData getPageData() {
		return new PageData(this.getRequest());
	}

	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	/**
	 * describe 日志
	 *
	 * @method logBefore
	 * @author JKD
	 * @param logger
	 * @param interfaceName
	 * @data 2019/6/6 9:47
	 * @throws
	 */
	public static void logBefore(Logger logger, String interfaceName) {
		logger.info("");
		logger.info("start");
		logger.info(interfaceName);
	}
}
