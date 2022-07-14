package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class EvenNumbersIteratorTest {

    private Iterator<Integer> it;

    @Before
    public void setUp() {
        it = new EvenNumbersIterator(new int[] {1, 3, 2, 3, 5, 5, 4, 5, 6, 7});
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertTrue(it.hasNext());
        assertSame(2, it.next());
        assertTrue(it.hasNext());
        assertSame(4, it.next());
        assertTrue(it.hasNext());
        assertSame(6, it.next());
        assertFalse(it.hasNext());
        it.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
        assertSame(2, it.next());
        assertSame(4, it.next());
        assertSame(6, it.next());
    }

    @Test
    public void  shouldReturnFalseIfNoAnyEvenNumbers() {
        it = new EvenNumbersIterator(new int[]{1});
        assertFalse(it.hasNext());
    }

    @Test
    public void  shouldReturnFalseIfNoAnyNumbers() {
        it = new EvenNumbersIterator(new int[]{});
        assertFalse(it.hasNext());
    }

    @Test
    public void allNumbersAreEven() {
        it = new EvenNumbersIterator(new int[] {2, 4, 6});
        assertTrue(it.hasNext());
        assertSame(2, it.next());
        assertTrue(it.hasNext());
        assertSame(4, it.next());
        assertTrue(it.hasNext());
        assertSame(6, it.next());
        assertFalse(it.hasNext());
    }
}