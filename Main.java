
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        campo[][] velha = new campo[3][3];
        char Simboloatual='x';
        boolean game= true;
        char vitoria=' ';
        Scanner analise= new Scanner(System.in);
        iniciarjogo(velha);
        while (game){
            desenhajogo(velha);
            vitoria=vervitoria(velha);
            if(vitoria!=(' ')){
                System.out.printf("Jogador %s Venceu!!!\n", vitoria);
                break;
            }
            try{
                if(Jogada(velha,jogar(analise,Simboloatual),Simboloatual)){
                    if(Simboloatual=='x'){
                        Simboloatual='o';
                    }else{
                        Simboloatual='x';
                    }
                }
            } catch(Exception e) {

            System.out.printf("Erro!");}
            }
        System.out.printf("Fim de jogo!");
        }
    public static void desenhajogo(campo[][] velha){
        limpatela();
    System.out.println("     0      1       2");
    System.out.printf ("0    %c  |  %c   | %c   %n", velha[0][0].getSimbolo(), velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
    System.out.println("      ------------------");
    System.out.printf ("1    %c  |  %c   | %c   %n", velha[1][0].getSimbolo(), velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
    System.out.println("      ------------------");
    System.out.printf ("2    %c  |  %c   | %c   %n", velha[2][0].getSimbolo(), velha[2][1].getSimbolo(), velha[2][2].getSimbolo());
    }
    public static void limpatela(){
        for(int cont=0;cont <200; cont++){
            System.out.println("");
        }
    }
    public static int[] jogar(Scanner analise,char Simboloatual){
        int p[] = new int[2];
        System.out.printf("%s %c\n", "Quem joga: ",Simboloatual);
        System.out.println("Informe a linha: ");
        p[0]=analise.nextInt();
        System.out.println("Informe a coluna: ");
        p[1]=analise.nextInt();
        return p;
    }

    public static boolean Jogada(campo[][] velha, int p[], char Simboloatual){
        if (velha[p[0]][p[1]].getSimbolo()==' '){
            velha[p[0]][p[1]].setSimbolo(Simboloatual);
            return true;
        }else{
            return false;
        }

    }
    public static void iniciarjogo(campo[][] velha){
        for(int l=0;l<3;l++){
            for(int c=0;c<3;c++){
                velha[l][c]=new campo();
            }
        }
    }
    public static char vervitoria(campo[][] velha){
        for(int i=0;i<3;i++){
            if((velha[i][0].getSimbolo()=='x'&& velha[i][1].getSimbolo()=='x'&& velha[i][2].getSimbolo()=='x')||(velha[i][0].getSimbolo()=='o'&& velha[i][1].getSimbolo()=='o'&& velha[i][2].getSimbolo()=='o')){
                return velha[i][0].getSimbolo();
            }
            if((velha[0][i].getSimbolo()=='x'&& velha[1][i].getSimbolo()=='x'&& velha[2][i].getSimbolo()=='x')||(velha[0][i].getSimbolo()=='o'&& velha[1][i].getSimbolo()=='o'&& velha[2][i].getSimbolo()=='o')){
                return velha[0][i].getSimbolo();
            }
            if((velha[0][0].getSimbolo()=='x'&& velha[1][1].getSimbolo()=='x'&& velha[2][2].getSimbolo()=='x')||(velha[0][0].getSimbolo()=='o'&& velha[1][1].getSimbolo()=='o'&& velha[2][2].getSimbolo()=='o')){
                return velha[0][0].getSimbolo();
            }
            if((velha[2][0].getSimbolo()=='x'&& velha[1][1].getSimbolo()=='x'&& velha[0][2].getSimbolo()=='x')||(velha[2][0].getSimbolo()=='o'&& velha[1][1].getSimbolo()=='o'&& velha[0][2].getSimbolo()=='o')){
                return velha[2][0].getSimbolo();
            }
        }
        return ' ';
    }

}