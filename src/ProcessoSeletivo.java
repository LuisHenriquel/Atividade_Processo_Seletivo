import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {

    public static void main(String[] args){

        String[] candidatos = {"FELIPE", "JULIA", "AUGUSTO", "LUIS", "HENRIQUE"};
        for(String candidato: candidatos) {
            entrandoEmContato(candidato);
        }

    }

    public static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 0;
        boolean continuarTentando = true;
        boolean atendeu=false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIADO COM SUCESSO");

        }while(continuarTentando && tentativasRealizadas<3);
        if(atendeu)
            System.out.println("Conseguimos Contato Com " + candidato + " Na " +  tentativasRealizadas + " Tentativas");
        else
            System.out.println("Não Conseguimos Contato Com " + candidato + ", Número Maximo Tentativas " + tentativasRealizadas + " Realizada");

    }

    public static boolean atender(){
        return new Random().nextInt(3)==1;

    }


    public static void imprimirSelecionados(){
        String[] candidatos = {"FELIPE", "JULIA", "AUGUSTO", "LUIS", "HENRIQUE"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for(int indice = 0; indice < candidatos.length; indice++){
            System.out.println("O candidato de nº " + (indice+1) + " é " + candidatos[indice]);

        }
        System.out.println("Forma abreviada de interação for each");

        for(String candidato : candidatos ){
            System.out.println("O candidato selecionado foi " + candidato);
        }


    }



    public static void selecaoCandidato() {
        String[] candidatos = {"FELIPE", "JULIA", "AUGUSTO", "LUIS", "HENRIQUE", "LAURA", "MONICA", "MIRELA", "DANIELA", "JOSE", "CARLOS"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBasico = 2000.0;
        DecimalFormat df = new DecimalFormat("#.00");
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            String salarioFormatado = df.format(salarioPretendido);
            System.out.println("O candidato " + candidato + " Solicitou este valor de salário  " + salarioFormatado);
            if(salarioBasico >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga" );
                candidatosSelecionados++;
            }
            else {
                System.out.println("O candidato não foi selecionado para vaga");
            }
            candidatosAtual++;
        }
    }

    public static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void analisarCandidato(double salarioPretendido){
        double salarioBase =0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATOS");
        }

    }
}



