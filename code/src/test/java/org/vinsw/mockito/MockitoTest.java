package org.vinsw.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    List<String> mockedList;

    @Spy
    SampleClassForMockito scfm; // every call is delegated to the real object

    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        verify(mockedList).add("one"); // verify the .add("one") method call
        doSomething();
        verify(mockedList).add("3");
        verify(mockedList).add("3");
        verify(mockedList).clear();
        assertEquals(0, mockedList.size()); // because is a mocked object

        when(mockedList.size()).thenReturn(100); // define return value for .size()
        assertEquals(100, mockedList.size());
    }

    @Test(expected = NullPointerException.class)
    public void throwNullPointerException() {
        scfm.generateException(3);
    }

    private void doSomething() {
        mockedList.add("3");
        mockedList.clear();
    }

}
