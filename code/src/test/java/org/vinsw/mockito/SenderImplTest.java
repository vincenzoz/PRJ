package org.vinsw.mockito;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class SenderImplTest {

    @Test
    public void testSendingTweet() {
        SenderImpl sender = new SenderImpl();

        ISender iSender = mock(ISender.class);
        when(iSender.getMessage()).thenReturn("Message to send!");

        sender.sendToHost(iSender);

        verify(iSender, atLeastOnce()).getMessage();
    }
}
