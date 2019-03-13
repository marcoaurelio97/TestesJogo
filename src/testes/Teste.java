package testes;

import classes.Jogo;
import classes.Participante;
import classes.Resultado;
import classes.Juiz;

import org.junit.*;

public class Teste {
    
    @Test
    public void deveTerJogoComUmUnicoParticipante() {
        Jogo jogo = new Jogo("Basquete");
        
        Assert.assertEquals(0, jogo.getResultados().size());
        
        jogo.anota(new Resultado(new Participante("Marco"), 462));
        
        Assert.assertEquals(1, jogo.getResultados().size());
        Assert.assertEquals(462, jogo.getResultados().get(0).getMetrica(), 0.00001);
    }
    
    @Test
    public void deveTerJogoComVariosParticipantes() {
        Jogo jogo = new Jogo("Futebol");

        Assert.assertEquals(0, jogo.getResultados().size());
        
        jogo.anota(new Resultado(new Participante("Marco"), 462));
        jogo.anota(new Resultado(new Participante("Guilherme"), 15));
        jogo.anota(new Resultado(new Participante("Bruno"), 44));
        jogo.anota(new Resultado(new Participante("Vinicius"), 897));
        
        Assert.assertEquals(4, jogo.getResultados().size());
        Assert.assertEquals("Bruno", jogo.getResultados().get(2).getParticipante().getNome());
        Assert.assertEquals(15, jogo.getResultados().get(1).getMetrica(), 0.00001);
    }

    @Test
    public void deveTerApenasUmResultadoPorParticipante() {

        Jogo jogo = new Jogo("Basquete");

        Assert.assertEquals(0, jogo.getResultados().size());
        
        jogo.anota(new Resultado(new Participante("Vinicius"), 105));
        jogo.anota(new Resultado(new Participante("Vinicius"), 235));
        
        Assert.assertEquals(1, jogo.getResultados().size());
        Assert.assertEquals("Vinicius", jogo.getResultados().get(0).getParticipante().getNome());
    }

    @Test
    public void deveClassificarPrimeiroColocado()
    {
        Jogo jogo = new Jogo("Futebol");

        Assert.assertEquals(0, jogo.getResultados().size());
        
        jogo.anota(new Resultado(new Participante("Marco"), 462));
        jogo.anota(new Resultado(new Participante("Guilherme"), 15));
        jogo.anota(new Resultado(new Participante("Bruno"), 44));
        jogo.anota(new Resultado(new Participante("Vinicius"), 897));

        Juiz juiz = new Juiz();
        juiz.julga(jogo)

        Assert.assertEquals(897, juiz.getPrimeiroColocado(), 0.00001);
    }

}