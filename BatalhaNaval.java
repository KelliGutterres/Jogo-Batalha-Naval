import java.util.Random;

public class BatalhaNaval{
  
  public static  void  main (String args []) {
   
    int l = Entrada.leiaInt("Informe um Tamanho para a MATRIZ! \n Informe a ALTURA: ");   
    int c = Entrada.leiaInt("Informe a LARGURA: ");
    
    if((l*c) > 5){  //Validando se o Tamanho Mínimo(5 índices) é Válido
    
      int tabul [][] = new int[l][c];  // Matriz com o tamanho que o Usuário informou.
      int navio [][] = new int [5][2]; // Matriz para armazenar a posição dos Navios.      
      int tiro [] = new int [2];       // Vetor para guardar a posição do tiro.
      int tent=0, acerto=0;
      
      
      System.out.print("JOGO BATALHA NAVAL!\n");
      System.out.print("Jogo Iniciado!\n\n");
      
      iniciaTabuleiro(tabul, l,c);
      enviaNavios(navio,l,c);
      
      System.out.print("");
      
      do{
            mostrarTabuleiro(tabul, l, c);
            lancarTiro(tiro);
            tent++;
            
            if(acertou(tiro,navio)== true){
               System.out.printf("Você ACERTOU o tiro! (%d,%d)\n",tiro[0]+1,tiro[1]+1);
                acerto++;
            }
            else{
              System.out.printf("Você ERROU o tiro! (%d,%d)\n",tiro[0]+1,tiro[1]+1);
            }
            
            alterarTabuleiro(tiro,navio,tabul);
            
        }while(acerto!=5);
        
        System.out.println("\n\nJOGO FINALIZADO! PARABÉNS!! Você acertou os 5 navios em "+tent+" tentativas!");
        //mostrarTabuleiro(tabul,l,c);
    }
    else{
      
      l = Entrada.leiaInt("Informe um Tamanho VÁLIDO para a matriz! \n\n Informe a ALTURA Novamente: ");   
      c = Entrada.leiaInt("Informe a LARGURA Novamente: ");
    }
  }
  
 public static void iniciaTabuleiro(int [][] tabul, int l, int c){
    
    System.out.print("Tabuleiro:\n");
    for(int conl=0; conl < l; conl++){
      
        for(int conc=0; conc < c; conc++){
        
         tabul[conl][conc]=-1;
        }
      }
  }
  
 public static void enviaNavios(int [][] navio, int l, int c){
    
  Random gerar = new Random();
     
     for(int contNavio=0 ; contNavio < 5 ; contNavio++){
       
            navio[contNavio][0]=gerar.nextInt(l);
            navio[contNavio][1]=gerar.nextInt(c);
            
            for(int ant=0 ; ant < contNavio ; ant++){ //Checa se esse par não foi sorteado
              
              if( (navio[contNavio][0] == navio[ant][0])&&(navio[contNavio][1] == navio[ant][1]) )
   
                    do{   //se foi, so sai do do...while enquanto sortear um diferente
                        navio[contNavio][0]=gerar.nextInt(l);
                        navio[contNavio][1]=gerar.nextInt(c);
                    }
                while((navio[contNavio][0] == navio[ant][0])&&(navio[contNavio][1] == navio[ant][1]));
            }
         }
     }
  
 public static void lancarTiro(int[] tiro){
        
        tiro[0] = Entrada.leiaInt("Linha: ");
        tiro[0]--;
        
        tiro[1] = Entrada.leiaInt("Coluna: ");
        tiro[1]--;
    }
  
  
 public static void mostrarTabuleiro(int [][] tabul, int l, int c){
    
    for(int lin=0 ; lin < l ; lin++ ){
            
            for(int col=0 ; col < c ; col++ ){
              
                if(tabul[lin][col]==-1){
                  
                    System.out.print(" ~ ");
                    
                }else if(tabul[lin][col]==0){
                  
                    System.out.print(" * ");
                    
                }else if(tabul[lin][col]==1){
                  
                    System.out.print(" X ");
                }
            }
            System.out.println();
        }
  }
  
 public static boolean acertou(int[] tiro, int[][] navio){
        
        for(int nav=0; nav < 5 ; nav++){
          
            if( tiro[0]==navio[nav][0] && tiro[1]==navio[nav][1]){
                return true;
            }
        }
        return false;
    }
  
 public static void alterarTabuleiro(int [] tiro, int [][] navio, int [][] tabul){
        
        if(acertou(tiro,navio))
            tabul[tiro[0]][tiro[1]]=1;
        else
            tabul[tiro[0]][tiro[1]]=0;
    }
  
  }