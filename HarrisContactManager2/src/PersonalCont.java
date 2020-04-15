import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PersonalCont extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tbFname;
	private JTextField tbLname;
	private JTextField tbEmail;
	private JTextField tbTelephone;
	private JTextField tbAddress1;
	private JTextField tbAddress2;
	private JTextField tbCity;
	private JTextField tbPostCode;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalCont frame = new PersonalCont();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonalCont() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 419, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tbFname.setText(table.getValueAt(table.getSelectedRow(),1).toString());
				tbLname.setText(table.getValueAt(table.getSelectedRow(),2).toString());
				tbEmail.setText(table.getValueAt(table.getSelectedRow(),3).toString());
				tbTelephone.setText(table.getValueAt(table.getSelectedRow(),4).toString());
				tbAddress1.setText(table.getValueAt(table.getSelectedRow(),5).toString());
				tbAddress2.setText(table.getValueAt(table.getSelectedRow(),6).toString());
				tbPostCode.setText(table.getValueAt(table.getSelectedRow(),7).toString());
				tbCity.setText(table.getValueAt(table.getSelectedRow(),8).toString());
			
			}
		});
		scrollPane.setViewportView(table);
		Dbconn d = new Dbconn(); 
		table.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
		
		tbFname = new JTextField();
		tbFname.setBounds(10, 22, 86, 20);
		contentPane.add(tbFname);
		tbFname.setColumns(10);
		
		tbLname = new JTextField();
		tbLname.setBounds(120, 22, 86, 20);
		contentPane.add(tbLname);
		tbLname.setColumns(10);
		
		tbEmail = new JTextField();
		tbEmail.setBounds(225, 22, 86, 20);
		contentPane.add(tbEmail);
		tbEmail.setColumns(10);
		
		tbTelephone = new JTextField();
		tbTelephone.setBounds(329, 22, 86, 20);
		contentPane.add(tbTelephone);
		tbTelephone.setColumns(10);
		
		tbAddress1 = new JTextField();
		tbAddress1.setBounds(10, 67, 86, 20);
		contentPane.add(tbAddress1);
		tbAddress1.setColumns(10);
		
		tbAddress2 = new JTextField();
		tbAddress2.setBounds(120, 67, 86, 20);
		contentPane.add(tbAddress2);
		tbAddress2.setColumns(10);
		
		tbCity = new JTextField();
		tbCity.setBounds(225, 67, 86, 20);
		contentPane.add(tbCity);
		tbCity.setColumns(10);
		
		tbPostCode = new JTextField();
		tbPostCode.setBounds(329, 67, 86, 20);
		contentPane.add(tbPostCode);
		tbPostCode.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(10, 11, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(120, 11, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(225, 11, 73, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telephone");
		lblNewLabel_3.setBounds(329, 11, 73, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address 1");
		lblNewLabel_4.setBounds(10, 54, 73, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address 2");
		lblNewLabel_5.setBounds(120, 54, 73, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setBounds(225, 54, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PostCode");
		lblNewLabel_7.setBounds(329, 54, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnSavenew = new JButton("Save New");
		btnSavenew.setEnabled(false);
		JButton btnSaveselected = new JButton ("Save Selected");
		JButton btnDeleteselected = new JButton("Delete selected");		
		JButton btnRefresh = new JButton("Refresh ");		
		JButton btnAddNew = new JButton("Add New");
		JButton btUpdate = new JButton("Update");
		JButton btnMaineMenu = new JButton("Main Menu");
		
		btnAddNew.setBounds(450, 21, 106, 23);
		contentPane.add(btnAddNew);
		
		btnSavenew.setBounds(450, 45, 106, 23);
		contentPane.add(btnSavenew);
								
		btnDeleteselected.setBounds(449, 185, 107, 23);
		contentPane.add(btnDeleteselected);
				
		btnRefresh.setBounds(450, 211, 106, 23);
		contentPane.add(btnRefresh);
		
		btnSaveselected.setBounds(450, 125, 106, 23);
		contentPane.add(btnSaveselected);
		
		btUpdate.setBounds(450, 102, 106, 23);
		contentPane.add(btUpdate);

		btnAddNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSavenew.setEnabled(true);
				btnSaveselected.setEnabled(false);
				btnDeleteselected.setEnabled(false);
				btnRefresh.setEnabled(false);
				btnAddNew.setEnabled(false);
				btUpdate.setEnabled(false);				
			}
		});
		
		btnSavenew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
								
					String Fname =tbFname.getText();
					String Lname =tbLname.getText();
					String Email =tbEmail.getText();
					String Tel =tbTelephone.getText();
					String Address1 =tbAddress1.getText();
					String Address2 =tbAddress2.getText();
					String City =tbCity.getText();
					String PostCode =tbPostCode.getText();
					d.AddPersonal(Fname, Lname, Email, Tel, Address1, Address2, City, PostCode);					
					table.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
					btnSaveselected.setEnabled(false);
					btnDeleteselected.setEnabled(true);
					btnSavenew.setEnabled(false);
					btnRefresh.setEnabled(true);
					btnAddNew.setEnabled(true);
					btUpdate.setEnabled(true);	
			
			}
		});
				
		btUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSaveselected.setEnabled(true);
				btnDeleteselected.setEnabled(false);
				btnSavenew.setEnabled(false);
				btnRefresh.setEnabled(false);
				btnAddNew.setEnabled(false);
				btUpdate.setEnabled(false);				
			}
		});
		
		btnSaveselected.setEnabled(false);
		
				
		btnMaineMenu.setBounds(450, 263, 106, 23);
		contentPane.add(btnMaineMenu);
		btnSaveselected.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				String Fname =tbFname.getText();
				String Lname =tbLname.getText();
				String Email =tbEmail.getText();
				String Tel =tbTelephone.getText();
				String Address1 =tbAddress1.getText();
				String Address2 =tbAddress2.getText();
				String City =tbCity.getText();
				String PostCode =tbPostCode.getText();
				String id =table.getValueAt(table.getSelectedRow(), 0). toString();
				d.UpdatePersonal(Fname, Lname, Email, Tel, Address1, Address2, City, PostCode, id);
				table.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
				btnSaveselected.setEnabled(false);
				btnDeleteselected.setEnabled(true);
				btnSavenew.setEnabled(false);
				btnRefresh.setEnabled(true);
				btnAddNew.setEnabled(true);
				btUpdate.setEnabled(true);						
			}
		});
	
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
			}
		});
			
		btnDeleteselected.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				d.DeletePersonal(id);
				table.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
				tbFname.setText("");
				tbLname.setText("");
				tbEmail.setText("");
				tbAddress1.setText("");
				tbAddress2.setText("");
				tbCity.setText("");
				tbPostCode.setText("");
				tbTelephone.setText("");
			}
		});
		
		btnMaineMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}
}
