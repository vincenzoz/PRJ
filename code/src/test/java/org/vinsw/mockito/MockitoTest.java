package org.vinsw.mokito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    List<String> mockedList;

    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        something();

        Mockito.verify(mockedList).add("3");
        Mockito.verify(mockedList).clear();
        assertEquals(0, mockedList.size());

        Mockito.when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
    }

    @Test
    public void SimpleTest() {

    }

    private void something() {
        mockedList.add("3");
        mockedList.clear();
    }

}
