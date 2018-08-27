package net.frank.framework.web.taglib.content.template;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import net.frank.commons.util.DateUtil;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenderDateDirective extends Directive{
	
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	public static final String CALL_FUNCTION_NAME = "renderDate";
	
	@Override
	public String getName() {
		return CALL_FUNCTION_NAME;
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer,
			Node node) throws IOException, ResourceNotFoundException,
			ParseErrorException, MethodInvocationException {
		Date value = (Date)node.jjtGetChild(0).value(context);
		String dateStr = DateUtil.toString(value, DateUtil.ALIGN_DATETIME_FORMAT);
		log.debug(dateStr);
		writer.write(dateStr);
		return true;
	}

}
