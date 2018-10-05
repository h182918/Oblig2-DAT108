package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;

public class Inputvalidering {
	
	public Inputvalidering() {
		
	}
	
	//validerer og escaper input
	public static String valider(HttpServletRequest request) {
		String input = request.getParameter("vare");
		if(input == null || input.equals("")) {
			return "feil";
		}else {
			input = StringEscapeUtils.escapeHtml(request.getParameter("vare"));
			input = StringEscapeUtils.escapeJavaScript(input);
			return input;
		}
		
	}

}
