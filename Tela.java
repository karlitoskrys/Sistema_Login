import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.ExportException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Tela{
    JFrame janela = new JFrame();
    JFrame janelaLogin = new JFrame();
    JLabel labelnome = new JLabel("Usuario: ");
    JTextField fieldnome = new JTextField();
    JLabel labelsenha = new JLabel("Senha: ");
    JPasswordField fieldsenha = new JPasswordField();
    JButton botaologin = new JButton("entrar");
    JButton botaocadastrar = new JButton("Cadastrar");
    JButton botaoprofessor = new JButton("Entrar como professor");
    JSeparator separadorcima = new JSeparator();
    JSeparator separadorbaixo = new JSeparator();
    JSeparator separadormeio = new JSeparator(JSeparator.VERTICAL);
    JPanel painelesquerdo = new JPanel();
    JLabel imagemEscola = new JLabel();
    JLabel textobemvindo = new JLabel("Bem-Vindo(a)");
    JLabel textomensagem = new JLabel("Faça seu login ou Cadastre-se");
    
    

    
   
    


    public Tela(){

        janela.setVisible(true);
        janela.setBounds(500,300,1100,700);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(3);
        janela.setLayout(null);
        janela.add(labelnome);
        janela.setResizable(false);
        janela.getContentPane().setBackground(new Color(8,25,42));
        janela.setTitle("Login");
        janela.add(separadorcima);
        janela.add(separadorbaixo);
        janela.add(separadormeio);
        janela.add(botaoprofessor);
        janela.add(textomensagem);
        
        
        separadorcima.setBounds(600, 180, 500, 20);
        separadorcima.setBackground(Color.black);
        janela.add(textobemvindo);
        textobemvindo.setBounds(750, 25, 300, 100);
        textobemvindo.setFont(new Font("Arial", Font.BOLD, 30));
        textobemvindo.setForeground(Color.white);
        textomensagem.setBounds(740,80,300,100);
        textomensagem.setFont(new Font("Arial", Font.BOLD, 15));
        textomensagem.setForeground(Color.white);
        

        
        labelnome.setBounds(700, 250, 200, 50);
        labelnome.setFont(new Font("Arial", Font.BOLD, 20));
        labelnome.setForeground(Color.white);
        labelnome.setVisible(true);
        janela.add(fieldnome);
        fieldnome.setVisible(true);
        fieldnome.setBounds(800, 265, 100, 25);
        janela.add(labelsenha);
        labelsenha.setVisible(true);
        labelsenha.setBounds(700, 300, 200, 50);
        labelsenha.setFont(new Font("Arial", Font.BOLD,20));
        labelsenha.setForeground(Color.WHITE);
        janela.add(fieldsenha);
        fieldsenha.setVisible(true);
        fieldsenha.setBounds(800, 315, 100, 25);    
        janela.add(botaologin);
        botaologin.setBounds(700, 400, 100, 50);
        janela.add(botaocadastrar);
        botaocadastrar.setBounds(880,400,100,50);
        botaocadastrar.setVisible(true);
        botaoprofessor.setBounds(740, 500, 200, 70);
        imagemEscola.setBounds(0, 0, 600, 690);
        janela.add(imagemEscola);
        ImageIcon icon = new ImageIcon("icones_escola_karlos/loginfundo.png");

        Image img = icon.getImage();
        Image imgRedimensionada = img.getScaledInstance(600,690, Image.SCALE_SMOOTH);

        imagemEscola.setIcon(new ImageIcon(imgRedimensionada));
        
        botaologin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            
            String Fieldnome = fieldnome.getText();
            String Fieldsenha = new String(fieldsenha.getPassword());
            if (Fieldnome.equals("") || Fieldsenha.equals("")){
                JOptionPane.showMessageDialog(janela, "Algum campo não foi respondido...");
            }else{

            Connection conexao = Conexao.conectar();

            String sql = "SELECT * FROM USUARIOS WHERE nome = ? AND senha = ?";
            try{
                PreparedStatement comando = conexao.prepareStatement(sql);
                comando.setString(1,Fieldnome);
                comando.setString(2,Fieldsenha);

                ResultSet resultado = comando.executeQuery();

                if(resultado.next()){   
                    janela.dispose();
                    new TelaAluno();
                }



            }catch (Exception erro){
                JOptionPane.showMessageDialog(janela, "Usuario ou senha incorreto");
                System.out.println(erro.getMessage());
            }

            
        }
        }
        
        });

        botaocadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                janela.dispose();
                new Telacadastro();

            }
        });
        
        botaoprofessor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                janela.dispose();
                new Telaloginprofessor();
            }
        
        });
        

    }






}