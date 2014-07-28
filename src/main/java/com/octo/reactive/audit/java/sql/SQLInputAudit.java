package com.octo.reactive.audit.java.sql;

import com.octo.reactive.audit.AbstractNetworkAudit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import static com.octo.reactive.audit.lib.Latency.HIGH;

// Nb methods: 27
@Aspect
public class SQLInputAudit extends AbstractNetworkAudit
{
	@Before("call(* java.sql.SQLInput.read*(..))")
	public void readSQL(JoinPoint thisJoinPoint)
	{
		latency(HIGH, thisJoinPoint);
	}
}
