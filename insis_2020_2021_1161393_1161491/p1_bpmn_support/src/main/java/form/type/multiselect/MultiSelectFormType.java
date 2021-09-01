package form.type.multiselect;
import org.activiti.engine.form.AbstractFormType;

public class MultiSelectFormType extends AbstractFormType {
	private static final long serialVersionUID = 3270047876629259463L;

	public static final String TYPE_NAME = "multiSelect";
	
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
			return null;
		}
		
		return modelValue.toString();
	}
	
}
