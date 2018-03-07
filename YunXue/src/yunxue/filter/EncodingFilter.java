package yunxue.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodingFilter
 * 
 * //设置编码过滤器
 * 
 */
@WebFilter(
		filterName="/EncodingFilter",
		urlPatterns={"/*"},
		initParams={
				@WebInitParam(name="Encoding",value="UTF-8")},
		dispatcherTypes={
				DispatcherType.FORWARD,
				DispatcherType.INCLUDE,
				DispatcherType.REQUEST,
				DispatcherType.ERROR,
				DispatcherType.ASYNC
		})

public class EncodingFilter implements Filter {
	
	private String Encoding;

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		if("GET".equals(req.getMethod())){
			req=new EncodingWrapper(req,Encoding);
		}
		else{
			req.setCharacterEncoding(Encoding);
		}
		chain.doFilter(req, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		Encoding=fConfig.getInitParameter("Encoding");
	}

}
