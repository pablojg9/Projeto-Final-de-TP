package com.projeto.ui.caixaeletronico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import com.projeto.ui.caixaeletronico.utils.MessageUtil;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

public class CaixaEletronico extends JFrame{

	JFrame frame;
	private Conta objConta = null;
	private JTextField txtSaida;
	private float valorDeposito;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaixaEletronico window = new CaixaEletronico();
					window.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public CaixaEletronico() {
		initialize();
		this.objConta = new Conta();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		frame.setTitle("Banco");
		
		txtSaida = new JTextField();
		txtSaida.setBounds(48, 96, 125, 20);
		frame.getContentPane().add(txtSaida);
		txtSaida.setColumns(10);
		txtSaida.setEditable(false);
		
		JLabel lblText = new JLabel("Valor: ");
		lblText.setBounds(48, 71, 144, 14);
		frame.getContentPane().add(lblText);
		
		
		JProgressBar pbFrame = new JProgressBar();
		pbFrame.setBounds(48, 203, 146, 14);
		frame.getContentPane().add(pbFrame);
		
		JLabel lblProcessamento = new JLabel("");
		lblProcessamento.setBounds(48, 179, 248, 14);
		frame.getContentPane().add(lblProcessamento);
		
		
		JButton btnDeposito = new JButton("DEPOSITO");
		btnDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {			
					new Thread() {
						@Override
						public void run() {
							 valorDeposito = Float.parseFloat(JOptionPane.showInputDialog("INFORME UM VALOR DE DEPÓSITO"));
								
								objConta.realizarDeposito(valorDeposito);
								
							for (int counter = 1; counter <= 100; counter++) {
								try {		
									
									if (counter <= 20) {
										lblProcessamento.setText("Processamento os dados...");
										pbFrame.setValue(counter);
										sleep(30);
									} else if(counter <= 70) {
										lblProcessamento.setText("Depositando o saldo solicitado..");
										
										if (valorDeposito < 0) {
											JOptionPane.showMessageDialog(null, MessageUtil.MESSAGE_VALOR_NEGATIVO);
											txtSaida.setText("");
											pbFrame.setValue(0);
											lblProcessamento.setText("");		
											break;
																		
											
										}
										
										pbFrame.setValue(counter);
										sleep(30);
									} else if(counter <= 100) {
										lblProcessamento.setText("Resultado: ");
										pbFrame.setValue(counter);
										txtSaida.setText("SALDO: " + objConta.verificarSaldo());
										sleep(30);
									}
									
									
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}	
						};
						
					}.start();	
				} catch (NumberFormatException exe) {
					exe.printStackTrace();
								
					JOptionPane.showMessageDialog(null, MessageUtil.MESSAGE_ERRO);		
				}
			}				
		});
		
		btnDeposito.setBounds(300, 81, 106, 38);
		frame.getContentPane().add(btnDeposito);
		
		
		
		JButton btnSaldo = new JButton("SALDO");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					@Override
					public void run() {
						for (int counter = 1; counter <= 100; counter++) {
							try {		
								
								if (counter <= 20) {
									lblProcessamento.setText("Processamento os dados...");
									pbFrame.setValue(counter);
								} 
							
								
								else if(counter <= 70) {
									lblProcessamento.setText("Mostrando o resultado do seu saldo..");
									pbFrame.setValue(counter);
								} else if(counter <= 100) {
									lblProcessamento.setText("Resultado: ");
									pbFrame.setValue(counter);
									txtSaida.setText("SALDO: " + objConta.verificarSaldo());
									
								}
								sleep(30);
								
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
					};
					
				}.start();
			}
		});
		btnSaldo.setBounds(300, 32, 106, 38);
		frame.getContentPane().add(btnSaldo);
		
		JButton btnSaque = new JButton("SAQUE");
		btnSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				new Thread() {
					@Override
					public void run() {
						float valorSaque =  Float.parseFloat(JOptionPane.showInputDialog("INFORME UM VALOR DE SAQUE"));
					    objConta.realizarSaque(valorSaque);
	        
				        for (int counter = 1; counter <= 100; counter++) {
							try {			
								if (counter <= 20) {
									lblProcessamento.setText("Processamento os dados...");
									pbFrame.setValue(counter);
										
								}
								else if(counter <= 70) {
									lblProcessamento.setText("Fazendo o saque solicitado...");
		
									if (valorSaque < 0) {
										lblProcessamento.setText("erro ao processar!");
										JOptionPane.showMessageDialog(null, MessageUtil.MESSAGE_VALOR_NEGATIVO);
										pbFrame.setValue(0);
										txtSaida.getText();
										
										
										lblProcessamento.setText("");	
												
										break;
									}								
									pbFrame.setValue(counter);
								}
							
								if (objConta.verificarSaldo() > objConta.saldo) {			
									if (objConta.verificarSaldo() > objConta.saldo) {
										lblProcessamento.setText("erro ao processar!");
										JOptionPane.showMessageDialog(null, MessageUtil.MESSAGE_VALOR_MENOR);
										txtSaida.setText("");
										pbFrame.setValue(0);
										break;									
									}
									
									lblProcessamento.setText("erro ao processar!");
									JOptionPane.showMessageDialog(null, MessageUtil.MESSAGE_VALOR_MENOR);
									txtSaida.getText();
									pbFrame.setValue(0);
									break;			
								}
								
								else if(counter <= 100) {
									lblProcessamento.setText("Resultado: ");
									pbFrame.setValue(counter);						
							        txtSaida.setText("SALDO: " + objConta.verificarSaldo());				
								}
								sleep(30);
								
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					};
				}.start();
      
			}
		});
		btnSaque.setBounds(300, 130, 106, 38);
		frame.getContentPane().add(btnSaque);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JOptionPane.showMessageDialog(null, MessageUtil.MESSAGE_FINALIZAR_PROGRAMA);

			}
		});
		btnSair.setBounds(300, 179, 106, 38);
		frame.getContentPane().add(btnSair);
		
		
		
		
	}
}

