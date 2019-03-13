package classes;

public class Juiz
{
    private double maisPontos = Double.NEGATIVE_INFINITY;
    private double menosPontos = Double.POSITIVE_INFINITY;

    public void julga(Jogo jogo)
    {
        for(Resultado resultado : jogo.getResultados())
        {
            if(resultado.getMetrica() > maisPontos) maisPontos = resultado.getMetrica();
            if(resultado.getMetrica() < menosPontos) menosPontos = resultado.getMetrica();
        }
    }

    public double getPrimeiroColocado(){
        return maisPontos;
    }

    public double getUltimoColocado(){
        return menosPontos;
    }
}