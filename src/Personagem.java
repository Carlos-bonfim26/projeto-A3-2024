import java.util.Random;

public abstract class Personagem {
    private Random random;
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected int mana;
    protected int especial;
    protected int limitemana;
    protected int esquiva;

    public Personagem(String nome, int vida, int mana, int limitemana, int ataque, int defesa, int especial, int esquiva) {
        this.random = new Random();
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.limitemana = limitemana;
        this.ataque = ataque;
        this.defesa = defesa;
        this.especial = especial;
        this.esquiva = esquiva;
    }

    ////// INFO
    public String getNome() {
        return nome;
    }

    ////// VIDA
    public int getVida() {
        return vida;
    }
    
    public void setVida(int vida) {
        this.vida = vida;
    }
    
    ////// MANA
    public int getMana() {
        return mana;
    }
    
    public int getLimitemana() {
        return limitemana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    
    ///// ATAQUES
    public int getEspecial() {
        return especial;
    }
    
    public int getAtaque() {
        return ataque;
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    public int getDefesa() {
        return defesa;
    }
    
    public int getEsquiva() {
        return esquiva;
    }

    
    public void AtualizarStatus() {
        if (mana > limitemana) {
            mana = limitemana;
        }
        if (vida <= 0) {
            vida = 0;
        }
    }
        
    public boolean estaMorto() {
        return vida <= 0;
    }
   
    
    public boolean esquivar() {
        int chance = random.nextInt(100);
            return chance < esquiva;
        }
    
    public void reduzirVida(int quantidade) {
        if (!esquivar()) {
            vida -= quantidade;
        }
    }
    
    public void atacar(Personagem alvo, int dano) {
        alvo.reduzirVida(dano);
    }
    
    public void aumentarMana(int quantidade) {
        mana += quantidade;
    }
    
    public void meditar(int manare) {
        this.aumentarMana(manare);
    }
}
