import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Tela extends Login{
    JFrame janela = new JFrame();
    JLabel labelnome = new JLabel("Usuario: ");
    JTextField fieldnome = new JTextField();
    JLabel labelsenha = new JLabel("Senha: ");
    JPasswordField fieldsenha = new JPasswordField();
    JButton butao = new JButton("entrar");
    

    
   
    


    public Tela(){

        janela.setVisible(true);
        janela.setBounds(500,300,400,600);
        janela.setDefaultCloseOperation(3);
        janela.setLayout(null);
        janela.add(labelnome);
        janela.setResizable(false);
        labelnome.setBounds(50, 150, 50, 50);
        labelnome.setVisible(true);
        janela.add(fieldnome);
        fieldnome.setVisible(true);
        fieldnome.setBounds(100, 165, 100, 25);
        janela.add(labelsenha);
        labelsenha.setVisible(true);
        labelsenha.setBounds(50, 200, 50, 50);
        janela.add(fieldsenha);
        fieldsenha.setVisible(true);
        fieldsenha.setBounds(100, 215, 100, 25);
        janela.add(butao);
        butao.setBounds(140, 300, 100, 50);
        
        butao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            Login login = new Login();
            String Fieldnome = fieldnome.getText();
            String Fieldsenha = new String(fieldsenha.getPassword());


            if(Fieldnome .equals(login.getLoginnome()) && Fieldsenha .equals( login.getLoginsenha())){
                System.out.println("Bem vindo");
            }else{
                System.out.print("Login ou Senha invalida");
            }
            

            }
        });
        

    }






}