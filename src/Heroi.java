import java.util.Random;

public class Heroi extends Personagem {

private Random random;
int dejavu;
int ataqueinic;
int rocklee;
int esquivainic;
boolean turnodefesa;
boolean finin;
    public Heroi(String nome, int vida, int mana,int limitemana, int ataque, int defesa, int especial, int esquiva) {
        super(nome, vida, mana, limitemana, ataque, defesa, especial, esquiva);
        this.dejavu = 0; 
        this.rocklee = 0;
        this.esquivainic = getEsquiva();
        this.random = new Random();
        this.ataqueinic = getAtaque();
        this.turnodefesa = false;
    }

public void setDejavu() {
    if (dejavu == 0){
    dejavu = 4;
    this.esquivainic = esquiva;
    esquiva = esquiva + 40;}
    }

public int getDejavu() {
    return dejavu;
    }

public void dejavuTurno() {
    if (dejavu > 0){
    dejavu --;
if (dejavu == 0){
    esquiva = esquivainic;
    }}}

public void setTurnoDefesa() {
    turnodefesa = true;
    }

public int getRocklee(){
    return rocklee;
    }
    
public void setRocklee() {
    if (rocklee == 0){
    rocklee ++;
    ataqueinic = getAtaque();
    setAtaque(getAtaque()*2);}
    else if (rocklee < 4){
        rocklee ++;
        setAtaque(getAtaque()*2);
    }}


public boolean getFinin(){
    return finin;
    }

public void setFinin(boolean finin){
    this.finin = finin;
    }

@Override
public void atacar(Personagem alvo, int dano) {
    if (rocklee == 4){
        alvo.reduzirVida(dano*10);}
    else if (rocklee < 4){
        alvo.reduzirVida(dano);}
    if (rocklee > 0){
    setAtaque(ataqueinic);
    rocklee = 0;}
    else{}
}    
    
    
    public void exaltasamba() {
    setVida(1000);
    setMana(getLimitemana());
    }
    
    @Override
        public void reduzirVida(int quantidade) {
        if (!esquivar()) {
            if (turnodefesa == true){
                if (defesa > quantidade){}
                else{
            vida -= quantidade - defesa;}}
            
            else{
            setAtaque(ataqueinic);
            rocklee = 0;
            vida -= quantidade;}
        }
    }
    
    
    
}