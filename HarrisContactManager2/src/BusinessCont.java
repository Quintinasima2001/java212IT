import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BusinessCont extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tbFname;
	private JTextField tbLname;
	private JTextField tbEmail;
	private JTextField tbAddress1;
	private JTextField tbAddress2;
	private JTextField tbCity;
	private JTextField tbTelephone;
	private JTextField tbPostCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusinessCont frame = new BusinessCont();
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
	public BusinessCont() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 405, 211);
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
		table.setModel(DbUtils.resultSetToTableModel(d.GetALLBusiness()));
			
		tbFname = new JTextField();
		tbFname.setBounds(10, 23, 86, 20);
		contentPane.add(tbFname);
		tbFname.setColumns(10);
		
		tbLname = new JTextField();
		tbLname.setBounds(113, 23, 86, 20);
		contentPane.add(tbLname);
		tbLname.setColumns(10);
		
		tbEmail = new JTextField();
		tbEmail.setBounds(225, 23, 86, 20);
		contentPane.add(tbEmail);
		tbEmail.setColumns(10);
		
		tbAddress1 = new JTextField();
		tbAddress1.setBounds(10, 59, 86, 20);
		contentPane.add(tbAddress1);
		tbAddress1.setColumns(10);
		
		tbAddress2 = new JTextField();
		tbAddress2.setBounds(113, 59, 86, 20);
		contentPane.add(tbAddress2);
		tbAddress2.setColumns(10);
		
		tbCity = new JTextField();
		tbCity.setBounds(225, 59, 86, 20);
		contentPane.add(tbCity);
		tbCity.setColumns(10);
		
		tbTelephone = new JTextField();
		tbTelephone.setBounds(321, 23, 86, 20);
		contentPane.add(tbTelephone);
		tbTelephone.setColumns(10);
		
		tbPostCode = new JTextField();
		tbPostCode.setBounds(321, 59, 86, 20);
		contentPane.add(tbPostCode);
		tbPostCode.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(10, 11, 62, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(106, 11, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(226, 11, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telephone");
		lblNewLabel_3.setBounds(321, 11, 73, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address 1");
		lblNewLabel_4.setBounds(10, 46, 73, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address 2");
		lblNewLabel_5.setBounds(113, 46, 61, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setBounds(225, 46, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PostCode");
		lblNewLabel_7.setBounds(321, 46, 46, 14);
		contentPane.add(lblNewLabel_7);		
		
		JButton btnAddnew = new JButton("Add New");
		btnAddnew.setBounds(425, 22, 103, 23);
		contentPane.add(btnAddnew);
		
		JButton btnDeleteselected = new JButton("Delete selected");		
		btnDeleteselected.setBounds(425, 223, 103, 23);
		contentPane.add(btnDeleteselected);
		
		JButton btnSavenew = new JButton("Save new ");		
		btnSavenew.setEnabled(false);
		btnSavenew.setBounds(425, 58, 103, 23);
		contentPane.add(btnSavenew);
		
		JButton btnSaveselected = new JButton("Save selected ");		
		btnSaveselected.setBounds(425, 140, 103, 23);
		contentPane.add(btnSaveselected);
		
		JButton btnRefresh = new JButton("Refresh");		
		btnRefresh.setBounds(425, 198, 103, 23);
		contentPane.add(btnRefresh);
		
		JButton btnUpdate = new JButton("Update");				
		btnUpdate.setBounds(425, 110, 103, 23);
		contentPane.add(btnUpdate);
		
		JButton btnMainMenu = new JButton("Main Menu");	
		btnMainMenu.setBounds(425, 268, 103, 23);
		contentPane.add(btnMainMenu);
		
		btnAddnew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSavenew.setEnabled(true);
				btnSaveselected.setEnabled(false);
				btnDeleteselected.setEnabled(false);
				btnRefresh.setEnabled(false);
				btnAddnew.setEnabled(false);
				btnUpdate.setEnabled(false);			
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
				d.AddBusiness(Fname, Lname, Email, Tel, Address1, Address2, City, PostCode);					
				table.setModel(DbUtils.resultSetToTableModel(d.GetALLBusiness()));
				btnSaveselected.setEnabled(false);
				btnDeleteselected.setEnabled(true);
				btnSavenew.setEnabled(false);
				btnRefresh.setEnabled(true);
				btnAddnew.setEnabled(true);
				btnUpdate.setEnabled(true);	
			}
		});
		
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSaveselected.setEnabled(true);
				btnDeleteselected.setEnabled(false);
				btnSavenew.setEnabled(false);
				btnRefresh.setEnabled(false);
				btnAddnew.setEnabled(false);
				btnUpdate.setEnabled(false);	
			}
		});
		
		btnSaveselected.setEnabled(false);
					
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
				d.updateBusiness(Fname, Lname, Email, Tel, Address1, Address2, City, PostCode, id);
				table.setModel(DbUtils.resultSetToTableModel(d.GetALLBusiness()));
				btnSaveselected.setEnabled(false);
				btnDeleteselected.setEnabled(true);
				btnSavenew.setEnabled(false);
				btnRefresh.setEnabled(true);
				btnAddnew.setEnabled(true);
				btnUpdate.setEnabled(true);
			}
		});
		
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(DbUtils.resultSetToTableModel(d.GetALLBusiness()));
			}
		});	
		
		btnDeleteselected.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
				d.DeleteBusiness(id);
				table.setModel(DbUtils.resultSetToTableModel(d.GetALLBusiness()));
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
		
		btnMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}
}
