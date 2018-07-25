package com.song.testng.test;

import org.mockito.InOrder;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;

public class MockTest {
    @Test
    public void testVerificationInOrder() throws Exception {
        // A. Single mock whose methods must be invoked in a particular order
        List singleMock = mock(List.class);

        //使用单个mock对象
        singleMock.add("was added first");
        singleMock.add("was added second");

        //创建inOrder
        InOrder inOrder = inOrder(singleMock);

        //验证调用次数，若是调换两句，将会出错，因为singleMock.add("was added first")是先调用的
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // 多个mock对象
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        //创建多个mock对象的inOrder
        inOrder = inOrder(firstMock, secondMock);

        //验证firstMock先于secondMock调用
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");
    }
    @Test
    public void testInteractionNeverHappened() {
        List mockOne = mock(List.class);
        List mockTwo = mock(List.class);

        //测试通过
        verifyZeroInteractions(mockOne, mockTwo);

        mockOne.add("");
        //测试不通过，因为mockTwo已经发生过交互了
        verifyZeroInteractions(mockOne, mockTwo);
    }
}
