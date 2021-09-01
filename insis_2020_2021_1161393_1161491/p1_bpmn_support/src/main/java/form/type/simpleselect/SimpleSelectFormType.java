package form.type.simpleselect;

import org.activiti.engine.form.AbstractFormType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleSelectFormType extends AbstractFormType{
	
	private static final long serialVersionUID = 1L;
	
	public static final String TYPE_NAME = "simpleSelect";
	
	private static Log log = LogFactory.getLog(SimpleSelectFormType.class);

	public String getName() {
		return TYPE_NAME;
	}

	@Override
	public Object convertFormValueToModelValue(String propertyValue) {
		return propertyValue;
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
		if (modelValue == null) {
			log.info("object simpleselect is null");
			return null;
		}
		
		return modelValue.toString();
	}

}
