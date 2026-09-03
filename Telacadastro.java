import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Telacadastro {
    JFrame janelacadastro = new JFrame();
    JLabel labelnome = new JLabel("Usuario: ");
    JTextField fieldnome = new JTextField("Usuario");
    JLabel labelsenha = new JLabel("Senha: ");
    JPasswordField fieldsenha = new JPasswordField();
    JButton botaocadastra = new JButton("Cadastrar");
    JButton botaolimpar = new JButton("Limpar");
    JButton botaovoltar = new JButton("Voltar");
    JPanel painelesquerdo = new JPanel();
    JPanel painelnome = new JPanel();
    JPanel painelsenha = new JPanel();

    public Telacadastro(){

        // adicionar na janela 
        janelacadastro.setVisible(true);
        janelacadastro.setBounds(500, 300, 1100, 700);
        janelacadastro.setDefaultCloseOperation(3);
        janelacadastro.setResizable(false);
        janelacadastro.setLayout(null);
        janelacadastro.setLocationRelativeTo(null);
        janelacadastro.setTitle("Cadastro");
        janelacadastro.add(labelnome);
        janelacadastro.add(labelsenha);
        janelacadastro.add(fieldsenha);
        janelacadastro.add(botaocadastra);
        janelacadastro.add(botaolimpar);
        janelacadastro.add(botaovoltar);
        janelacadastro.add(painelesquerdo);
        janelacadastro.add(painelnome);
        janelacadastro.add(painelsenha);
        painelnome.add(fieldnome);
        painelnome.setLayout(null);


        // personalizar os comandos

        labelnome.setBounds(50, 150, 50, 50);
        fieldnome.setBounds(40, 6, 550, 50);
        labelsenha.setBounds(50, 200, 50, 50);
        fieldsenha.setBounds(100, 215, 100, 25);
        painelesquerdo.setBounds(0, 0, 600, 690);
        painelesquerdo.setBackground(Color.BLACK);
        painelnome.setBounds(700, 250, 320, 60);
        painelnome.setBackground(new Color(15,25,30));
        fieldnome.setFont(new Font ("Arial", Font.PLAIN, 15));
        fieldnome.setForeground(Color.GRAY);
        fieldnome.setBackground(new Color(15,25,30));
        fieldnome.setBorder(null);

        fieldnome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (fieldnome.getText().equals("Usuario")){
                    fieldnome.setText("");
                    fieldnome.setForeground(Color.white);

                }
            }
            public void focusLost(java.awt.event.FocusEvent e){
                if (fieldnome.getText().isEmpty()){
                    fieldnome.setText("Usuario");
                    fieldnome.setForeground(Color.gray);
                }
            }
        });
        



        //botao
        botaocadastra.setBounds(50, 300, 100, 50);
        botaocadastra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            String usuariocadastro = fieldnome.getText();
            String senhacadastro = new String(fieldsenha.getPassword());

            Connection conexao = Conexao.conectar();

            String sql = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";

            try{

            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, usuariocadastro);
            comando.setString(2,senhacadastro);
            comando.executeUpdate();
        } catch (SQLException erro){
            System.out.println("Erro ao cadastar");
            System.out.println(erro.getMessage());

        }

            
                

            }
        });

        



    }
}

