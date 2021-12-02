package mundo;

public class State 
{// Atributos
    private String fatherKey;
    private String move;
    private Rubik rubik;
    
 // Constructor
    public State(String fatherKey, String move, Rubik rubik) 
    { this.fatherKey = fatherKey;
      this.move = move;
      this.rubik = rubik;
    }

    public void imprimir (){
        System.out.println("padre: "+fatherKey+" movimiento: "+move+" cubo: "+rubik.getKey());
    }
    
    
 // Metodos get   
    public String getFatherKey() { return fatherKey; }
    public String getMove() { return move; }
    public Rubik getRubik() { return rubik; }  
    
    
    
}
