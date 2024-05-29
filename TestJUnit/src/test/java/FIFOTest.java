import org.junit.Test;

import static junit.framework.TestCase.*;

public class FIFOTest {

    @Test
    public void enqueue() {
        FIFO fila = new FIFO(5);
        assertTrue(fila.vazia());

        fila.enqueue(1);
        assertFalse(fila.vazia());
        assertEquals(1, fila.dequeue());

        fila.enqueue(2);
        assertFalse(fila.vazia());
        assertEquals(2, fila.dequeue());

        assertTrue(fila.vazia());

    }

    @Test
    public void dequeue() {
    }

    @Test
    public void cheia() {
    }

    @Test
    public void vazia() {
    }
}