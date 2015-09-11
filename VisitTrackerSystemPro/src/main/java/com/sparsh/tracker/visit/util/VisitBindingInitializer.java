//package com.sparsh.tracker.visit.util;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.beans.propertyeditors.StringTrimmerEditor;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.support.WebBindingInitializer;
//import org.springframework.web.context.request.WebRequest;
//
//import com.sparsh.tracker.visit.controller.VisitController;
//
///**
// * Shared WebBindingInitializer for PetClinic's custom editors.
// *
// * <p>Alternatively, such init-binder code may be put into
// * {@link org.springframework.web.bind.annotation.InitBinder}
// * annotated methods on the controller classes themselves.
// *
// * @author Prashant Swamy
// */
//public class VisitBindingInitializer implements WebBindingInitializer {
//
//	@Autowired
//	public VisitController controller;
//	
//	@Override
//	public void initBinder(WebDataBinder binder, WebRequest request) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//		dateFormat.setLenient(false);
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
//	}
//
//}
