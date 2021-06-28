package com.projeto.ui.caixaeletronico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.projeto.ui.caixaeletronico.utils.MessageUtil;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
public class Main {
    private JFrame frame;
    private Conta conta = null;
    private CaixaEletronico objCaixaEletronico = null;
    private JTextField txtSenha;
    private JButton btnEntrar = null;

    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main() {
		this.objCaixaEletronico = new CaixaEletronico();
		conta = new Conta();
		this.btnEntrar = new JButton();

		
		initialize();
		tela();
	}

	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JLabel lblsenha = new JLabel("COLOQUE A SENHA DO CARTÃO");
		lblsenha.setBounds(125, 68, 199, 14);
		frame.getContentPane().add(lblsenha);
		
		JLabel lblDemostracao = new JLabel("Demostração. Senha: 123");
		lblDemostracao.setBackground(Color.red);
		lblDemostracao.setBounds(137, 233, 168, 14);
		frame.getContentPane().add(lblDemostracao);
		
	
	}
	
	private void tela() {
		txtSenha = new JTextField();
		txtSenha.setBounds(165, 117, 96, 20);
		frame.getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		frame.setTitle("Banco");
		
		this.btnEntrar.setText("Entrar");
		
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				String senha = txtSenha.getText();

				if (senha.equalsIgnoreCase("123") && !senha.isEmpty()) {
					JOptionPane.showMessageDialog(null, MessageUtil.MESSAGE_SENHA_SUCESSO);
					Main window = new Main();
					window.frame.setVisible(false);
					frame.dispose();
					
					
					objCaixaEletronico.frame.setVisible(true);
					objCaixaEletronico.frame.setLocationRelativeTo(null);
					objCaixaEletronico.frame.setResizable(false);					
				} else {
					JOptionPane.showMessageDialog(null, MessageUtil.MESSAGE_ERRO_SENHA);
					txtSenha.setText("");
				}		
			}
		
		});
			
		btnEntrar.setBounds(165, 164, 96, 23);
		frame.getContentPane().add(btnEntrar);
		frame.getRootPane().setDefaultButton(btnEntrar);
	}
    
    
}
