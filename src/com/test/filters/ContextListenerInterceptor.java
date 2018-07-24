package com.test.filters;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class ContextListenerInterceptor implements HandlerInterceptor
{
	static Logger _oLogger = Logger.getLogger(ContextListenerInterceptor.class.getName());
	@Autowired ServletContext servletContext;
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
	{
        return true;
    }
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception 
    {
       
//    	System.out.println("Host -Post "+Params.getMyFlowHost());
//        System.out.println("Port -Post "+Params.getMyFlowPort());
    }
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
//        System.out.println("After completion handle");
    }
	public void initContext(ServletContext context)
	{/*

		File fopPath = null;
		FopFactory fopFactory = null;
		FOUserAgent foUserAgent = null;
		TransformerFactory factory = null;
		try
		{
			_oLogger.debug("Came to set inital parameter in Context...");
			fopPath = new File(context.getRealPath(context.getInitParameter("FOPConfig")));			

			fopFactory = FopFactory.newInstance();
			DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();			
			FileInputStream dis = new FileInputStream(fopPath); 
			Configuration cfg = cfgBuilder.build(dis);

			fopFactory.setUserConfig(cfg);			
			foUserAgent = fopFactory.newFOUserAgent();
			factory = TransformerFactory.newInstance();

			context.setAttribute("EQC_CONTEXT", "Y");
			context.setAttribute("FACTORY", factory);
			context.setAttribute("FOPFACTORY", fopFactory);
			context.setAttribute("FOUSERAGENT", foUserAgent);

			Params.setMyFlowHost(context.getInitParameter("MyFlowHost"));
			Params.setMyFlowPort(context.getInitParameter("MyFlowPort"));
			Params.setMyFlowUser(context.getInitParameter("MyFlowUser"));
			Params.setMyFlowPwd(context.getInitParameter("MyFlowPwd"));
			Params.setStartSeq(Integer.parseInt(context.getInitParameter("StartSeq")));
			Params.setEndSeq(Integer.parseInt(context.getInitParameter("EndSeq")));
			Params.setXServiceHost(context.getInitParameter("X_SERVICE_HOST"));
			Params.setXServicePort(context.getInitParameter("X_SERVICE_PORT"));

			_oLogger.debug("Setting inital parameter in Context end...");
		}
		catch(SAXException sax)
		{
			_oLogger.error("SAXException Occured while Setting inital parameter in Context : "+sax.getMessage());
			sax.printStackTrace();
		}
		catch(IOException iox)
		{
			_oLogger.error("IOException Occured while Setting inital parameter in Context : "+iox.getMessage());
			iox.printStackTrace();
		}
		catch(Exception ex)
		{
			_oLogger.error("Exception Occured while Setting inital parameter in Context : "+ex.getMessage());
			ex.printStackTrace();
		}
	*/}

}
