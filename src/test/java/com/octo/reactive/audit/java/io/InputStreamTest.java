package com.octo.reactive.audit.java.io;

import com.octo.reactive.audit.AuditReactive;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public abstract class InputStreamTest
{
	protected abstract InputStream newInputStream() throws IOException;

	@Test
	public void New() throws IOException
	{
		AuditReactive.strict.commit();
		try (InputStream in = newInputStream())
		{
			AuditReactive.off.commit();
		}
	}

	@Test
	public void available() throws IOException
	{
		AuditReactive.off.commit();
		try (InputStream in = newInputStream())
		{
			AuditReactive.strict.commit();
			in.available();
		}
	}

	@Test
	public void close() throws IOException
	{
		AuditReactive.off.commit();
		try (InputStream in = newInputStream())
		{
			AuditReactive.strict.commit();
			in.close();
		}
	}

	@Test
	public void read() throws IOException
	{
		AuditReactive.off.commit();
		try (InputStream in = newInputStream())
		{
			AuditReactive.strict.commit();
			in.read();
		}
	}

	@Test
	public void read_B() throws IOException
	{
		AuditReactive.off.commit();
		try (InputStream in = newInputStream())
		{
			AuditReactive.strict.commit();
			in.read(new byte[1]);
		}
	}

	@Test
	public void read_Bii() throws IOException
	{
		AuditReactive.off.commit();
		try (InputStream in = newInputStream())
		{
			AuditReactive.strict.commit();
			in.read(new byte[1], 0, 1);
		}
	}

	@Test
	public void skip() throws IOException
	{
		AuditReactive.off.commit();
		try (InputStream in = newInputStream())
		{
			AuditReactive.strict.commit();
			in.skip(0);
		}
	}
}
