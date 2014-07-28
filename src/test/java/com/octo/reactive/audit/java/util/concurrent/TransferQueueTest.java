package com.octo.reactive.audit.java.util.concurrent;

import com.octo.reactive.audit.AuditReactive;
import com.octo.reactive.audit.lib.CPUAuditReactiveException;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class TransferQueueTest
{
	TransferQueue<Object> t = new TransferQueue<Object>()
	{

		@Override
		public boolean tryTransfer(Object o)
		{
			return false;
		}

		@Override
		public void transfer(Object o) throws InterruptedException
		{

		}

		@Override
		public boolean tryTransfer(Object o, long timeout, TimeUnit unit) throws InterruptedException
		{
			return false;
		}

		@Override
		public boolean hasWaitingConsumer()
		{
			return false;
		}

		@Override
		public int getWaitingConsumerCount()
		{
			return 0;
		}

		@Override
		public boolean add(Object o)
		{
			return false;
		}

		@Override
		public boolean offer(Object o)
		{
			return false;
		}

		@Override
		public Object remove()
		{
			return null;
		}

		@Override
		public Object poll()
		{
			return null;
		}

		@Override
		public Object element()
		{
			return null;
		}

		@Override
		public Object peek()
		{
			return null;
		}

		@Override
		public void put(Object o) throws InterruptedException
		{

		}

		@Override
		public boolean offer(Object o, long l, TimeUnit timeUnit) throws InterruptedException
		{
			return false;
		}

		@Override
		public Object take() throws InterruptedException
		{
			return null;
		}

		@Override
		public Object poll(long l, TimeUnit timeUnit) throws InterruptedException
		{
			return null;
		}

		@Override
		public int remainingCapacity()
		{
			return 0;
		}

		@Override
		public boolean remove(Object o)
		{
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c)
		{
			return false;
		}

		@Override
		public boolean addAll(Collection<?> c)
		{
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c)
		{
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c)
		{
			return false;
		}

		@Override
		public void clear()
		{

		}

		@Override
		public int size()
		{
			return 0;
		}

		@Override
		public boolean isEmpty()
		{
			return false;
		}

		@Override
		public boolean contains(Object o)
		{
			return false;
		}

		@Override
		public Iterator<Object> iterator()
		{
			return null;
		}

		@Override
		public Object[] toArray()
		{
			return new Object[0];
		}

		@Override
		public <T> T[] toArray(T[] a)
		{
			return null;
		}

		@Override
		public int drainTo(Collection<? super Object> objects)
		{
			return 0;
		}

		@Override
		public int drainTo(Collection<? super Object> objects, int i)
		{
			return 0;
		}
	};

	@Test(expected = CPUAuditReactiveException.class)
	public void transfer() throws InterruptedException
	{
		AuditReactive.strict.commit();
		t.transfer("");
	}

	@Test(expected = CPUAuditReactiveException.class)
	public void tryTransfer() throws InterruptedException
	{
		AuditReactive.strict.commit();
		t.tryTransfer("", 1, TimeUnit.MILLISECONDS);
	}
}
