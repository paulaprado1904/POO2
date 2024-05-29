public class FIFO
{
    //VARIAVEIS
    private int cabeca, cauda, qtd_elementos; //indices e contador
    //cabeca -> primeiro item
    //cauda-1 -> ultimo item
    private int fila[]; //vetor de elementos
    //METODOS
    //constructor -- determina capacidade da fila / innicializando fila
    public FIFO(int tamanho)
    {
        this.fila = new int[tamanho]; //cria vetor com capacidade = 'tamanho'
        cauda = 0;
        cabeca = 0;
        qtd_elementos = 0;
    }
    //Funcao de insecao na fila
    public void enqueue(int elemento)
    {
        //SE HOUVER ESPACO NA FILA
        this.fila[this.cauda] = elemento; //insere elemento na cauda
        //incrementa indice cauda
        if(this.cauda == this.fila.length-1) /*se indice cauda aponta fim do vetor(length-1
pois indice vai de 0 a length-1)*/
            this.cauda = 0; //circula e volta para o inicio
        else //indice cauda não aponta o fim
            this.cauda +=1; //incrementa indice cauda
        this.qtd_elementos++; // incrementa qtd de elementos
        //elemento inserido
        return;
    }
    //Funcao remocao da fila
    public int dequeue()
    {
        //SE HOUVER ITEM NA FILA
        int valor = this.fila[this.cabeca]; //extrai o primeiro da fila
        //incrementa indice cabeca
        if(this.cabeca == this.fila.length-1) //se indice cabeca aponta fim do vetor(cabeca  vai de 0 a length-1)
        this.cabeca = 0; //circula e volta pro inicio
 else //indice cabeca não aponta o fim
        this.cabeca +=1; //incrementa indice cabeca
        this.qtd_elementos--; // decrementa qtd de elementos
        //elemento retirado
        return valor;
    }
    //Funcao que indica fila cheia
    public boolean cheia()
    {
        if(this.qtd_elementos == this.fila.length)
            return true;
        else
            return false;
    }
    //Funcao que indica fila vazia
    public boolean vazia()
    {
        if(this.qtd_elementos == 0)
            return true;
        else
            return false;
    }
}