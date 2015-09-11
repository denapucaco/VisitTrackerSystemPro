//package com.sparsh.tracker.visit.authorization;
//
//import java.io.IOException;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import com.sparsh.tracker.visit.domain.Login;
//import com.sparsh.tracker.visit.service.LoginService;
//
///**
// * 
// * @author Prashant Swamy
// * @created on 15/12/2012
// */
//public class RoleBasedAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//	private Map<String, String> roleUrlMap;
//
//	@Autowired
//	private LoginService loginService;
//	
//	public void onAuthenticationSuccess(HttpServletRequest request,
//										HttpServletResponse response,
//										Authentication authentication) throws IOException, ServletException {
//
//		if (authentication.getPrincipal() instanceof UserDetails) {
//			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//			String role = userDetails.getAuthorities().isEmpty() ? null : userDetails.getAuthorities().toArray()[0].toString();
//
//			Login login = loginService.findByUserName(userDetails.getUsername());
//			// Set the Login into Session
//			request.getSession().setAttribute("login", login);
//			
//			response.sendRedirect(request.getContextPath() + roleUrlMap.get(role));
//			/*Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
//	        if (roles.contains("ROLE_USER")) {
//	            response.sendRedirect("/userpage");
//	        }*/
//		}
//	}
//
//	public void setRoleUrlMap(Map<String, String> roleUrlMap) {
//		this.roleUrlMap = roleUrlMap;
//	}
//}