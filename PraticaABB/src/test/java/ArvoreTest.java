import org.junit.Test;

import static org.junit.Assert.*;

public class ArvoreTest {


    @Test
    public void buscarTest() {
        Arvore arvore = new Arvore();
        arvore.insere(5);
        arvore.insere(3);
        arvore.insere(7);
        arvore.insere(2);
        arvore.insere(4);
        arvore.insere(9);
        arvore.insere(12);
        arvore.insere(12);

        assertTrue(arvore.buscar(5));
        assertTrue(arvore.buscar(3));
        assertTrue(arvore.buscar(7));
        assertTrue(arvore.buscar(2));
        assertTrue(arvore.buscar(4));
        assertTrue(arvore.buscar(9));
        assertTrue(arvore.buscar(12));

    }
    @Test
    public void testBuscaFloat() {
        Arvore<Float> arvore = new Arvore<>();
        arvore.insere(5.5f);
        arvore.insere(3.3f);
        arvore.insere(7.7f);
        arvore.insere(2.2f);
        arvore.insere(4.4f);
        arvore.insere(9.9f);
        arvore.insere(12.12f);
        arvore.insere(12.12f);

        assertTrue(arvore.buscar(5.5f));
        assertTrue(arvore.buscar(3.3f));
        assertTrue(arvore.buscar(7.7f));
        assertTrue(arvore.buscar(2.2f));
        assertTrue(arvore.buscar(4.4f));
        assertTrue(arvore.buscar(9.9f));
        assertTrue(arvore.buscar(12.12f));
    }

    @org.junit.Test
    public void testBuscaChar() {
        Arvore<Character> arvore = new Arvore<>();
        arvore.insere('a');
        arvore.insere('b');
        arvore.insere('c');
        arvore.insere('d');
        arvore.insere('e');
        arvore.insere('f');
        arvore.insere('g');
        arvore.insere('h');

        assertTrue(arvore.buscar('a'));
        assertTrue(arvore.buscar('b'));
        assertTrue(arvore.buscar('c'));
        assertTrue(arvore.buscar('d'));
        assertTrue(arvore.buscar('e'));
        assertTrue(arvore.buscar('f'));
        assertTrue(arvore.buscar('g'));
        assertTrue(arvore.buscar('h'));
    }

    @org.junit.Test
    public void testBuscaString() {
        Arvore<String> arvore = new Arvore<>();
        arvore.insere("OpenAI");
        arvore.insere("is");
        arvore.insere("awesome");
        arvore.insere("and");
        arvore.insere("powerful");

        assertTrue(arvore.buscar("OpenAI"));
        assertTrue(arvore.buscar("is"));
        assertTrue(arvore.buscar("awesome"));
        assertTrue(arvore.buscar("and"));
        assertTrue(arvore.buscar("powerful"));
    }

    @Test
    public void removeTest() {
        Arvore<Integer> arvore = new Arvore<>();
        arvore.insere(5);
        arvore.insere(3);
        arvore.insere(7);
        arvore.insere(2);
        arvore.insere(4);
        arvore.insere(9);
        arvore.insere(12);

        assertTrue(arvore.buscar(5));
        arvore.remove(5);
        assertFalse(arvore.buscar(5));

        assertTrue(arvore.buscar(9));
        arvore.remove(9);
        assertFalse(arvore.buscar(9));
    }

    @Test
    public void removeTestChar(){
        Arvore<Character> arvoreString = new Arvore<>();
        arvoreString.insere('a');
        arvoreString.insere('b');
        assertTrue(arvoreString.buscar('a'));
        arvoreString.remove('a');
        assertFalse(arvoreString.buscar('a'));
    }
    @Test
    public void removeTestFloat(){
        Arvore<Float> arvoreFloat = new Arvore<>();
        arvoreFloat.insere(5.5f);
        arvoreFloat.insere(3.3f);
        arvoreFloat.insere(7.7f);
        arvoreFloat.insere(2.2f);
        arvoreFloat.insere(4.4f);
        arvoreFloat.insere(9.9f);
        arvoreFloat.insere(12.12f);

        assertTrue(arvoreFloat.buscar(5.5f));
        arvoreFloat.remove(5.5f);
        assertFalse(arvoreFloat.buscar(5.5f));

        assertTrue(arvoreFloat.buscar(9.9f));
        arvoreFloat.remove(9.9f);
        assertFalse(arvoreFloat.buscar(9.9f));
    }
    @Test
    public void removeTestString(){
        Arvore<String> arvoreString = new Arvore<>();
        arvoreString.insere("ABB");
        arvoreString.insere("is");
        arvoreString.insere("awesome");
        arvoreString.insere("and");
        arvoreString.insere("powerful");

        assertTrue(arvoreString.buscar("ABB"));
        arvoreString.remove("ABB");
        assertFalse(arvoreString.buscar("ABB"));

        assertTrue(arvoreString.buscar("awesome"));
        arvoreString.remove("awesome");
        assertFalse(arvoreString.buscar("awesome"));
    }
}