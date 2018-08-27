package net.frank.framework.web.taglib.content.template;

import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenderPropertiesDirective extends Directive {
	
	public static final String PROPERTIES_KEY = "properties";
	
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	public static final String CALL_FUNCTION_NAME = "properties";

	
	@Override
	public String getName() {
		return CALL_FUNCTION_NAME;
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter vContext, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException,
			MethodInvocationException {
		String proKey = (String)node.jjtGetChild(0).value(vContext);
		log.debug("input properties Key is:"+proKey);
		Properties p = (Properties)vContext.get(PROPERTIES_KEY);
		String text = p.getProperty(proKey);
		writer.write(text);
		return true;
	}

}
