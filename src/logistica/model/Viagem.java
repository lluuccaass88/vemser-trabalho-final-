package src.logistica.model;

public class Viagem  {
    private int idViagem;
    private Caminhao caminhao;
    private Rota rota;
    private Usuario usuario;
    private int finalizada;

    public Viagem() { this.finalizada = 0; }
    public int getIdViagem() { return idViagem; }
    public void setIdViagem(int idViagem) { this.idViagem = idViagem; }
    public Caminhao getCaminhao() { return caminhao; }
    public void setCaminhao(Caminhao caminhao) { this.caminhao = caminhao; }
    public Rota getRota() { return rota; }
    public void setRota(Rota rota) { this.rota = rota; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public int getFinalizada() { return finalizada; }
    public void setFinalizada(int finalizada) { this.finalizada = finalizada; }

    @Override
    public String toString() {
        if(this.finalizada == 1 ){
            return "Viagem{" +
                    "id Viagem = " + idViagem +
                    ", Placa do caminhao = " + caminhao.getPlaca() +
                    ", rota = " + rota.getDescricao() +
                    ", usuario = " + usuario.getNome() +
                    ", viagem finalizada }";
        }else{
            return "Viagem{" +
                    "idViagem=" + idViagem +
                    ", Placa do caminhao = " + caminhao.getPlaca() +
                    ", rota = " + rota.getDescricao() +
                    ", usuario = " + usuario.getNome() +
                    ", viagem em andamento }";
        }
    }
}