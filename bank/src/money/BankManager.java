package money;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class BankManager extends JFrame{
	private JTextField textField;
	public BankManager() {
		getContentPane().setLayout(null);
		
		// ����
		JLabel insert_label = new JLabel("ȸ�� ���� ����");
		insert_label.setBounds(145, 10, 97, 15);
		getContentPane().add(insert_label);
		JLabel insert_id = new JLabel("���̵�");
		insert_id.setBounds(54, 44, 57, 15);
		getContentPane().add(insert_id);
		JTextField idTextField = new JTextField(10);
		idTextField.setBounds(193, 41, 116, 21);
		getContentPane().add(idTextField);
		JLabel insert_name = new JLabel("�̸�");
		insert_name.setBounds(54, 85, 57, 15);
		getContentPane().add(insert_name);
		JTextField nameTextField = new JTextField(10);
		nameTextField.setBounds(193, 82, 116, 21);
		getContentPane().add(nameTextField);
		JLabel insert_age = new JLabel("����");
		insert_age.setBounds(54, 129, 57, 15);
		getContentPane().add(insert_age);
		JTextField ageTextField = new JTextField(10);
		ageTextField.setBounds(193, 126, 116, 21);
		getContentPane().add(ageTextField);
		JLabel insert_tel = new JLabel("��ȭ��ȣ");
		insert_tel.setBounds(54, 172, 57, 15);
		getContentPane().add(insert_tel);
		JTextField telTextField = new JTextField(10);
		telTextField.setBounds(193, 169, 116, 21);
		getContentPane().add(telTextField);
		JButton insert_btn = new JButton("����");
		
		insert_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BankDTO dto = new BankDTO();
				BankDAO dao = new BankDAO();
				
				String id = idTextField.getText();
				String name = nameTextField.getText();
				String age = ageTextField.getText();
				String tel = telTextField.getText();

				dto.setId(id);
				dto.setName(name);
				dto.setAge(age);
				dto.setTel(tel);

				dao.insert(dto);
				
				JOptionPane.showMessageDialog(null, "���� �Ϸ�");
			}
		});
		insert_btn.setBounds(151, 209, 97, 23);
		getContentPane().add(insert_btn);
		
		// ����
		JLabel update_id = new JLabel("���̵�");
		update_id.setBounds(54, 288, 57, 15);
		getContentPane().add(update_id);
		JLabel update_label = new JLabel("ȸ�� ���� ����");
		update_label.setBounds(145, 260, 85, 15);
		getContentPane().add(update_label);
		JLabel update_tel = new JLabel("��ȭ��ȣ");
		update_tel.setBounds(54, 332, 57, 15);
		getContentPane().add(update_tel);
		JTextField textField_4 = new JTextField(10);
		textField_4.setBounds(193, 285, 116, 21);
		getContentPane().add(textField_4);
		JTextField textField_5 = new JTextField(10);
		textField_5.setBounds(193, 329, 116, 21);
		getContentPane().add(textField_5);
		JButton update_btn = new JButton("����");
		update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BankDTO dto = new BankDTO();
				BankDAO dao = new BankDAO();
				
				String id = textField_4.getText();
				String tel = textField_5.getText();
				
				dto.setId(id);
				dto.setTel(tel);
				
				dao.update(dto);
				
				JOptionPane.showMessageDialog(null, "���� �Ϸ�");
			}
		});
		update_btn.setBounds(151, 372, 97, 23);
		getContentPane().add(update_btn);
		
		// ����
		JLabel delete_label = new JLabel("ȸ�� ���� ����");
		delete_label.setBounds(412, 10, 85, 15);
		getContentPane().add(delete_label);
		JLabel delete_id = new JLabel("���̵�");
		delete_id.setBounds(334, 44, 57, 15);
		getContentPane().add(delete_id);
		JButton delete_btn = new JButton("����");
		delete_btn.setBounds(412, 81, 97, 23);
		getContentPane().add(delete_btn);
		JTextField textField_6 = new JTextField(10);
		textField_6.setBounds(463, 41, 116, 21);
		getContentPane().add(textField_6);
		
		delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BankDTO dto = new BankDTO();
				BankDAO dao = new BankDAO();
				
				String id = textField_6.getText();
				
				dto.setId(id);
				dao.delete(dto);
				
				JOptionPane.showMessageDialog(null, "���� �Ϸ�");
			}
		});
		
		// ��ü �˻�
		JLabel selectAll_label = new JLabel("ȸ�� ���� ��ü �˻�");
		selectAll_label.setBounds(401, 260, 125, 15);
		getContentPane().add(selectAll_label);
		JButton selectAll_btn = new JButton("��ü �˻�");
		selectAll_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankDAO dao = new BankDAO();
				ArrayList list = dao.selectAll();
				
			    System.out.println("        id   name   age     tel");
				for (int i = 0; i < list.size(); i++) {
					BankDTO dto = (BankDTO)list.get(i);
					System.out.print((i+1)+"��° >> ");
					System.out.print(dto.getId()+"  ");
					System.out.print("   "+dto.getName()+" ");
					System.out.print("   "+dto.getAge()+" ");
					System.out.print("   "+dto.getTel()+" ");
					System.out.println();
				}
			}
		});
		selectAll_btn.setBounds(412, 324, 97, 23);
		getContentPane().add(selectAll_btn);
		
		// �˻�
		JLabel select_label = new JLabel("ȸ�� ���� �˻�");
		select_label.setBounds(412, 129, 85, 15);
		getContentPane().add(select_label);
		JLabel select_id = new JLabel("���̵�");
		select_id.setBounds(334, 169, 57, 15);
		getContentPane().add(select_id);
		textField = new JTextField(10);
		textField.setBounds(463, 169, 116, 21);
		getContentPane().add(textField);
		JButton select_btn = new JButton("�˻�");
		select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  String inputId = textField.getText();
			  
			  BankDAO dao = new BankDAO();
			  BankDTO dto = dao.select(inputId);
			  
			  String id = dto.getId();
			  String name = dto.getName();
			  String age = dto.getAge();
			  String tel = dto.getTel();
			  
			  idTextField.setText(id);
			  nameTextField.setText(name);
			  ageTextField.setText(age);
			  telTextField.setText(tel);
			}
		});
		select_btn.setBounds(412, 209, 97, 23);
		getContentPane().add(select_btn);
		setSize(639, 443);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		BankManager bankManager = new BankManager();
	}
}
