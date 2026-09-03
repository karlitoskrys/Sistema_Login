import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaPagamento {
    JPanel paineldireito = new JPanel();
    JFrame janela = new JFrame();


    public TelaPagamento(){
        janela.setVisible(true);
        janela.setBounds(300, 300, 300, 300);
        janela.setDefaultCloseOperation(3);
        janela.setResizable(false);;
    }
}
