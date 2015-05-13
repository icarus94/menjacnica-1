package menjacnica.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
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
	
	public static void sacuvajUFajl() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(menjacnica.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				menjacnica.sistem.sacuvajUFajl(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(menjacnica.getContentPane(), e1.getMessage(),
					"Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void ucitajIzFajla() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(menjacnica.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				menjacnica.sistem.ucitajIzFajla(file.getAbsolutePath());
				prikaziSveValute();
			}	
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(menjacnica.getContentPane(), e1.getMessage(),
					"Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void prikaziSveValute() {
		menjacnica.getList().setListData(menjacnica.sistem.vratiKursnuListu().toArray());

	}
	
	public static void prikaziDodajKursGUI() {
		DodajKursGUI prozor = new DodajKursGUI(menjacnica);
		prozor.setLocationRelativeTo(menjacnica.getContentPane());
		prozor.setVisible(true);
	}

	public static void prikaziObrisiKursGUI() {
		if (menjacnica.getList().getSelectedValue() != null) {
			ObrisiKursGUI prozor = new ObrisiKursGUI(menjacnica,
					(Valuta) (menjacnica.getList().getSelectedValue()));
			prozor.setLocationRelativeTo(menjacnica.getContentPane());
			prozor.setVisible(true);
		}
	}
	

}
