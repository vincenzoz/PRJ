package org.vinsw.mockito;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class TweetClientTest {

    @Test
    public void testSendingTweet() {
        TweetClient tc = new TweetClient();

        ITweet iTweet = mock(ITweet.class);
        when(iTweet.getMessage()).thenReturn("Using mockito is great!");

        tc.sendTweet(iTweet);

        verify(iTweet, atLeastOnce()).getMessage();
    }
}
