public class Inimigo extends Personagem {

    
    public Inimigo(String nome, int vida, int mana,int limitemana, int ataque, int defesa, int especial, int esquiva) {
        super(nome, vida, mana, limitemana, ataque, defesa, especial,esquiva);
    }
    
    
    
    @Override
    
    public void reduzirVida(int quantidade) {
        if (!esquivar()) {
            vida -= quantidade;
        }
    }
}


