package testeaula06;

public class ControleRemoto implements Controlador{
    //Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;
   
    
    //Construtores
    public ControleRemoto(int volume, boolean ligado, boolean tocando) {
        this.volume = volume;
        this.ligado = ligado;
        this.tocando = tocando;
    }

    public ControleRemoto() {
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }

    
    
    
    //Metodos Especiais
    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
    
    
    
    //Metodos Abstratos
    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        if(this.getLigado()){
            System.out.println("----MENU----");
            System.out.println("Ligado: "+ this.getLigado());
            System.out.print("Volume: "+ this.getVolume());
            for(int i = 0; i <= this.getVolume();i+=10){
                System.out.print("|");
            }
            System.out.println("\nTocando: "+ this.getTocando());
        }
        else{
            System.out.println("Aparelho desligado.");
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu ...");
    }

    @Override
    public void maisVolume() {
        if(this.getLigado()){
            this.setVolume(this.getVolume() + 5);
        }
        System.out.println("Impossivel aumentar volume.");
    }

    @Override
    public void menosVolume() {
        if(this.getLigado()){
            this.setVolume(this.getVolume() - 5);
        }
        else{
            System.out.println("Impossivel diminuir volume.");
        }
    }

    @Override
    public void ligarMudo() {
        if(this.getLigado() && this.getVolume()>0){
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if(this.getLigado() && this.getVolume() == 0){
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if(this.getLigado() && !(this.getTocando())){
            this.setTocando(true);
        }
        else{
            System.out.println("Não é possivel dar play.");
        }
    }

    @Override
    public void pause() {
        if(this.getLigado() && this.getTocando()){
            this.setTocando(false);
        }
        else{
            System.out.println("Não é possivel dar pause.");
        }
    }
    
    
    
    
    
    
}
