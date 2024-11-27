import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sistema_bancario {

    private JPanel tela;
    private JButton btnSaque;
    private JButton btnDepositar;
    private JTextField inputDepositar;
    private JTextField inputSaque;
    private JTextArea mensagem;
    private JButton limparButton;
    private JLabel saldoTxt;

    double saldo = 500.0 ;

    public static void main(String[] args) {

        JFrame tela = new JFrame("SISTEMA BANCARIO");
        tela.setContentPane(new sistema_bancario().tela);
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setSize(600, 400);
        tela.setVisible(true);

    }

    public void atualizaSaldo(){

        saldoTxt.setText(String.valueOf(saldo));
    }


    public void sacar(){

        try {
            double valorDigitado = Double.parseDouble(inputSaque.getText());

            if( valorDigitado > saldo || valorDigitado > 0){
                mensagem.setText("ERRO: Valor digitado é maior que o Saldo disponivel");
            }else{
                saldo -= valorDigitado;
                atualizaSaldo();
                mensagem.setText("Saque bem-sucedido.");
            }

        }catch (Exception e){
            System.out.println("erro");
        }

    }

    public void depositar(){

        try{

            double valorDigitado = Double.parseDouble(inputDepositar.getText());

            if (valorDigitado <= 1000){
                saldo += valorDigitado;
                atualizaSaldo();
            }else{
                mensagem.setText("ERRO: depósitos são permitidos em valores até 1000");
            }


        }catch (Exception e) {
            System.out.println("ERRO");
        }
    }


    public sistema_bancario(){

        btnSaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sacar();
            }
        });

        btnDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositar();
            }
        });

    }
}
