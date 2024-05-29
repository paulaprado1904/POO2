class Endereco {
    private String rua;
    private int numero;
    private String bairro;
    private String cep;
    private String complemento;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String printaEnderecoCLiente(){
        return  "\nRua: "+ getRua()
                +"\nNúmero: "+getNumero()
                +"\nBairro: "+getBairro()
                +"\nCEP: "+getCep()
                +"\nComplemento: "+getComplemento();
    }
}