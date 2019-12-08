package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.xml.stream.events.StartDocument;

public class FamilyMovieMain{

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
	
	public static int questionBoard(String question, ArrayList<String> options) {
		
		Object[] strings = options.toArray();
		return JOptionPane.showOptionDialog(null, question, "It's a question to you", optionType, messageType[2], null, strings, null);
	}
	
	 
	public static int multiplicityQuestion(String question, ArrayList<String> options){
		ArrayList<Object> boxes = new ArrayList<>();
		for (int i = 0; i < options.size(); i++) {
			boxes.add(new JCheckBox(options.get(i)));
		}
		
		ArrayList<Integer> results = new ArrayList<>();
		JButton confirmButton = new JButton("Confirm");
		boxes.add(confirmButton);
		Object[] panel = boxes.toArray();
		JOptionPane pane = new JOptionPane();
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				for (int i=0; i<boxes.size()-1; i++) {
					if( 	((JCheckBox)boxes.get(i)).isSelected()) {
						//return i;
						results.add(i);			
					}
				}
				pane.getRootFrame().dispose();								 
			  }
		});
		
				
		pane.showOptionDialog(null, question, "It's a question to you", optionType, messageType[2], null, panel, null);
		int x= 0;
		for (int i = 0; i < results.size(); i++) {
			System.out.println(options.get(results.get(i)));
			return results.get(i);
		}
		
		return 0;
	}
    
	
	public static void respondBoard(String respond) {
		String ok[] = {"Ok"};
		JOptionPane.showOptionDialog(null, respond, "Respond", optionType, messageType[1], null, ok, ok[0]);
	}

		  

}