import java.sql.Connection;
public class Main extends Tela{
    public static void main(String []args){
        
        Tela tela = new Tela();
        
           Connection teste = Conexao.conectar();

        if (teste != null) {
            System.out.println("Conexao funcionando!");
        } else {
            System.out.println("Nao conectou.");
        }
        
        
    }

}
