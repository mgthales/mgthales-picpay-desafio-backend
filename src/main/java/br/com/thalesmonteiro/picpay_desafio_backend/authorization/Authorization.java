package br.com.thalesmonteiro.picpay_desafio_backend.authorization;

public record Authorization(
        String status
) {
    public boolean isAuthorized(){
        return status.equals("success");
    }
}
