package menjacnica.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import menjacnica.Valuta;

public class GUIKontroler {
	
	private static MenjacnicaGUI menjacnica;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static  void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(menjacnica.getContentPane(),
				"Da li ZAISTA zelite da izadjete iz apliacije", "Izlazak",
				JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	public static void prikaziIzvrsiZamenuGUI() {
		if (menjacnica.getList().getSelectedValue() != null) {
			IzvrsiZamenuGUI prozor = new IzvrsiZamenuGUI(menjacnica,
					(Valuta) (menjacnica.getList().getSelectedValue()));
			prozor.setLocationRelativeTo(menjacnica.getContentPane());
			prozor.setVisible(true);
		}
	}

}
