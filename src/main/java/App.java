

public class App extends SerialCom {

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SerialComLeitura leitura = new SerialComLeitura("COM3", 9600, 500);

        leitura.HabilitarEscrita();
        leitura.ObterIdDaPorta();
        leitura.AbrirPorta();

        leitura.EnviarUmaString("0x04");
        leitura.HabilitarLeitura();
        leitura.ObterIdDaPorta();
        leitura.LerDados();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Erro na Thread: " + ex);
        }
        leitura.FecharCom();
    }
}

//public class App {
//    public static void main(String[] args) throws Exception {
////        SerialPortUtils.showAvailablePorts(args);
//        SerialPortUtils.showAvailablePorts();
//    }
//}