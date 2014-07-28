package com.octo.reactive.audit.java.io;

import com.octo.reactive.audit.AuditReactive;
import com.octo.reactive.audit.IOTestTools;
import com.octo.reactive.audit.lib.FileAuditReactiveException;
import org.junit.Test;

import java.io.*;

import static com.octo.reactive.audit.TestTools.pop;
import static com.octo.reactive.audit.TestTools.push;

public class InputStreamReaderTest extends AuditedReaderTest
{
	@Override
	protected Reader newReader() throws IOException
	{
		push();
		InputStream in = new FileInputStream(IOTestTools.getTempFile());
		pop();
		return new InputStreamReader(in);
	}

	// FIXME: est-ce ncessaire ?
	@Test(expected = FileAuditReactiveException.class)
	public void read_with_FilterInputStream() throws IOException
	{
		AuditReactive.off.commit();
		try (Reader in = new InputStreamReader(new BufferedInputStream(new FileInputStream(IOTestTools.getTempFile()))))
		{
			AuditReactive.strict.commit();
			in.read();
		}
	}
}
