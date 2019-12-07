package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import javax.swing.JOptionPane;

public class FamilyMovieMain {

	public static final void main(String[] args) {
        try {
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
	
	private static int optionType = JOptionPane.DEFAULT_OPTION;
	private static int messageType[] = {JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, 
										JOptionPane.QUESTION_MESSAGE, JOptionPane.WARNING_MESSAGE, JOptionPane.ERROR_MESSAGE};
	
	public static int questionBoard(String question, String[] answers) {
		return JOptionPane.showOptionDialog(null, question, "It's a question to you", optionType, messageType[2], null, answers, null);
	}
	
	/*public static void multiplicityQuestion(String question, String[] answers){
		
	}*/
    
	public static void respondBoard(String respond) {
		String ok[] = {"Ok"};
		JOptionPane.showOptionDialog(null, respond, "Respond", optionType, messageType[1], null, ok, ok[0]);
	}
	  

}